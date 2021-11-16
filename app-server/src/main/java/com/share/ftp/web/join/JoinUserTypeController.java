package com.share.ftp.web.join;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinUserTypeController {

  @GetMapping("/join/userType")
  public ModelAndView userType() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "HappyShare : 회원가입유형");
    mv.addObject("contentUrl", "join/JoinUserType.jsp");
    mv.setViewName("template1");
    return mv;
  }

}







