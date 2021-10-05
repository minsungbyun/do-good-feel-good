package com.share.ftp.handler.personal.support;

import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class QuestionUpdateHandler implements Command {

  QuestionDao questionDao;

  public QuestionUpdateHandler(QuestionDao questionDao) {
    this.questionDao = questionDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    while (true) {

      System.out.println();
      System.out.println("[메인/고객센터/문의하기/게시글 수정]");
      int questionNo = (int)request.getAttribute("questionNo");

      QuestionListDTO myQuestionListDTO = questionDao.findByNo(questionNo);

      try {
        if (myQuestionListDTO == null) {
          System.out.println("해당 번호의 게시글이 없습니다.");
          return;
        }

        if (myQuestionListDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
          System.out.println("삭제 권한이 없습니다.");
          return;
        }


        QuestionListDTO updateQuestion = new QuestionListDTO();

        updateQuestion.setTitle(String.format("제목(%s)? ", myQuestionListDTO.getTitle()));
        updateQuestion.setContent(String.format("내용(%s)? ", myQuestionListDTO.getContent()));
        updateQuestion.setFileUpload(String.format("파일첨부(%s)? ", myQuestionListDTO.getFileUpload()));

        String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
        if (input.equalsIgnoreCase("n") /*|| input.length() == 0*/) {
          System.out.println("게시글 수정을 취소하였습니다.");
          return;
        } else if (input.equals("y")) {
          System.out.println("게시글을 수정하였습니다.");
          myQuestionListDTO.setTitle(title);
          myQuestionListDTO.setContent(content);
          return;
        } else {
          System.out.println("y 또는 n을 입력하세요.");
          continue;
        }
      } catch (Throwable e) {
      }
    }
  }

}