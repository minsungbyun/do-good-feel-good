package com.share.ftp.handler.join;

import com.share.ftp.domain.join.PersonalDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class PersonalHandler implements Command {


  // 마이페이지의 나의정보보기
  @Override
  public void execute(CommandRequest request) throws Exception {

    PersonalDTO personalUser =  (PersonalDTO) AuthLoginHandler.getLoginUser();

    System.out.println();
    System.out.printf("[ %s님의 정보입니다 ]\n", personalUser.getName());

    System.out.printf("▶ 아이디: %s\n",       personalUser.getId());
    System.out.printf("▶ 이름: %s\n",         personalUser.getName());
    System.out.printf("▶ 생년월일: %s\n",     personalUser.getBirthdate());
    System.out.printf("▶ 전화: %s\n",         personalUser.getTel());
    System.out.printf("▶ 이메일: %s\n",       personalUser.getEmail());
    System.out.printf("▶ 기부금액: %d\n",     personalUser.getDonationMoney());
    System.out.printf("▶ 우편번호: %s\n",     personalUser.getPostNo());
    System.out.printf("▶ 기본주소: %s\n",     personalUser.getBasicAddress());
    System.out.printf("▶ 상세주소: %s\n",     personalUser.getDetailAddress());
    System.out.printf("▶ 등록일: %s\n",       personalUser.getRegisterDate());
  }
}

