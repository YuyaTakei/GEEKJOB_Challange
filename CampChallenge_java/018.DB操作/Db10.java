package JDBC;

import java.sql.*;

public class Db10 {

    Connection db_con = null;
    PreparedStatement db_st = null;
    ResultSet db_data = null;

    private static String dbName = "Challenge_db";
    private static String url = "jdbc:mysql://localhost:3306/" + dbName;
    private static String user = "YUU";
    private static String pass = "1234";
  
    public void deleteProfile(int id)
            throws SQLException, Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection(url, user, pass);
            db_st = db_con.prepareStatement("DELETE FROM profiles WHERE profilesID = ?");
            db_st.setInt(1, id);
            db_st.executeUpdate();

        } finally {
            try {
                if (db_data != null) {
                    db_data.close();
                }
            } catch (Exception e_data) {
                System.out.println(e_data.getMessage());
            } finally {
                try {
                    if (db_st != null) {
                        db_st.close();
                    }
                } catch (Exception e_st) {
                    System.out.println(e_st.getMessage());
                } finally {
                    try {
                        if (db_con != null) {
                            db_con.close();
                        }
                    } catch (Exception e_con) {
                        System.out.println(e_con.getMessage());
                    }
                }
            }
        }
    }
}
