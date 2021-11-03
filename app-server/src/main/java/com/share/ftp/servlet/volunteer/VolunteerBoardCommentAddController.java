package com.share.ftp.servlet.volunteer;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;
import com.share.ftp.domain.join.JoinDTO;

@WebServlet("/volunteer/commentAdd")
public class VolunteerBoardCommentAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  VolunteerBoardDao volunteerBoardDao;
  VolunteerBoardCommentDao volunteerBoardCommentDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    volunteerBoardDao = (VolunteerBoardDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardDao");
    volunteerBoardCommentDao = (VolunteerBoardCommentDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardCommentDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    VolunteerBoardCommentDTO volunteerBoardCommentDTO = new VolunteerBoardCommentDTO();

    JoinDTO owner = new JoinDTO();
    owner.setNo(Integer.parseInt(request.getParameter("owner")));

    volunteerBoardCommentDTO.setVolBoardNo(0);
    volunteerBoardCommentDTO.setOwner(owner);
    volunteerBoardCommentDTO.setCommentContent(request.getParameter("content")); 
    volunteerBoardCommentDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    try {
      volunteerBoardCommentDao.insert(volunteerBoardCommentDTO);
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=commentList");
      request.getRequestDispatcher("VolunteerBoardCommentAdd.jsp").forward(request, response);

    } catch (Exception e) {

      e.printStackTrace();  
      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
      request.setAttribute("error", e);

      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }

    //    try {
    //      noticeDao.insert(noticeDTO);
    //      for (NoticeAttachedFile noticeAttachedFile : noticeDTO.getFileUpload()) {
    //        noticeDao.insertFile(noticeDTO.getNo(), noticeAttachedFile.getFilepath());
    //      }
    //      sqlSession.commit();
    //
    //    } catch (Exception e) {
    //      e.printStackTrace(); 
    //      sqlSession.rollback();
    //    }


  }
}
