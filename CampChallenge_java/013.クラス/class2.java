package clapack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class Human{
        //パブリックな2つの変数を用意（フィールド）
        public String name ="";
        public int age =0;
        //2つの変数に値を設定するパブリックなメソッド
        public void setHuman(String n,int i){
            this.name =n;
            this.age =i;
        }
        //2つの変数の中身をprintするパブリックなメソッド
        public void printHuman(PrintWriter out){
            out.print("名前　"+this.name+"<br>");
            out.print("年齢　"+this.age+"<br><br>");
        }
}
//Humanクラスを継承するnoHumanクラス
class noHuman extends Human{
    //2つの変数の中身をクリアするパブリックなメソッドを実装
    public void clearHuman(){
         this.name = "";
         this.age = 0;
    }
}

public class class2 extends HttpServlet {
    
    

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //hitoというnoHuman（Humanを継承）クラスのインスタンスを作る
            noHuman hito= new noHuman();
            
            //インスタンス hito のフィールドに情報をセットするメソッドを利用
            hito.setHuman("佐藤",22);
            
            //インスタンス hito の中身をprintするメソッドを利用
            hito.printHuman(out);
            
            //インスタンス hito の変数の中身をクリアするメソッドを利用
            hito.clearHuman();
            
            //再びprintしてクリアされているか確認
            hito.printHuman(out);
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
