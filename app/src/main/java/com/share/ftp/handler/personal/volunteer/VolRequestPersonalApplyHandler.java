package com.share.ftp.handler.personal.volunteer;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.guest.JoinDTO;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolRequestPersonalApplyHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳


  public VolRequestPersonalApplyHandler(List<PersonalRequestDTO> personalRequestDTOList) {

    super(personalRequestDTOList);
  }


  @Override
  public void execute() {
    System.out.println();
    System.out.println("[개인봉사활동 양식]");

    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();

    if (joinDTO == null) {
      System.out.println("로그인 후 사용가능합니다.");
      return;
    }
    while (true) {
      try {

        PersonalRequestDTO personalRequestDTO = new PersonalRequestDTO();

        personalRequestDTO.setNo(Prompt.inputInt("번호? "));

        while (true) {
          personalRequestDTO.setTitle(Prompt.inputString("제목? "));
          if (!personalRequestDTO.getTitle().matches("^[가-힣]*$")) {
            System.out.println("한글을 작성하세요. ex) 뜨개질");
            System.out.println();
            continue;
          } else {
            break;
          }
        }

        while (true) {
          personalRequestDTO.setSort(Prompt.inputString("분류? "));
          if (!personalRequestDTO.getSort().matches("^[가-힣]*$")) {
            System.out.println("한글을 작성하세요. ex) 비대면");
            System.out.println();
            continue;
          } else {
            break;
          }
        }

        while (true) {
          personalRequestDTO.setTel(Prompt.inputString("전화번호? "));
          if (!personalRequestDTO.getTel().contains("-")) {
            System.out.println("전화번호 양식에 맞추어 작성바랍니다. ex) 010-0000-0000");
            System.out.println();
            continue;
          } else {
            break;
          }
        }

        while (true) {
          personalRequestDTO.setEmail(Prompt.inputString("이메일? ")); 
          if (!personalRequestDTO.getEmail().contains("@") && 
              !personalRequestDTO.getEmail().contains(".")) {

            System.out.println("이메일 양식에 맞추어 작성바랍니다. ex) aaa@test.com");
            System.out.println();
            continue;
          } else {
            break;
          }
        }

        personalRequestDTO.setVolunteerPeriod(Prompt.inputString("봉사기간? ")); 
        personalRequestDTO.setVolunteerTime(new Date(System.currentTimeMillis())); 
        personalRequestDTO.setVolunteerList(Prompt.inputString("봉사목록? ")); 
        personalRequestDTO.setJoinNum(Prompt.inputInt("봉사인원? "));
        personalRequestDTO.setContent(Prompt.inputString("내용? ")); 

        while (true) {
          personalRequestDTO.setFileUpload(Prompt.inputString("파일? ")); 
          if (!personalRequestDTO.getFileUpload().contains(".")) {
            System.out.println("파일 양식에 맞추어 작성바랍니다. ex) a.jpg");
            System.out.println();
            continue;
          } else {
            break;
          }
        }
        personalRequestDTO.setIsOrg(false); 
        //      personalRequestDTO.setIsSigned("승인대기");

        personalRequestDTOList.add(personalRequestDTO);

      } catch (NumberFormatException e) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("올바른 숫자를 입력하세요");
        System.out.println("--------------------------------------------------------------");
        continue;

      } catch (Exception e) {
        System.out.println("--------------------------------------------------------------");
        //      System.out.printf("오류 발생: %s\n", e.getClass().getName());
        System.out.println("다시 입력 바랍니다.");
        System.out.println("--------------------------------------------------------------");
        continue;

      }
      break;
    }

    System.out.println("개인봉사신청이 완료되었습니다.");
  }
}
