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

  //해당 봉사 신청서를 승인한다.
  public void acceptApply() {
    System.out.println("[개인봉사신청서 승인]");
    int no = Prompt.inputInt("번호? ");

    int personalRequestIndex = -1;

    for (int i = 0; i < this.size; i++) {
      if (this.personalRequestsDTO[i].getNo() == no) {
        personalRequestIndex = i;
        break;
      }
    }

    if (personalRequestIndex == -1) {
      System.out.println("해당 번호의 개인봉사신청서가 없습니다.");
      return;
    }



    String input = Prompt.inputString("정말 승인하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 승인을 취소하였습니다.");
      return;
    }

    for (int i = personalRequestIndex + 1; i < this.size; i++) {
      this.personalRequestsDTO[i - 1] = this.personalRequestsDTO[i];
    }
    this.personalRequestsDTO[--this.size] = null;

    System.out.println("해당 봉사활동을 승인하였습니다.");
  }



  // 해당 봉사 신청서를 반려한다.
  public void rejectApply() {
    System.out.println();
    System.out.println("[개인봉사신청서 반려]");

    int no = Prompt.inputInt("봉사번호? ");

    int personalRequestIndex = -1;

    for (int i = 0; i < this.size; i++) {
      if (this.personalRequestsDTO[i].getNo() == no) {
        personalRequestIndex = i;
        break;
      }
    }

    if (personalRequestIndex == -1) {
      System.out.println("개인봉사신청서를 찾을 수 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 반려하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      return;
    }

    for (int i = personalRequestIndex + 1; i < this.size; i++) {
      this.personalRequestsDTO[i - 1] = this.personalRequestsDTO[i];
    }
    this.personalRequestsDTO[--this.size] = null;

    System.out.println("해당 봉사신청을 반려하였습니다.");
  }

}
