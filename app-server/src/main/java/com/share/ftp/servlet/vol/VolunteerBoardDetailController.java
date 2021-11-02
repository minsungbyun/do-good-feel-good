package com.share.ftp.servlet.vol;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardDTO;

@WebServlet("/vol/board/detail")
public class VolunteerBoardDetailController extends GenericServlet {
  private static final long serialVersionUID = 1L;

  VolunteerBoardDao volunteerBoardDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerBoardDao = (VolunteerBoardDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    try {
      int volBoardNo = Integer.parseInt(request.getParameter("no"));
      VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(volBoardNo);

      if (volunteerBoardDTO == null) {
        throw new Exception("[  해당 게시글이 없습니다.  ]");
      }

      request.setAttribute("volunteerBoardDTO", volunteerBoardDTO);
      request.getRequestDispatcher("/vol/board/VolunteerBoardDetail.jsp").forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}


//      System.out.printf("번호 ▶ %s\n", volunteerBoardDTO.getNo());
//      System.out.printf("아이디 ▶ %s\n", volunteerBoardDTO.getOwner().getId());
//      System.out.printf("제목 ▶ %s\n", volunteerBoardDTO.getTitle());
//      System.out.printf("내용 ▶ %s\n", volunteerBoardDTO.getContent());
//
//      volunteerBoardDTO.setViewCount(volunteerBoardDTO.getViewCount() + 1);
//      System.out.printf("조회수 ▶ %d\n", volunteerBoardDTO.getViewCount());
//      System.out.printf("좋아요♡  %d\n", volunteerBoardLike);
//
//      for (VolunteerBoardAttachedFile file : volunteerBoardDTO.getFileUpload()) {
//        System.out.printf("%s\n", file.getFilepath());
//      }
//
//      volunteerBoardDao.updateCount(volBoardNo);
//      sqlSession.commit();
//
//      JoinDTO loginUser = AuthLoginHandler.getLoginUser(); 
//
//      if (loginUser == null) {
//        System.out.println("로그인 해주세요.");
//        return;
//      }
//
//      if ((volunteerBoardDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
//          AuthLoginHandler.getLoginUser().getId().equals("admin")) {
//
//        request.setAttribute("volBoardNo", volBoardNo);
//
//        while (true) {
//          String input = Prompt.inputString("변경(U), 삭제(D), 댓글(R), 이전(0)>");
//          switch (input) {
//            case "U":
//            case "u":
//              request.getRequestDispatcher("/volunteerBoard/update").forward(request);
//              return;
//            case "D":
//            case "d":
//              request.getRequestDispatcher("/volunteerBoard/delete").forward(request);
//              return;
//            case "R":
//            case "r":
//              request.getRequestDispatcher("/volunteerBoardComment/list").forward(request);
//              return;
//            case "0":
//              return;
//            default:
//              System.out.println("명령어가 올바르지 않습니다!");
//          }
//        } 
//      } 
//
//      if (loginUser!= null) {
//
//        request.setAttribute("volBoardNo", volBoardNo);
//
//        while (true) {
//          String input = Prompt.inputString("좋아요(L), 댓글(R), 이전(0)>");
//          switch (input) {
//            case "L":
//            case "l":
//              request.getRequestDispatcher("/volunteerBoard/like").forward(request);
//              return;
//            case "R":
//            case "r":
//              request.getRequestDispatcher("/volunteerBoardComment/list").forward(request);
//              return;
//            case "0":
//              return;
//            default:
//              System.out.println("명령어가 올바르지 않습니다!");
//          }
//        } 
//
//
//      }
//    }
//  }
//}
//
