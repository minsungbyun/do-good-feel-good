package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.QuestionDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminQuestionDeleteHandler extends AbstractAdminQuestionHandler {



  public AdminQuestionDeleteHandler(List<QuestionDTO> questionDTOList) {
    super(questionDTOList);
  }


  public void execute(CommandRequest request) throws Exception {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    QuestionDTO questionDTO = findByNo(no);

    if (questionDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    questionDTOList.remove(questionDTO);

    System.out.println("게시글을 삭제하였습니다.");
  }



}
