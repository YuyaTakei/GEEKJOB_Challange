package JDBC;

import java.sql.*;

public class Db9 {

    Connection db_con = null;
    PreparedStatement db_st = null;
    ResultSet db_data = null;

    private static String dbName = "Challenge_db";
    private static String url = "jdbc:mysql://localhost:3306/" + dbName;
    private static String user = "YUU";
    private static String pass = "1234";

    public int getID()
            throws SQLException, Exception {

        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection(url, user, pass);
            db_st = db_con.prepareStatement("SELECT profilesID FROM profiles");
            db_data = db_st.executeQuery();
            
            //最後の行にあるIDをint変数iで受け取り、それが返し値となる
            while (db_data.next()) {
                i = db_data.getInt("profilesID");
            }

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
        return i;
    }
    
    public void setProfile(int id, String name, String tel, int age, String birthday)
            throws SQLException, Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection(url, user, pass);
            db_st = db_con.prepareStatement("INSERT INTO profiles VALUE (?, ?, ?, ?, ?)");

            db_st.setInt(1, id);
            db_st.setString(2, name);
            db_st.setString(3, tel);
            db_st.setInt(4, age);
            db_st.setString(5, birthday);

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
