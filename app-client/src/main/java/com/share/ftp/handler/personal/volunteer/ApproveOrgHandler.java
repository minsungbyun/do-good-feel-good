package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.volunteer.ApproveOrgDTO;
import com.share.util.Prompt;

public class ApproveOrgHandler {

  List<ApproveOrgDTO> approveOrgDTOList;

  public ApproveOrgHandler(List<ApproveOrgDTO> approveOrgDTOList) {
    this.approveOrgDTOList = approveOrgDTOList;
  }

  public void add() {

    System.out.println();
    System.out.println("[메인/ 마이페이지 / 기관승인신청/ 신청하기]");

    ApproveOrgDTO approveOrgDTO = new ApproveOrgDTO();

    approveOrgDTO.setNo(Prompt.inputInt("번호? "));
    approveOrgDTO.setOrgName(Prompt.inputString("단체명? "));
    approveOrgDTO.setSort(Prompt.inputString("단체유형? "));
    approveOrgDTO.setOrgCheif(Prompt.inputString("단체장? "));
    approveOrgDTO.setTel(Prompt.inputString("연락처? "));
    approveOrgDTO.setOrgAddress(Prompt.inputString("사무실주소? "));
    approveOrgDTO.setOrgInfo(Prompt.inputString("단체소개? "));
    approveOrgDTO.setFileUpload(Prompt.inputString("파일첨부? "));

    approveOrgDTOList.add(approveOrgDTO);
  }

  //  public ApproveOrgDTO[] toAdmin() {
  //    
  //    return 
  //  }

  public void list() {

    System.out.println();
    System.out.println("[메인/ 마이페이지 / 기관승인신청/ 신청내역]");

    ApproveOrgDTO[] approveOrgsDTO = new ApproveOrgDTO [approveOrgDTOList.size()];

    for(ApproveOrgDTO approveOrgDTO : approveOrgsDTO) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s\n", 
          approveOrgDTO.getNo(), 
          approveOrgDTO.getOrgName(), 
          approveOrgDTO.getSort(),
          approveOrgDTO.getOrgCheif(),
          approveOrgDTO.getTel(), 
          approveOrgDTO.getOrgAddress(),
          approveOrgDTO.getOrgInfo(),
          approveOrgDTO.getFileUpload());
    }
  }

  public void detail() {
    System.out.println();
    System.out.println("[메인/ 마이페이지 / 기관승인신청/ 신청내역 상세보기]");
    int no = Prompt.inputInt("번호? ");

    ApproveOrgDTO approveOrgDTO = findByNo(no);

    if (approveOrgDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("번호: %d\n", approveOrgDTO.getNo());
    System.out.printf("단체명: %s\n", approveOrgDTO.getOrgName());
    System.out.printf("단체유형: %s\n", approveOrgDTO.getSort());
    System.out.printf("단체장: %s\n", approveOrgDTO.getOrgCheif());
    System.out.printf("연락처: %s\n", approveOrgDTO.getTel());
    System.out.printf("사무실주소: %s\n", approveOrgDTO.getOrgAddress());
    System.out.printf("단체소개: %s\n", approveOrgDTO.getOrgInfo());
    System.out.printf("파일첨부: %s\n", approveOrgDTO.getFileUpload());
  }

  public void update() {
    System.out.println();
    System.out.println("[메인/ 마이페이지 / 기관승인신청/ 신청내역 변경]");
    int no = Prompt.inputInt("번호? ");

    ApproveOrgDTO approveOrgDTO = findByNo(no);

    if (approveOrgDTO == null) {
      System.out.println("해당 번호의 기관인증 신청내역이 없습니다.");
      return;
    }


    String orgName = Prompt.inputString(String.format("단체명(" + approveOrgDTO.getOrgName() + ")? "));
    String sort = Prompt.inputString(String.format("단체유형(" + approveOrgDTO.getSort() + ")? "));
    String orgCheif = Prompt.inputString(String.format("단체장(" + approveOrgDTO.getOrgCheif() + ")? "));
    String tel = Prompt.inputString(String.format("연락처(" + approveOrgDTO.getTel() + ")? "));
    String orgAddress = Prompt.inputString(String.format("사무실주소(" + approveOrgDTO.getOrgAddress() + ")? "));
    String orgInfo = Prompt.inputString(String.format("단체소개(" + approveOrgDTO.getOrgInfo() + ")? "));
    String fileUpload = Prompt.inputString(String.format("파일첨부(" + approveOrgDTO.getFileUpload() + ")? "));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("기관인증 신청내역 변경을 취소하였습니다.");
      return;
    }

    approveOrgDTO.setOrgName(orgName);
    approveOrgDTO.setSort(sort);
    approveOrgDTO.setOrgCheif(orgCheif);
    approveOrgDTO.setTel(tel);
    approveOrgDTO.setOrgAddress(orgAddress);
    approveOrgDTO.setOrgInfo(orgInfo);
    approveOrgDTO.setFileUpload(fileUpload);
    System.out.println("기관인증 신청내역을 변경하였습니다.");
  }

  public void delete() {

    System.out.println();
    System.out.println("[메인/ 마이페이지 / 기관승인신청/ 신청내역삭제]");
    int no = Prompt.inputInt("번호? ");

    ApproveOrgDTO approveOrgDTO = findByNo(no);

    if (approveOrgDTO == null) {
      System.out.println("해당 번호의 기관인증 신청내역이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("기관 인증 신청내역 삭제를 취소하였습니다.");
      return;
    }

    approveOrgDTOList.remove(approveOrgDTO);

    System.out.println("기관인증 신청내역을 삭제하였습니다.");
  }

  private ApproveOrgDTO findByNo(int no) {
    ApproveOrgDTO[] arr = approveOrgDTOList.toArray(new ApproveOrgDTO[0]);
    for (ApproveOrgDTO approveOrgDTO : arr) {
      if (approveOrgDTO.getNo() == no) {
        return approveOrgDTO;
      }
    }
    return null;
  }

}
