package hello.springmvc.basic.request.entity;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Member;


// 톰캣이 생성해줌
// 몇개를 생성해줄까?
// 요청이 100개 가 들어옴
// testServlet 객체는 100번이 요청
// 100개가? 존나 쳐맞는거야
// 객체를 딱 하나바께 생성안해
// singleton
// 이새끼를 하나바께 생성안하면 ? 데이터가 다르잖아
@WebServlet(name = "장민우인촌이먹튀",urlPatterns = "/장민우 인촌이 먹튀")
public class TestServlet extends HttpServlet {
    
    private String name;
    
    //비용이 비싸다는 이유 멀티쓰레드, 쓰레드를 생성하는게 cpu
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.name = request.getParameter("name"); // 장민우 ,배성환
        
        쓰레드 1번 // 배성환
        쓰레드 2번 // 배성환
        
    }
}
