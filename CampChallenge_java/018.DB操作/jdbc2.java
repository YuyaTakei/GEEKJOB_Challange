package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class jdbc2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Connection db_con = null;
            //SQLを実行する為にPreparedStatement変数 db_stを用意
            PreparedStatement db_st = null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "YUU", "1234");
                out.println("接続に成功しました<br>");
                //ConnectionのprepareStatementメソッドの引数にSQL文を渡す
                db_st = db_con.prepareStatement("INSERT INTO profiles VALUE(?,?,?,?,?)");
                //上記SQL文の？に適用する情報を設定→set~~(何番目,入れたい情報);
                db_st.setInt(1,6);
                db_st.setString(2, "葛城 巧");
                db_st.setString(3, "000-0000-0000");
                db_st.setInt(4,26);
                db_st.setString(5, "1991-03-01");
                //SQL文の実行
                db_st.executeUpdate();
                out.println("情報を入力しました<br>");
                //完了したのでクローズ
                db_con.close();
                db_st.close();
                out.println("接続を終了しました<br>");
            //profilesIDにPrimary Key制約をかけたところ、処理二回目以降SQLException例外が発生
            //toStringメソッドによりkeyがduplicateしていると表示される。問題なくcatch出来ている事を確認
            } catch (SQLException e_sql){
                out.println("接続時にエラーが発生しました(SQL)："+e_sql.toString());
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
