package Method1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class method7 extends HttpServlet {
    String[] array(int id){
        String[]satou = {"1","佐藤太郎","1月1日","東京"};
        String[]isurugi ={"2","石動惣一","2月2日",null};
        String[]katsuragi ={"3","葛城巧","3月3日","北海道"};
        String[][]meibo={satou,isurugi,katsuragi};
        return meibo[id-1];
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           for(int id=1; id<=3; id++){
           String[] profile=array(id);
            for(int num=1; num<=3; num++){
            if(profile[num] == null){
                out.print("<br>");
                continue;
            }
              switch(num){
                case 1:
                    out.print("名前 "+profile[1]+"<br>");
                    break;
                case 2:
                    out.print("生年月日 "+profile[2]+"<br>");
                    break;
                case 3:
                    out.print("住所 "+profile[3]+"<br><br>");
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
