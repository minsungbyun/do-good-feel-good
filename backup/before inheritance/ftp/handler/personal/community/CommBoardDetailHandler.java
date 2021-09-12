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
    System.out.println("[소통해요/ 나눔이야기/ 상세보기]");
    int no = Prompt.inputInt("번호? ");

    CommBoardDTO commBoardDTO = findByNo(no);

    if (commBoardDTO == null) {
      System.out.println("해당 게시글 없습니다.");
      return;
    }
    //AuthLoginHandler.loginUser.getId(),

    System.out.printf("아이디 ▶ %s\n", commBoardDTO.getOwner().getId());
    System.out.printf("번호 ▶ %s\n", commBoardDTO.getNo());
    System.out.printf("제목 ▶ %s\n", commBoardDTO.getTitle());
    System.out.printf("내용 ▶ %s\n", commBoardDTO.getContent());
    System.out.printf("첨부파일 ▶ %s\n", commBoardDTO.getFileUpload());

    commBoardDTO.setViewCount(commBoardDTO.getViewCount() + 1);
    System.out.printf("조회수: %d\n", commBoardDTO.getViewCount());

  }
}
