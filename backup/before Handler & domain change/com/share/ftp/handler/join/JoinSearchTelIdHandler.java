package com.share.ftp.handler.join;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.util.Prompt;

public class JoinSearchTelIdHandler extends AbstractJoinHandler {

  public JoinSearchTelIdHandler(List<JoinDTO> joinDTOList) {
    super(joinDTOList);

  }

  // 아이디찾기 -> 휴대폰 번호를 통해 찾는다.
  @Override
  public void execute() {
    System.out.println();

    System.out.println("[휴대폰 번호를 입력해주세요.]");
    String tel = Prompt.inputString("휴대폰 번호? ");

    JoinDTO joinDTOTel = findByTel(tel);

    if (joinDTOTel == null) {
      System.out.println("일치하는 휴대폰 번호가 없습니다.");
      return;
    }  else {
      System.out.println();
      System.out.printf("아이디: [ %s ]\n", joinDTOTel.getId());
      return;
    }
  }
}


