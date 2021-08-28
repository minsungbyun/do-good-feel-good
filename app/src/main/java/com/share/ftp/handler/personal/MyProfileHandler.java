package com.share.ftp.handler.personal;

import com.share.ftp.domain.personal.MyProfileDTO;
import com.share.util.Prompt;

public class MyProfileHandler {

  public static final int MAX_LENTGH = 100;
  MyProfileDTO[] myProfilesDTO = new MyProfileDTO[MAX_LENTGH];
  int size;



  public void apply() {
    MyProfileDTO myProfileDTO = new MyProfileDTO();

    myProfileDTO.setPhoto(Prompt.inputString("제목? ")); 
    myProfileDTO.setPassword(Prompt.inputString("분류? ")); 
    myProfileDTO.setEmail(Prompt.inputString("전화번호? ")); 
    myProfileDTO.setAdress(Prompt.inputString("이메일? ")); 

    myProfilesDTO[size++] = myProfileDTO;

    System.out.println("프로필변경이 완료되었습니다.");
  }
}
