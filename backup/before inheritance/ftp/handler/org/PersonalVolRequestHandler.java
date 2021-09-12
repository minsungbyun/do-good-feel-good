package com.share.ftp.handler.org;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.util.Prompt;

public class PersonalVolRequestHandler {


  List<PersonalRequestDTO> personalRequestDTOList;
  public static final int MAX_LENTGH = 100;
  PersonalRequestDTO[] personalRequestsDTO = new PersonalRequestDTO[MAX_LENTGH];
  int size;

  public void apply() {
    PersonalRequestDTO personalRequestDTO = new PersonalRequestDTO();

    personalRequestDTO.setNo(Prompt.inputInt("번호? ")); 
    personalRequestDTO.setTitle(Prompt.inputString("제목? ")); 
    personalRequestDTO.setSort(Prompt.inputString("분류? ")); 
    personalRequestDTO.setTel(Prompt.inputString("전화번호? ")); 
    personalRequestDTO.setEmail(Prompt.inputString("이메일? ")); 
    personalRequestDTO.setVolunteerPeriod(Prompt.inputString("봉사기간? ")); 
    personalRequestDTO.setVolunteerTime(new Date(System.currentTimeMillis())); 
    personalRequestDTO.setVolunteerList(Prompt.inputString("봉사시간? ")); 
    personalRequestDTO.setContent(Prompt.inputString("내용? ")); 
    personalRequestDTO.setFileUpload(Prompt.inputString("파일? ")); 
    personalRequestDTO.setIsOrg(Prompt.inputBool("기업여부? ")); 

    personalRequestsDTO[size++] = personalRequestDTO;


    System.out.println("개인봉사신청이 완료되었습니다.");
  }

}
