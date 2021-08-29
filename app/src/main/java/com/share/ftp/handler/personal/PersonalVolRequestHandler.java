package com.share.ftp.handler.personal;

import java.sql.Date;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.util.Prompt;

public class PersonalVolRequestHandler { // 개인 봉사신청 양식 쓰는 곳

  public static final int MAX_LENTGH = 100;
  PersonalRequestDTO[] personalRequestsDTO = new PersonalRequestDTO[MAX_LENTGH];
  int size;


  public void apply() {

    System.out.println("[개인봉사활동 양식]");

    try {
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
      personalRequestDTO.setIsOrg(false); 

      personalRequestsDTO[size++] = personalRequestDTO;



    } catch (Throwable e) {
      System.out.println("--------------------------------------------------------------");
      System.out.printf("오류 발생: %s\n", e.getClass().getName());
      System.out.println("--------------------------------------------------------------");
    }



    System.out.println("개인봉사신청이 완료되었습니다.");

    //    return personalRequestsDTO;
  }

  public void applyList() {
    System.out.println("[개인봉사신청 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %b \n", 
          this.personalRequestsDTO[i].getNo(), 
          this.personalRequestsDTO[i].getTitle(), 
          this.personalRequestsDTO[i].getTel(),
          this.personalRequestsDTO[i].getEmail(),
          this.personalRequestsDTO[i].getVolunteerPeriod(),
          this.personalRequestsDTO[i].getVolunteerTime(),
          this.personalRequestsDTO[i].getVolunteerList(),
          this.personalRequestsDTO[i].getContent(),
          this.personalRequestsDTO[i].getFileUpload(),
          this.personalRequestsDTO[i].isOrg()
          );
    }
  }

}
