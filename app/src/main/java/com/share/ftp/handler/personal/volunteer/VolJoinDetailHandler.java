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

  @Override
  public void execute() {
    System.out.println();

    LOOP: while (true) {
      System.out.println("[ 상세한 봉사내역을 보실 카테고리를 선택해 주세요 ]");
      System.out.println();

      System.out.println("1. 개인봉사참여");
      System.out.println("2. 기관봉사참여");
      System.out.println("3. 참여자정보보기");
      System.out.println();

      int input = Prompt.inputInt("입력 > ");

      switch (input) {
        case 1 : volRequestPersonalAppliedListDetailHandler.execute(); break LOOP;
        case 2 : volRequestOrgAppliedListDetailHandler.execute(); break LOOP;
        case 3 : volDoJoinHandler.execute(); break LOOP;
        default : System.out.println("다시 입력해주세요"); break;
      }
      System.out.println();
    }
  }
}
