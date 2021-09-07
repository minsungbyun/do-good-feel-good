package com.share.ftp.handler.personal.volunteer;

import com.share.ftp.handler.Command;
import com.share.ftp.handler.personal.volunteerOrg.VolRequestOrgAppliedListDetailHandler;
import com.share.util.Prompt;

public class VolJoinDetailHandler implements Command {


  VolRequestPersonalAppliedListDetailHandler volRequestPersonalAppliedListDetailHandler;
  VolRequestOrgAppliedListDetailHandler volRequestOrgAppliedListDetailHandler;
  VolRequestTotalApprovedListHandler volRequestTotalApprovedListHandler;
  VolDoJoinHandler volDoJoinHandler;

  public VolJoinDetailHandler( VolRequestPersonalAppliedListDetailHandler volRequestPersonalAppliedListDetailHandler,
      VolRequestOrgAppliedListDetailHandler volRequestOrgAppliedListDetailHandler,
      VolRequestTotalApprovedListHandler volRequestTotalApprovedListHandler,
      VolDoJoinHandler volDoJoinHandler) {
    this.volRequestPersonalAppliedListDetailHandler = volRequestPersonalAppliedListDetailHandler;
    this.volRequestOrgAppliedListDetailHandler = volRequestOrgAppliedListDetailHandler;
    this.volRequestTotalApprovedListHandler = volRequestTotalApprovedListHandler;
    this.volDoJoinHandler = volDoJoinHandler;
  }


  public void execute() {
    // 비회원 열람가능
    System.out.println();

    // 봉사 관련된 내용들

    //봉사정보

    // 봉사위치

    // 주최자정보
    System.out.println("[ 봉사 목록  ]");
    volRequestTotalApprovedListHandler.execute();
    System.out.println();


    LOOP: while (true) {
      System.out.println("[ 상세한 봉사내역을 보실 카테고리를 선택해 주세요 ]");

      System.out.println("1. 개인");
      System.out.println("2. 기관");
      System.out.println("3. 참여자정보");

      int input = Prompt.inputInt("입력> ");

      switch (input) {
        case 1 : volRequestPersonalAppliedListDetailHandler.execute(); break LOOP;
        case 2 : volRequestOrgAppliedListDetailHandler.execute(); break LOOP;
        case 3 :  volDoJoinHandler.execute(); break LOOP;
        default : System.out.println("다시 입력해주세요"); break;
      }
    }
    //참여자목록



    //    String input = Prompt.inputString("해당 봉사활동을 참가하시겠습니까?(y/N) ");
    //    if (input.equalsIgnoreCase("n") || input.length() == 0) {
    //      System.out.println("[  해당 봉사신청 참여를 취소하였습니다. ]");
    //      return;
    //    }
    //
    //    System.out.println("[  봉사참여가 완료되었습니다. ]");

    // 참여 봉사 정보


    //    System.out.println("참여하기");
    //    System.out.println("참여인원");
    //    System.out.println("문의하기");



    //    String input = Prompt.inputString("세부내역을 보고 싶은 봉사번호를 입력하세요? ");




  }







}
