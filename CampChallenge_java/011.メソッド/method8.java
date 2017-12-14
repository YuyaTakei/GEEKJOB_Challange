package Method1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class method8 extends HttpServlet {

    String[][] array() {
        String[] satou = {"1", "佐藤太郎", "1月1日", "東京"};
        String[] isurugi = {"2", "石動惣一", "2月2日", null};
        String[] katsuragi = {"3", "葛城巧", "3月3日", "北海道"};
        String[][] meibo = {satou, isurugi, katsuragi};
        return meibo;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Integer limit = 2;
            for (int id = 0; id < limit; id++) {
                for (int num = 1; num <= 3; num++) {
                    String[][] profile = array();
                    if (profile[id][num] == null) {
                        out.print("<br>");
                        continue;
                    }
                    switch (num) {
                        case 1:
                            out.print("名前 " + profile[id][num] + "<br>");
                            break;
                        case 2:
                            out.print("生年月日 " + profile[id][num] + "<br>");
                            break;
                        case 3:
                            out.print("住所 " + profile[id][num] + "<br><br>");
                            break;
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
