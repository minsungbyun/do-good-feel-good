package com.share.ftp.handler.personal;

import java.sql.Date;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.util.Prompt;

public class PersonalVolRequestHandler { // 개인 봉사신청 양식 쓰는 곳


  // 전체 배열
  public static final int MAX_LENTGH = 100;
  PersonalRequestDTO[] personalRequestsDTO = new PersonalRequestDTO[MAX_LENTGH];
  int size;

  // 봉사 승인 관련 배열
  PersonalRequestDTO[] personalRequestApplyDTO = new PersonalRequestDTO[MAX_LENTGH];
  int applySize;

  // 봉사 반려 관련 배열
  PersonalRequestDTO[] personalRequestRejectDTO = new PersonalRequestDTO[MAX_LENTGH];
  int rejectSize;



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
      System.out.printf("봉사명 : %d\n 봉사제목 : %s\n %s, %s, %s, %s, %s, %s, %s, %b \n", 
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

  public void appliedList() {
    System.out.println("[개인봉사승인 목록]");
    for (int i = 0; i < this.applySize; i++) {
      System.out.printf("봉사명 : %d\n 봉사제목 : %s\n %s, %s, %s, %s, %s, %s, %s, %b \n", 
          this.personalRequestApplyDTO[i].getNo(), 
          this.personalRequestApplyDTO[i].getTitle(), 
          this.personalRequestApplyDTO[i].getTel(),
          this.personalRequestApplyDTO[i].getEmail(),
          this.personalRequestApplyDTO[i].getVolunteerPeriod(),
          this.personalRequestApplyDTO[i].getVolunteerTime(),
          this.personalRequestApplyDTO[i].getVolunteerList(),
          this.personalRequestApplyDTO[i].getContent(),
          this.personalRequestApplyDTO[i].getFileUpload(),
          this.personalRequestApplyDTO[i].isOrg()
          );
    }
  }

  public void rejectedList() {
    System.out.println("[개인봉사반려 목록]");
    for (int i = 0; i < this.rejectSize; i++) {
      System.out.printf("봉사명 : %d\n 봉사제목 : %s\n %s, %s, %s, %s, %s, %s, %s, %b \n", 
          this.personalRequestRejectDTO[i].getNo(), 
          this.personalRequestRejectDTO[i].getTitle(), 
          this.personalRequestRejectDTO[i].getTel(),
          this.personalRequestRejectDTO[i].getEmail(),
          this.personalRequestRejectDTO[i].getVolunteerPeriod(),
          this.personalRequestRejectDTO[i].getVolunteerTime(),
          this.personalRequestRejectDTO[i].getVolunteerList(),
          this.personalRequestRejectDTO[i].getContent(),
          this.personalRequestRejectDTO[i].getFileUpload(),
          this.personalRequestRejectDTO[i].isOrg()
          );
    }
  }

  //해당 봉사 신청서를 승인한다.   
  public void acceptApply() {


    System.out.println("[개인봉사신청서 승인]");
    int no = Prompt.inputInt("번호? ");

    int personalRequestIndex = indexOf(no);

    //    PersonalRequestDTO personalRequestApplyDTO = null;
    PersonalRequestDTO personalRequestDTO = findByVol(no);

    for (int i = 0; i < this.size; i++) {
      if (this.personalRequestsDTO[i].getNo() == no) {
        //        PersonalRequestApplyDTO personalRequestApplyDTO = new PersonalRequestApplyDTO();
        //        this.personalRequestApplyDTO[i].getNo(); 
        //        //        this.personalRequestsDTO[i].getTitle(), 
        //        this.personalRequestsDTO[i].getTel(),
        //        this.personalRequestsDTO[i].getEmail(),
        //        this.personalRequestsDTO[i].getVolunteerPeriod(),
        //        this.personalRequestsDTO[i].getVolunteerTime(),
        //        this.personalRequestsDTO[i].getVolunteerList(),
        //        this.personalRequestsDTO[i].getContent(),
        //        this.personalRequestsDTO[i].getFileUpload(),
        //        this.personalRequestsDTO[i].isOrg()
        personalRequestDTO = personalRequestsDTO[i];
        personalRequestIndex = i;
        break;
      }
    }


    if (personalRequestIndex == -1) {
      System.out.println("해당 번호의 개인봉사신청서가 없습니다.");
    }

    if (personalRequestDTO == null) {
      System.out.println("해당 번호의 개인봉사신청서가 없습니다.");
    }




    String input = Prompt.inputString("정말 승인하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("해당 봉사신청 승인을 취소하였습니다.");
      return;
    }

    personalRequestApplyDTO[applySize++] = personalRequestDTO;

    for (int i = personalRequestIndex + 1; i < this.size; i++) {
      this.personalRequestsDTO[i - 1] = this.personalRequestsDTO[i];
    }
    this.personalRequestsDTO[--this.size] = null;

    System.out.println("해당 봉사신청을 승인하였습니다.");

  }



  // 해당 봉사 신청서를 반려한다.
  public void rejectApply() {
    System.out.println();
    System.out.println("[개인봉사신청서 반려]");

    int no = Prompt.inputInt("봉사번호? ");

    int personalRequestIndex = indexOf(no);
    PersonalRequestDTO personalRequestDTO = findByVol(no);

    for (int i = 0; i < this.size; i++) {
      if (this.personalRequestsDTO[i].getNo() == no) {
        personalRequestDTO = personalRequestsDTO[i];
        personalRequestIndex = i;
        break;
      }
    }

    if (personalRequestIndex == -1) {
      System.out.println("개인봉사신청서를 찾을 수 없습니다.");
      return;
    }

    if (personalRequestDTO == null) {
      System.out.println("해당 번호의 개인봉사신청서가 없습니다.");
    }



    String input = Prompt.inputString("정말 반려하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      return;
    }

    personalRequestApplyDTO[applySize++] = personalRequestDTO;

    for (int i = personalRequestIndex + 1; i < this.size; i++) {
      this.personalRequestsDTO[i - 1] = this.personalRequestsDTO[i];
    }
    this.personalRequestsDTO[--this.size] = null;

    System.out.println("해당 봉사신청을 반려하였습니다.");
  }

  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.personalRequestsDTO[i].getNo() == no) {
        return i;
      }
    }
    return -1;
  }

  public String getReturnMessage() {
    for (int i = 0; i < this.size; i++) {
      if (this.personalRequestsDTO[i] == null) {
        return ""; 
      }
    }
    return null;
  }

  private PersonalRequestDTO findByVol(int no) {
    for (int i = 0; i < this.size; i++) {
      if (personalRequestsDTO[i].getNo() == no) {
        return personalRequestsDTO[i];
      }
    }
    return null;

  }

}
