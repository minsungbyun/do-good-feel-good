package com.share.ftp.handler.personal.volunteer;

public class VolJoinHandler {

  VolSelectHandler volSelectHandler = new VolSelectHandler();





  // 봉사 참여하기
  public void join() {
    System.out.println("해당 봉사 선택 후 봉사 신청하기");

  }

  // 봉사의 참여내역
  public void joinList() {
    System.out.println("해당 봉사 참여내역");

  }


  // 해당 번호의 봉사에 참여한 참가자 목록
  public void joinMemberList() {
    System.out.println("[참여자 목록]");
  }


  // 봉사 유효성 확인
  public boolean exist() {
    return true;
  }
}
