package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.QuestionDTO;
import com.share.util.Prompt;

public class AdminQuestionUpdateHandler extends AbstractAdminQuestionHandler {


  public AdminQuestionUpdateHandler(List<QuestionDTO> questionDTOList) {
    super(questionDTOList);
  }

  public void execute() {
    System.out.println("[문의사항 변경]");
    int no = Prompt.inputInt("번호? ");

    QuestionDTO questionDTO = findByNo(no);

    if (questionDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", questionDTO.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", questionDTO.getContent()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    questionDTO.setTitle(title);
    questionDTO.setContent(content);
    System.out.println("게시글을 변경하였습니다.");
  }



}
