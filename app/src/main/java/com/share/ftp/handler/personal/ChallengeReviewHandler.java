package com.share.ftp.handler.personal;

import java.sql.Date;
import java.util.List;

import com.share.ftp.handler.join.AuthHandler;
import com.share.ftp.domain.guest.JoinDTO;
import com.share.ftp.domain.personal.MyChallengeReviewDTO;
import com.share.util.Prompt;

public class ChallengeReviewHandler {

  List<MyChallengeReviewDTO> myChallengeReviewDTOList;

  public ChallengeReviewHandler(List<MyChallengeReviewDTO> myChallengeReviewDTOList) {
    this.myChallengeReviewDTOList = myChallengeReviewDTOList;
  }
  
  MyChallengeReviewDTO myChallengeReviewDTO;

  public void add() {
    System.out.println("[참여인증&댓글 등록]");

    MyChallengeReviewDTO myChallengeReviewDTO = new MyChallengeReviewDTO();

    myChallengeReviewDTO.setNo(Prompt.inputInt("번호: "));
    myChallengeReviewDTO.setMemberId(Prompt.inputString("아이디: "));
    myChallengeReviewDTO.setContent(Prompt.inputString("내용: "));
    myChallengeReviewDTO.setFileUpload(Prompt.inputString("파일첨부: "));
    myChallengeReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    myChallengeReviewDTOList.add(myChallengeReviewDTO);
  }

  public void list() {
    System.out.println("[참여인증&댓글 목록]");
    MyChallengeReviewDTO[] myChallengeReviewDTOs = new MyChallengeReviewDTO[myChallengeReviewDTOList.size()];
    myChallengeReviewDTOList.toArray(myChallengeReviewDTOs);
    for (MyChallengeReviewDTO myChallengeReviewDTO : myChallengeReviewDTOs) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          myChallengeReviewDTO.getNo(), 
          myChallengeReviewDTO.getMemberId(), 
          myChallengeReviewDTO.getContent(),
          myChallengeReviewDTO.getFileUpload(),
          myChallengeReviewDTO.getRegisteredDate());
    }
  }

  public void detail() {
    System.out.println("[참여인증&댓글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    MyChallengeReviewDTO myChallengeReviewDTO = findByNo(no);

    if (myChallengeReviewDTO == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }

    System.out.printf("아이디: %s\n", myChallengeReviewDTO.getMemberId());
    System.out.printf("내용: %s\n", myChallengeReviewDTO.getContent());
    System.out.printf("파일첨부: %s\n", myChallengeReviewDTO.getFileUpload());
    System.out.printf("등록일: %s\n", myChallengeReviewDTO.getRegisteredDate());
  }

  public void update() {
    System.out.println("[참여인증&댓글 수정]");
    int no = Prompt.inputInt("번호? ");

    MyChallengeReviewDTO myChallengeReviewDTO = findByNo(no);

    if (myChallengeReviewDTO == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", myChallengeReviewDTO.getContent()));
    String fileUpload = Prompt.inputString(String.format("파일첨부(%s)? ", myChallengeReviewDTO.getFileUpload()));

    String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("참여인증&댓글 수정을 취소하였습니다.");
      return;
    }

    myChallengeReviewDTO.setContent(content);
    myChallengeReviewDTO.setFileUpload(fileUpload);
    System.out.println("참여인증&댓글을 변경하였습니다.");
  }
  
  public void delete() {
    System.out.println("[댓글 삭제]");
    int no = Prompt.inputInt("번호? ");

    MyChallengeReviewDTO myChallengeReview = findByNo(no);

    if (myChallengeReview == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("참여인증&댓글 삭제를 취소하였습니다.");
      return;
    }

    if (myChallengeReviewDTO.getOwner().getName() != AuthHandler.getLoginUser().getName()) {
      System.out.println("이 프로젝트의 관리자가 아닙니다.");
      return;
      }
    
    myChallengeReviewDTOList.remove(myChallengeReview);

    System.out.println("참여인증&댓글을 삭제하였습니다.");
  }
  private MyChallengeReviewDTO findByNo(int no) {
      MyChallengeReviewDTO[] arr = myChallengeReviewDTOList.toArray(new MyChallengeReviewDTO[0]);
      for (MyChallengeReviewDTO myChallengeReviewDTO : arr) {
        if (myChallengeReviewDTO.getNo() == no) {
          return myChallengeReviewDTO;
      }
    }
    return null;
  }
}
