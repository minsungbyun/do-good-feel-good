package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolRequestPersonalAppliedListDetailHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳

  int volNo;

  public VolRequestPersonalAppliedListDetailHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList) {

    super(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList);
  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  봉사 참여  ]");
    System.out.println(" ▶ 참여를 원하는 봉사번호를 입력해주세요 ");
    System.out.println();
    volNo = Prompt.inputInt("봉사번호 > ");

    PersonalRequestDTO personalRequestApplyDTO = findByApplyVol(volNo);


    if (personalRequestApplyDTO == null) {
      System.out.println("[  ⛔ 존재하지 않는 봉사입니다 ⛔ ]");
    }

    // 봉사 관련 내역들
    System.out.printf("봉사번호: %d\n"
        + "봉사제목: %s\n"
        + "주최자: %s\n"
        + "봉사분류: %s\n"
        + "전화번호: %s\n"
        + "이메일: %s\n"
        + "봉사시작기간: %s\n"
        + "봉사종료기간: %s\n"
        + "봉사시작시간: %s\n"
        + "봉사종료시간: %s\n"
        + "봉사목록: %s\n"
        + "봉사인원: %d\n"
        + "봉사내용: %s\n"
        + "첨부파일: %s\n\n",

        personalRequestApplyDTO.getNo(),      
        personalRequestApplyDTO.getTitle(),     
        personalRequestApplyDTO.getOwner().getName(), 
        personalRequestApplyDTO.getSort(), 
        personalRequestApplyDTO.getTel(),
        personalRequestApplyDTO.getEmail(),
        personalRequestApplyDTO.getVolStartDate(),
        personalRequestApplyDTO.getVolEndDate(),
        personalRequestApplyDTO.getVolStartTime(),
        personalRequestApplyDTO.getVolEndTime(),
        personalRequestApplyDTO.getVolList(),
        personalRequestApplyDTO.getJoinNum(),
        personalRequestApplyDTO.getContent(),
        personalRequestApplyDTO.getFileUpload()
        );

    String input = Prompt.inputString("해당 봉사활동을 참가하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 참여를 취소하였습니다. ]");
      return;
    }

    // 주최자 유효성검사
    if (personalRequestApplyDTO.getOwner().getName().
        equals(AuthLoginHandler.getLoginUser().getName())) {
      System.out.println("당신은 이미 주최자입니다!");
      return;
    }

<<<<<<< HEAD

    //    // 봉사인원 유효성 검사
    //    if (personalRequestApplyDTO.getTotalJoinCount() == personalRequestApplyDTO.getJoinNum()) {
    //      System.out.println("[ 정원이 초과하였습니다! 다음에 참여해주세요! ]");
    //      return;

    if (no == 1) {
      if (m1.contains(AuthLoginHandler.getLoginUser())) {
        System.out.println("이미 봉사참여를 하셨습니다!");
        return; 
      } 

      if (personalRequestApplyDTO.getTotalJoinCount1() == personalRequestApplyDTO.getJoinNum()) {
        System.out.println("[ 정원이 초과하였습니다! 다음에 참여해주세요! ]");
        return;
      }

      m1.add(AuthLoginHandler.getLoginUser());


      if (m1.contains(personalRequestApplyDTO.getOwner())) {
        m1.remove(personalRequestApplyDTO.getOwner());
      }

      personalRequestApplyDTO.setMembers1(m1);

      int joinCounts = personalRequestApplyDTO.getTotalJoinCount1(); 
      joinCounts += 1;

      personalRequestApplyDTO.setTotalJoinCount1(joinCounts);

    } else if (no == 2 ) {

      if (m2.contains(AuthLoginHandler.getLoginUser())) {
        System.out.println("이미 봉사참여를 하셨습니다!");
        return; 
      } 

      if (personalRequestApplyDTO.getTotalJoinCount2() == personalRequestApplyDTO.getJoinNum()) {
        System.out.println("[ 정원이 초과하였습니다! 다음에 참여해주세요! ]");
        return;
      }

      m2.add(AuthLoginHandler.getLoginUser());

      if (m2.contains(personalRequestApplyDTO.getOwner())) {
        m2.remove(personalRequestApplyDTO.getOwner());
      }

      personalRequestApplyDTO.setMembers2(m2);


      int joinCount2 = personalRequestApplyDTO.getTotalJoinCount2(); 
      joinCount2 += 1;

      personalRequestApplyDTO.setTotalJoinCount2(joinCount2);

    } else if (no == 3) {


      if (m3.contains(AuthLoginHandler.getLoginUser())) {
        System.out.println("이미 봉사참여를 하셨습니다!");
        return; 
      } 

      if (personalRequestApplyDTO.getTotalJoinCount3() == personalRequestApplyDTO.getJoinNum()) {
        System.out.println("[ 정원이 초과하였습니다! 다음에 참여해주세요! ]");
        return;
      }
      m3.add(AuthLoginHandler.getLoginUser());

      if (m3.contains(personalRequestApplyDTO.getOwner())) {
        m3.remove(personalRequestApplyDTO.getOwner());
      }

      personalRequestApplyDTO.setMembers3(m3);
      int joinCount3 = personalRequestApplyDTO.getTotalJoinCount3(); 
      joinCount3 += 1;

      personalRequestApplyDTO.setTotalJoinCount3(joinCount3);

    }

    //    //    findByName(no);
    //    if (members.contains(AuthLoginHandler.getLoginUser())) {
    //      System.out.println("이미 봉사참여를 하셨습니다!");
    //      return; 
    //    } 
    //    System.out.println("유효성 검사 전");
    //    System.out.println("member객체의 사이즈:"+ members.size());

=======
>>>>>>> 818a38be46257fdff0a5a49f83496ff6d5d83edb
    // 봉사인원 유효성 검사
    if (personalRequestApplyDTO.getTotalJoinCount() == personalRequestApplyDTO.getJoinNum()) {
      System.out.println("[ 정원이 초과하였습니다! 다음에 참여해주세요! ]");
      return;
    }


    if (personalRequestApplyDTO.getMembers().contains(AuthLoginHandler.getLoginUser())) {
      System.out.println("이미 봉사참여를 하셨습니다!");
      return;
    } 

    // 출력할 멤버 list에 추가시킨다
    personalRequestApplyDTO.addMembers(AuthLoginHandler.getLoginUser());

    // 주최자 이름이 멤버 출력하는데 포함되어 있다면 제거
    if (personalRequestApplyDTO.getMembers().contains(personalRequestApplyDTO.getOwner())) {
      personalRequestApplyDTO.getMembers().remove(personalRequestApplyDTO.getOwner());
    }

    // 총 참여 인원(주최자1명 포함)을 누적시킨다.
    int count = personalRequestApplyDTO.getTotalJoinCount();
    count += 1;
    personalRequestApplyDTO.setTotalJoinCount(count); 

    System.out.println("[  봉사참여가 완료되었습니다. ]");
  }
}
//    if (no == 1) {
//      if (m1.contains(AuthLoginHandler.getLoginUser())) {
//        System.out.println("이미 봉사참여를 하셨습니다!");
//        return; 
//      } 
//
//      if (personalRequestApplyDTO.getTotalJoinCount1() == personalRequestApplyDTO.getJoinNum()) {
//        System.out.println("[ 정원이 초과하였습니다! 다음에 참여해주세요! ]");
//        return;
//      }
//
//      m1.add(AuthLoginHandler.getLoginUser());
//
//
//      if (m1.contains(personalRequestApplyDTO.getOwner())) {
//        m1.remove(personalRequestApplyDTO.getOwner());
//      }
//
//      personalRequestApplyDTO.setMembers1(m1);
//
//      int joinCounts = personalRequestApplyDTO.getTotalJoinCount1(); 
//      joinCounts += 1;
//
//      personalRequestApplyDTO.setTotalJoinCount1(joinCounts);
//
//    } else if (no == 2 ) {
//
//      if (m2.contains(AuthLoginHandler.getLoginUser())) {
//        System.out.println("이미 봉사참여를 하셨습니다!");
//        return; 
//      } 
//
//      if (personalRequestApplyDTO.getTotalJoinCount2() == personalRequestApplyDTO.getJoinNum()) {
//        System.out.println("[ 정원이 초과하였습니다! 다음에 참여해주세요! ]");
//        return;
//      }
//
//      m2.add(AuthLoginHandler.getLoginUser());
//
//      if (m2.contains(personalRequestApplyDTO.getOwner())) {
//        m2.remove(personalRequestApplyDTO.getOwner());
//      }
//
//      personalRequestApplyDTO.setMembers2(m2);
//
//
//      int joinCount2 = personalRequestApplyDTO.getTotalJoinCount2(); 
//      joinCount2 += 1;
//
//      personalRequestApplyDTO.setTotalJoinCount2(joinCount2);
//
//    } else if (no == 3) {
//
//
//      if (m3.contains(AuthLoginHandler.getLoginUser())) {
//        System.out.println("이미 봉사참여를 하셨습니다!");
//        return; 
//      } 
//
//      if (personalRequestApplyDTO.getTotalJoinCount3() == personalRequestApplyDTO.getJoinNum()) {
//        System.out.println("[ 정원이 초과하였습니다! 다음에 참여해주세요! ]");
//        return;
//      }
//      m3.add(AuthLoginHandler.getLoginUser());
//
//      if (m3.contains(personalRequestApplyDTO.getOwner())) {
//        m3.remove(personalRequestApplyDTO.getOwner());
//      }
//
//      personalRequestApplyDTO.setMembers3(m3);
//      int joinCount3 = personalRequestApplyDTO.getTotalJoinCount3(); 
//      joinCount3 += 1;
//
//      personalRequestApplyDTO.setTotalJoinCount3(joinCount3);
//
//    }

//    //    findByName(no);
//    if (members.contains(AuthLoginHandler.getLoginUser())) {
//      System.out.println("이미 봉사참여를 하셨습니다!");
//      return; 
//    } 
//    System.out.println("유효성 검사 전");
//    System.out.println("member객체의 사이즈:"+ members.size());

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






