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
import com.share.ftp.domain.volunteer.GeneralRequestDTO;
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

        GeneralRequestDTO generalRequestDTO = new GeneralRequestDTO();

        while (true) {
          System.out.println(" ▶ 번호를 선택해주세요");
          System.out.println();
          System.out.println(" ▶ 1. 단체봉사신청");
          System.out.println(" ▶ 2. 기관봉사신청");
          System.out.println();

          int num = Prompt.inputInt("번호입력 ▶ ");

          switch (num) {
            case 1: generalRequestDTO.setMemberType(GROUP);             break;
            case 2: generalRequestDTO.setMemberType(ORG);               break;
            default: System.out.println("올바를 숫자를 입력해주세요."); continue;
          }

          if (AuthLoginHandler.getLoginUser().getType() != generalRequestDTO.getMemberType()) {
            System.out.println("당신은 해당 유형봉사를 신청 할 수 없습니다.");
            System.out.println("단체회원인지 기관회원인지 확인하세요!");
            continue;
          }
          break;
        }


        generalRequestDTO.setTitle(Prompt.inputString("제목 ▶ "));

        if (generalRequestDTO.getMemberType() == GROUP) {
          GroupDTO groupUser = (GroupDTO) joinDTO;
          generalRequestDTO.setOwner(groupUser);

        } else if (generalRequestDTO.getMemberType() == ORG) {
          OrgDTO orgUser = (OrgDTO) joinDTO;
          generalRequestDTO.setOwner(orgUser);
        }

        generalRequestDTO.setType(new GeneralHelper(generalDao).promptCategory());
        generalRequestDTO.setTel(Prompt.inputString("전화번호 ▶ "));
        generalRequestDTO.setEmail(Prompt.inputString("이메일 ▶ ")); 
        generalRequestDTO.setStartDate(Prompt.inputDate("봉사시작기간(yyyy-mm-dd) ▶ "));
        generalRequestDTO.setEndDate(Prompt.inputDate("봉사종료기간(yyyy-mm-dd) ▶ ")); 
        generalRequestDTO.setStartTime(Prompt.inputString("봉사시작시간 ▶ ")); 
        generalRequestDTO.setEndTime(Prompt.inputString("봉사종료시간 ▶ ")); 
        //        personalRequestDTO.setVolList(Prompt.inputString("봉사목록 ▶ ")); 
        generalRequestDTO.setLimitNum(Prompt.inputInt("봉사인원 ▶ "));
        generalRequestDTO.setContent(Prompt.inputString("내용 ▶ ")); 
        generalRequestDTO.setFileUpload(Prompt.inputString("파일 ▶ ")); 
        generalRequestDTO.setStatus(Waiting);

        volunteerDao.insert(generalRequestDTO);
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