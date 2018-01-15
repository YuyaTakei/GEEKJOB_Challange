package JDBC;

import java.sql.*;
import java.util.ArrayList;

public class Db13 {

    Connection db_con = null;
    PreparedStatement db_st = null;
    ResultSet db_data = null;

    private static String dbName = "Challenge_db";
    private static String url = "jdbc:mysql://localhost:3306/" + dbName;
    private static String user = "YUU";
    private static String pass = "1234";

    public boolean canLogin(int id, String password)
            throws SQLException, Exception {

        boolean login = true;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection(url, user, pass);
            db_st = db_con.prepareStatement("SELECT password FROM userlogin WHERE userID = ?");

            db_st.setInt(1, id);
            db_data = db_st.executeQuery();
            if (db_data.next()) {
                if (db_data.getString("password").equals(password)) {
                    login = true;
                } else {
                    login = false;
                }
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
        return login;
    }
    
    public void registItem(int id, String name, int stock, String category)
            throws SQLException, Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection(url, user, pass);
            db_st = db_con.prepareStatement("INSERT INTO item VALUE (?,?,?,?)");
            db_st.setInt(1, id);
            db_st.setString(2, name);
            db_st.setInt(3, stock);
            db_st.setString(4, category);
            
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
    
    public int getItemid()
            throws SQLException, Exception {

        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection(url, user, pass);
            db_st = db_con.prepareStatement("SELECT itemID FROM item");
            db_data = db_st.executeQuery();

            while (db_data.next()) {
                i = db_data.getInt("itemID");
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

    public int getID()
            throws SQLException, Exception {

        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection(url, user, pass);
            db_st = db_con.prepareStatement("SELECT userID FROM userlogin");
            db_data = db_st.executeQuery();

            while (db_data.next()) {
                i = db_data.getInt("userID");
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
    
    public String getName(int id)
            throws SQLException, Exception {

        String name = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection(url, user, pass);
            db_st = db_con.prepareStatement("SELECT name FROM userlogin WHERE userID = ?");
            db_st.setInt(1, id);
            db_data = db_st.executeQuery();

            if (db_data.next()) {
                name = db_data.getString("name");
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
        return name;
    }
    
     public ArrayList getAllprofiles()
            throws SQLException, Exception {
        //profileを格納するArrayList
        ArrayList profiles = new ArrayList<ArrayList>();
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection(url, user, pass);
            db_st = db_con.prepareStatement("SELECT * FROM item");
            db_data = db_st.executeQuery();

            while (db_data.next()) {
                        
                        profiles.add(db_data.getInt("itemID"));
                        profiles.add(db_data.getString("name"));
                        profiles.add(db_data.getInt("stock"));
                        profiles.add(db_data.getString("category")); 
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


    public void createUser(int id, String name, String pass)
            throws SQLException, Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection(url, user, pass);
            db_st = db_con.prepareStatement("INSERT INTO userlogin VALUE (?, ?, ?)");

            db_st.setInt(1, id);
            db_st.setString(2, name);
            db_st.setString(3, pass);

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
