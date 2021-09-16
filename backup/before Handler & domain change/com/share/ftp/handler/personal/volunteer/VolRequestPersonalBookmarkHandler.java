package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;

public class VolRequestPersonalBookmarkHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳


  // 개인 전체 리스트
  List<PersonalRequestDTO> personalRequestDTOList;
  // 개인 봉사 승인 리스트
  List<PersonalRequestDTO> personalRequestApplyDTOList;
  //  List<PersonalRequestApplyDTO> personalRequestApplyDTOList;
  // 개인 봉사 반려 리스트
  List<PersonalRequestDTO> personalRequestRejectDTOList;
  //  List<PersonalRequestRejectDTO> personalRequestRejectDTOList;


  public VolRequestPersonalBookmarkHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList) {

    super(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList);

  }


  // 함께해요 - 찜한 목록(마이페이지 연동 예정) 북마크
  @Override
  public void execute() {

    // 인증받은 봉사 리스트 중 내가 선택한 번호의 봉사 리스트를
    // 새로운 배열(리스트)에 담아서 마이페이지에서 보여준다.



  }







}
