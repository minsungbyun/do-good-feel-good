package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.admin.AbstractAdminChallengeHandler;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyChallengeListHandler extends AbstractAdminChallengeHandler {

  public MyChallengeListHandler(List<ChallengeDTO> challengeDTOList) {
    super(challengeDTOList);
  }

  // 챌린지에 참가한 회원이면 리스트를 보여준다.
  @Override
  public void execute(CommandRequest request) throws Exception {
    //    System.out.println("번호 제목[댓글] 작성자 참여인원  참여기간   ");
    for (ChallengeDTO challengeDTO : challengeDTOList) {
      if (challengeDTO.getMemberNames().contains(AuthLoginHandler.getLoginUser().getName())) {
        System.out.printf("%d, %s[%d], %s, %d, %s ~ %s\n", 
            challengeDTO.getNo(), 
            //          challengeDTO.getAdminId(), 
            challengeDTO.getTitle(), 
            challengeDTO.getReviewCount(), 
            challengeDTO.getAdmin().getName(),
            challengeDTO.getTotalJoinCount(),
            //          challengeDTO.getFileUpload(), 
            challengeDTO.getStartDate(),
            challengeDTO.getEndDate());

      }
    }

  }

}
