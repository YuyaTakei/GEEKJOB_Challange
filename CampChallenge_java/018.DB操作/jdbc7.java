package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class jdbc7 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Connection db_con = null;
            PreparedStatement db_st = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "YUU", "1234");
                out.println("接続に成功しました<br>");
                db_st = db_con.prepareStatement("UPDATE profiles SET name = ?, age = ?, birthday = ? WHERE profilesID = ?");
                db_st.setString(1, "松岡 修造");
                db_st.setInt(2, 48);
                db_st.setString(3, "1967-11-06");
                db_st.setInt(4, 1);
                db_st.executeUpdate();
                out.print("更新を完了しました<br>");
                
                db_st.close();
                db_con.close();
                out.println("接続を終了しました<br>");
            } catch (SQLException e_sql) {
                out.print("接続時にエラーが発生しました(SQL):" + e_sql.toString());
            } catch (Exception e) {
                out.print("接続時にエラーが発生しました:" + e.toString());
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
