package com.share.ftp.handler.join;

import java.util.List;
import com.share.ftp.domain.guest.JoinDTO;
import com.share.util.Prompt;

public class JoinSearchIdHandler extends AbstractJoinHandler {

  public JoinSearchIdHandler(List<JoinDTO> joinDTOList) {
    super(joinDTOList);

  }

  // 아이디찾기 이름, 이메일을 통해 찾는다.
  @Override
  public void execute() {
    System.out.println();
    String id = Prompt.inputString("아이디? ");
    String email = Prompt.inputString("이메일? ");

    JoinDTO joinDTO = findByMember(id, email);

    if (joinDTO == null) {
      System.out.println("해당 아이디를 찾을 수 없습니다.");
      return;
    }
    System.out.printf("아이디: %s\n", joinDTO.getId());
    System.out.printf("비밀번호: %s\n", joinDTO.getPassword());

    //    System.out.println();
    //    while (true) {
    //      System.out.println("이메일과 이름을 입력해주세요.");
    //      String email = Prompt.inputString("이메일? ");
    //      String name = Prompt.inputString("이름? ");
    //
    //      JoinDTO joinDTOEmail = findByEmail(email);
    //      JoinDTO joinDTOName = findByName(name);
    //
    //      if (joinDTOEmail != null && joinDTOName == null) {
    //        System.out.println("이름");
    //      } else if (joinDTOEmail == null && joinDTOName != null) {
    //        System.out.println(" 이메일");
    //      } else {
    //        System.out.println();
    //        System.out.printf("아이디: %s\n", joinDTOEmail.getId());
    //      }
    //    }
  }
}


// 회원가입을 안했는데 아이디 찾기하는 경우 - 등록된 아이디가 없습니다.
// 회원가입을 했는데 이름이 틀린경우 - 일치하는 이름이 없습니다.
// 회원가입을 했는데 이메일이 틀린경우 - 일치하는 이메일이 없습니다.


