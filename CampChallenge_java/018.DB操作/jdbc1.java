package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ワイルドカードで一度にインポート
import java.sql.*;

public class jdbc1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //接続情報を受け取る為のConnection変数 db_con を用意
            Connection db_con = null;
            
            try{
                //Class.forNameメソッドを利用しインスタンスを生成（DriveManagerにセットされる）
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //DriverManagerのgetConnectionメソッドでDBへの接続を取得する
                //Connection変数 = DriverManager.getConnection("接続文字列", "アカウント名", "パスワード");
                //接続文字列とは→"jdbc:" + データベースの種類 + "://" + 接続先 + ":" + ポート番号 + "/" + データベース名
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "YUU", "1234");
                out.println("接続に成功しました<br>");
                //操作が完了したらクローズする
                db_con.close();
                out.println("接続を終了しました<br>");
            //catch (例外クラス 変数名)
            } catch (SQLException e_sql){
                out.println("接続時にエラーが発生しました："+e_sql.toString());
            } catch (Exception e){
                out.println("接続時にエラーが発生しました；"+e.toString());
            } finally {
                if(db_con != null){
                    try{
                        db_con.close();
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
