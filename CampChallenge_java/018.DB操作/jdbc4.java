package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class jdbc4 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "YUU", "1234");
                out.println("接続に成功しました<br>");
                db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE profilesID = 1;");
                db_data = db_st.executeQuery();
                //ResultSetのnextメソッドには次の行のデータの有無を確認しtruefalseを返す効果と、その行にカーソルを移動させる効果がある
                //nextメソッドを使わずにSQLの返却値を参照しようとするとデータのない空白行が参照される→エラー
                //今回はID1だけの表示なのでwhile文は要らないが、if文を使って空白の次を参照することでエラーを防げる
                if (db_data.next()) {
                    out.print("ID：" + db_data.getInt("profilesID") + "<br>");
                    out.print("名前：" + db_data.getString("name") + "<br>");
                    out.print("電話番号：" + db_data.getString("tel") + "<br>");
                    out.print("年齢：" + db_data.getInt("age") + "<br>");
                    out.print("生年月日：" + db_data.getString("birthday") + "<br><br>");
                }
                out.print("情報を出力しました<br>");
                db_data.close();
                db_st.close();
                db_con.close();
                out.print("接続を終了しました<br>");
            } catch (SQLException e_sql) {
                out.println("接続時にエラーが発生しました(SQL)" + e_sql.toString());
            } catch (Exception e) {
                out.println("接続時にエラーが発生しました" + e.toString());
            } finally {
                if (db_data != null) {
                    try {
                        db_data.close();
                    } catch (SQLException e_data) {
                        System.out.println(e_data.getMessage());
                    } finally {
                        try {
                            if (db_st != null) {
                                db_st.close();
                            }
                        } catch (SQLException e_st) {
                            System.out.println(e_st.getMessage());
                        } finally {
                            if (db_con != null) {
                                try {
                                    db_con.close();
                                } catch (SQLException e_con) {
                                    System.out.println(e_con.getMessage());
                                }

                            }
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
