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

    try {
      PersonalRequestDTO personalRequestDTO = new PersonalRequestDTO();

      personalRequestDTO.setNo(Prompt.inputInt("번호? ")); 
      personalRequestDTO.setTitle(Prompt.inputString("제목? ")); 
      personalRequestDTO.setSort(Prompt.inputString("분류? ")); 
      personalRequestDTO.setTel(Prompt.inputString("전화번호? ")); 
      personalRequestDTO.setEmail(Prompt.inputString("이메일? ")); 
      personalRequestDTO.setVolunteerPeriod(Prompt.inputString("봉사기간? ")); 
      personalRequestDTO.setVolunteerTime(new Date(System.currentTimeMillis())); 
      personalRequestDTO.setVolunteerList(Prompt.inputString("봉사목록? ")); 
      personalRequestDTO.setJoinNum(Prompt.inputInt("봉사인원? "));
      personalRequestDTO.setContent(Prompt.inputString("내용? ")); 
      personalRequestDTO.setFileUpload(Prompt.inputString("파일? ")); 
      personalRequestDTO.setIsOrg(false); 
      //      personalRequestDTO.setIsSigned("승인대기");

      personalRequestDTOList.add(personalRequestDTO);

    } catch (Exception e) {
      System.out.println("--------------------------------------------------------------");
      //      System.out.printf("오류 발생: %s\n", e.getClass().getName());
      System.out.println("오류가 발생했으니 다시 입력 바랍니다.");
      e.printStackTrace();
      System.out.println("--------------------------------------------------------------");
    }

    System.out.println("개인봉사신청이 완료되었습니다.");

  }



}
