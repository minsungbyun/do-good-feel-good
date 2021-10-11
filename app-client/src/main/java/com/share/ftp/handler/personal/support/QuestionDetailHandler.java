package com.share.ftp.handler.personal.support;

import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionListDTO;
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

    QuestionListDTO questionListDTO = questionDao.findByQuestionNo(questionNo);

    if (questionListDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    while (true) {

      if (AuthLoginHandler.getLoginUser().getId().equals("admin")) {

        System.out.printf("번호: %s\n", questionListDTO.getNo());
        System.out.printf("문의분야: %s\n", questionListDTO.getQnaType());
        System.out.printf("제목: %s\n", questionListDTO.getTitle());
        System.out.printf("아이디: %s\n", questionListDTO.getOwner().getId());
        System.out.printf("내용: %s\n", questionListDTO.getContent());
        System.out.printf("첨부파일: %s\n", questionListDTO.getFileUpload());
        System.out.printf("등록일: %s\n", questionListDTO.getRegisteredDate());

        questionListDTO.setViewCount(questionListDTO.getViewCount() + 1);
        System.out.printf("조회수: %d\n", questionListDTO.getViewCount());

        questionDao.update(questionListDTO);
        break;

      } else if (AuthLoginHandler.getLoginUser().getId().equals(questionListDTO.getOwner().getId())) {

        int password = Prompt.inputInt("비밀번호: ");


        if (password == questionListDTO.getPassword()) {

          System.out.printf("번호: %s\n", questionListDTO.getNo());
          System.out.printf("문의분야: %s\n", questionListDTO.getQnaType());
          System.out.printf("제목: %s\n", questionListDTO.getTitle());
          System.out.printf("아이디: %s\n", questionListDTO.getOwner().getId());
          System.out.printf("내용: %s\n", questionListDTO.getContent());
          System.out.printf("첨부파일: %s\n", questionListDTO.getFileUpload());
          System.out.printf("등록일: %s\n", questionListDTO.getRegisteredDate());

          questionListDTO.setViewCount(questionListDTO.getViewCount() + 1);
          System.out.printf("조회수: %d\n", questionListDTO.getViewCount());

          questionDao.update(questionListDTO);
          break;

        } else {
          System.out.println();
          System.out.println("비밀번호가 틀렸습니다.");
          System.out.println("비밀번호를 다시 입력해주세요.");

        }
      } else if (questionListDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId() ||
          !AuthLoginHandler.getLoginUser().getId().equals("admin")) {
        System.out.println("본인이 작성한 글만 확인할 수 있습니다.");
        return;
      }

    }


    if (questionListDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {

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