package com.share.ftp.servlet.volunteer;
import static com.share.util.General.member.PERSONAL;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.join.GroupDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerGroupJoinHandler implements Command { 

  VolunteerDao volunteerDao;

  public VolunteerGroupJoinHandler(VolunteerDao volunteerDao) {
    this.volunteerDao = volunteerDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사 참여  ]");
    System.out.println();

    if (AuthLoginHandler.getLoginUser().getType() == PERSONAL) {
      System.out.println("단체회원만 참여할 수 있습니다!");
      return;
    }

    GroupDTO loginUser = (GroupDTO) AuthLoginHandler.getLoginUser();

    int volNo = (int) request.getAttribute("volNo");

    VolunteerRequestDTO volunteerRequestDTO = volunteerDao.findByApprovedVolunteerNo(volNo);

    //    System.out.printf("봉사번호: %d\n"
    //        + "봉사제목: %s\n"
    //        + "주최자: %s\n"
    //        + "봉사분류: %s\n"
    //        + "전화번호: %s\n"
    //        + "이메일: %s\n"
    //        + "봉사시작기간: %s\n"
    //        + "봉사종료기간: %s\n"
    //        + "봉사시작시간: %s\n"
    //        + "봉사종료시간: %s\n"
    //        + "봉사남은시간: %s\n"
    //        //        + "봉사목록: %s\n"
    //        + "봉사인원: %d명 / %d명\n"
    //        + "봉사내용: %s\n"
    //        + "첨부파일: %s\n\n",
    //
    //        generalRequestApplyDTO.getNo(),      
    //        generalRequestApplyDTO.getTitle(),     
    //        generalRequestApplyDTO.getOwner().getName(), 
    //        generalRequestApplyDTO.getType(), 
    //        generalRequestApplyDTO.getTel(),
    //        generalRequestApplyDTO.getEmail(),
    //        generalRequestApplyDTO.getStartDate(),
    //        generalRequestApplyDTO.getEndDate(),
    //        generalRequestApplyDTO.getStartTime(),
    //        generalRequestApplyDTO.getEndTime(),
    //        Helper.getRemainTime(generalRequestApplyDTO.getEndDate().getTime() - System.currentTimeMillis()),
    //        //        personalRequestApplyDTO.getVolList(),
    //        generalRequestApplyDTO.getTotalJoinCount(),
    //        generalRequestApplyDTO.getLimitNum(),
    //        generalRequestApplyDTO.getContent(),
    //        generalRequestApplyDTO.getFileUpload()
    //        );

    String input = Prompt.inputString("해당 봉사활동을 참가하시겠습니까?(y/N) ▶ ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 참여를 취소하였습니다. ]");
      return;
    }

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

    // 출력할 멤버 list에 추가시킨다
    volunteerRequestDTO.addMembers(loginUser);
    // 주최자 이름이 멤버 출력하는데 포함되어 있다면 제거
    if (volunteerRequestDTO.getMembers().contains(volunteerRequestDTO.getOwner())) {
      volunteerRequestDTO.getMembers().remove(volunteerRequestDTO.getOwner());
    }
    //    loginUser.setPoint(loginUser.getPoint() + VOLUNTEER_POINT);

    // 총 참여 인원(주최자1명 포함)을 누적시킨다.
    int count = volunteerRequestDTO.getCurrentNum();
    volunteerRequestDTO.setCurrentNum(count += 1); 

    //    volunteerDao.update(volunteerRequestDTO);

    System.out.println("[  ✔️ 봉사참여가 완료되었습니다. ]");
  }
}