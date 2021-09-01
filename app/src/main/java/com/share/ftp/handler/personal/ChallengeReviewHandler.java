package com.share.ftp.handler.personal;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.MyChallengeReviewDTO;
import com.share.util.Prompt;

public class ChallengeReviewHandler {

  List<MyChallengeReviewDTO> myChallengeReviewDTOList;

  public ChallengeReviewHandler(List<MyChallengeReviewDTO> myChallengeReviewDTOList) {
    this.myChallengeReviewDTOList = myChallengeReviewDTOList;
  }


  public void add() {
    System.out.println("[참여인증&댓글 등록]");

    MyChallengeReviewDTO myChallengeReview = new MyChallengeReviewDTO();

    myChallengeReview.setNo(Prompt.inputInt("번호: "));
    myChallengeReview.setMemberId(Prompt.inputString("아이디: "));
    myChallengeReview.setContent(Prompt.inputString("내용: "));
    myChallengeReview.setFileUpload(Prompt.inputString("파일첨부: "));
    myChallengeReview.setRegisteredDate(new Date(System.currentTimeMillis()));

    myChallengeReviewDTOList.add(myChallengeReview);
  }

  public void list() {
    System.out.println("[참여인증&댓글 목록]");
    for (MyChallengeReviewDTO myChallengeReviewDTO : myChallengeReviewDTOList) {
      System.out.printf("%d, %s, %s, %s, %s", 
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
    System.out.println("[참여인증&댓글 변경]");
    int no = Prompt.inputInt("번호? ");

    MyChallengeReviewDTO myChallengeReviewDTO = findByNo(no);

    if (myChallengeReviewDTO == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", myChallengeReviewDTO.getContent()));
    String fileUpload = Prompt.inputString(String.format("파일첨부(%s)? ", myChallengeReviewDTO.getFileUpload()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("참여인증&댓글 변경을 취소하였습니다.");
      return;
    }

    myChallengeReviewDTO.setContent(content);
    myChallengeReviewDTO.setFileUpload(fileUpload);
    System.out.println("참여인증&댓글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[댓글 삭제]");
    int no = Prompt.inputInt("번호? ");

    MyChallengeReviewDTO myChallengeReviewDTO = findByNo(no);

    if (myChallengeReviewDTO == null) {
      System.out.println("해당 번호의 참여인증&댓글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("참여인증&댓글 삭제를 취소하였습니다.");
      return;
    }

    myChallengeReviewDTOList.remove(myChallengeReviewDTO);

    System.out.println("참여인증&댓글을 삭제하였습니다.");
  }
  private MyChallengeReviewDTO findByNo(int no) {
    for (MyChallengeReviewDTO myChallengeReviewDTO : myChallengeReviewDTOList) {
      if (myChallengeReviewDTO.getNo() == no) {
        return myChallengeReviewDTO;
      }
    }
    return null;
  }


}
