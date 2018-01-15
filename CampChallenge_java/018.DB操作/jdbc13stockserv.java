package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class jdbc13stockserv extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Db13 db = new Db13();       
            request.setCharacterEncoding("UTF-8");
            ArrayList prof = new ArrayList();
            
            //名前で検索するメソッドを使いArrayListに追加
            prof = db.getAllprofiles();
            //メソッドにより該当データがArrayListに入っていれば出力する処理を行う
            if (prof.size() != 0) {
                
                for (int i = 0; i <= prof.size(); i += 4) {
                    out.print("ID:" + prof.get(i) + "<br>");
                    out.print("商品名:" + prof.get(i + 1) + "<br>");
                    out.print("在庫:" + prof.get(i + 2) + "<br>");
                    out.print("分類:" + prof.get(i + 3) + "<br><br>");
                }
            }
        } catch (SQLException e_sql) {
            System.out.print("接続時にエラーが発生しました(SQL):" + e_sql.toString());
        } catch (Exception e) {
            System.out.print("接続時にエラーが発生しました:" + e.toString());
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
