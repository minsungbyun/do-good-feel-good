package com.share.ftp.handler.personal.support;

import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class QuestionDeleteHandler implements Command {

  QuestionDao questionDao;

  public QuestionDeleteHandler(QuestionDao questionDao) {
    this.questionDao = questionDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    while (true) {

      System.out.println();
      System.out.println("[고객센터/문의하기/문의하기 삭제]");
      //      int no = Prompt.inputInt("번호? ");

      int questionNo = (int) request.getAttribute("questionNo");

      QuestionListDTO questionListDTO = questionDao.findByNo(questionNo);

      try {
        if (questionListDTO == null) {
          System.out.println("해당 번호의 게시글이 없습니다.");
          return;
        }

        if (questionListDTO.getOwner().getId() == (AuthLoginHandler.getLoginUser().getId()) ||
            AuthLoginHandler.getLoginUser().getId().equals("admin")) {

          String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
          if (input.equalsIgnoreCase("n") || input.length() == 0) {
            System.out.println("게시글 삭제를 취소하였습니다.");
            return;
          } 

          questionDao.delete(questionNo);
          System.out.println();

          System.out.println("게시글을 삭제하였습니다.");
        }

        //        if (QuestionListDTO == null) {
        //          System.out.println("해당 번호의 게시글이 없습니다.");
        //          return;
        //        }
        //
        //        if (QuestionListDTO.getOwner().getId() == (AuthLoginHandler.getLoginUser().getId()) ||
        //            AuthLoginHandler.getLoginUser().getId().equals("admin")) {
        //
        //          String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
        //          if (input.equalsIgnoreCase("n") /*|| input.length() == 0 */) {
        //            System.out.println("게시글 삭제를 취소하였습니다.");
        //            return;
        //          } else if(input.equals("y")) {
        //            System.out.println("게시글을 삭제하였습니다.");
        //            myQuestionListDTOList.remove(QuestionListDTO);
        //            return;
        //          } else  {
        //            System.out.println("y 또는 n을 입력하세요.");
        //            continue;  
        //          } 
        //        }

        if (questionListDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
          System.out.println("삭제 권한이 없습니다.");
          return;
        }
      } catch (Throwable e) {

      }
    }
  }
}