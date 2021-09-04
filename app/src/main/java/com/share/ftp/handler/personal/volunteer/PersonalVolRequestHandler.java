package com.share.ftp.handler.personal.volunteer;

public class PersonalVolRequestHandler { // 개인 봉사신청 양식 쓰는 곳


  //  // 개인 전체 리스트
  //  List<PersonalRequestDTO> personalRequestDTOList;
  //  // 개인 봉사 승인 리스트
  //  List<PersonalRequestDTO> personalRequestApplyDTOList;
  //  //  List<PersonalRequestApplyDTO> personalRequestApplyDTOList;
  //  // 개인 봉사 반려 리스트
  //  List<PersonalRequestDTO> personalRequestRejectDTOList;
  //  //  List<PersonalRequestRejectDTO> personalRequestRejectDTOList;
  //
  //
  //  public PersonalVolRequestHandler(
  //      List<PersonalRequestDTO> personalRequestDTOList,
  //      List<PersonalRequestDTO> personalRequestApplyDTOList,
  //      List<PersonalRequestDTO> personalRequestRejectDTOList) {
  //
  //    this.personalRequestDTOList = personalRequestDTOList;
  //    this.personalRequestApplyDTOList = personalRequestApplyDTOList;
  //    this.personalRequestRejectDTOList = personalRequestRejectDTOList;
  //
  //  }
  //
  //  //  // 전체 배열
  //  //  public static final int MAX_LENTGH = 100;
  //  //  PersonalRequestDTO[] personalRequestsDTO = new PersonalRequestDTO[MAX_LENTGH];
  //  //  int size;
  //  //
  //  //
  //  //
  //  //
  //  //  // 봉사 승인 관련 배열
  //  //  PersonalRequestDTO[] personalRequestApplyDTO = new PersonalRequestDTO[MAX_LENTGH];
  //  //  int applySize;
  //  //
  //  //  // 봉사 반려 관련 배열
  //  //  PersonalRequestDTO[] personalRequestRejectDTO = new PersonalRequestDTO[MAX_LENTGH];
  //  //  int rejectSize;
  //
  //
  //
  //  public void apply() {
  //    System.out.println();
  //    System.out.println("[개인봉사활동 양식]");
  //
  //    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();
  //
  //    if (joinDTO == null) {
  //      System.out.println("로그인 후 사용가능합니다.");
  //      return;
  //    }
  //
  //    try {
  //      PersonalRequestDTO personalRequestDTO = new PersonalRequestDTO();
  //
  //      personalRequestDTO.setNo(Prompt.inputInt("번호? ")); 
  //      personalRequestDTO.setTitle(Prompt.inputString("제목? ")); 
  //      personalRequestDTO.setSort(Prompt.inputString("분류? ")); 
  //      personalRequestDTO.setTel(Prompt.inputString("전화번호? ")); 
  //      personalRequestDTO.setEmail(Prompt.inputString("이메일? ")); 
  //      personalRequestDTO.setVolunteerPeriod(Prompt.inputString("봉사기간? ")); 
  //      personalRequestDTO.setVolunteerTime(new Date(System.currentTimeMillis())); 
  //      personalRequestDTO.setVolunteerList(Prompt.inputString("봉사목록? ")); 
  //      personalRequestDTO.setJoinNum(Prompt.inputInt("봉사인원? "));
  //      personalRequestDTO.setContent(Prompt.inputString("내용? ")); 
  //      personalRequestDTO.setFileUpload(Prompt.inputString("파일? ")); 
  //      personalRequestDTO.setIsOrg(false); 
  //      //      personalRequestDTO.setIsSigned("승인대기");
  //
  //      personalRequestDTOList.add(personalRequestDTO);
  //
  //    } catch (Exception e) {
  //      System.out.println("--------------------------------------------------------------");
  //      //      System.out.printf("오류 발생: %s\n", e.getClass().getName());
  //      System.out.println("오류가 발생했으니 다시 입력 바랍니다.");
  //      e.printStackTrace();
  //      System.out.println("--------------------------------------------------------------");
  //    }
  //
  //    System.out.println("개인봉사신청이 완료되었습니다.");
  //
  //  }
  //
  //  public void applyList() {
  //    System.out.println();
  //    System.out.println("[개인봉사신청 목록]");
  //
  //    if (personalRequestDTOList.isEmpty()) {
  //      System.out.println("현재 등록된 봉사목록이 없습니다.");
  //      return;
  //    }
  //
  //
  //    for (PersonalRequestDTO personalRequestDTO : personalRequestDTOList) {
  //      System.out.printf("번호: %d\n봉사제목: %s\n전화번호: %s\n이메일: %s\n봉사기간: %s\n봉사시간: %s\n"
  //          + "봉사목록: %s\n봉사인원: %d\n봉사내용: %s\n첨부파일: %s\n승인여부: %b \n\n", 
  //          personalRequestDTO.getNo(), 
  //          personalRequestDTO.getTitle(), 
  //          personalRequestDTO.getTel(),
  //          personalRequestDTO.getEmail(),
  //          personalRequestDTO.getVolunteerPeriod(),
  //          personalRequestDTO.getVolunteerTime(),
  //          personalRequestDTO.getVolunteerList(),
  //          personalRequestDTO.getJoinNum(),
  //          personalRequestDTO.getContent(),
  //          personalRequestDTO.getFileUpload(),
  //          personalRequestDTO.isChecked()
  //          //          this.personalRequestRejectDTO[i].getIsSigned()
  //          );
  //    }
  //  }
  //
  //  public void appliedList() {
  //    System.out.println();
  //    System.out.println("[개인봉사승인 목록]");
  //
  //
  //    if (personalRequestApplyDTOList.isEmpty()) {
  //      System.out.println("현재 승인된 봉사목록이 없습니다.");
  //      return;
  //    }
  //
  //
  //    for (PersonalRequestDTO personalRequestApplyDTO : personalRequestApplyDTOList) {
  //      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %b \n", 
  //          personalRequestApplyDTO.getNo(), 
  //          personalRequestApplyDTO.getTitle(), 
  //          personalRequestApplyDTO.getTel(),
  //          personalRequestApplyDTO.getEmail(),
  //          personalRequestApplyDTO.getVolunteerPeriod(),
  //          personalRequestApplyDTO.getVolunteerTime(),
  //          personalRequestApplyDTO.getVolunteerList(),
  //          personalRequestApplyDTO.getContent(),
  //          personalRequestApplyDTO.getFileUpload(),
  //          personalRequestApplyDTO.isChecked()
  //          //          this.personalRequestRejectDTO[i].getIsSigned()
  //          );
  //    }
  //  }
  //
  //  public void rejectedList() {
  //    System.out.println();
  //    System.out.println("[개인봉사반려 목록]");
  //
  //    if (personalRequestRejectDTOList.isEmpty()) {
  //      System.out.println("현재 반려된 봉사목록이 없습니다.");
  //      return;
  //    }
  //
  //    for (PersonalRequestDTO personalRequestRejectDTO : personalRequestRejectDTOList) {
  //      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %b \n", 
  //          personalRequestRejectDTO.getNo(), 
  //          personalRequestRejectDTO.getTitle(), 
  //          personalRequestRejectDTO.getTel(),
  //          personalRequestRejectDTO.getEmail(),
  //          personalRequestRejectDTO.getVolunteerPeriod(),
  //          personalRequestRejectDTO.getVolunteerTime(),
  //          personalRequestRejectDTO.getVolunteerList(),
  //          personalRequestRejectDTO.getContent(),
  //          personalRequestRejectDTO.getFileUpload(),
  //          personalRequestRejectDTO.isChecked()
  //          //          this.personalRequestRejectDTO[i].getIsSigned()
  //          );
  //    }
  //  }
  //
  //  //해당 봉사 신청서를 승인한다.   
  //  public void acceptApply() {
  //    System.out.println();
  //    System.out.println("[개인봉사신청서 승인]");
  //    int no = Prompt.inputInt("번호? ");
  //
  //    //    int personalRequestIndex = indexOf(no);
  //
  //
  //    //    PersonalRequestDTO personalRequestApplyDTO = null;
  //    PersonalRequestDTO personalRequestDTO = findByVol(no);
  //
  //    //    PersonalRequestApplyDTO personalRequestApplyDTO = (PersonalRequestApplyDTO)personalRequestDTO;
  //    //
  //    ////    PersonalRequestApplyDTO personalRequestApplyDTO : personalRequestApplyDTOList
  //    //    
  //    //    personalRequestApplyDTOList.add(personalRequestDTO);
  //    //    
  //    //    
  //    //    for (PersonalRequestDTO personalRequestDTO : personalRpersonalRequestApplyDTOListequestDTOList) {
  //    //      if (personalRequestDTO.getNo() == no) {
  //    //
  //    //
  //    //        personalRequestDTO = personalRequestsDTO[i];
  //    //        personalRequestIndex = i;
  //    //        break;
  //    //      }
  //    //    }
  //
  //    //
  //    //    if (personalRequestIndex == -1) {
  //    //      System.out.println("해당 번호의 개인봉사신청서가 없습니다.");
  //    //      return;
  //    //    }
  //
  //    if (personalRequestDTO == null) {
  //      System.out.println("해당 번호의 개인봉사신청서가 없습니다.");
  //      return;
  //    }
  //
  //
  //
  //
  //    String input = Prompt.inputString("정말 승인하시겠습니까?(y/N) ");
  //    if (input.equalsIgnoreCase("n") || input.length() == 0) {
  //      System.out.println("해당 봉사신청 승인을 취소하였습니다.");
  //      return;
  //    }
  //
  //    personalRequestDTO.setChecked(true);
  //    //    personalRequestDTO.setIsSigned("승인됨");
  //
  //    //    List<Integer> first = new ArrayList<>(); first.add(0); first.add(1); first.add(2);
  //    //
  //    //    
  //    //    List<Integer> second = new ArrayList<>();
  //    //    for (Integer i : first) { 
  //    //      second.add(i);
  //    //      } 
  //    // second.addAll(first); first.add(3); System.out.println(second.toString()); }
  //
  //    //    List<PersonalRequestDTO> personalRequestApplyDTOList = new ArrayList<>();
  //
  //    // 기존 리스트 복사
  //    for (PersonalRequestDTO personalRequestApplyDTO : personalRequestDTOList) {
  //      personalRequestApplyDTOList.add(personalRequestApplyDTO);
  //    }
  //
  //
  //
  //
  //    //    personalRequestApplyDTO[applySize++] = personalRequestDTO;
  //
  //    //    for (int i = personalRequestIndex + 1; i < this.size; i++) {
  //    //      this.personalRequestsDTO[i - 1] = this.personalRequestsDTO[i];
  //    //    }
  //    //    this.personalRequestsDTO[--this.size] = null;
  //
  //    System.out.println("해당 봉사신청을 승인하였습니다.");
  //
  //  }
  //
  //
  //
  //  // 해당 봉사 신청서를 반려한다.
  //  public void rejectApply() {
  //    System.out.println();
  //    System.out.println("[개인봉사신청서 반려]");
  //
  //    int no = Prompt.inputInt("봉사번호? ");
  //
  //    //    int personalRequestIndex = indexOf(no);
  //    PersonalRequestDTO personalRequestDTO = findByVol(no);
  //
  //    //    for (int i = 0; i < this.size; i++) {
  //    //      if (this.personalRequestsDTO[i].getNo() == no) {
  //    //        personalRequestDTO = personalRequestsDTO[i];
  //    //        personalRequestIndex = i;
  //    //        break;
  //    //      }
  //    //    }
  //
  //    //    if (personalRequestIndex == -1) {
  //    //      System.out.println("개인봉사신청서를 찾을 수 없습니다.");
  //    //      return;
  //    //    }
  //
  //    if (personalRequestDTO == null) {
  //      System.out.println("해당 번호의 개인봉사신청서가 없습니다.");
  //      return;
  //    }
  //
  //
  //    String input = Prompt.inputString("정말 반려하시겠습니까?(y/N) ");
  //    if (input.equalsIgnoreCase("n") || input.length() == 0) {
  //      System.out.println("해당 봉사신청 반려를 취소하였습니다.");
  //      return;
  //    }
  //
  //    personalRequestDTO.setChecked(false);
  //    //    personalRequestDTO.setIsSigned("반려됨");
  //    //    personalRequestApplyDTO[applySize++] = personalRequestDTO;
  //
  //    // 기존 리스트 복사
  //    for (PersonalRequestDTO personalRequestRejectDTO : personalRequestDTOList) {
  //      personalRequestApplyDTOList.add(personalRequestRejectDTO);
  //    }
  //
  //    //    for (int i = personalRequestIndex + 1; i < this.size; i++) {
  //    //      this.personalRequestsDTO[i - 1] = this.personalRequestsDTO[i];
  //    //    }
  //    //    this.personalRequestsDTO[--this.size] = null;
  //
  //    System.out.println("해당 봉사신청을 반려하였습니다.");
  //  }
  //
  //  //인증받은 봉사 리스트 (개인 + 기관)
  //  public void approvedList() {
  //
  //    // 구현예정
  //
  //  }
  //
  //  // 인증받은 봉사 리스트 세부사항
  //  public void approvedDetail() {
  //    System.out.println();
  //
  //    // 인증받은 봉사 중 1개를 선택해서 세부사항을 본다.
  //    // 선택 > 참여자현황 / 신청하기 / 세부설명(봉사정보,위치) / 문의사항 
  //
  //    System.out.println("[개인봉사승인 목록]");
  //    //    for (int i = 0; i < this.applySize; i++) {
  //    //      System.out.printf("봉사명 : %d\n 봉사제목 : %s\n %s, %s, %s, %s, %s, %s, %s, %s\n", 
  //    //          this.personalRequestApplyDTO[i].getNo(), 
  //    //          this.personalRequestApplyDTO[i].getTitle(), 
  //    //          this.personalRequestApplyDTO[i].getTel(),
  //    //          this.personalRequestApplyDTO[i].getEmail(),
  //    //          this.personalRequestApplyDTO[i].getVolunteerPeriod(),
  //    //          this.personalRequestApplyDTO[i].getVolunteerTime(),
  //    //          this.personalRequestApplyDTO[i].getVolunteerList(),
  //    //          this.personalRequestApplyDTO[i].getContent(),
  //    //          this.personalRequestApplyDTO[i].getFileUpload(),
  //    //          //          this.personalRequestApplyDTO[i].isChecked()
  //    //          this.personalRequestRejectDTO[i].getIsSigned()
  //    //
  //    //          );
  //    //    }
  //
  //    //구현예정
  //
  //  }
  //
  //
  //  // 함께해요 - 찜한 목록(마이페이지 연동 예정)
  //  public void showVolBookmark() {
  //
  //    // 인증받은 봉사 리스트 중 내가 선택한 번호의 봉사 리스트를
  //    // 새로운 배열(리스트)에 담아서 마이페이지에서 보여준다.
  //


}






//  private int indexOf(int no) {
//    for (int i = 0; i < this.size; i++) {
//      if (this.personalRequestsDTO[i].getNo() == no) {
//        return i;
//      }
//    }
//    return -1;
//  }
//
//  public String getReturnMessage() {
//    for (int i = 0; i < this.size; i++) {
//      if (this.personalRequestsDTO[i] == null) {
//        return ""; 
//      }
//    }
//    return null;
//  }

//  private PersonalRequestDTO findByVol(int no) {
//    for (int i = 0; i < this.size; i++) {
//      if (personalRequestsDTO[i].getNo() == no) {
//        return personalRequestsDTO[i];
//      }
//    }
//    return null;
//
//  }

//private PersonalRequestDTO findByVol(int no) {
//  for (PersonalRequestDTO personalRequestDTO : personalRequestDTOList) {
//    if (personalRequestDTO.getNo() == no) {
//      return personalRequestDTO;
//    }
//  }
//  return null;
//
//}

