package com.share.ftp.handler.personal.support;

import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class QuestionDetailHandler implements Command {

  QuestionDao questionDao;

  public QuestionDetailHandler(QuestionDao questionDao) {
    this.questionDao = questionDao;

  }
  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[고객센터/문의하기/상세보기]");

    int questionNo = Prompt.inputInt("번호? ");

    QuestionListDTO myQuestionListDTO = questionDao.findByNo(questionNo);

    if (myQuestionListDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    while (true) {

      if (AuthLoginHandler.getLoginUser().getId().equals("admin")) {

        System.out.printf("번호: %s\n", myQuestionListDTO.getNo());
        System.out.printf("문의분야: %s\n", myQuestionListDTO.getQnaType());
        System.out.printf("제목: %s\n", myQuestionListDTO.getTitle());
        System.out.printf("아이디: %s\n", myQuestionListDTO.getOwner().getId());
        System.out.printf("내용: %s\n", myQuestionListDTO.getContent());
        System.out.printf("첨부파일: %s\n", myQuestionListDTO.getFileUpload());
        System.out.printf("등록일: %s\n", myQuestionListDTO.getRegisteredDate());

        myQuestionListDTO.setViewCount(myQuestionListDTO.getViewCount() + 1);
        System.out.printf("조회수: %d\n", myQuestionListDTO.getViewCount());
        break;

      } else if (AuthLoginHandler.getLoginUser().getId().equals(myQuestionListDTO.getOwner().getId())) {

        int password = Prompt.inputInt("비밀번호: ");


        if (password == myQuestionListDTO.getPassword()) {

          System.out.printf("번호: %s\n", myQuestionListDTO.getNo());
          System.out.printf("문의분야: %s\n", myQuestionListDTO.getQnaType());
          System.out.printf("제목: %s\n", myQuestionListDTO.getTitle());
          System.out.printf("아이디: %s\n", myQuestionListDTO.getOwner().getId());
          System.out.printf("내용: %s\n", myQuestionListDTO.getContent());
          System.out.printf("첨부파일: %s\n", myQuestionListDTO.getFileUpload());
          System.out.printf("등록일: %s\n", myQuestionListDTO.getRegisteredDate());

          myQuestionListDTO.setViewCount(myQuestionListDTO.getViewCount() + 1);
          System.out.printf("조회수: %d\n", myQuestionListDTO.getViewCount());
          break;

        } else {
          System.out.println();
          System.out.println("비밀번호를 다시 입력해주세요.");

        }
      } else if (myQuestionListDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId() ||
          !AuthLoginHandler.getLoginUser().getId().equals("admin")) {
        System.out.println("본인이 작성한 글만 확인할 수 있습니다.");
        return;
      }

    }


    if (myQuestionListDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {

      request.setAttribute("questionNo", questionNo);

      while (true) {
        String input = Prompt.inputString("변경(U), 삭제(D), 이전(0)>");
        switch (input) {
          case "U":
          case "u":
            request.getRequestDispatcher("/question/update").forward(request);
            return;
          case "D":
          case "d":
            request.getRequestDispatcher("/question/delete").forward(request);
            return;
          case "0":
            return;
          default:
            System.out.println("명령어가 올바르지 않습니다!");
        }
      }
    }

    if (AuthLoginHandler.getLoginUser().getId().equals("admin")) {
      request.setAttribute("questionNo", questionNo);

      while (true) {
        String input = Prompt.inputString("삭제(D), 답글(A), 이전(0)>");
        switch (input) {
          case "D":
          case "d":
            request.getRequestDispatcher("/question/delete").forward(request);
            return;
          case "A":
          case "a":
            request.getRequestDispatcher("/adminQuestion/connect").forward(request);
            return;
          case "0":
            return;
          default:
            System.out.println("명령어가 올바르지 않습니다!");
        }
      }
    }

  } 


}