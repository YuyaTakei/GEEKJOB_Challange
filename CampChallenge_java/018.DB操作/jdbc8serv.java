package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class jdbc8serv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //DB操作を行うクラスDb8のインスタンス作成
            Db8 db = new Db8();
            //ArrayListを返し値とするメソッドの受け皿作成
            ArrayList prof = new ArrayList();

            request.setCharacterEncoding("UTF-8");
            //フォームから送られてきた名前をStringに格納
            String name = request.getParameter("name");

            //フォームに何も入力されていなければ入力を促す
            if (name.equals("") || name.equals(" ") || name == null) {
                out.print("1文字以上入力してください");

                //入力されていれば入力内容を表示
            } else {
                out.print("検索:" + name + "<br><br>");

                int i = 0;
                prof = db.getProfiles(name);
                //ArrayList p = new ArrayList();
                //p.add(prof.get(0));

                //メソッドによりArrayListに値が格納されていれば
                if (prof.size() != 0) {

                        for (i = 0; i <= prof.size(); i += 5) {
                            out.print("ID:" + prof.get(i) + "<br>");
                            out.print("名前:" + prof.get(i+1) + "<br>");
                            out.print("電話番号:" + prof.get(i+2) + "<br>");
                            out.print("年齢:" + prof.get(i+3) + "<br>");
                            out.print("生年月日:" + prof.get(i+4) + "<br><br>");
                        }
                    
                    //格納されていなければ
                } else {
                    out.print("見つかりませんでした");
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
