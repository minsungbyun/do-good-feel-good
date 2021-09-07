package com.share.ftp.handler.join;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.util.Prompt;

public class JoinDetailHandler extends AbstractJoinHandler {

  public JoinDetailHandler(List<JoinDTO> joinDTOList) {
    super(joinDTOList);
  }


  //가입회원 상세보기 (관리자가 가입한 회원의 상세정보를을 볼 수 있다) => 관리자 연결
  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  회원 상세보기  ]");
    String id = Prompt.inputString("아이디? "); 
    String password = Prompt.inputString("비밀번호? ");

    JoinDTO joinDTO = findByMember(id, password);

    if (joinDTO == null) {
      System.out.println("해당 아이디와 비밀번호가 일치하지 않습니다.");
      return;
    }

    System.out.printf("이름: %s\n", joinDTO.getName());
    System.out.printf("전화: %s\n", joinDTO.getTel());
    System.out.printf("이메일: %s\n", joinDTO.getEmail());
    System.out.printf("주소: %s\n", joinDTO.getAddress());
    System.out.printf("등록일: %s\n", joinDTO.getRegisterDate());
  }
}



