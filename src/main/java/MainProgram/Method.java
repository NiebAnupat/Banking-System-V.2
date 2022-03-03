package MainProgram;

import swing.PanelBorder;
import swing.ScrollBar;
import swing.Table;
import model.StatusType;
import component.AC_Select_Card;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;


public class Method {
    public static void displayError(String message){
        JOptionPane.showMessageDialog(null,message,"Alert",JOptionPane.ERROR_MESSAGE);
    }

    public static void displayInfo(String message){
        JOptionPane.showMessageDialog(null,message,"Information",JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean isNumeric(String string) {
        int intValue;
        if(string == null || string.equals("")) {
            return false;
        }
        
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {}
        return false;
    }

    public static void center_screen(JFrame parent){
        int lebar = parent.getWidth()/2;
        int tinggi = parent.getHeight()/2;
        int x = ( Toolkit.getDefaultToolkit().getScreenSize().width/2)-lebar;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height/2)-tinggi;
        parent.setLocation(x, y);
    }

    public static void Escape (JFrame parent){
        parent.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0), "Cancel");

        parent.getRootPane().getActionMap().put("Cancel", new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
    }

    // -------------------------------------- SignIn - SignUp Part --------------------------------------
    private static String current_id;
    public static void Login(JFrame parent,String user_id,String user_password){
        String query = String.format("select user_id from users where user_id='%s' and user_password='%s'",user_id,user_password);
        DB_Connection db = new DB_Connection();
        current_id = user_id;
        try {
            ResultSet rs = db.getResultSet( query );
            if ( rs.next() ) {
                query = String.format("select user_name from users where user_id='%s'",user_id);
                rs = db.getResultSet( query );
                rs.next();
                String name = rs.getString(1);
                String[] firstName = name.split( " " );
                displayInfo( "Welcome "+firstName[0]+" !" );
                main m = new main();
                m.setVisible( true );
                parent.dispose();
            }
        } catch (SQLException e) {
            displayError(e.getMessage());
        }
    }

    public static void Register(JFrame parent, String user_id, String user_password, String user_confirm_password, String user_name, String user_tel,String user_mail, String user_citizen_id,String user_address){

        boolean temp;
            if(user_password.equals(user_confirm_password)){
                DB_Connection db = new DB_Connection();
                try {

                    String query = String.format("SELECT user_id FROM users WHERE user_id='%s'", user_id);
                    ResultSet rs = db.getResultSet(query);
                    if (rs.next()) {
                        throw new SQLException("Your ID has already used");
                    }else {
                        query = String.format("INSERT INTO users(user_id,user_password,user_name,user_tel,user_mail,user_citizen_id,user_address) " +
                                "VALUES('%s','%s','%s','%s','%s','%s','%s');", user_id, user_password, user_name, user_tel,user_mail,user_citizen_id,user_address);
                        temp = db.execute(query);
                    }
                }catch(SQLException e){
                    temp = false;
                    Method.displayError(e.getMessage());

                }catch (Exception e) {
                    temp = false;
                    Method.displayError("Error : "+e);
                }finally {
                    try {
                        db.disconnect();
                    } catch (SQLException e) {
                        Method.displayError( e.getMessage() );
                    }
                }

                if (temp){
                    Method.displayInfo("Register done");
                    loginPage lp = new loginPage();
                    lp.setVisible( true );
                    parent.dispose();
                }else {
                    Method.displayError("Register fail");

                }
            }else{
                Method.displayError("Password and Confirm Password must be same!");
            }


    }
    // --------------------------------------------------------------------------------------------------

    // -------------------------------------- Dashboard Part --------------------------------------
    public static void SetTotalBalance_Dashboard(JLabel parent) {
        String query = String.format("select sum(ac_balance) from account where user_id='%s' and ac_status='t'",current_id);
        DB_Connection db = new DB_Connection();
        try {
            ResultSet rs = db.getResultSet( query );
            if (rs.next()){
                parent.setText(rs.getString(1)+" ฿");
            }else{
                displayError("Error");
            }
        }catch(Exception e){
            displayError( e.getMessage() );
        }
    }

    public static void SetAllAcTable_Dashboard(Table parent,JScrollPane parent_scrollbar){

        parent.clearTable();
        String query = String.format("select ac_number,bk.bank_name,ac_name,ac_balance from account inner join bank as bk on account.bank_id = bk.bank_id where user_id='%s' and ac_status='t'",current_id);
        DB_Connection db = new DB_Connection();
        try {
            ResultSet rs = db.getResultSet( query );
            while (rs.next()){
                Object[] ac_data = { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4) };
                parent.addRow( ac_data );
            }
            parent_scrollbar.setVerticalScrollBar( new ScrollBar() );
        }catch (Exception e){
            displayError( e.getMessage() );
        }
    }

    // show recent statement

    // --------------------------------------------------------------------------------------------

    // -------------------------------------- Account Part --------------------------------------

    public static void SetBank_Combobox(JComboBox parent){
        String query = String.format("select bank_name from bank");
        DB_Connection db = new DB_Connection();
        try {

            ResultSet rs = db.getResultSet( query );
            while (rs.next()) {
                parent.addItem( rs.getString( 1 ) );
            }

        }catch (Exception e){
            displayError( e.getMessage() );
        }
    }

    public static void SetAllAcTable_Account(Table parent,JScrollPane parent_scrollbar){

        String query = String.format("select ac_number,bk.bank_name,ac_name,ac_balance,ac_status from account inner join bank as bk on account.bank_id = bk.bank_id where user_id='%s'",current_id);
        DB_Connection db = new DB_Connection();
        // String columns[] = {"Number","Bank","Name","Balance","Status"};
        try {
            ResultSet rs = db.getResultSet( query );
            Object[] ac_data;
            parent.clearTable();
            //DefaultTableModel model = new DefaultTableModel(columns,1);
            while (rs.next()){
                if ( rs.getString( 5 ).equals( "t" )) {ac_data = new Object[]{rs.getString( 1 ), rs.getString( 2 ), rs.getString( 3 ), rs.getString( 4 )+" ฿", StatusType.ACTIVATE};
                }
                else  ac_data = new Object[]{rs.getString( 1 ), rs.getString( 2 ), rs.getString( 3 ), rs.getString( 4 )+" ฿", StatusType.DEACTIVATE};

                parent.addRow( ac_data );

            }
            parent_scrollbar.setVerticalScrollBar( new ScrollBar() );

        }catch (Exception e){
            displayError( e.getMessage() );
        }
    }

    public static void CloseAccount(String ac_number){

        String query = String.format("update account set ac_status='f' where ac_number='%s'",ac_number);
        DB_Connection db = new DB_Connection();
        try {
            if ( db.execute(query) ) {
                displayInfo( "Account number "+ac_number+" has deactivated" );
            }
            else throw new Exception("Deactivate fail");
        } catch (Exception e) {
            displayError(e.getMessage());
        }
    }

    public static void Register_ac(String ac_number,String bank_id,String ac_name,String ac_pin,String ac_tel,String ac_citizenid,String ac_address){

        String query = String.format("insert into account " +
                "values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                current_id,ac_number,bank_id,ac_name,0.0,ac_pin,ac_tel,ac_citizenid,ac_address,"t");

        DB_Connection db = new DB_Connection();
        try {
            if ( db.execute( query ) ) displayInfo("Open account done");
            else throw new Exception("Fail to open account");

        }catch(Exception e){
            displayError( e.getMessage() );
        }

    }

    public static String Random_AC_Number(String bank_name){
        String ac_number ="",query;
        try {
            DB_Connection db = new DB_Connection();
            ResultSet rs;
            Random rd = new Random();
            while (true) {
                for (int i = 0; i<=6;i++){
                    ac_number += String.valueOf(rd.nextInt(10));
                }
                query = String.format("SELECT ac_number FROM account INNER JOIN bank ON account.bank_id = bank.bank_id WHERE ac_number = '%s' AND bank.bank_name = '%s')",ac_number,bank_name);
                rs = db.getResultSet(query);
                rs.next();
                db.disconnect();
            }
        }catch (Exception ignored){
            return ac_number;
        }

    }



    // ------------------------------------------------------------------------------------------

    // -------------------------------------- Banking Page --------------------------------------

    public static void SetAccountCard(CardLayout parent_layout, PanelBorder parent_panel){
        parent_layout = (CardLayout) parent_panel.getLayout();
        String query = String.format("select bk.bank_name,ac_name,ac_number,ac_balance from account inner join bank as bk on account.bank_id = bk.bank_id where user_id='%s' and ac_status='t'",current_id);
        DB_Connection db = new DB_Connection();
        parent_panel.removeAll();
        try {
            ResultSet rs = db.getResultSet( query );
            int num=0;
            while (rs.next()) {
                num++;
                parent_panel.add( new AC_Select_Card(parent_layout,parent_panel,rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble( 4 ) ),String.valueOf( num ));
            }
            parent_layout.show( parent_panel,"1" );
        }catch (Exception e){
            displayError( e.getMessage() );
        }
    }

    public static String GetSelectedAccount(){
            return AC_Select_Card.get_show_ac_number();
    }

    // ------------------------------------------------------------------------------------------



}
