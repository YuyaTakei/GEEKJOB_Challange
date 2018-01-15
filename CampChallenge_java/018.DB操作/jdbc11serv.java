package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class jdbc11serv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {

                Db11 db = new Db11();

                request.setCharacterEncoding("UTF-8");
                
                String nointid = request.getParameter("id");
                int id = Integer.parseInt(nointid);
                String name = request.getParameter("name");
                String tel = request.getParameter("tel");
                String nointage = request.getParameter("age");
                int age = Integer.parseInt(nointage);
                String birthday = request.getParameter("birthday");

                out.print(
                        "ID№"
                        + id + 
                        "の内容を<br><br>名前:"
                        + name
                        + "<br>電話番号:"
                        + tel
                        + "<br>年齢:"
                        + age
                        + "<br>生年月日:"
                        + birthday
                        + "<br><br>に更新します"
                );

                db.updateProfile(id, name, tel, age, birthday);

                out.print("<br><br>更新を完了しました");

            } catch (SQLException e_sql) {
                out.print("接続時にエラーが発生しました(SQL):" + e_sql.toString());
            } catch (Exception e) {
                out.print("接続時にエラーが発生しました:" + e.toString());
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
