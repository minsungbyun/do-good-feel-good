package com.share.ftp.handler.personal.mypage;

import java.util.List;
import com.share.ftp.domain.personal.MyProfileDTO;
import com.share.util.Prompt;

public class MyProfileHandler {

  List<MyProfileDTO> myProfileDTOList;

  public MyProfileHandler(List<MyProfileDTO> myProfileDTOList) {
    this.myProfileDTOList = myProfileDTOList;
  }

  public void updateMyProfile() {

    System.out.println();
    System.out.println("[메인/ 마이페이지 / 회원정보/ 수정하기]");

    MyProfileDTO myProfileDTO = new MyProfileDTO();

    myProfileDTO.setPhoto(Prompt.inputString("사진? ")); 
    myProfileDTO.setPassword(Prompt.inputString("비밀번호? ")); 
    myProfileDTO.setEmail(Prompt.inputString("이메일? ")); 
    myProfileDTO.setEmail(Prompt.inputString("주소? ")); 

    myProfileDTOList.add(myProfileDTO);

    System.out.println("프로필변경이 완료되었습니다.");
  }
}
