package com.share.ftp.handler.personal.volunteer;

import static com.share.util.General.check.APPLIED;
import static com.share.util.General.member.GROUP;
import static com.share.util.General.member.ORG;
import static com.share.util.General.point.VOLUNTEER_POINT;
import java.sql.Date;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.join.PersonalDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class VolunteerJoinHandler implements Command { 

  VolunteerDao volunteerDao;

  public VolunteerJoinHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사 참여  ]");
    System.out.println();

    if (AuthLoginHandler.getLoginUser().getType() == GROUP || 
        AuthLoginHandler.getLoginUser().getType() == ORG) {
      System.out.println("개인회원만 참여할 수 있습니다!");
      return;
    }

    PersonalDTO loginUser = (PersonalDTO) AuthLoginHandler.getLoginUser();

    int volNo = (int) request.getAttribute("volNo");

    VolunteerRequestDTO volunteerRequestDTO = volunteerDao.findByApprovedVolunteerNo(volNo);

    //    VolunteerJoinDTO volunteerJoinDTO = new VolunteerJoinDTO();

    // 주최자 유효성검사
    if (volunteerRequestDTO.getOwner().getId().
        equals(loginUser.getId())) {
      System.out.println("당신은 이미 주최자입니다!");
      return;
    }

    // 봉사인원 유효성 검사
    if (volunteerRequestDTO.getCurrentNum() == volunteerRequestDTO.getLimitNum()) {
      System.out.println("[ 정원이 초과하였습니다! 다음에 참여해주세요! ]");
      return;
    }


    if (volunteerRequestDTO.getMemberNames().contains(loginUser.getId())) {
      System.out.println("이미 봉사참여를 하셨습니다!");
      return;
    } 


    Date applyDate = Prompt.inputDate("참여일(yyyy-mm-dd) ▶ ");

    GeneralHelper.promptVolunteerTime(volunteerRequestDTO);



    String input = Prompt.inputString("해당 봉사활동을 참가하시겠습니까?(y/N) ▶ ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 참여를 취소하였습니다. ]");
      return;
    }



    volunteerRequestDTO.setUserNo(loginUser.getNo());
    volunteerRequestDTO.setVolNo(volunteerRequestDTO.getNo());
    volunteerRequestDTO.setApplyOwner(AuthLoginHandler.getLoginUser());
    volunteerRequestDTO.setApplyDate(applyDate);
    volunteerRequestDTO.setApplyStatus(APPLIED);

    // 출력할 멤버 list에 추가시킨다
    volunteerRequestDTO.addMembers(loginUser);
    // 주최자 이름이 멤버 출력하는데 포함되어 있다면 제거
    if (volunteerRequestDTO.getMembers().contains(volunteerRequestDTO.getOwner())) {
      volunteerRequestDTO.getMembers().remove(volunteerRequestDTO.getOwner());
    }
    loginUser.setPoint(loginUser.getPoint() + VOLUNTEER_POINT);

    // 총 참여 인원(주최자1명 포함)을 누적시킨다.
    int count = volunteerRequestDTO.getCurrentNum();
    volunteerRequestDTO.setCurrentNum(count += 1); 

    volunteerDao.insertUser(volunteerRequestDTO);

    System.out.println("[  ✔️ 봉사참여가 완료되었습니다. ]");
  }
}