package com.share.ftp.handler.personal;

import com.share.ftp.domain.personal.ApproveOrgDTO;
import com.share.util.Prompt;

public class ApproveOrgHandler {

  static final int MAX_LENGTH = 100;

  ApproveOrgDTO[] approveOrgs = new ApproveOrgDTO[MAX_LENGTH];
  int size = 0;

  public void add() {
    System.out.println();
    System.out.println("[메인/ 마이페이지 / 기관승인신청/ 신청하기]");
    ApproveOrgDTO approveOrg = new ApproveOrgDTO();

    approveOrg.setNo(Prompt.inputInt("번호? "));
    approveOrg.setOrgName(Prompt.inputString("단체명? "));
    approveOrg.setSort(Prompt.inputString("단체유형? "));
    approveOrg.setOrgCheif(Prompt.inputString("단체장? "));
    approveOrg.setTel(Prompt.inputString("연락처? "));
    approveOrg.setOrgAddress(Prompt.inputString("사무실주소? "));
    approveOrg.setOrgInfo(Prompt.inputString("단체소개? "));
    approveOrg.setFileUpload(Prompt.inputString("파일첨부? "));

    this.approveOrgs[this.size++] = approveOrg;
  }

  //  public ApproveOrgDTO[] toAdmin() {
  //    
  //    return 
  //  }

  public void list() {
    System.out.println();
    System.out.println("[메인/ 마이페이지 / 기관승인신청/ 신청내역]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s\n", 
          this.approveOrgs[i].getNo(), 
          this.approveOrgs[i].getOrgName(), 
          this.approveOrgs[i].getSort(),
          this.approveOrgs[i].getOrgCheif(),
          this.approveOrgs[i].getTel(), 
          this.approveOrgs[i].getOrgAddress(),
          this.approveOrgs[i].getOrgInfo(),
          this.approveOrgs[i].getFileUpload());
    }
  }

  public void detail() {
    System.out.println();
    System.out.println("[메인/ 마이페이지 / 기관승인신청/ 신청내역 상세보기]");
    int no = Prompt.inputInt("번호? ");

    ApproveOrgDTO approveOrg = findByNo(no);

    if (approveOrg == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("번호: %d\n", approveOrg.getNo());
    System.out.printf("단체명: %s\n", approveOrg.getOrgName());
    System.out.printf("단체유형: %s\n", approveOrg.getSort());
    System.out.printf("단체장: %s\n", approveOrg.getOrgCheif());
    System.out.printf("연락처: %s\n", approveOrg.getTel());
    System.out.printf("사무실주소: %s\n", approveOrg.getOrgAddress());
    System.out.printf("단체소개: %s\n", approveOrg.getOrgInfo());
    System.out.printf("파일첨부: %s\n", approveOrg.getFileUpload());
  }

  public void update() {
    System.out.println();
    System.out.println("[메인/ 마이페이지 / 기관승인신청/ 신청내역 변경]");
    int no = Prompt.inputInt("번호? ");

    ApproveOrgDTO approveOrg = findByNo(no);

    if (approveOrg == null) {
      System.out.println("해당 번호의 기관인증 신청내역이 없습니다.");
      return;
    }


    String orgName = Prompt.inputString(String.format("단체명(" + approveOrg.getOrgName() + ")? "));
    String sort = Prompt.inputString(String.format("단체유형(" + approveOrg.getSort() + ")? "));
    String orgCheif = Prompt.inputString(String.format("단체장(" + approveOrg.getOrgCheif() + ")? "));
    String tel = Prompt.inputString(String.format("연락처(" + approveOrg.getTel() + ")? "));
    String orgAddress = Prompt.inputString(String.format("사무실주소(" + approveOrg.getOrgAddress() + ")? "));
    String orgInfo = Prompt.inputString(String.format("단체소개(" + approveOrg.getOrgInfo() + ")? "));
    String fileUpload = Prompt.inputString(String.format("파일첨부(" + approveOrg.getFileUpload() + ")? "));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("기관인증 신청내역 변경을 취소하였습니다.");
      return;
    }

    approveOrg.setOrgName(orgName);
    approveOrg.setSort(sort);
    approveOrg.setOrgCheif(orgCheif);
    approveOrg.setTel(tel);
    approveOrg.setOrgAddress(orgAddress);
    approveOrg.setOrgInfo(orgInfo);
    approveOrg.setFileUpload(fileUpload);
    System.out.println("기관인증 신청내역을 변경하였습니다.");
  }

  public void delete() {
    System.out.println();
    System.out.println("[메인/ 마이페이지 / 기관승인신청/ 신청내역삭제]");
    int no = Prompt.inputInt("번호? ");

    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 기관인증 신청내역이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("기관 인증 신청내역 삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.approveOrgs[i - 1] = this.approveOrgs[i];
    }
    this.approveOrgs[--this.size] = null;

    System.out.println("기관인증 신청내역을 삭제하였습니다.");
  }

  private ApproveOrgDTO findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.approveOrgs[i].getNo() == no) {
        return this.approveOrgs[i];
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.approveOrgs[i].getNo() == no) {
        return i;
      }
    }
    return -1;
  }


}
