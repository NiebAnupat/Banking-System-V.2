
import java.sql.*;
import javax.swing.JOptionPane;
public class DB_Connection {

    // <editor-fold defaultstate="collapsed" desc="Database Connection">
    // ----------------สร้าง Object ที่ใช้กับ Database---------------------
    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;
    // ---------------------------------------------------------------
    // ----------------URL สำหรับเชื่อมฐานข้อมูลบน Server-------------------
    private String url = "jdbc:mysql://localhost:3306/banking-system-v2";
    // ---------------------------------------------------------------
    //----------------------User ที่ใช้ Database-------------------------
    private String username = "root";
    private String password = "";
    // ---------------------------------------------------------------
    // </editor-fold>


    // -------Method ที่ใช้ในการเชื่อมต่อกับ Database--------
    public void connectDB() throws SQLException {
        try{
            conn = DriverManager.getConnection(url,username,password);
        }catch (SQLException ex){
            Method.displayError(ex.getMessage());
            Method.displayError("Error connecting to database");
        }
    }
    // ----------------------------------------------


    // ------Method ที่ใช้ในการตัดการเชื่อมต่อกับฐานข้อมูล--------
    public void disconnect() throws SQLException {
        try {
            conn.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error disconnecting");
        }
    }
    // -----------------------------------------------

    // -----------Method ที่ใช้ในการสั่ง exceute คำสั่ง Sql-----------------
    public boolean execute (String query) throws SQLException {
        boolean rs;
        try{
            connectDB();
            st = conn.createStatement();
            st.execute(query);
            rs = true;
        }catch (SQLException ex){
            rs = false;
        }
        disconnect();
        return rs;
    }
    // ------------------------------------------------------------

    // ----------Method ที่ใช้ในการเก็บค่า ResultSet ที่ได้จากการ execute-------------
    public ResultSet getResultSet (String query) throws SQLException {
        try{
            connectDB();
            st = conn.createStatement();
            rs = st.executeQuery(query);
        }catch (Exception ex){
            rs = null;
        }
        return rs;
    }
    // ---------------------------------------------------------------------



}
