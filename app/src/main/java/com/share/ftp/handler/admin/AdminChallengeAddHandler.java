package com.share.ftp.handler.admin;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class AdminChallengeAddHandler extends AbstractAdminChallengeHandler {


  public AdminChallengeAddHandler(List<ChallengeDTO> challengeDTOList) {
    super(challengeDTOList);
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[챌린지 등록]");

    ChallengeDTO challengeDTO = new ChallengeDTO();

    //    challengeDTO.setAdminId(Prompt.inputString("관리자 아이디? "));
    challengeDTO.setTitle(Prompt.inputString("제목? "));
    challengeDTO.setContent(Prompt.inputString("내용? ")); 
    challengeDTO.setFileUpload(Prompt.inputString("첨부파일? ")); 
    challengeDTO.setAdmin(AuthLoginHandler.getLoginUser());
    challengeDTO.setStartDate(Prompt.inputDate("시작일? "));
    challengeDTO.setEndDate(Prompt.inputDate("종료일? "));
    challengeDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    challengeDTO.setNo(getNextNum()); // 챌린지 고유번호 부여

    challengeDTOList.add(challengeDTO);

    System.out.println("챌린지가 정상적으로 등록되었습니다.");
  }
}
