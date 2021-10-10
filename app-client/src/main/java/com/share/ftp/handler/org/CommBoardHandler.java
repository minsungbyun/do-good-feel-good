package com.share.ftp.handler.org;

import java.sql.Date;
import com.share.ftp.domain.community.CommBoardDTO;
import com.share.util.Prompt;

public class CommBoardHandler {

  static final int MAX_LENGTH = 100;

  CommBoardDTO[] commBoardsDTO = new CommBoardDTO[MAX_LENGTH];
  int size;

  public void add() {

    System.out.println();
    System.out.println("[소통해요/ 나눔이야기/ 등록]");

    try {

      CommBoardDTO commBoardDTO = new CommBoardDTO();

      commBoardDTO.setCommNo(Prompt.inputInt("번호? "));
      commBoardDTO.setTitle(Prompt.inputString("제목? "));
      commBoardDTO.setContent(Prompt.inputString("내용? "));
      commBoardDTO.setFileUpload(Prompt.inputString("첨부파일? "));
      commBoardDTO.setPassword(Prompt.inputString("비밀번호? "));
      commBoardDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

      commBoardsDTO[size++] = commBoardDTO;

    } catch (Throwable e) {
      System.out.println("--------------------------------------------------------------");
      System.out.printf("오류 발생: %s\n", e.getClass().getName());
      System.out.println("--------------------------------------------------------------");
    }
  }

  public void list() {
    System.out.println();
    System.out.println("[소통해요/ 나눔이야기/ 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s, %d\n", 
          this.commBoardsDTO[i].getCommNo(), 
          this.commBoardsDTO[i].getTitle(), 
          this.commBoardsDTO[i].getContent(),
          this.commBoardsDTO[i].getFileUpload(),
          //this.commBoardsDTO[i].getPassword(),
          this.commBoardsDTO[i].getRegisteredDate(), 
          this.commBoardsDTO[i].getViewCount());
    }
  }

  public void detail() {
    System.out.println();
    System.out.println("[소통해요/ 나눔이야기/ 상세보기]");
    int no = Prompt.inputInt("번호? ");

    CommBoardDTO commBoardDTO = findByNo(no);

    if (commBoardDTO == null) {
      System.out.println("해당 게시글이 없습니다.");
      return;
    }

    System.out.printf("번호: %s\n", commBoardDTO.getCommNo());
    System.out.printf("제목: %s\n", commBoardDTO.getTitle());
    System.out.printf("내용: %s\n", commBoardDTO.getContent());
    System.out.printf("작성자: %s\n", commBoardDTO.getFileUpload());
    System.out.printf("등록일: %s\n", commBoardDTO.getRegisteredDate());

    commBoardDTO.setViewCount(commBoardDTO.getViewCount() + 1);
    System.out.printf("조회수: %d\n", commBoardDTO.getViewCount());
  }

  public void update() {
    System.out.println();
    System.out.println("[소통해요/ 나눔이야기/ 게시글변경]");
    int no = Prompt.inputInt("번호? ");

    CommBoardDTO commBoardDTO = findByNo(no);

    if (commBoardDTO == null) {
      System.out.println("해당 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", commBoardDTO.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", commBoardDTO.getContent()));
    String fileUpload = Prompt.inputString(String.format("첨부파일(%s)? ", commBoardDTO.getFileUpload()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    commBoardDTO.setTitle(title);
    commBoardDTO.setContent(content);
    commBoardDTO.setFileUpload(fileUpload);

    System.out.println("게시글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println();
    System.out.println("[소통해요/ 나눔이야기/ 게시글삭제]");
    int no = Prompt.inputInt("번호? ");

    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.commBoardsDTO[i - 1] = this.commBoardsDTO[i];
    }
    this.commBoardsDTO[--this.size] = null;

    System.out.println("게시글을 삭제하였습니다.");
  }

  private CommBoardDTO findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if(this.commBoardsDTO[i].getCommNo() == no) {
        return this.commBoardsDTO[i];
      }
    }
    return null;
  }
  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.commBoardsDTO[i].getCommNo() == no) {
        return i;
      }
    }
    return -1;
  }

  public CommBoardDTO[] chooseBoard() {
    // TODO Auto-generated method stub
    return null;
  }

}





