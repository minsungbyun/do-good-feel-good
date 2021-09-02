package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.util.Prompt;

public class CommBoardDetailHandler extends AbstractCommBoardHandler {

  public CommBoardDetailHandler(List<CommBoardDTO> commBoardDTOList) {
    super(commBoardDTOList);
  }

  @Override
  public void execute() {

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





}





