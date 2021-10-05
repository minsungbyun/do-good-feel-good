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

      QuestionListDTO questionListDTO = questionDao.findByNo(questionNo);

      try {
        if (questionListDTO == null) {
          System.out.println("해당 번호의 게시글이 없습니다.");
          return;
        }

        if (questionListDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
          System.out.println("삭제 권한이 없습니다.");
          return;
        }


        QuestionListDTO updateQuestion = new QuestionListDTO();

        updateQuestion.setTitle(Prompt.inputString("제목(" + questionListDTO.getTitle() + ")? "));
        updateQuestion.setContent(Prompt.inputString("내용(" + questionListDTO.getContent() + ")? "));
        updateQuestion.setFileUpload(Prompt.inputString("첨부파일(" + questionListDTO.getFileUpload() + ")? "));

        String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
        if (input.equalsIgnoreCase("n") /*|| input.length() == 0*/) {
          System.out.println("게시글 수정을 취소하였습니다.");
          return;
        } 
        questionDao.update(updateQuestion);
        System.out.println();

        System.out.println("게시글 수정이 완료되었습니다.");
      } catch (Throwable e) {
      }
    }
  }

}