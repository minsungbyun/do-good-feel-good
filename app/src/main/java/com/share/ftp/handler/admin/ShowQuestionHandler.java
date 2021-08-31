package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.QuestionDTO;
import com.share.util.Prompt;

public class ShowQuestionHandler {

  List<QuestionDTO> questionDTOList;

  public ShowQuestionHandler(List<QuestionDTO> questionDTOList) {
    this.questionDTOList = questionDTOList;
  }

  public void addreply() {
    System.out.println("[문의사항 등록]");

    QuestionDTO questionDTO = new QuestionDTO();

    questionDTO.setAdminId(Prompt.inputInt("관리자ID: "));
    questionDTO.setTitle(Prompt.inputString("제목: "));
    questionDTO.setContent(Prompt.inputString("내용: "));

    questionDTOList.add(questionDTO);
  }

  public void list() {
    System.out.println("[문의사항 목록]");
    for (QuestionDTO questionDTO : questionDTOList) {
      System.out.printf("%d, %s, %s\n", 
          questionDTO.getAdminId(), 
          questionDTO.getTitle(), 
          questionDTO.getContent());
    }
  }

  public void detail() {
    System.out.println("[문의사항 상세보기]");
    int no = Prompt.inputInt("관리자ID: ");

    QuestionDTO questionDTO = findByNo(no);

    if (questionDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", questionDTO.getTitle());
    System.out.printf("내용: %s\n", questionDTO.getContent());
  }

  public void update() {
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

  public void delete() {
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

  private QuestionDTO findByNo(int no) {
    QuestionDTO[] arr = questionDTOList.toArray(new QuestionDTO[0]);
    for (QuestionDTO questionDTO : arr) {
      if (questionDTO.getNo() == no) {
        return questionDTO;
      }
    }
    return null;
  }

}
