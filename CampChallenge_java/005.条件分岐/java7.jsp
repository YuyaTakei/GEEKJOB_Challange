<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    char lang = 'C';
    switch(lang){
    case 'A':
        out.print("英語");
        break;
    case 'あ':
        out.print("日本語");
        break;
    }
    %>