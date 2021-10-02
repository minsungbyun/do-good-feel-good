package com.share.ftp.handler.personal.volunteer;

import static com.share.util.General.member.ORG;
import static com.share.util.General.member.PERSONAL;
import static com.share.util.General.type.ANIMAL;
import static com.share.util.General.type.CHILDREN;
import static com.share.util.General.type.ELDER;
import static com.share.util.General.type.ENVIRONMENT;
import static com.share.util.General.type.HANDICAPPED;
import static com.share.util.General.type.OTHER;
import static com.share.util.General.type.TEEN;
import static com.share.util.General.type.UNTACT;
import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import  com.share.ftp.domain.personal.GeneralRequestDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolGeneralRequestApplyHandler extends AbstractVolGeneralHandler { // 개인 봉사신청 양식 쓰는 곳
  //  int volNo;  // 봉사 번호 자동 부여
  List<JoinDTO> joinDTOList;

  public VolGeneralRequestApplyHandler(
      List<GeneralRequestDTO> generalRequestDTOList,
      List<JoinDTO> joinDTOList) {

    super(generalRequestDTOList);
    this.joinDTOList = joinDTOList;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사활동 양식  ]");

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
          System.out.println(" ▶ 1. 개인봉사신청");
          System.out.println(" ▶ 2. 기관봉사신청");
          System.out.println();

          int num = Prompt.inputInt("번호입력 ▶ ");

          switch (num) {
            case 1: generalRequestDTO.setMemberType(PERSONAL);          break;
            case 2: generalRequestDTO.setMemberType(ORG);               break;
            default: System.out.println("올바를 숫자를 입력해주세요."); continue;
          }

          if (AuthLoginHandler.getLoginUser().getType() != generalRequestDTO.getMemberType()) {
            System.out.println("당신은 해당 유형봉사를 신청 할 수 없습니다.");
            System.out.println("개인회원인지 기관회원인지 확인하세요!");
            continue;
          }
          break;
        }

        generalRequestDTO.setVolTitle(Prompt.inputString("제목 ▶ "));
        generalRequestDTO.setOwner(joinDTO);
        generalRequestDTO.setOwnerId(joinDTO.getId());
        generalRequestDTO.setVolName(joinDTO.getName());
        System.out.println();

        System.out.println(" ▶ 봉사 유형 ");
        System.out.println();

        System.out.print("[1 ▶ 비대면] ");
        System.out.print("[2 ▶ 아동  ] ");
        System.out.print("[3 ▶ 청소년] ");
        System.out.print("[4 ▶ 노인  ]\n");
        System.out.print("[5 ▶ 장애인] ");
        System.out.print("[6 ▶ 동물  ] ");
        System.out.print("[7 ▶ 환경  ] ");
        System.out.print("[8 ▶ 기타  ]\n ");
        System.out.println();

        int input = Prompt.inputInt("유형 ▶ ");

        switch (input) {
          case 1: generalRequestDTO.setVolType(UNTACT);        break;
          case 2: generalRequestDTO.setVolType(CHILDREN);      break;
          case 3: generalRequestDTO.setVolType(TEEN);          break;
          case 4: generalRequestDTO.setVolType(ELDER);         break;
          case 5: generalRequestDTO.setVolType(HANDICAPPED);   break;
          case 6: generalRequestDTO.setVolType(ANIMAL);        break;
          case 7: generalRequestDTO.setVolType(ENVIRONMENT);   break;
          case 8: generalRequestDTO.setVolType(OTHER);         break;
          default: System.out.println("올바른 번호를 입력해주세요"); continue;
        }

        generalRequestDTO.setVolTel(Prompt.inputString("전화번호 ▶ "));
        generalRequestDTO.setVolEmail(Prompt.inputString("이메일 ▶ ")); 
        generalRequestDTO.setVolStartDate(Prompt.inputDate("봉사시작기간(yyyy-mm-dd) ▶ "));
        generalRequestDTO.setVolEndDate(Prompt.inputDate("봉사종료기간(yyyy-mm-dd) ▶ ")); 
        generalRequestDTO.setVolStartTime(Prompt.inputString("봉사시작시간 ▶ ")); 
        generalRequestDTO.setVolEndTime(Prompt.inputString("봉사종료시간 ▶ ")); 
        //        personalRequestDTO.setVolList(Prompt.inputString("봉사목록 ▶ ")); 
        generalRequestDTO.setVolLimitNum(Prompt.inputInt("봉사인원 ▶ "));
        generalRequestDTO.setVolContent(Prompt.inputString("내용 ▶ ")); 
        generalRequestDTO.setVolSubmitTime(new Date(System.currentTimeMillis())); 
        generalRequestDTO.setVolFileUpload(Prompt.inputString("파일 ▶ ")); 
        generalRequestDTO.getIsSigned();


        generalRequestDTO.setVolNo(getNextNum());

        generalRequestDTOList.add(generalRequestDTO);

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





