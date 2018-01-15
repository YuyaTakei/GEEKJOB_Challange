package JDBC;

import java.sql.*;

public class Db11 {

    Connection db_con = null;
    PreparedStatement db_st = null;

    private static String dbName = "Challenge_db";
    private static String url = "jdbc:mysql://localhost:3306/" + dbName;
    private static String user = "YUU";
    private static String pass = "1234";

    public void updateProfile(int id, String name, String tel, int age, String birthday)
            throws SQLException, Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection(url, user, pass);
            db_st = db_con.prepareStatement("UPDATE profiles SET name = ?, tel = ?, age = ?, birthday = ? WHERE profilesID = ?");

            db_st.setString(1, name);
            db_st.setString(2, tel);
            db_st.setInt(3, age);
            db_st.setString(4, birthday);
            db_st.setInt(5, id);

            db_st.executeUpdate();

        } finally {
            try {

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
