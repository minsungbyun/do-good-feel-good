package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminChallengeDeleteHandler extends AbstractAdminChallengeHandler {


  public AdminChallengeDeleteHandler(List<ChallengeDTO> challengeDTOList) {
    super(challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 챌린지 삭제 ]");
    int no = (int) request.getAttribute("challengeNo"); 

    ChallengeDTO challengeDTO = findByNo(no);


    if (challengeDTO == null) {
      System.out.println("해당 번호의 챌린지가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("공지사항 삭제를 취소하였습니다.");
      return;
    }

    challengeDTOList.remove(challengeDTO);
    System.out.println();

    System.out.println("챌린지를 삭제하였습니다.");
  }
}
