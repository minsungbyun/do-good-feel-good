package com.share.ftp.handler.personal;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.MyQuestionListDTO;
import com.share.util.Prompt;

public class QuestionListHandler {

  List<MyQuestionListDTO> myQuestionListDTOList;

  public QuestionListHandler(List<MyQuestionListDTO> myQuestionListDTOList) {
    this.myQuestionListDTOList = myQuestionListDTOList;
  }

  public void add() {

    System.out.println("[고객센터/문의하기/문의하기 등록]");

    MyQuestionListDTO myQuestionListDTO = new MyQuestionListDTO();

    myQuestionListDTO.setNo(Prompt.inputInt("번호? "));
    myQuestionListDTO.setTitle(Prompt.inputString("제목? "));
    myQuestionListDTO.setPassword(Prompt.inputInt("비밀번호? "));
    myQuestionListDTO.setContent(Prompt.inputString("내용? "));
    myQuestionListDTO.setFileUpload(Prompt.inputString("파일첨부? "));
    myQuestionListDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    myQuestionListDTOList.add(myQuestionListDTO);
  }

  public void list() {
    System.out.println("[고객센터/문의하기/문의하기 목록]");
    for (MyQuestionListDTO myQuestionListDTO : myQuestionListDTOList) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %d\n", 
          myQuestionListDTO.getNo(), 
          myQuestionListDTO.getTitle(), 
          myQuestionListDTO.getMemberld(),
          myQuestionListDTO.getContent(),
          myQuestionListDTO.getFileUpload(),
          myQuestionListDTO.getRegisteredDate(),
          myQuestionListDTO.getViewCount());
    }
  }

  public void detail() {
    System.out.println("[고객센터/문의하기/문의하기 상세]");
    int no = Prompt.inputInt("번호? ");

    MyQuestionListDTO myQuestionListDTO = findByNo(no);

    if (myQuestionListDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", myQuestionListDTO.getTitle());
    System.out.printf("내용: %s\n", myQuestionListDTO.getContent());
    System.out.printf("작성자: %s\n", myQuestionListDTO.getMemberld());
    System.out.printf("등록일: %s\n", myQuestionListDTO.getRegisteredDate());

    myQuestionListDTO.setViewCount(myQuestionListDTO.getViewCount() + 1);
    System.out.printf("조회수: %d\n", myQuestionListDTO.getViewCount());
  }

  public void update() {
    System.out.println("[게시글 수정하기]");
    int no = Prompt.inputInt("번호? ");

    MyQuestionListDTO myQuestionListDTO = findByNo(no);

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

  public void delete() {
    System.out.println("[고객센터/문의하기/문의하기 삭제]");
    int no = Prompt.inputInt("번호? ");

    MyQuestionListDTO myQuestionListDTO = findByNo(no);

    if (myQuestionListDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    myQuestionListDTOList.remove(myQuestionListDTO);

    System.out.println("게시글을 삭제하였습니다.");
  }

  private MyQuestionListDTO findByNo(int no) {
    for (MyQuestionListDTO myQuestionListDTO : myQuestionListDTOList) {
      if (myQuestionListDTO.getNo() == no) {
        return myQuestionListDTO;
      }
    }
    return null;
  }

}