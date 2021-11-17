package com.share.ftp.web.support;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionListDTO;

@WebServlet("/support/questionDetail")
public class QuestionDetailController extends GenericServlet {
  private static final long serialVersionUID = 1L;

  QuestionDao questionDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    questionDao = (QuestionDao) 웹애플리케이션공용저장소.getAttribute("questionDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    try {
      int questionNo = Integer.parseInt(request.getParameter("questionNo"));
      QuestionListDTO questionListDTO = questionDao.findByNo(questionNo);

      questionDao.findByPassword(questionNo, request.getParameter("qnaPassword"));

      if (questionListDTO == null) {
        throw new Exception("해당 번호의 게시글이 없습니다.");
      }

      System.out.println(questionListDTO);

      request.setAttribute("questionListDTO", questionListDTO);

      request.setAttribute("pageTitle", "문의사항 상세");
      request.setAttribute("contentUrl", "/support/QuestionDetail.jsp");
      request.getRequestDispatcher("/template1.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }


  //    while (true) {
  //
  //      if (AuthLoginHandler.getLoginUser().getId().equals("admin")) {
  //
  //        System.out.printf("번호: %s\n", questionListDTO.getNo());
  //        System.out.printf("문의분야: %s\n", questionListDTO.getQnaType().getTitle());
  //        System.out.printf("제목: %s\n", questionListDTO.getTitle());
  //        System.out.printf("아이디: %s\n", questionListDTO.getOwner().getId());
  //        System.out.printf("내용: %s\n", questionListDTO.getContent());
  //        System.out.printf("등록일: %s\n", questionListDTO.getRegisteredDate());
  //        questionListDTO.setViewCount(questionListDTO.getViewCount() + 1);
  //        System.out.printf("조회수: %d\n", questionListDTO.getViewCount());
  //
  //        for (QuestionAttachedFile questionAttachedFile : questionListDTO.getFileUpload()) {
  //          System.out.printf("첨부파일: %s\n", questionAttachedFile.getFilepath());
  //        }
  //
  //        if (questionListDTO.getStatus() == 1) {
  //          System.out.println("-------------------------------------");
  //          System.out.printf("제목: %s번 문의 답변드립니다.\n",
  //              questionListDTO.getNo());
  //          System.out.printf("%s", questionListDTO.getReply());
  //          System.out.println();
  //        }
  //        break;
  //
  //      } else if (AuthLoginHandler.getLoginUser().getId().equals(questionListDTO.getOwner().getId())) {
  //
  //        String password = Prompt.inputString("비밀번호: ");
  //
  //        QuestionListDTO qnaDTO = questionDao.findByPassword(questionNo, password);
  //
  //        //        !questionListDTO.getQnaPassword().equals(questionListDTO1.getQnaPassword()) || 
  //        if (
  //            qnaDTO == null) {
  //          System.out.println();
  //          System.out.println("비밀번호가 틀렸습니다.");
  //          System.out.println("비밀번호를 다시 입력해주세요.");
  //          continue;
  //        }
  //
  //        System.out.printf("번호: %s\n", questionListDTO.getNo());
  //        System.out.printf("문의분야: %s\n", questionListDTO.getQnaType().getTitle());
  //        System.out.printf("제목: %s\n", questionListDTO.getTitle());
  //        System.out.printf("아이디: %s\n", questionListDTO.getOwner().getId());
  //        System.out.printf("내용: %s\n", questionListDTO.getContent());
  //        //          System.out.printf("첨부파일: %s\n", questionListDTO.getFileUpload());
  //        System.out.printf("등록일: %s\n", questionListDTO.getRegisteredDate());
  //
  //        questionListDTO.setViewCount(questionListDTO.getViewCount() + 1);
  //        System.out.printf("조회수: %d\n", questionListDTO.getViewCount());
  //
  //        for (QuestionAttachedFile questionAttachedFile : questionListDTO.getFileUpload()) {
  //          System.out.printf("첨부파일: %s\n", questionAttachedFile.getFilepath());
  //        }
  //        if (questionListDTO.getStatus() == 1) {
  //          System.out.println("-------------------------------------");
  //          System.out.printf("제목: %s번 문의 답변드립니다.\n",
  //              questionListDTO.getNo());
  //          System.out.printf("%s", questionListDTO.getReply());
  //          System.out.println();
  //        }
  //        break;
  //
  //      } else if (questionListDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId() ||
  //          !AuthLoginHandler.getLoginUser().getId().equals("admin")) {
  //        System.out.println("본인이 작성한 글만 확인할 수 있습니다.");
  //        return;
  //      }
  //
  //    }
  //
  //
  //    if (questionListDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
  //
  //      request.setAttribute("questionNo", questionNo);
  //
  //      while (true) {
  //        String input = Prompt.inputString("수정(U), 삭제(D), 이전(0)>");
  //        switch (input) {
  //          case "U":
  //          case "u":
  //            request.getRequestDispatcher("/question/update").forward(request);
  //            return;
  //          case "D":
  //          case "d":
  //            request.getRequestDispatcher("/question/delete").forward(request);
  //            return;
  //          case "0":
  //            return;
  //          default:
  //            System.out.println("명령어가 올바르지 않습니다!");
  //        }
  //      }
  //    }
  //
  //    if (AuthLoginHandler.getLoginUser().getId().equals("admin")) {
  //      request.setAttribute("questionNo", questionNo);
  //
  //      while (true) {
  //        String input = Prompt.inputString("답변삭제(D), 답변등록(A), 답변수정(U), 이전(0)>");
  //        switch (input) {
  //          case "D":
  //          case "d":
  //            request.getRequestDispatcher("/adminReply/delete").forward(request);
  //            return;
  //          case "A":
  //          case "a":
  //            request.getRequestDispatcher("/adminReply/add").forward(request);
  //            return;
  //          case "U":
  //          case "u":
  //            request.getRequestDispatcher("/adminReply/update").forward(request);
  //            return;
  //          case "0":
  //            return;
  //          default:
  //            System.out.println("명령어가 올바르지 않습니다!");
  //        }
  //      }
  //    }
  //
  //  } 
}