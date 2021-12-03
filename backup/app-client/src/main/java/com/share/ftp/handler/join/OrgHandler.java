package com.share.ftp.handler.join;

import com.share.ftp.domain.join.OrgDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class OrgHandler implements Command {


  // 마이페이지의 나의정보보기
  @Override
  public void execute(CommandRequest request) throws Exception {

    OrgDTO orgUser = (OrgDTO) AuthLoginHandler.getLoginUser();

    System.out.println();
    System.out.printf("[ %s님의 정보입니다 ]\n", orgUser.getName());

    System.out.printf("▶ 아이디: %s\n",       orgUser.getId());
    System.out.printf("▶ 이름: %s\n",         orgUser.getName());
    System.out.printf("▶ 전화: %s\n",         orgUser.getTel());
    System.out.printf("▶ 사업자번호: %s\n",   orgUser.getCorpNo());
    System.out.printf("▶ 팩스: %s\n",         orgUser.getFax());
    System.out.printf("▶ 홈페이지: %s\n",     orgUser.getHomepage());
    System.out.printf("▶ 이메일: %s\n",       orgUser.getEmail());
    System.out.printf("▶ 우편번호: %s\n",     orgUser.getPostNo());
    System.out.printf("▶ 기본주소: %s\n",     orgUser.getBasicAddress());
    System.out.printf("▶ 상세주소: %s\n",     orgUser.getDetailAddress());
    System.out.printf("▶ 등록일: %s\n",       orgUser.getRegisterDate());
  }
}

