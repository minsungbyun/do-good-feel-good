package com.share.ftp.handler.personal.volunteer;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolRequestPersonalApplyHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳


  int volNo;  // 봉사 번호 자동 부여
  List<JoinDTO> joinDTOList;

  public VolRequestPersonalApplyHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<JoinDTO> joinDTOList) {

    super(personalRequestDTOList);
    this.joinDTOList = joinDTOList;
  }


  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  개인봉사활동 양식  ]");

    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();


    if (joinDTO == null) {
      System.out.println("[  ⛔ 로그인 후 사용가능합니다 ⛔  ]");
      return;
    }
    while (true) {
      try {

        PersonalRequestDTO personalRequestDTO = new PersonalRequestDTO();

        personalRequestDTO.setVolNo(++volNo);
        personalRequestDTO.setVolTitle(Prompt.inputString("제목 ▶ "));
        personalRequestDTO.setOwner(joinDTO);
        personalRequestDTO.setOwnerId(joinDTO.getId());
        personalRequestDTO.setVolName(joinDTO.getName());
        personalRequestDTO.setVolSort(Prompt.inputString("분류 ▶ "));
        personalRequestDTO.setVolTel(Prompt.inputString("전화번호 ▶ "));
        personalRequestDTO.setVolEmail(Prompt.inputString("이메일 ▶ ")); 
        personalRequestDTO.setVolStartDate(Prompt.inputDate("봉사시작기간(yyyy-mm-dd) ▶ "));
        personalRequestDTO.setVolEndDate(Prompt.inputDate("봉사종료기간(yyyy-mm-dd) ▶ ")); 
        personalRequestDTO.setVolStartTime(Prompt.inputString("봉사시작시간 ▶ ")); 
        personalRequestDTO.setVolEndTime(Prompt.inputString("봉사종료시간 ▶ ")); 
        //        personalRequestDTO.setVolList(Prompt.inputString("봉사목록 ▶ ")); 
        personalRequestDTO.setVolLimitNum(Prompt.inputInt("봉사인원 ▶ "));
        personalRequestDTO.setVolContent(Prompt.inputString("내용 ▶ ")); 
        personalRequestDTO.setVolSubmitTime(new Date(System.currentTimeMillis())); 
        personalRequestDTO.setVolFileUpload(Prompt.inputString("파일 ▶ ")); 
        personalRequestDTO.setPersonal(true);
        //        personalRequestDTO.setChecked(false);
        personalRequestDTO.getIsSigned();


        personalRequestDTOList.add(personalRequestDTO);

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









//  private List<JoinDTO> addOwner() {
//    
//  }
//
//  public static boolean checkDate(String checkDate) {
//    try {
//      SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyyy/MM/dd"); //검증할 날짜 포맷 설정
//      dateFormatParser.setLenient(false); //false일경우 처리시 입력한 값이 잘못된 형식일 시 오류가 발생
//      dateFormatParser.parse(checkDate); //대상 값 포맷에 적용되는지 확인
//      return true;
//    } catch (Exception e) {
//      return false;
//    }
//  }

// 예외처리 ver.

//  System.out.println();
//  System.out.println("[개인봉사활동 양식]");
//
//  JoinDTO joinDTO = AuthLoginHandler.getLoginUser();
//
//  if (joinDTO == null) {
//    System.out.println("로그인 후 사용가능합니다.");
//    return;
//  }
//  while (true) {
//    try {
//
//      PersonalRequestDTO personalRequestDTO = new PersonalRequestDTO();
//
//      personalRequestDTO.setNo(Prompt.inputInt("번호? "));
//
//      while (true) {
//        personalRequestDTO.setTitle(Prompt.inputString("제목? "));
//        if (!personalRequestDTO.getTitle().matches("^[가-힣]*$")) {
//          System.out.println("한글을 작성하세요. ex) 뜨개질");
//          System.out.println();
//          continue;
//        } else {
//          break;
//        }
//      }
//
//      while (true) {
//        personalRequestDTO.setSort(Prompt.inputString("분류? "));
//        if (!personalRequestDTO.getSort().matches("^[가-힣]*$")) {
//          System.out.println("한글을 작성하세요. ex) 비대면");
//          System.out.println();
//          continue;
//        } else {
//          break;
//        }
//      }
//
//      while (true) {
//        personalRequestDTO.setTel(Prompt.inputString("전화번호? "));
//        if (!personalRequestDTO.getTel().contains("-")) {
//          System.out.println("전화번호 양식에 맞추어 작성바랍니다. ex) 010-0000-0000");
//          System.out.println();
//          continue;
//        } else {
//          break;
//        }
//      }
//
//        while (true) {
//          personalRequestDTO.setEmail(Prompt.inputString("이메일? ")); 
//          if (!(personalRequestDTO.getEmail().contains("@") && 
//              personalRequestDTO.getEmail().contains("."))) {
//  
//            System.out.println("이메일 양식에 맞추어 작성바랍니다. ex) aaa@test.com");
//            System.out.println();
//            continue;
//          } else {
//            break;
//          }
//        }
//
//      personalRequestDTO.setVolunteerPeriod(Prompt.inputString("봉사기간? ")); 
//      personalRequestDTO.setVolunteerTime(new Date(System.currentTimeMillis())); 
//      personalRequestDTO.setVolunteerList(Prompt.inputString("봉사목록? ")); 
//      personalRequestDTO.setJoinNum(Prompt.inputInt("봉사인원? "));
//      personalRequestDTO.setContent(Prompt.inputString("내용? ")); 
//
//      while (true) {
//        personalRequestDTO.setFileUpload(Prompt.inputString("파일? ")); 
//        if (!personalRequestDTO.getFileUpload().contains(".")) {
//          System.out.println("파일 양식에 맞추어 작성바랍니다. ex) a.jpg");
//          System.out.println();
//          continue;
//        } else {
//          break;
//        }
//      }
//      personalRequestDTO.setIsOrg(false); 
//      //      personalRequestDTO.setIsSigned("승인대기");
//
//      personalRequestDTOList.add(personalRequestDTO);
//
//    } catch (NumberFormatException e) {
//      System.out.println("--------------------------------------------------------------");
//      System.out.println("올바른 숫자를 입력하세요");
//      System.out.println("--------------------------------------------------------------");
//      continue;
//
//    } catch (Exception e) {
//      System.out.println("--------------------------------------------------------------");
//      //      System.out.printf("오류 발생: %s\n", e.getClass().getName());
//      System.out.println("다시 입력 바랍니다.");
//      System.out.println("--------------------------------------------------------------");
//      continue;
//
//    }
//    break;
//  }
//
//  System.out.println("개인봉사신청이 완료되었습니다.");
//}
//  





