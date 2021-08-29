package com.share.ftp.handler.personal;

import java.sql.Date;
import com.share.ftp.domain.personal.OrgRequestDTO;
import com.share.util.Prompt;

public class OrgVolRequestHandler {

  public static final int MAX_LENTGH = 100;
  OrgRequestDTO[] orgRequestsDTO = new OrgRequestDTO[MAX_LENTGH];
  int size;



  public void apply() {

    try {
      OrgRequestDTO orgRequestDTO = new OrgRequestDTO();

      orgRequestDTO.setNo(Prompt.inputInt("번호? ")); 
      orgRequestDTO.setTitle(Prompt.inputString("제목? ")); 
      orgRequestDTO.setSort(Prompt.inputString("분류? ")); 
      orgRequestDTO.setTel(Prompt.inputString("전화번호? ")); 
      orgRequestDTO.setEmail(Prompt.inputString("이메일? ")); 
      orgRequestDTO.setVolunteerPeriod(Prompt.inputDate("봉사기간? ")); 
      orgRequestDTO.setVolunteerTime(new Date(System.currentTimeMillis())); 
      orgRequestDTO.setVolunteerList(Prompt.inputString("봉사시간? ")); 
      orgRequestDTO.setContent(Prompt.inputString("내용? ")); 
      orgRequestDTO.setFileUpload(Prompt.inputString("파일? ")); 
      orgRequestDTO.setIsOrg(Prompt.inputBool("기업여부? ")); 

      orgRequestsDTO[size++] = orgRequestDTO;

    } catch (Throwable e) {
      System.out.println(e.getClass().getName());
    }


    System.out.println("기관봉사신청이 완료되었습니다.");
  }



}
