//package org.zerock.bitboard.filter;
//
//import lombok.extern.log4j.Log4j2;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(filterName = "signin", urlPatterns = {"/board/register", "/board/read"}) //register, read 기져올 때 필터사용
//@Log4j2
//public class SigninFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        log.info("Signin Filter...............run...............");
//
//        //다운캐스팅
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//
//        HttpSession session = req.getSession();
//
//        //로그인 사용자 걸러내기
//        //not yet login
//        if(session.getAttribute("member") == null){
//
//            res.sendRedirect("/login");
//            return;
//
//        }
//
//        chain.doFilter(request, response);
//
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
