package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.admin.AbstractAdminChallengeHandler;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeWishHandler extends AbstractAdminChallengeHandler {


  public ChallengeWishHandler(List<ChallengeDTO> challengeDTOList) {
    super(challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    while (true) {
      System.out.println("[  🎈 WISH 🎈  ]");
      System.out.println();

      int no = (int) request.getAttribute("no");

      ChallengeDTO challengeList = findByNo(no); 



      String input = Prompt.inputString("[  🎈 관심 챌린지로 추가하시겠습니까?(y/N) 🎈 ] ");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println();
        System.out.println("[  ❌ WISH 취소❌  ]");
        return;
      } else if (input.equals("y")) {
        System.out.println();
        System.out.println("[  🎈 WISH 🎈  ]");
        challengeList.setWish(AuthLoginHandler.getLoginUser());
        return;
      } else {
        System.out.println("y 또는 n을 입력하세요.");
        continue;
      } 
    } 
  }
}

