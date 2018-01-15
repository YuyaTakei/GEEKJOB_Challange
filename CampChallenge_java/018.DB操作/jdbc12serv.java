package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class jdbc12serv extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Db12 db = new Db12();
            ArrayList prof = new ArrayList();
            
            request.setCharacterEncoding("UTF-8");
            String info = request.getParameter("info");
            
            //名前で検索するメソッドを使いArrayListに追加
            prof = db.getProbyname(info);
            //メソッドにより該当データがArrayListに入っていれば出力する処理を行う
            if (prof.size() != 0) {
                
                for (int i = 0; i <= prof.size(); i += 5) {
                    out.print("ID:" + prof.get(i) + "<br>");
                    out.print("名前:" + prof.get(i + 1) + "<br>");
                    out.print("電話番号:" + prof.get(i + 2) + "<br>");
                    out.print("年齢:" + prof.get(i + 3) + "<br>");
                    out.print("生年月日:" + prof.get(i + 4) + "<br><br>");
                }
            //ArrayListに情報がなければ年齢で検索するメソッドを使う
            } else {
                prof = db.getProbyage(info);
                if (prof.size() != 0) {
                    
                    for (int i = 0; i <= prof.size(); i += 5) {
                        out.print("ID:" + prof.get(i) + "<br>");
                        out.print("名前:" + prof.get(i + 1) + "<br>");
                        out.print("電話番号:" + prof.get(i + 2) + "<br>");
                        out.print("年齢:" + prof.get(i + 3) + "<br>");
                        out.print("生年月日:" + prof.get(i + 4) + "<br><br>");
                    }
                //名前にも年齢にも該当がなければ誕生日で該当情報を検索    
                } else {
                    prof = db.getProbybirthday(info);
                    if (prof.size() != 0) {
                        
                        for (int i = 0; i <= prof.size(); i += 5) {
                            out.print("ID:" + prof.get(i) + "<br>");
                            out.print("名前:" + prof.get(i + 1) + "<br>");
                            out.print("電話番号:" + prof.get(i + 2) + "<br>");
                            out.print("年齢:" + prof.get(i + 3) + "<br>");
                            out.print("生年月日:" + prof.get(i + 4) + "<br><br>");
                        }
                    //名前、年齢、誕生日全て該当データなければ下記を出力
                    } else {
                        out.print("該当データなし");
                    }
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
