package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.util.Prompt;

public class QuestionUpdateHandler extends AbstractQuestionHandler {

  public QuestionUpdateHandler(List<QuestionListDTO> myQuestionListDTOList) {
    super (myQuestionListDTOList);
  }

  public void execute() {

    System.out.println();
    System.out.println("[메인/고객센터/문의하기/게시글 수정]");
    int no = Prompt.inputInt("번호? ");

    QuestionListDTO myQuestionListDTO = findByNo(no);

    if (myQuestionListDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", myQuestionListDTO.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", myQuestionListDTO.getContent()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    myQuestionListDTO.setTitle(title);
    myQuestionListDTO.setContent(content);
    System.out.println("게시글을 변경하였습니다.");
  }


}