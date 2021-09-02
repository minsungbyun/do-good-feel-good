package com.share.ftp.handler.personal.mypage;

import java.util.List;
import com.share.ftp.domain.guest.JoinDTO;
import com.share.ftp.handler.join.JoinHandler;
import com.share.util.Prompt;

public class MyPageHandler2 {

  List<JoinDTO> joinDTOList;
  JoinHandler joinHandler;

  public MyPageHandler2(List<JoinDTO> joinDTOList, JoinHandler joinHandler) {
    this.joinDTOList = joinDTOList;
    this.joinHandler = joinHandler;
  }


  // 나의정보
  public void myProfile() {}

  // 나의 봉사활동
  public void myVolunteer() {}

  // 나의 게시판 작성글
  public void myBoardList() {}
  
  // 나의 포인트
  public void myPoint() {}

  // 나의 기부내역
  public void myDonation() {}

  // 기관신청
  public void approveOrganization() {}

  // 회원탈퇴
  public void withdrawMember() {
    System.out.println("[회원 탈퇴]");
    String id = Prompt.inputString("아이디? ");
    String password = Prompt.inputString("비밀번호? ");

    JoinDTO joinDTO = findByMember(id, password);

    if (joinDTO == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 탈퇴 하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 탈퇴를 취소하였습니다.");
      return;
    }

    joinDTOList.remove(joinDTO);
    
    System.out.println("회원을 탈퇴하였습니다.");
  }
  
  public JoinDTO findByMember(String id, String email) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getId().equalsIgnoreCase(id) && 
          joinDTO.getEmail().equalsIgnoreCase(email)) {
        return joinDTO;
      }
    }
    return null;
  }
  
}
