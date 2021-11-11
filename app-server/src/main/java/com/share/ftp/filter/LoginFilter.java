package com.share.ftp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@WebFilter("/auth/*") 
public class LoginFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpSession session = httpRequest.getSession(false);

    boolean login = false;

    if (session != null) {

      if (session.getAttribute("userId") != null &&
          session.getAttribute("userPassoword") != null) {
        login = true; // session이 있으면 true 설정
      }
    }


    // 세션이 있을 경우, 필터거쳐서 서버쪽으로 들어간다.
    if (login) {
      chain.doFilter(request, response);
      // 세션이 null일 경우, 로그인 폼으로 이동한다.
    } else {
      System.out.println("실패");
      request.getRequestDispatcher("/login/Login.jsp").forward(request, response);

    }
  }

  @Override
  public void destroy() {

  }

}
