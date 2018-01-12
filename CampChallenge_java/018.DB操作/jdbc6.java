package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class jdbc6 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Connection db_con = null;
            PreparedStatement db_st = null;
            PreparedStatement db_st2 = null;
            ResultSet db_data = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "YUU", "1234");
                out.println("接続に成功しました<br>");
                db_st = db_con.prepareStatement("DELETE FROM profiles WHERE profilesID = 6");
                db_st.executeUpdate();
                out.print("削除を完了しました<br>");
                
                db_st2 = db_con.prepareStatement("SELECT * FROM profiles");
                db_data = db_st2.executeQuery();
                while(db_data.next()){
                    out.print("ID:"+db_data.getInt("profilesID")+"<br>");
                    out.print("名前:"+db_data.getString("name")+"<br>");
                    out.print("電話番号:"+db_data.getString("tel")+"<br>");
                    out.print("年齢:"+db_data.getInt("age")+"<br>");
                    out.print("生年月日"+db_data.getString("birthday")+"<br>");
                }
                db_data.close();
                db_st.close();
                db_con.close();
            } catch (SQLException e_sql) {
                out.print("接続時にエラーが発生しました(SQL):" + e_sql.toString());
            } catch (Exception e) {
                out.print("接続時にエラーが発生しました:" + e.toString());
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

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
