package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class QuestionDeleteHandler extends AbstractQuestionHandler {

  public QuestionDeleteHandler(List<QuestionListDTO> myQuestionListDTOList) {
    super (myQuestionListDTOList);
  }

  public void execute() {

    while (true) {

      System.out.println();
      System.out.println("[고객센터/문의하기/문의하기 삭제]");
      int no = Prompt.inputInt("번호? ");

      QuestionListDTO myQuestionListDTO = findByNo(no);

      try {
        if (myQuestionListDTO == null) {
          System.out.println("해당 번호의 게시글이 없습니다.");
          return;
        }

        if (myQuestionListDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
          System.out.println("삭제 권한이 없습니다.");
          return;
        }

        String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
        if (input.equalsIgnoreCase("n") /*|| input.length() == 0 */) {
          System.out.println("게시글 삭제를 취소하였습니다.");
          return;
        } else if(input.equals("y")) {
          System.out.println("게시글을 삭제하였습니다.");
          myQuestionListDTOList.remove(myQuestionListDTO);
          return;
        } else  {
          System.out.println("y 또는 n을 입력하세요.");
          continue;  
        } 

      } catch (Throwable e) {

      }
    }
  }
}