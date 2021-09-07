package com.share.ftp.handler.personal.volunteer;

import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolRequestPersonalAppliedListDetailHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳


  PersonalRequestDTO personalRequestDTO;

  List<PersonalRequestDTO> personalSelectedList;
  ArrayList<JoinDTO> members = new ArrayList<>();

  public VolRequestPersonalAppliedListDetailHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList,
      List<PersonalRequestDTO> personalSelectedList,
      PersonalRequestDTO personalRequestDTO) {

    super(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList);
    this.personalSelectedList = personalSelectedList;
    this.personalRequestDTO = personalRequestDTO;
  }


  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  개인봉사승인 목록  ]");

    int no = Prompt.inputInt("번호? ");

    PersonalRequestDTO personalRequestApplyDTO = findByApplyVol(no);

    //
    //    if (personalRequestApplyDTOList.isEmpty()) {
    //      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
    //      return;
    //    }

    if (personalRequestApplyDTO == null) {
      System.out.println("[  해당 번호의 봉사목록이 없습니다. ]");
    }

    System.out.printf("번호: %d\n"
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
        + "첨부파일: %s\n"
        //          + "승인여부: %b \n"
        + "승인여부: %s \n\n",  

        personalRequestApplyDTO.getNo(),      
        personalRequestApplyDTO.getTitle(),     
        personalRequestApplyDTO.getOwner(), 
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
        personalRequestApplyDTO.getFileUpload(),
        //          personalRequestApplyDTO.isChecked(),
        personalRequestApplyDTO.getIsSigned()
        //          this.personalRequestRejectDTO[i].getIsSigned()
        );

    String input = Prompt.inputString("해당 봉사활동을 참가하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 참여를 취소하였습니다. ]");
      return;
    }



    personalRequestApplyDTO.setMembers(addJoinMember()); // 참여 멤버 등록
    personalRequestApplyDTO.getJoinCount(); //참여인원증가
    //    personalRequestDTO.setMembers( addJoinMember());
    //    personalRequestApplyDTO.getJoinCount(); // 카운트 1 증가

    personalSelectedList.add(personalRequestApplyDTO);

    System.out.println("[  봉사참여가 완료되었습니다. ]");

  }
  public List<JoinDTO> addJoinMember() {
    //    ArrayList<JoinDTO> members = new ArrayList<>();
    //    String memberName = AuthLoginHandler.getLoginUser().getName();
    //    JoinDTO member = AuthLoginHandler.findByName(memberName);
    JoinDTO member = AuthLoginHandler.getLoginUser();

    if (member != null) {
      members.add(member);
    } else if (member == null) {
      System.out.println("등록된 회원이 아닙니다.");
    }

    //    personalRequestDTO.setMembers(members);
    return members;
  }



}




