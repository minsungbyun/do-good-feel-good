package com.share.ftp.handler.personal;

import com.share.ftp.domain.personal.MyProfileDTO;
import com.share.util.Prompt;

public class MyProfileHandler {

  public static final int MAX_LENTGH = 100;
  MyProfileDTO[] myProfilesDTO = new MyProfileDTO[MAX_LENTGH];
  int size;


  public void updateMyProfile() {

    System.out.println();
    System.out.println("[메인/ 마이페이지 / 회원정보/ 수정하기]");

    MyProfileDTO myProfileDTO = new MyProfileDTO();

    myProfileDTO.setPhoto(Prompt.inputString("사진? ")); 
    myProfileDTO.setPassword(Prompt.inputString("비밀번호? ")); 
    myProfileDTO.setEmail(Prompt.inputString("이메일? ")); 
    myProfileDTO.setEmail(Prompt.inputString("주소? ")); 

    myProfilesDTO[size++] = myProfileDTO;

    System.out.println("프로필변경이 완료되었습니다.");
  }
}
