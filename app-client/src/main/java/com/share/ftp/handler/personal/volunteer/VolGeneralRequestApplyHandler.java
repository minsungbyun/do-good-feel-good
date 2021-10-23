package com.share.ftp.handler.personal.volunteer;

import static com.share.util.General.check.Waiting;
import static com.share.util.General.member.GROUP;
import static com.share.util.General.member.ORG;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.join.GroupDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.join.OrgDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class VolGeneralRequestApplyHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;
  GeneralDao generalDao;
  SqlSession sqlSession;

  public VolGeneralRequestApplyHandler(VolunteerDao volunteerDao, GeneralDao generalDao, SqlSession sqlSession) {
    this.volunteerDao = volunteerDao;
    this.generalDao = generalDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사신청서 양식  ]");

    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();


    if (joinDTO == null) {
      System.out.println("[  ⛔ 로그인 후 사용가능합니다 ⛔  ]");
      return;
    }
    while (true) {
      try {

        VolunteerRequestDTO volunteerRequestDTO = new VolunteerRequestDTO();

        while (true) {
          System.out.println(" ▶ 번호를 선택해주세요");
          System.out.println();
          System.out.println(" ▶ 1. 단체봉사신청");
          System.out.println(" ▶ 2. 기관봉사신청");
          System.out.println();

          int num = Prompt.inputInt("번호입력 ▶ ");

          switch (num) {
            case 1: volunteerRequestDTO.setMemberType(GROUP);             break;
            case 2: volunteerRequestDTO.setMemberType(ORG);               break;
            default: System.out.println("올바를 숫자를 입력해주세요."); continue;
          }

          if (AuthLoginHandler.getLoginUser().getType() != volunteerRequestDTO.getMemberType()) {
            System.out.println("당신은 해당 유형봉사를 신청 할 수 없습니다.");
            System.out.println("단체회원인지 기관회원인지 확인하세요!");
            continue;
          }
          break;
        }


        volunteerRequestDTO.setTitle(Prompt.inputString("제목 ▶ "));

        if (volunteerRequestDTO.getMemberType() == GROUP) {
          GroupDTO groupUser = (GroupDTO) joinDTO;
          volunteerRequestDTO.setOwner(groupUser);

        } else if (volunteerRequestDTO.getMemberType() == ORG) {
          OrgDTO orgUser = (OrgDTO) joinDTO;
          volunteerRequestDTO.setOwner(orgUser);
        }

        volunteerRequestDTO.setType(new GeneralHelper(generalDao).promptCategory());
        volunteerRequestDTO.setTel(Prompt.inputString("전화번호 ▶ "));
        volunteerRequestDTO.setEmail(Prompt.inputString("이메일 ▶ ")); 
        volunteerRequestDTO.setStartDate(Prompt.inputDate("봉사시작기간(yyyy-mm-dd) ▶ "));
        volunteerRequestDTO.setEndDate(Prompt.inputDate("봉사종료기간(yyyy-mm-dd) ▶ ")); 
        volunteerRequestDTO.setStartTime(Prompt.inputString("봉사시작시간 ▶ ")); 
        volunteerRequestDTO.setEndTime(Prompt.inputString("봉사종료시간 ▶ ")); 
        //        personalRequestDTO.setVolList(Prompt.inputString("봉사목록 ▶ ")); 
        volunteerRequestDTO.setLimitNum(Prompt.inputInt("봉사인원 ▶ "));
        volunteerRequestDTO.setContent(Prompt.inputString("내용 ▶ ")); 
        volunteerRequestDTO.setFileUpload(Prompt.inputString("파일 ▶ ")); 
        volunteerRequestDTO.setStatus(Waiting);

        volunteerDao.insert(volunteerRequestDTO);
        sqlSession.commit();


      } catch (NumberFormatException e) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("올바른 숫자를 입력하세요");
        System.out.println("--------------------------------------------------------------");
        continue; // 나중에 설정할거

      } catch (Exception e) {
        System.out.println("--------------------------------------------------------------");
        //      System.out.printf("오류 발생: %s\n", e.getClass().getName());
        System.out.println("다시 입력 바랍니다.");
        System.out.println("--------------------------------------------------------------");
        continue;
      }
      break;
    }
    System.out.println("[  ✔️ 개인봉사신청이 정상적으로 완료되었습니다.  ]");
  }
}