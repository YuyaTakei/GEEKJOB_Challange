package JDBC;


import java.sql.*;
import java.util.ArrayList;

//DBを操作するクラス
public class Db8 {

    Connection db_con = null;
    PreparedStatement db_st = null;
    ResultSet db_data = null;

    private static String dbName = "Challenge_db";
    private static String url = "jdbc:mysql://localhost:3306/" + dbName;
    private static String user = "YUU";
    private static String pass = "1234";
    
    //throwsすることでメソッドを利用してくる奴（サーブレット）にエラーを投げる
    public ArrayList getProfiles(String name)
            throws SQLException, Exception {
        //profileを格納するArrayList
        ArrayList profiles = new ArrayList<ArrayList>();
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection(url, user, pass);
            db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE name LIKE ?");
            db_st.setString(1, "%" + name + "%");
            db_data = db_st.executeQuery();

            while (db_data.next()) {
                        
                        profiles.add(db_data.getInt("profilesID"));
                        profiles.add(db_data.getString("name"));
                        profiles.add(db_data.getString("tel"));
                        profiles.add(db_data.getInt("age"));
                        profiles.add(db_data.getString("birthday")); 
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
        return profiles;
    }
}
