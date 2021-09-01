package com.share.ftp.handler.personal;

import java.util.List;

import com.share.ftp.domain.personal.MyChallengeQuestionDTO;
import com.share.util.Prompt;

public class ChallengeQuestionHandler {

  List<MyChallengeQuestionDTO> myChallengeQuestionDTOList;

  public ChallengeQuestionHandler(List<MyChallengeQuestionDTO> myChallengeQuestionDTOList) {
    this.myChallengeQuestionDTOList = myChallengeQuestionDTOList;
  }

  public void add() {
    System.out.println("[문의 등록]");

    MyChallengeQuestionDTO myChallengeQuestionDTO = new MyChallengeQuestionDTO();

    myChallengeQuestionDTO.setNo(Prompt.inputInt("번호: "));
    myChallengeQuestionDTO.setMemberId(Prompt.inputString("아이디: "));
    myChallengeQuestionDTO.setContent(Prompt.inputString("내용: "));

    myChallengeQuestionDTOList.add(myChallengeQuestionDTO);
  }

  public void list() {
    System.out.println("[문의 목록]");
    MyChallengeQuestionDTO[] myChallengeQuestionDTOs = new MyChallengeQuestionDTO[myChallengeQuestionDTOList.size()];
    myChallengeQuestionDTOList.toArray(myChallengeQuestionDTOs);
    for (MyChallengeQuestionDTO myChallengeQuestionDTO : myChallengeQuestionDTOs) {
      System.out.printf("%s, %s\n", 
      myChallengeQuestionDTO.getMemberId(), 
      myChallengeQuestionDTO.getContent());
    }
  }

  public void detail() {
    System.out.println("[문의 상세보기]");
    int no = Prompt.inputInt("번호? ");

    MyChallengeQuestionDTO myChallengeQuestion = findByNo(no);

    if (myChallengeQuestion == null) {
      System.out.println("해당 번호의 문의가 없습니다.");
      return;
    }

    System.out.printf("아이디: %s\n", myChallengeQuestion.getMemberId());
    System.out.printf("내용: %s\n", myChallengeQuestion.getContent());
  }

  public void update() {
    System.out.println("[문의 수정]");
    int no = Prompt.inputInt("번호? ");

    MyChallengeQuestionDTO myChallengeQuestion = findByNo(no);

    if (myChallengeQuestion == null) {
      System.out.println("해당 번호의 문의가 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", myChallengeQuestion.getContent()));

    String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("문의 수정을 취소하였습니다.");
      return;
    }

    myChallengeQuestion.setContent(content);
    System.out.println("문의를 수정하였습니다.");
  }

  public void delete() {
    System.out.println("[문의 삭제]");
    int no = Prompt.inputInt("번호? ");

    MyChallengeQuestionDTO myChallengeQuestion = findByNo(no);

    if (myChallengeQuestion == null) {
      System.out.println("해당 번호의 문의가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("문의 삭제를 취소하였습니다.");
      return;
    }

    myChallengeQuestionDTOList.remove(myChallengeQuestion);

    System.out.println("문의를 삭제하였습니다.");
  }

  private MyChallengeQuestionDTO findByNo(int no) {
      MyChallengeQuestionDTO[] arr = myChallengeQuestionDTOList.toArray(new MyChallengeQuestionDTO[0]);
      for (MyChallengeQuestionDTO myChallengeQuestionDTO : arr) {
        if (myChallengeQuestionDTO.getNo() == no) {
          return myChallengeQuestionDTO;
      }
    }
    return null;
  }
}
