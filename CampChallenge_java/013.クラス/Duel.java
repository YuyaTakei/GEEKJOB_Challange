package jackpack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Duel extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //ディーラーとユーザーのインスタンス作成
            Dealer COM = new Dealer();
            User You = new User();

            //それぞれにディール
            out.print("●ディールします<br>");
            out.print("――――――――――<br>");
            //Dealer
            COM.setCard(COM.deal());
            out.print("ディーラー<br>" + COM.myCards);
            out.print("　合計" + COM.open() + "<br>");
            out.print("―――――――――――――――<br>");
            //User
            You.setCard(COM.deal());
            out.print("あなた<br>" + You.myCards);
            out.print("　合計" + You.open() + "<br>");
            out.print("――――――――――<br><br><br>");

            out.print("●ヒットorスタンド？<br>");
            out.print("――――――――――<br>");
            //それぞれの状態を格納する変数を用意
            String COMstate = "";
            String Youstate = "";

            
                while (You.checkSum() == true) {
                    out.print("あなた<br>ヒット　");
                    You.setCard(COM.hit());
                    out.print(You.myCards + "　合計" + You.open() + "<br><br>");
                }
            //あなた　の状態を表示
            if (You.open() < 21) {
                out.print("あなた<br>スタンド");
            } else if (You.open() > 21) {
                out.print("あなた<br>バスト！");
                Youstate = "バスト";
            } else {
                out.print("あなた<br>ブラックジャック！");
                Youstate = "ブラックジャック";
            }
            out.print("<br>―――――――――――――――<br>");
            
          
                while (COM.checkSum() == true) {
                    out.print("ディーラー<br>ヒット　");
                    COM.setCard(COM.hit());
                    out.print(COM.myCards + "　合計" + COM.open() + "<br><br>");
          
            }
            //ディーラー　の状態を表示
            if (COM.open() < 21) {
                out.print("ディーラー<br>スタンド");
            } else if (COM.open() > 21) {
                out.print("ディーラー<br>バスト！");
                COMstate = "バスト";
            } else {
                out.print("ディーラー<br>ブラックジャック！");
                COMstate = "ブラックジャック";
            }
            out.print("<br>――――――――――<br><br><br>");

            out.print("●オープンします<br>");
            out.print("――――――――――<br>");
            out.print("あなた　" + You.open() + You.myCards + "　" + Youstate);
            out.print("<br>―――――――――――――――<br>");
            out.print("ディーラー　" + COM.open() + COM.myCards + "　" + COMstate);
            out.print("<br>――――――――――<br><br><br>●");

            String win = "あなたの勝ちです";
            String lose = "あなたの負けです";
            String drow = "引き分けです";

            if (You.open() > 21) {
                out.print(lose);
            } else if (COM.open() > 21) {
                out.print(win);
            } else if (You.open() == COM.open()) {
                out.print(drow);
            } else if (You.open() == 21) {
                out.print(win);
            } else {
                if (You.open() > COM.open()) {
                    out.print(win);
                } else if (You.open() == COM.open()) {
                    out.print(drow);
                } else {
                    out.print(lose);
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
