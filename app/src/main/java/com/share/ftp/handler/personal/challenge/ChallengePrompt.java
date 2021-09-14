package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.util.Prompt;

public class ChallengePrompt {

  protected List<ChallengeDTO> challengeDTOList;

  public ChallengePrompt(List<ChallengeDTO> challengeDTOList) {
    this.challengeDTOList = challengeDTOList;
  }

  public ChallengeDTO promptChallenge() {
    System.out.println();
    System.out.println("챌린지 목록:");

    for (ChallengeDTO challengeDTO : challengeDTOList) {
      if (challengeDTO.isChecked() == true) {
        System.out.println();
        System.out.printf("  [ %d. %s ]\n", challengeDTO.getNo(), challengeDTO.getTitle());
      }
    }


    while (true) {
      System.out.println();
      int challengeNo = Prompt.inputInt("챌린지 번호 선택? (취소: 0) ");
      if (challengeNo == 0) {
        return null;
      }
      ChallengeDTO selectChallenge = findByNo(challengeNo);
      if (selectChallenge != null) {
        return selectChallenge;
      }
      System.out.println("챌린지 번호가 옳지 않습니다.");
    }
  }
  protected ChallengeDTO findByNo(int no) {
    for (ChallengeDTO challengeDTO : challengeDTOList) {
      if (challengeDTO.getNo() == no) {
        return challengeDTO;
      }
    }
    return null;
  }
}
