package com.share.ftp.handler.join;

import java.util.List;
import com.share.ftp.domain.guest.JoinDTO;
import com.share.util.Prompt;

public class JoinSearchEmailIdHandler extends AbstractJoinHandler {

  public JoinSearchEmailIdHandler(List<JoinDTO> joinDTOList) {
    super(joinDTOList);

  }

  // 아이디찾기 -> 이메일을 통해 찾는다.
  @Override
  public void execute() {
    System.out.println();
    System.out.println("이메일을 입력해주세요.");
    String email = Prompt.inputString("이메일? ");

    JoinDTO joinDTOEmail = findByEmail(email);

    if (joinDTOEmail == null) {
      System.out.println("일치하는 이메일이 없습니다.");
      return;
    } else {
      System.out.println();
      System.out.printf("아이디: [ %s ]\n", joinDTOEmail.getId());
      return;
    }
  }
}


