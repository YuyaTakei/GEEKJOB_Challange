package fileop;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class fileop3 extends HttpServlet {

    //ログファイルに書き込むメソッド　IOExceptionはここでthrows
    static void Fw(Date now, String pro, PrintWriter out) throws IOException {
        File fp = new File("logfile.txt");
        FileWriter fw = new FileWriter(fp, true);
        SimpleDateFormat sdf
                = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        fw.write(sdf.format(now) + "　処理を" + pro + "　");
        fw.close();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Date now = new Date();
            //メソッドを用いて処理の開始をログファイルに書き込み
            Fw(now, "開始", out);

            //標準クラス（今回はMath)のロジックを作成
            int a = 5;
            int b = 10;
            int c = 25;
            //Mathクラスメソッドmax（大きい値を取得）
            out.println(Math.max(a, b));
            //メソッドmin（小さい方）
            out.println(Math.min(a, b));
            //メソッドsqrt（平方根）
            out.println(Math.sqrt(c));
            //メソッドpow(対数）
            out.println(Math.pow(a, b));
            out.print("<br>");

            //全ての処理終了後、ログファイルに書き込み
            Fw(now, "終了", out);

            File fp = new File("logfile.txt");
            //サーブレットの場合はNetBeans内ではなくGlassFish側にtextファイルが作られる
            //場所がわからない場合は↓を利用して明示
            //out.print(fp.getAbsolutePath() +"<br>");
            FileReader fr = new FileReader(fp);
            BufferedReader br = new BufferedReader(fr);
            out.print(br.readLine());
            br.close();

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
