package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.admin.AbstractAdminChallengeHandler;
import com.share.util.Prompt;

public class ChallengeLikeHandler extends AbstractAdminChallengeHandler {


  public ChallengeLikeHandler(List<ChallengeDTO> challengeDTOList) {
    super(challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    while (true) {
      System.out.println("[  ❤ LIKE ❤  ]");
      System.out.println();

      int no = (int) request.getAttribute("no");
      System.out.println();

      ChallengeDTO challengeList = findByNo(no); 



      String input = Prompt.inputString("[  ♡ 공감이 되셨다면 좋아요를 눌러주세요(y/N) ♡ ] ");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("[  ❌ 좋아요 취소❌  ]");
        return;
      } else if (input.equals("y")) {
        System.out.println("[  ❤ LIKE ❤  ]");
        challengeList.setLike(challengeList.getLike() + 1);
        return;
      } else {
        System.out.println("y 또는 n을 입력하세요.");
        continue;
      } 
    } 
  }
}

