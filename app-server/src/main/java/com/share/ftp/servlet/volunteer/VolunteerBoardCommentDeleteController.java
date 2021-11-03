package com.share.ftp.servlet.volunteer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/volunteer/commentDelete")
public class VolunteerBoardCommentDeleteController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  //  VolunteerBoardCommentDao volunteerBoardCommentDao;
  //  SqlSession sqlSession;

  //  @Override
  //  public void init(ServletConfig config) throws ServletException {
  //    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
  //    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
  //    volunteerBoardCommentDao = (VolunteerBoardCommentDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardCommentDao");  }
  //
  //  @Override
  //  protected void service(HttpServletRequest request, HttpServletResponse response)
  //      throws ServletException, IOException {
  //
  //    try {
  //      int commentNo = Integer.parseInt(request.getParameter("no"));
  //      VolunteerBoardDTO volunteerBoardDTO = volunteerBoardCommentDao.findByCommentNo(volBoardNo, commentNo);
  //
  //      if (volunteerBoardDTO == null) {
  //        throw new Exception("해당 번호의 게시글이 없습니다.");
  //      }
  //      volunteerBoardCommentDao.delete(commentNo);
  //      sqlSession.commit();
  //
  //      response.setHeader("Refresh", "1;url=boardList");
  //
  //    } catch (Exception e) {
  //      e.printStackTrace();
  //      request.setAttribute("error", e);
  //      request.getRequestDispatcher("/Error.jsp").forward(request, response);
  //    }
  //  }
}

