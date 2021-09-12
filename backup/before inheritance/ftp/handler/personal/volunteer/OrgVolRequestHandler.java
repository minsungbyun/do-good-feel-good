package com.share.ftp.handler.personal.volunteer;

public class OrgVolRequestHandler {

  //  public static final int MAX_LENTGH = 100;
  //  OrgRequestDTO[] orgRequestsDTO = new OrgRequestDTO[MAX_LENTGH];
  //  int size;
  //
  //  public void apply() {
  //    try {
  //      System.out.println();
  //      System.out.println("[기관봉사활동 양식]");
  //
  //      OrgRequestDTO orgRequestDTO = new OrgRequestDTO();
  //
  //      orgRequestDTO.setNo(Prompt.inputInt("번호? ")); 
  //      orgRequestDTO.setTitle(Prompt.inputString("제목? ")); 
  //      orgRequestDTO.setSort(Prompt.inputString("분류? ")); 
  //      orgRequestDTO.setTel(Prompt.inputString("전화번호? ")); 
  //      orgRequestDTO.setEmail(Prompt.inputString("이메일? ")); 
  //      orgRequestDTO.setVolunteerPeriod(Prompt.inputString("봉사기간? ")); 
  //      orgRequestDTO.setVolunteerTime(new Date(System.currentTimeMillis())); 
  //      orgRequestDTO.setVolunteerList(Prompt.inputString("봉사목록? ")); 
  //      orgRequestDTO.setJoinNum(Prompt.inputInt("봉사인원? ")); 
  //      orgRequestDTO.setContent(Prompt.inputString("내용? ")); 
  //      orgRequestDTO.setFileUpload(Prompt.inputString("파일? ")); 
  //      orgRequestDTO.setIsOrg(true); 
  //
  //      orgRequestsDTO[size++] = orgRequestDTO;
  //
  //    } catch (Throwable e) {
  //      System.out.println("--------------------------------------------------------------");
  //      System.out.printf("오류 발생: %s\n", e.getClass().getName());
  //      System.out.println("--------------------------------------------------------------");
  //    }
  //
  //
  //    System.out.println("기관봉사신청이 완료되었습니다.");
  //  }
  //
  //  public void applyList() {
  //    System.out.println();
  //    System.out.println("[기관봉사신청 목록]");
  //    for (int i = 0; i < this.size; i++) {
  //      System.out.printf("번호: %d\n봉사제목: %s\n전화번호: %s\n이메일: %s\n봉사기간: %s\n봉사시간: %s"
  //          + "봉사목록: %s\n봉사인원: %d\n봉사내용: %s\n첨부파일: %s\n승인여부: %b \n\n", 
  //          this.orgRequestsDTO[i].getNo(), 
  //          this.orgRequestsDTO[i].getTitle(), 
  //          this.orgRequestsDTO[i].getTel(),
  //          this.orgRequestsDTO[i].getEmail(),
  //          this.orgRequestsDTO[i].getVolunteerPeriod(),
  //          this.orgRequestsDTO[i].getVolunteerTime(),
  //          this.orgRequestsDTO[i].getVolunteerList(),
  //          this.orgRequestsDTO[i].getJoinNum(),
  //          this.orgRequestsDTO[i].getContent(),
  //          this.orgRequestsDTO[i].getFileUpload(),
  //          this.orgRequestsDTO[i].isOrg()
  //          );
  //    }
  //  }
  //
  //  //해당 봉사 신청서를 승인한다.
  //  public void acceptApply() {
  //    System.out.println();
  //    System.out.println("[기관봉사신청서 승인]");
  //    int no = Prompt.inputInt("번호? ");
  //
  //    int orgRequestIndex = -1;
  //
  //    for (int i = 0; i < this.size; i++) {
  //      if (this.orgRequestsDTO[i].getNo() == no) {
  //        orgRequestIndex = i;
  //        break;
  //      }
  //    }
  //
  //    if (orgRequestIndex == -1) {
  //      System.out.println("해당 번호의 기관봉사신청서가 없습니다.");
  //      return;
  //    }
  //
  //    String input = Prompt.inputString("정말 승인하시겠습니까?(y/N) ");
  //    if (input.equalsIgnoreCase("n") || input.length() == 0) {
  //      System.out.println("게시글 승인을 취소하였습니다.");
  //      return;
  //    }
  //
  //    for (int i = orgRequestIndex + 1; i < this.size; i++) {
  //      this.orgRequestsDTO[i - 1] = this.orgRequestsDTO[i];
  //    }
  //    this.orgRequestsDTO[--this.size] = null;
  //
  //    System.out.println("해당 봉사활동을 승인하였습니다.");
  //  }
  //
  //
  //  // 해당 봉사 신청서를 반려한다.
  //  public void rejectApply() {
  //    System.out.println();
  //    System.out.println("[기관봉사신청서 반려]");
  //
  //    int no = Prompt.inputInt("봉사번호? ");
  //
  //    int orgRequestIndex = -1;
  //
  //    for (int i = 0; i < this.size; i++) {
  //      if (this.orgRequestsDTO[i].getNo() == no) {
  //        orgRequestIndex = i;
  //        break;
  //      }
  //    }
  //
  //    if (orgRequestIndex == -1) {
  //      System.out.println("해당 기관봉사신청서를 찾을 수 없습니다.");
  //      return;
  //    }
  //
  //    String input = Prompt.inputString("정말 반려하시겠습니까?(y/N) ");
  //    if (input.equalsIgnoreCase("n") || input.length() == 0) {
  //      System.out.println("게시글 반려를 취소하였습니다.");
  //      return;
  //    }
  //
  //    for (int i = orgRequestIndex + 1; i < this.size; i++) {
  //      this.orgRequestsDTO[i - 1] = this.orgRequestsDTO[i];
  //    }
  //    this.orgRequestsDTO[--this.size] = null;
  //
  //    System.out.println("해당 봉사신청을 반려하였습니다.");
  //  }
  //
  //
  //  // 봉사 신청과 반려를 마이페이지에서 볼 수 있게 return 한다.
  //  private String acceptMessage() {
  //    return null;
  //  } 
  //
  //  private String rejectMessage() {
  //    return null;
  //  } 





}
