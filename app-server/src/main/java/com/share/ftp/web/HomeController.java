package com.share.ftp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @GetMapping("/home")
  public ModelAndView home() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "HappyShare : 메인화면");
    mv.addObject("contentUrl", "home.jsp");
    mv.setViewName("template1");
    return mv;
  }
}




//  @Override
//  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//    request.setAttribute("pageTitle", "HappyShare : 메인화면");
//    request.setAttribute("contentUrl", "/index.jsp");
//    request.getRequestDispatcher("/template1.jsp").forward(request, response);
//  }







