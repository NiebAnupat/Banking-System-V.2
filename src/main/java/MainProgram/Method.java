package MainProgram;

import swing.PanelBorder;
import swing.ScrollBar;
import swing.Table;
import model.StatusType;
import component.AC_Select_Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class Method {

    // <editor-fold defaultstate="collapsed" desc="Main Program">

    // <editor-fold defaultstate="collapsed" desc="SignIn - SignUp Part">
    private static String current_id;

    public static void Login (JFrame parent, String user_id, String user_password) {
        String query = String.format( "select user_id from users where user_id='%s' and user_password='%s'", user_id, user_password );
        DB_Connection db = new DB_Connection();
        current_id = user_id;
        try {
            ResultSet rs = db.getResultSet( query );
            if ( rs.next() ) {
                query = String.format( "select user_name from users where user_id='%s'", user_id );
                rs = db.getResultSet( query );
                rs.next();
                String name = rs.getString( 1 );
                String[] firstName = name.split( " " );
                displayInfo( "Welcome " + firstName[0] + " !" );
                main m = new main();
                m.setVisible( true );
                parent.dispose();
            }
        } catch (SQLException e) {
            displayError( e.getMessage() );
        }
    }

    public static void Register (JFrame parent, String user_id, String user_password, String user_confirm_password, String user_name, String user_tel, String user_mail, String user_citizen_id, String user_address) {

        boolean temp;
        if ( user_password.equals( user_confirm_password ) ) {
            DB_Connection db = new DB_Connection();
            try {

                String query = String.format( "SELECT user_id FROM users WHERE user_id='%s'", user_id );
                ResultSet rs = db.getResultSet( query );
                if ( rs.next() ) {
                    throw new SQLException( "Your ID has already used" );
                } else {
                    query = String.format( "INSERT INTO users(user_id,user_password,user_name,user_tel,user_mail,user_citizen_id,user_address) " +
                            "VALUES('%s','%s','%s','%s','%s','%s','%s');", user_id, user_password, user_name, user_tel, user_mail, user_citizen_id, user_address );
                    temp = db.execute( query );
                }
            } catch (SQLException e) {
                temp = false;
                Method.displayError( e.getMessage() );

            } catch (Exception e) {
                temp = false;
                Method.displayError( "Error : " + e );
            } finally {
                try {
                    db.disconnect();
                } catch (SQLException e) {
                    Method.displayError( e.getMessage() );
                }
            }

            if ( temp ) {
                Method.displayInfo( "Register done" );
                loginPage lp = new loginPage();
                lp.setVisible( true );
                parent.dispose();
            } else {
                Method.displayError( "Register fail" );

            }
        } else {
            Method.displayError( "Password and Confirm Password must be same!" );
        }


    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Dashboard Part">
    public static void SetTotalBalance_Dashboard (JLabel parent) {
        String query = String.format( "select sum(ac_balance) from account where user_id='%s' and ac_status='t'", current_id );
        DB_Connection db = new DB_Connection();
        try {
            ResultSet rs = db.getResultSet( query );
            if ( rs.next() ) {
                parent.setText( rs.getString( 1 ) + " ฿" );
            } else {
                displayError( "Error" );
            }
        } catch (Exception e) {
            displayError( e.getMessage() );
        }
    }

    public static void SetAllAcTable_Dashboard (Table parent, JScrollPane parent_scrollbar) {

        parent.clearTable();
        String query = String.format( "select ac_number,bk.bank_name,ac_name,ac_balance from account inner join bank as bk on account.bank_id = bk.bank_id where user_id='%s' and ac_status='t'", current_id );
        DB_Connection db = new DB_Connection();
        try {
            ResultSet rs = db.getResultSet( query );
            while (rs.next()) {
                Object[] ac_data = {rs.getString( 1 ), rs.getString( 2 ), rs.getString( 3 ), rs.getString( 4 )+" ฿"};
                parent.addRow( ac_data );
            }
            parent_scrollbar.setVerticalScrollBar( new ScrollBar() );
        } catch (Exception e) {
            displayError( e.getMessage() );
        }
    }

    public static void SetRecentTable (Table parent,JScrollPane parent_scrollbar) {
        parent.clearTable();
        DB_Connection db = new DB_Connection();
        try {
            String query = String.format( "select st.stm_id,bt.type_name,st.ac_number,st.amount from statements as st " +
                    "inner join banking_type as bt on st.type_id = bt.type_id " +
                    "inner join account as ac on st.ac_number = ac.ac_number " +
                    "where ac.user_id = '%s' and ac.ac_status='t' order by st.stm_id DESC",current_id);
            ResultSet rs = db.getResultSet( query );
            while (rs.next()) {
                Object[] recent_data = {rs.getString( 1 ), rs.getString( 2 ), rs.getString( 3 ), rs.getString( 4 )+" ฿"};
                parent.addRow( recent_data );
            }
            parent_scrollbar.setVerticalScrollBar( new ScrollBar());
        }catch (Exception e) {
            displayError( e.getMessage() );
        }

    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Account Part">

    public static void SetBank_Combobox (JComboBox parent) {
        String query = "select bank_name from bank";
        DB_Connection db = new DB_Connection();
        try {

            ResultSet rs = db.getResultSet( query );
            while (rs.next()) {
                parent.addItem( rs.getString( 1 ) );
            }

        } catch (Exception e) {
            displayError( e.getMessage() );
        }
    }

    public static void SetAllAcTable_Account (Table parent, JScrollPane parent_scrollbar) {

        String query = String.format( "select ac_number,bk.bank_name,ac_name,ac_balance,ac_status from account inner join bank as bk on account.bank_id = bk.bank_id where user_id='%s' order by ac_status='t' DESC", current_id );
        DB_Connection db = new DB_Connection();
        // String columns[] = {"Number","Bank","Name","Balance","Status"};
        try {
            ResultSet rs = db.getResultSet( query );
            Object[] ac_data;
            parent.clearTable();
            //DefaultTableModel model = new DefaultTableModel(columns,1);
            while (rs.next()) {
                if ( rs.getString( 5 ).equals( "t" ) ) {
                    ac_data = new Object[]{rs.getString( 1 ), rs.getString( 2 ), rs.getString( 3 ), rs.getString( 4 ) + " ฿", StatusType.ACTIVATE};
                } else
                    ac_data = new Object[]{rs.getString( 1 ), rs.getString( 2 ), rs.getString( 3 ), rs.getString( 4 ) + " ฿", StatusType.DEACTIVATE};

                parent.addRow( ac_data );

            }
            parent_scrollbar.setVerticalScrollBar( new ScrollBar() );

        } catch (Exception e) {
            displayError( e.getMessage() );
        }
    }

    public static void CloseAccount (String ac_number) {

        String query;
        ResultSet rs;
        DB_Connection db = new DB_Connection();
        try {

            String pin =JOptionPane.showInputDialog( null,"Please enter account PIN Code :");
            if (  pin.equals("") ) throw new Exception("Please input PIN Code");

            query = String.format( "select * from account where ac_number='%s' and ac_pin='%s'",ac_number,pin);
            rs = db.getResultSet( query );
            if ( rs.next() ) {}
            else throw new Exception( "Wrong Pin Code");

            query = String.format( "update account set ac_status='f' where ac_number='%s'", ac_number );
            if ( db.execute( query ) )  AC_Select_Card.Reset_AC_number();
            else throw new Exception( "Deactivate fail" );

        } catch (Exception e) {
            displayError( e.getMessage() );
        }
    }

    public static void ActivateAccount (String ac_number){
        String query = String.format( "update account set ac_status='t' where ac_number='%s'", ac_number );
        DB_Connection db = new DB_Connection();
        try {
            if ( db.execute( query ) ) {
                AC_Select_Card.Reset_AC_number();
                displayInfo( "Account number " + ac_number + " has activate" );
            } else throw new Exception( "activate fail" );
        } catch (Exception e) {
            displayError( e.getMessage() );
        }
    }

    public static void Register_ac (String ac_number, String bank_id, String ac_name, String ac_pin, String ac_tel, String ac_citizenid, String ac_address) {

        String query = String.format( "insert into account " +
                        "values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                current_id, ac_number, bank_id, ac_name, 0.0, ac_pin, ac_tel, ac_citizenid, ac_address, "t" );

        DB_Connection db = new DB_Connection();
        try {
            if ( db.execute( query ) ) displayInfo( "Open account done" );
            else throw new Exception( "Fail to open account" );
            AC_Select_Card.Reset_AC_number();

        } catch (Exception e) {
            displayError( e.getMessage() );
        }

    }

    public static String Random_AC_Number (String bank_name) {
        String ac_number = "", query;
        try {
            DB_Connection db = new DB_Connection();
            ResultSet rs;
            Random rd = new Random();
            while (true) {
                for (int i = 0 ; i <= 6 ; i++) {
                    ac_number += String.valueOf( rd.nextInt( 10 ) );
                }
                query = String.format( "SELECT ac_number FROM account INNER JOIN bank ON account.bank_id = bank.bank_id WHERE ac_number = '%s' AND bank.bank_name = '%s')", ac_number, bank_name );
                rs = db.getResultSet( query );
                rs.next();
                db.disconnect();
            }
        } catch (Exception e) {
            return ac_number;
        }

    }

    public static void SetStatementsTable (String ac_number, Table parent, JScrollPane parent_scrollbar, JLabel label_display_number){
        String query = String.format( "select st.stm_id,bt.type_name,st.amount from statements as st " +
                "inner join banking_type as bt on st.type_id = bt.type_id " +
                "where st.ac_number = '%s' order by st.stm_id DESC",ac_number);
        DB_Connection db = new DB_Connection();
        parent.clearTable();
        try{
            label_display_number.setText( ac_number );
            ResultSet rs = db.getResultSet( query );
            while (rs.next()) {
                Object[] stm_data = {rs.getString( 1 ), rs.getString( 2 ), rs.getString( 3 )+" ฿"};
                parent.addRow( stm_data );
            }
            parent_scrollbar.setVerticalScrollBar( new ScrollBar());

        }catch(Exception e){
            displayError( e.getMessage() );
        }
    }

    public static String GetSelectedAccount () {
        return AC_Select_Card.get_showwing_ac_number();
    }


    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Banking Part">

    public static void SetAccountCard (CardLayout parent_layout, PanelBorder parent_panel) {
        parent_layout = (CardLayout) parent_panel.getLayout();
        String query = String.format( "select bk.bank_name,ac_name,ac_number,ac_balance from account as ac inner join bank as bk on ac.bank_id = bk.bank_id where ac.user_id='%s' and ac.ac_status='t'", current_id );
        DB_Connection db = new DB_Connection();
        parent_panel.removeAll();
        try {
            ResultSet rs = db.getResultSet( query );
            int num = 0;
            while (rs.next()) {
                num++;
                parent_panel.add( new AC_Select_Card( parent_layout, parent_panel, rs.getString( 1 ), rs.getString( 2 ), rs.getString( 3 ), rs.getDouble( 4 ) ), String.valueOf( num ) );
            }
            parent_layout.show( parent_panel, "1" );
        } catch (Exception e) {
            displayError( e.getMessage() );
        }
    }

    public static void Deposit (String amount_to_deposit, String ac_number) {

        double money = 0.0;
        String query;
        DB_Connection db = new DB_Connection();
        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
        SimpleDateFormat sdfSql = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String date = sdf.format( new Date() );
        String dateSql = sdfSql.format( new Date() );
        boolean is_success;

        try {

            money = Double.parseDouble( amount_to_deposit );

            ResultSet rs;

            // Update Account balance after deposit
            query = String.format( "update account set ac_balance=((select ac_balance from account where ac_number='%s') + '%f') where ac_number='%s'",ac_number,money,ac_number);
            if ( db.execute( query ) ) {}
            else throw new Exception( "Can't execute SQL 1");

            // Save deposit history
            query = String.format("insert into moneydeposit (dp_money,ac_number) values ('%f','%s');",money,ac_number);
            if ( db.execute( query ) ) {}
            else throw new Exception( "Can't execute SQL 2");

            // Get deposit ID to save as statement
            query = "select MAX(dp_id) from moneydeposit ;";
            rs = db.getResultSet(query);
            rs.next();
            String dp_id = rs.getString(1);

            // Save transaction statement
            query = String.format( "insert into statements (stm_date,type_id,ac_number,banking_id,amount) VALUES ('%s','%s','%s','%s','%f')",dateSql,"1",ac_number,dp_id,money);
            if ( db.execute( query ) ) {}
            else throw new Exception( "Can't execute SQL 3");

            // Update bank balance by bank id from account number that deposit
            query = String.format("update bank set bank_balance = (select sum(ac_balance) " +
                    "from account as ac inner join bank b on ac.bank_id = b.bank_id " +
                    "where ac.bank_id=(select bank_id from account where ac_number='%s')) " +
                    "where bank_id=(select bank_id from account where ac_number='%s')"
                    ,ac_number,ac_number);
            if ( db.execute( query ) ) is_success = true;
            else throw new Exception( "Can't execute SQL 4");

        } catch (ClassCastException e) {
            displayError( "Please input money to deposit" );
            is_success = false;
        } catch (Exception e) {
            displayError( e.getMessage() );
            is_success = false;
        }

        if ( is_success )
            displayInfo( String.format( "Transaction successful\nTime : %s\nDeposit to account number : %s \nAmount to deposit : %.2f ฿", date,ac_number, money ) );
        else displayError( String.format( "Transaction fail\nTime : %s\n", date ) );


    }

    public static void Withdraw (String amount_to_withdraw, String ac_number){

        double money = 0.0;
        double ac_balance = 0.0;
        String query;
        DB_Connection db = new DB_Connection();
        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
        SimpleDateFormat sdfSql = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String date = sdf.format( new Date() );
        String dateSql = sdfSql.format( new Date() );
        boolean is_success;

        try{

            money = Double.parseDouble( amount_to_withdraw );
            ResultSet rs;

            String pin =JOptionPane.showInputDialog( null,"Please enter account PIN Code :");
            if (  pin.equals("") ) throw new Exception("Please input PIN Code");

            query = String.format( "select * from account where ac_number='%s' and ac_pin='%s'",ac_number,pin);
            rs = db.getResultSet( query );
            if ( rs.next() ) {}
            else throw new Exception( "Wrong Pin Code");

            query = String.format( "select ac_balance from account where ac_number='%s'", ac_number );
            rs = db.getResultSet( query );
            if ( rs.next() ) {
                ac_balance = rs.getDouble( 1 );
            }

            if (ac_balance >= money){
                // Update Account balance after withdraw
                query = String.format( "update account set ac_balance=((select ac_balance from account where ac_number='%s') - '%f') where ac_number='%s'",ac_number,money,ac_number);
                if ( db.execute( query ) ) {}
                else throw new Exception( "Can't execute SQL 1");

                // Save withdraw history
                query = String.format("insert into moneywithdraw (wd_money,ac_number) values ('%f','%s');",money,ac_number);
                if ( db.execute( query ) ) {}
                else throw new Exception( "Can't execute SQL 2");

                // Get deposit ID to save as statement
                query = "select MAX(wd_id) from moneywithdraw ;";
                rs = db.getResultSet(query);
                rs.next();
                String wd_id = rs.getString(1);

                // Save transaction statement
                query = String.format( "insert into statements (stm_date,type_id,ac_number,banking_id,amount) VALUES ('%s','%s','%s','%s','%f')",dateSql,"2",ac_number,wd_id,money);
                if ( db.execute( query ) ) {}
                else throw new Exception( "Can't execute SQL 3");

                // Update bank balance by bank id from account number that withdraw
                query = String.format("update bank set bank_balance = (select sum(ac_balance) " +
                                "from account as ac inner join bank b on ac.bank_id = b.bank_id " +
                                "where ac.bank_id=(select bank_id from account where ac_number='%s')) " +
                                "where bank_id=(select bank_id from account where ac_number='%s')"
                        ,ac_number,ac_number);
                if ( db.execute( query ) ) is_success = true;
                else throw new Exception( "Can't execute SQL 4");
            }else throw new Exception( "Money not enough" );

        }catch(ClassCastException e){
            displayError( "Please input money to withdraw" );
            is_success = false;
        }
        catch (Exception e) {
            displayError( e.getMessage());
            is_success = false;
        }

        if ( is_success )
            displayInfo( String.format( "Transaction successful\nTime : %s\nWithdraw to account number : %s \nAmount to withdraw : %.2f ฿", date,ac_number, money ) );
        else displayError( String.format( "Transaction fail\nTime : %s\n", date ) );

    }

    static String current_number_recipient, current_number_transferor,current_bank_name_recipient;
    static double amount_to_transfer;

    public static boolean SetTransferDetails(String ac_number_transferor, String ac_number_recipient,String bank_recipient,String amount,JLabel show_number_transferor,JLabel show_name_transferor,JLabel show_bank_transferor,JLabel show_number_recipient,JLabel show_name_recipient,JLabel show_bank_recipient,JLabel show_amount_trasfer){
        String query;
        DB_Connection db = new DB_Connection();
        ResultSet rs;
        try {
            amount_to_transfer = Double.parseDouble( amount );
            current_number_transferor = ac_number_transferor;
            current_number_recipient = ac_number_recipient;
            if(ac_number_recipient.equals( "" )) throw new NumberFormatException();

            // Set Label transferor
            show_number_transferor.setText(ac_number_transferor);

            try{
                query = String.format( "select ac.ac_name, bk.bank_name from account as ac inner join bank as bk on ac.bank_id = bk.bank_id where ac.ac_number = '%s'",ac_number_transferor);
                rs = db.getResultSet( query );
                rs.next();
                show_name_transferor.setText( rs.getString(1) );
                show_bank_transferor.setText(rs.getString(2));
            }
            catch (Exception e){
                throw new Exception("Can't get account name transferor");
            }

            // Set Label recipient
            show_number_recipient.setText( ac_number_recipient );

            try{
                query = String.format( "select ac.ac_name, bk.bank_name from account as ac inner join bank as bk on ac.bank_id = bk.bank_id where ac.ac_number = '%s' and bk.bank_name='%s' and ac.ac_status='t'",ac_number_recipient,bank_recipient);
                rs = db.getResultSet( query );
                rs.next();
                current_bank_name_recipient = bank_recipient;
                show_name_recipient.setText( rs.getString(1) );
                show_bank_recipient.setText(rs.getString(2));
            }
            catch(Exception e){
                throw new Exception("Account number of bank was wrong");
            }



            show_amount_trasfer.setText( amount_to_transfer + " ฿");
            return true;

        }catch(ClassCastException e){
            displayError( "Please input money to transfer" );
            return false;
        }catch (NumberFormatException e){
            displayError( "Please input amount or account number" );
            return false;
        }
        catch (Exception e) {
            displayError( e.getMessage());
            return  false;
        }
    }

    public static boolean Transfer (String pin){

        String query;
        double ac_balance = 0.0;
        DB_Connection db = new DB_Connection();
        ResultSet rs;
        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
        SimpleDateFormat sdfSql = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String date = sdf.format( new Date() );
        String dateSql = sdfSql.format( new Date() );
        try {

            if ( pin.equals("") ) throw new Exception("Please input PIN Code");

            query = String.format( "select * from account where ac_number='%s' and ac_pin='%s'",current_number_transferor,pin);
            rs = db.getResultSet( query );
            if ( rs.next() ) {}
            else throw new Exception( "Wrong Pin Code");

            query = String.format( "select ac_balance from account where ac_number='%s'", current_number_transferor );
            rs = db.getResultSet( query );
            if ( rs.next() ) {
                ac_balance = rs.getDouble( 1 );
            }

            if (ac_balance >= amount_to_transfer){

                // <editor-fold defaultstate="collapsed" desc="Transferor Part">
                // Update account balance
                query = String.format( "update account set ac_balance=(select ac_balance from account where ac_number='%s') - %f where ac_number='%s'",current_number_transferor,amount_to_transfer,current_number_transferor);
                if( db.execute(query) ) {}
                else throw new Exception( "Can't execute SQL 1'");

                // Update bank balance
                query = String.format("update bank set bank_balance = (select sum(ac_balance) " +
                                "from account as ac inner join bank b on ac.bank_id = b.bank_id " +
                                "where ac.bank_id=(select bank_id from account where ac_number='%s')) " +
                                "where bank_id=(select bank_id from account where ac_number='%s')"
                        ,current_number_transferor,current_number_transferor);
                if ( db.execute( query ) ) {}
                else throw new Exception( "Can't execute SQL 2");
                // </editor-fold>

                // <editor-fold defaultstate="collapsed" desc="Recipient Part">
                // Update account balance
                query = String.format( "update account set ac_balance=(select ac_balance from account where ac_number='%s') + %f where ac_number='%s'",current_number_recipient,amount_to_transfer,current_number_recipient);
                if( db.execute(query) ) {}
                else throw new Exception( "Can't execute SQL 3'");

                // Update bank balance
                query = String.format("update bank set bank_balance = (select sum(ac_balance) " +
                                "from account as ac inner join bank b on ac.bank_id = b.bank_id " +
                                "where ac.bank_id=(select bank_id from account where ac_number='%s')) " +
                                "where bank_id=(select bank_id from account where ac_number='%s')"
                        ,current_number_recipient,current_number_recipient);
                if ( db.execute( query ) ) {}
                else throw new Exception( "Can't execute SQL 4");
                // </editor-fold>

                // Save transfer history
                query = String.format( "insert into moneytransfer (tf_money,ac_number_transferor,ac_number_recipient) values ('%f','%s','%s')",amount_to_transfer,current_number_transferor,current_number_recipient );
                if ( db.execute( query ) ) {}
                else throw new Exception( "Can't execute SQL 5");

                // Get transfer ID to save as statement
                query = "select MAX(tf_id) from moneytransfer ;";
                rs = db.getResultSet(query);
                rs.next();
                String tf_id = rs.getString(1);

                // Save transaction statement
                query = String.format( "insert into statements (stm_date,type_id,ac_number,banking_id,amount) VALUES ('%s','%s','%s','%s','%f')",dateSql,"3",current_number_transferor,tf_id,amount_to_transfer);
                if ( db.execute( query ) ) {}
                else throw new Exception( "Can't execute SQL 6");

                query = String.format( "insert into statements (stm_date,type_id,ac_number,banking_id,amount) VALUES ('%s','%s','%s','%s','%f')",dateSql,"4",current_number_recipient,tf_id,amount_to_transfer);
                if ( db.execute( query ) ) {}
                else throw new Exception( "Can't execute SQL 7");

                displayInfo( String.format( "Transaction successful\nTime : %s\nTransfer to account number : %s \nAmount to transfer : %.2f ฿", date,current_number_recipient, amount_to_transfer ) );
                return true;

            }else throw new Exception( "Money not enough" );


        }catch (Exception e) {
            displayError(e.getMessage());
            displayError( String.format( "Transaction fail\nTime : %s\n", date ) );
            return false;
        }

    }

    // </editor-fold>

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Most use method">
    public static void displayError (String message) {
        JOptionPane.showMessageDialog( null, message, "Alert", JOptionPane.ERROR_MESSAGE );
    }

    public static void displayInfo (String message) {
        JOptionPane.showMessageDialog( null, message, "Information", JOptionPane.INFORMATION_MESSAGE );
    }

    public static void displayInfo (double message) {
        JOptionPane.showMessageDialog( null, String.valueOf(message), "Information", JOptionPane.INFORMATION_MESSAGE );
    }

    public static void displayInfo (int message) {
        JOptionPane.showMessageDialog( null, String.valueOf(message), "Information", JOptionPane.INFORMATION_MESSAGE );
    }

    public static boolean isNumeric (String string) {
        int intValue;
        if ( string == null || string.equals( "" ) ) {
            return false;
        }

        try {
            intValue = Integer.parseInt( string );
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }

    public static void center_screen (JDialog parent) {
        int lebar = parent.getWidth() / 2;
        int tinggi = parent.getHeight() / 2;
        int x = ( Toolkit.getDefaultToolkit().getScreenSize().width / 2 ) - lebar;
        int y = ( Toolkit.getDefaultToolkit().getScreenSize().height / 2 ) - tinggi;
        parent.setLocation( x, y );
    }

    public static void Escape (JFrame parent) {
        parent.getRootPane().getInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW ).
                put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "Cancel" );

        parent.getRootPane().getActionMap().put( "Cancel", new AbstractAction() {
            public void actionPerformed (ActionEvent e) {
                System.exit( 0 );
            }
        } );
    }


    // </editor-fold>


}
