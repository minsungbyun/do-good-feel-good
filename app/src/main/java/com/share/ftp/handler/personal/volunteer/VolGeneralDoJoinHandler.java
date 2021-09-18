package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.GeneralRequestDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolGeneralDoJoinHandler extends AbstractVolGeneralHandler { 


  public VolGeneralDoJoinHandler(
      List<GeneralRequestDTO> generalRequestDTOList,
      List<GeneralRequestDTO> generalRequestApplyDTOList,
      List<GeneralRequestDTO> generalRequestRejectDTOList) {

    super(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);
  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  봉사 참여  ]");
    System.out.println(" ▶ 참여를 원하는 봉사번호를 입력해주세요 ");
    System.out.println();
    int volNo = Prompt.inputInt("봉사번호 ▶ ");

    GeneralRequestDTO generalRequestApplyDTO = findByApplyVol(volNo);


    if (generalRequestApplyDTO == null) {
      System.out.println("[  ⛔ 존재하지 않는 봉사입니다 ⛔ ]");
      return;
    }

    System.out.printf("봉사번호: %d\n"
        + "봉사유형: %s\n"
        + "봉사제목: %s\n"
        + "주최자: %s\n"
        + "봉사분류: %s\n"
        + "전화번호: %s\n"
        + "이메일: %s\n"
        + "봉사시작기간: %s\n"
        + "봉사종료기간: %s\n"
        + "봉사시작시간: %s\n"
        + "봉사종료시간: %s\n"
        //        + "봉사목록: %s\n"
        + "봉사인원: %d명  /  %d명\n"
        + "봉사내용: %s\n"
        + "첨부파일: %s\n\n",

        generalRequestApplyDTO.getVolNo(),      
        generalRequestApplyDTO.getMemberType(),      
        generalRequestApplyDTO.getVolTitle(),     
        generalRequestApplyDTO.getOwner().getName(), 
        generalRequestApplyDTO.getVolType(), 
        generalRequestApplyDTO.getVolTel(),
        generalRequestApplyDTO.getVolEmail(),
        generalRequestApplyDTO.getVolStartDate(),
        generalRequestApplyDTO.getVolEndDate(),
        generalRequestApplyDTO.getVolStartTime(),
        generalRequestApplyDTO.getVolEndTime(),
        //        personalRequestApplyDTO.getVolList(),
        generalRequestApplyDTO.getTotalJoinCount(),
        generalRequestApplyDTO.getVolLimitNum(),
        generalRequestApplyDTO.getVolContent(),
        generalRequestApplyDTO.getVolFileUpload()
        );

    String input = Prompt.inputString("해당 봉사활동을 참가하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 참여를 취소하였습니다. ]");
      return;
    }

    // 주최자 유효성검사
    if (generalRequestApplyDTO.getOwner().getName().
        equals(AuthLoginHandler.getLoginUser().getName())) {
      System.out.println("당신은 이미 주최자입니다!");
      return;
    }

    // 봉사인원 유효성 검사
    if (generalRequestApplyDTO.getTotalJoinCount() == generalRequestApplyDTO.getVolLimitNum()) {
      System.out.println("[ 정원이 초과하였습니다! 다음에 참여해주세요! ]");
      return;
    }

    if (generalRequestApplyDTO.getMembers().contains(AuthLoginHandler.getLoginUser())) {
      System.out.println("이미 봉사참여를 하셨습니다!");
      return;
    } 

    // 출력할 멤버 list에 추가시킨다
    generalRequestApplyDTO.addMembers(AuthLoginHandler.getLoginUser());
    // 주최자 이름이 멤버 출력하는데 포함되어 있다면 제거
    if (generalRequestApplyDTO.getMembers().contains(generalRequestApplyDTO.getOwner())) {
      generalRequestApplyDTO.getMembers().remove(generalRequestApplyDTO.getOwner());
    }

    // 총 참여 인원(주최자1명 포함)을 누적시킨다.
    int count = generalRequestApplyDTO.getTotalJoinCount();
    count += 1;
    generalRequestApplyDTO.setTotalJoinCount(count); 

    System.out.println("[  ✔️ 봉사참여가 완료되었습니다. ]");
  }
}


// 봉사인원 유효성 검사
//    if (personalRequestApplyDTO.getTotalJoinCount() == personalRequestApplyDTO.getJoinNum()) {
//      System.out.println("[ 정원이 초과하였습니다! 다음에 참여해주세요! ]");
//      return;
//    }
//    System.out.println("멤버추가시키기 전");
//    System.out.println("member객체의 사이즈:"+ members.size());
//    //    if (!members.contains(AuthLoginHandler.getLoginUser())) {
//    //      members.add(AuthLoginHandler.getLoginUser());
//    //    }
//
//    if (members.contains(personalRequestApplyDTO.getOwner())) {
//      members.remove(personalRequestApplyDTO.getOwner());
//    }
//    System.out.println("멤버추가 시킨 후");
//    System.out.println("member객체의 사이즈:"+ members.size());
//
//
//
//
//    personalRequestApplyDTO.setMembers(members); // 참여 멤버 등록

//    members.clear();


//    personalRequestDTO.setMembers( addJoinMember());

//    int joinCount = personalRequestApplyDTO.getJoinCount() + 1;


//    int joinCounts = personalRequestApplyDTO.getTotalJoinCount(); 
//    System.out.println("참여 카운트(전) " +joinCounts);
//    joinCounts += 1;
//
//    System.out.println("전체카운트 " + (joinCounts));
//    personalRequestApplyDTO.setTotalJoinCount(joinCounts);
//    System.out.println("참여 카운트(후) " +joinCounts);

//    joinCounts = personalRequestApplyDTO.getJoinCount() + 1; //참여인원증가


//    personalSelectedList.add(personalRequestApplyDTO); 








//  private PersonalRequestDTO findByName(int no) {
//    for (PersonalRequestDTO personalRequestApplyDTO : personalSelectedList) {
//      if (personalRequestApplyDTO.getName().equals(AuthLoginHandler.getLoginUser().getName()) ||
//          personalRequestApplyDTO.getNo() == no) {
//        return personalRequestApplyDTO;
//      }
//    }
//    return null;
//  }
//
//  private PersonalRequestDTO findByValid(int no) {
//    for (PersonalRequestDTO personalRequestSelectedDTO : personalSelectedList) {
//      if (personalRequestSelectedDTO.getNo() == no) {
//        return personalRequestSelectedDTO;
//      }
//    }
//    return null;
//  }

//  public void addMembers(int volNo, JoinDTO member) {
//    PersonalRequestDTO personalRequestApplyDTO = findByApplyVol(volNo);
//    personalRequestApplyDTO.set
//    
//    
//  if (personalRequestApplyDTO) {
//    
//  }
//    
//    this.members.add(member);








//  public List<JoinDTO> members() {
//    //    ArrayList<JoinDTO> members = new ArrayList<>();
//    //    String memberName = AuthLoginHandler.getLoginUser().getName();
//    //    JoinDTO member = AuthLoginHandler.findByName(memberName);
//    JoinDTO member = AuthLoginHandler.getLoginUser();
//
//    //    PersonalRequestDTO personalRequestApplyDTO = findByApplyVol(no);
//    //    personalRequestApplyDTO.
//
//    if (members != null) {
//      members.add(member);
//      System.out.println("멤버 1명 추가");
//    } else if (members == null) {
//      System.out.println("등록된 회원이 아닙니다.");
//    }
//
//    //    personalRequestDTO.setMembers(members);
//    return members;
//  }

//  public List<JoinDTO> addOwner() {
//    //    ArrayList<JoinDTO> members = new ArrayList<>();
//    //    String memberName = AuthLoginHandler.getLoginUser().getName();
//    //    JoinDTO member = AuthLoginHandler.findByName(memberName);
//
//
//
//
//    //    personalRequestDTO.setMembers(members);
//    return members;
//  }
//
//
//  public  JoinDTO exist(String name) {
//    for (JoinDTO joinDTO : joinDTOList) {
//      if (joinDTO.getName() == name) {
//        return joinDTO;
//      }
//    }
//    return null;
//  }
//






