package com.share.ftp.web.auth;

import static com.share.util.General.member.GROUP;
import static com.share.util.General.member.ORG;
import static com.share.util.General.member.PERSONAL;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/auth")
public class AuthController {

  private static final Logger logger = LogManager.getLogger(AuthController.class);

  @Autowired JoinDao joinDao;
  @Autowired OrgDao orgDao;
  @Autowired GroupDao groupDao;
  @Autowired PersonalDao personalDao;
  @Autowired ServletContext sc;

  @GetMapping("loginForm")
  public ModelAndView loginForm() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "HappyShare : 로그인");
    mv.addObject("contentUrl", "auth/LoginForm.jsp");
    mv.setViewName("template1");
    logger.info("로그인 화면 이동!");
    return mv;
  }

  @PostMapping("login")
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
      logger.info(cookie.getName()+ "이름의 쿠키 생성");

    } else {
      cookie = new Cookie("id", "");
      cookie.setMaxAge(0);
    }

    response.addCookie(cookie);

    ModelAndView mv = new ModelAndView();
    JoinDTO admin = new JoinDTO();
    admin.setId("admin");
    admin.setName("admin");
    admin.setPassword("1111");

    if (id.equals("admin") && password.equals("1111")) {
      session.setAttribute("admin", admin);
      mv.setViewName("redirect:loginList");
      logger.info("관리자 로그인 성공");
      return mv;
    }

    JoinDTO loginUser = joinDao.findByIdPassword(id, password);

    if (loginUser != null) {
      if (loginUser.getType() == ORG) {
        OrgDTO orgLoginUser = orgDao.findByOrgNo(loginUser.getNo());
        session.setAttribute("orgLoginUser", orgLoginUser);
        logger.info(orgLoginUser+" 세션 할당 완료");

      } else if(loginUser.getType() == GROUP) {
        GroupDTO groupLoginUser = groupDao.findByGroupNo(loginUser.getNo());
        session.setAttribute("groupLoginUser", groupLoginUser);
        logger.info(groupLoginUser+" 세션 할당 완료");

      } else if(loginUser.getType() == PERSONAL) {
        PersonalDTO personalLoginUser = personalDao.findByPersonalNo(loginUser.getNo());
        session.setAttribute("personalLoginUser", personalLoginUser);
        logger.info(personalLoginUser+" 세션 할당 완료");

      }

      session.setAttribute("loginUser", loginUser);
      mv.setViewName("redirect:../home");
      logger.info(loginUser.getId()+" 로그인 완료");
      return mv;

    } else {
      mv.addObject("pageTitle", "HappyShare : 로그인"); 
      mv.addObject("contentUrl", "auth/LoginForm.jsp"); 
      mv.setViewName("template1");
      logger.info("로그인 실패");
      return mv;
    }
  }

  @GetMapping("logout")
  public ModelAndView logout(HttpSession session) throws Exception {

    session.invalidate();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:loginForm");
    logger.info("정상적으로 로그아웃 되었습니다!");
    return mv;
  }

  @GetMapping("loginList")
  public ModelAndView userList(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<JoinDTO> joinUserList = joinDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("joinUserList", joinUserList);
    mv.addObject("pageTitle", "HappyShare : 관리자"); 
    mv.addObject("contentUrl", "auth/LoginList.jsp");  
    mv.setViewName("template2");
    logger.info("관리자 메인 페이지 접속완료!");
    return mv;
  }
}






