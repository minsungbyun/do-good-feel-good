package com.share.ftp.web.auth;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.GroupDao;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.GroupDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.join.OrgDTO;
import com.share.ftp.domain.join.PersonalDTO;


@Controller
public class AuthController {

  @Autowired JoinDao joinDao;
  @Autowired OrgDao orgDao;
  @Autowired GroupDao groupDao;
  @Autowired PersonalDao personalDao;
  @Autowired ServletContext sc;

  @GetMapping("/auth/loginForm")
  public ModelAndView loginForm() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "HappyShare : 로그인");
    mv.addObject("contentUrl", "auth/LoginForm.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("/auth/login")
  public ModelAndView login(
      String id, 
      String password, 
      String saveId, 
      HttpServletResponse response, 
      HttpSession session)
          throws Exception {

    Cookie cookie  = null;
    if (saveId != null) {

      cookie = new Cookie("id", id);
      cookie.setMaxAge(60 * 60 * 24 * 7 * 4);
      cookie.setPath(sc.getContextPath() + "/app/auth");

    } else {
      cookie = new Cookie("id", "");
      cookie.setMaxAge(0);
    }

    response.addCookie(cookie);

    ModelAndView mv = new ModelAndView();

    if (id.equals("admin") && password.equals("1111")) {
      mv.setViewName("redirect:loginList");
      return mv;
    }

    JoinDTO loginUser = joinDao.findByIdPassword(id, password);

    if (loginUser != null) {

      if (loginUser.getType() == 3) {
        OrgDTO orgLoginUser = orgDao.findByOrgNo(loginUser.getNo());
        session.setAttribute("orgLoginUser", orgLoginUser);


      } else if(loginUser.getType() == 2) {
        GroupDTO groupLoginUser = groupDao.findByGroupNo(loginUser.getNo());
        session.setAttribute("groupLoginUser", groupLoginUser);

      } else if(loginUser.getType() == 1) {
        PersonalDTO personalLoginUser = personalDao.findByPersonalNo(loginUser.getNo());
        session.setAttribute("personalLoginUser", personalLoginUser);

      }

      session.setAttribute("loginUser", loginUser);
      mv.setViewName("redirect:../home");
      return mv;

    } else {

      mv.addObject("pageTitle", "HappyShare : 로그인"); 
      mv.addObject("contentUrl", "auth/LoginForm.jsp"); 
      mv.setViewName("template1");

      return mv;
    }

    //    if (loginUser == null || 
    //        orgLoginUser == null ||
    //        groupLoginUser == null ||
    //        personalLoginUser == null ||
    //        orgLoginUser.getStatus() == 2 ||
    //        groupLoginUser.getStatus() == 2) {
    //      System.out.println(loginUser);
    //      System.out.println(loginUser);
    //      //        response.sendRedirect("loginForm");
    //      mv.addObject("pageTitle", "HappyShare : 로그인"); 
    //      mv.addObject("contentUrl", "auth/LoginForm.jsp"); 
    //      mv.setViewName("template1");
    //      
    //      return mv;
  }






  @GetMapping("/auth/logout")
  public ModelAndView logout(HttpSession session) throws Exception {

    session.invalidate();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:loginForm");
    return mv;
  }

  @GetMapping("/auth/loginList")
  public ModelAndView userList(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<JoinDTO> joinUserList = joinDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("joinUserList", joinUserList);
    mv.addObject("pageTitle", "HappyShare : 관리자"); 
    mv.addObject("contentUrl", "auth/LoginList.jsp");  
    mv.setViewName("template2");
    return mv;
  }


}






