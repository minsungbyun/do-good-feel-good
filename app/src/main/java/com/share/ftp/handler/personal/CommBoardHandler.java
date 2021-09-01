package com.share.ftp.handler.personal;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.join.JoinHandler;
import com.share.util.Prompt;

public class CommBoardHandler {

  List<CommBoardDTO> commBoardDTOList;
  JoinHandler joinHandler;

  public CommBoardHandler(List<CommBoardDTO> commBoardDTOList, JoinHandler joinHandler) {
    this.commBoardDTOList = commBoardDTOList;
    this.joinHandler = joinHandler;
  }

  public void add() {

    System.out.println();
    System.out.println("[메인/소통해요/나눔이야기/등록]");

    CommBoardDTO commBoardDTO = new CommBoardDTO();

    commBoardDTO.setNo(Prompt.inputInt("번호? "));
    commBoardDTO.setTitle(Prompt.inputString("제목? "));
    commBoardDTO.setContent(Prompt.inputString("내용? "));
    commBoardDTO.setFileUpload(Prompt.inputString("첨부파일? "));
    commBoardDTO.setPassword(Prompt.inputString("비밀번호? "));
    commBoardDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    commBoardDTOList.add(commBoardDTO);
  }

  public void list() {

    System.out.println();
    System.out.println("[메인/소통해요/나눔이야기/목록]");

    for(CommBoardDTO commBoardDTO : commBoardDTOList) {

      //    CommBoardDTO[] commBoardsDTO = new CommBoardDTO [commBoardDTOList.size()];
      //    commBoardDTOList.toArray(commBoardsDTO);
      //
      //    for (CommBoardDTO commBoardDTO : commBoardsDTO) {
      System.out.printf("%d, %s, %s, %s, %s, %d\n", 
          commBoardDTO.getNo(), 
          commBoardDTO.getTitle(), 
          commBoardDTO.getContent(),
          commBoardDTO.getFileUpload(),
          //commBoardDTO.getPassword(),
          commBoardDTO.getRegisteredDate(), 
          commBoardDTO.getViewCount());
    }
  }

  public void detail() {

    System.out.println();
    System.out.println("[메인/소통해요/나눔이야기/상세보기]");
    int no = Prompt.inputInt("번호? ");

    CommBoardDTO commBoardDTO = findByNo(no);

    if (commBoardDTO == null) {
      System.out.println("해당 게시글이 없습니다.");
      return;
    }

    System.out.printf("번호: %s\n", commBoardDTO.getNo());
    System.out.printf("제목: %s\n", commBoardDTO.getTitle());
    System.out.printf("내용: %s\n", commBoardDTO.getContent());
    System.out.printf("작성자: %s\n", commBoardDTO.getFileUpload());
    System.out.printf("등록일: %s\n", commBoardDTO.getRegisteredDate());

    commBoardDTO.setViewCount(commBoardDTO.getViewCount() + 1);
    System.out.printf("조회수: %d\n", commBoardDTO.getViewCount());
  }

  public void update() {
    System.out.println();
    System.out.println("[메인/소통해요/나눔이야기/게시글변경]");
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
    System.out.println("[메인/소통해요/나눔이야기/게시글삭제]");
    int no = Prompt.inputInt("번호? ");

    CommBoardDTO commBoardDTO = findByNo(no);

    if (commBoardDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    commBoardDTOList.remove(commBoardDTO);

    System.out.println("게시글을 삭제하였습니다.");
  }

  private CommBoardDTO findByNo(int no) {
    CommBoardDTO[] arr = commBoardDTOList.toArray(new CommBoardDTO[0]);
    for(CommBoardDTO commBoardDTO : arr) {
      if (commBoardDTO.getNo() == no) {
        return commBoardDTO;
      }
    }
    return null;
  }

  //  public CommBoardDTO[] chooseBoard() {
  //
  //    // 조회수 높은 상위 3개 담을 배열
  //    CommBoardDTO[] top3 = new CommBoardDTO[3];
  //
  //    CommBoardDTO max = commBoardsDTO[0];
  //
  //    for (int i = 0; i < this.size; i++) {
  //      if (max.getViewCount() < commBoardsDTO[i].getViewCount()) {
  //        max = commBoardsDTO[i];
  //        top3[0] = max;
  //      }
  //    }
  //    return top3;
  //
  //  }




}





