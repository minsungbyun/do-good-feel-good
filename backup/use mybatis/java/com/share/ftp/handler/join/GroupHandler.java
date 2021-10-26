package com.share.ftp.handler.join;

import com.share.ftp.domain.join.GroupDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class GroupHandler implements Command {


  // 마이페이지의 나의정보보기
  @Override
  public void execute(CommandRequest request) throws Exception {

    GroupDTO groupUser = (GroupDTO) AuthLoginHandler.getLoginUser();

    System.out.println();
    System.out.printf("[ %s님의 정보입니다 ]\n", groupUser.getName());

    System.out.printf("▶ 아이디: %s\n",       groupUser.getId());
    System.out.printf("▶ 이름: %s\n",         groupUser.getName());
    System.out.printf("▶ 전화: %s\n",         groupUser.getTel());
    System.out.printf("▶ 소속인원: %d\n",     groupUser.getGroupCount());
    System.out.printf("▶ 이메일: %s\n",       groupUser.getEmail());
    System.out.printf("▶ 우편번호: %s\n",     groupUser.getPostNo());
    System.out.printf("▶ 기본주소: %s\n",     groupUser.getBasicAddress());
    System.out.printf("▶ 상세주소: %s\n",     groupUser.getDetailAddress());
    System.out.printf("▶ 등록일: %s\n",       groupUser.getRegisterDate());
  }
}

