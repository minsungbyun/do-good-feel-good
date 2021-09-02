package com.share.ftp.handler.personal;

import java.sql.Date;
import com.share.ftp.domain.guest.JoinDTO;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.handler.join.AuthHandler;
import com.share.util.Prompt;

public class PersonalVolRequestHandler { // 개인 봉사신청 양식 쓰는 곳

  OrgVolRequestHandler orgVolRequestHandler;
  public PersonalVolRequestHandler(OrgVolRequestHandler orgVolRequestHandler) {
    this.orgVolRequestHandler = orgVolRequestHandler;
  }

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

    JoinDTO joinDTO = AuthHandler.getLoginUser();

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
      System.out.printf("번호: %d\n봉사제목: %s\n전화번호: %s\n이메일: %s\n봉사기간: %s\n봉사시간: %s\n"
          + "봉사목록: %s\n봉사인원: %d\n봉사내용: %s\n첨부파일: %s\n승인여부: %b \n\n", 
          this.personalRequestsDTO[i].getNo(), 
          this.personalRequestsDTO[i].getTitle(), 
          this.personalRequestsDTO[i].getTel(),
          this.personalRequestsDTO[i].getEmail(),
          this.personalRequestsDTO[i].getVolunteerPeriod(),
          this.personalRequestsDTO[i].getVolunteerTime(),
          this.personalRequestsDTO[i].getVolunteerList(),
          this.personalRequestsDTO[i].getJoinNum(),
          this.personalRequestsDTO[i].getContent(),
          this.personalRequestsDTO[i].getFileUpload(),
          this.personalRequestsDTO[i].isChecked()
          );
    }
  }

  public void appliedList() {
    System.out.println("[개인봉사승인 목록]");

    if (this.personalRequestsDTO == null) {
      System.out.println("현재 승인된 봉사목록이 없습니다.");
      return;
    }

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
          this.personalRequestApplyDTO[i].isChecked()
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
          this.personalRequestRejectDTO[i].isChecked()
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
        personalRequestDTO = personalRequestsDTO[i];
        personalRequestIndex = i;
        break;
      }
    }


    if (personalRequestIndex == -1) {
      System.out.println("해당 번호의 개인봉사신청서가 없습니다.");
      return;
    }

    if (personalRequestDTO == null) {
      System.out.println("해당 번호의 개인봉사신청서가 없습니다.");
      return;
    }




    String input = Prompt.inputString("정말 승인하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("해당 봉사신청 승인을 취소하였습니다.");
      return;
    }

    personalRequestDTO.setChecked(true);
    personalRequestApplyDTO[applySize++] = personalRequestDTO;

    //    for (int i = personalRequestIndex + 1; i < this.size; i++) {
    //      this.personalRequestsDTO[i - 1] = this.personalRequestsDTO[i];
    //    }
    //    this.personalRequestsDTO[--this.size] = null;

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
      return;
    }


    String input = Prompt.inputString("정말 반려하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("해당 봉사신청 반려를 취소하였습니다.");
      return;
    }

    personalRequestDTO.setChecked(false);
    personalRequestApplyDTO[applySize++] = personalRequestDTO;

    for (int i = personalRequestIndex + 1; i < this.size; i++) {
      this.personalRequestsDTO[i - 1] = this.personalRequestsDTO[i];
    }
    this.personalRequestsDTO[--this.size] = null;

    System.out.println("해당 봉사신청을 반려하였습니다.");
  }

  //인증받은 봉사 리스트 (개인 + 기관)
  public void approvedList() {

    // 구현예정

  }

  // 인증받은 봉사 리스트 세부사항
  public void approvedDetail() {

    // 인증받은 봉사 중 1개를 선택해서 세부사항을 본다.
    // 선택 > 참여자현황 / 신청하기 / 세부설명(봉사정보,위치) / 문의사항 

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
          this.personalRequestApplyDTO[i].isChecked()
          );
    }

    //구현예정

  }


  // 함께해요 - 찜한 목록(마이페이지 연동 예정)
  public void showVolBookmark() {

    // 인증받은 봉사 리스트 중 내가 선택한 번호의 봉사 리스트를
    // 새로운 배열(리스트)에 담아서 마이페이지에서 보여준다.



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
