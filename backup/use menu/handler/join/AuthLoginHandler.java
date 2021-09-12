package com.share.ftp.handler.join;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.util.Prompt;

public class AuthLoginHandler implements Command {

  List<JoinDTO> joinDTOList;

  static JoinDTO loginUser;
  public static JoinDTO getLoginUser() {
    return loginUser;
  }

  public AuthLoginHandler(List<JoinDTO> joinDTOList) {
    this.joinDTOList = joinDTOList;
  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[로그인]");

    String id = Prompt.inputString("아이디? ");
    String password = Prompt.inputString("비밀번호? ");

    JoinDTO joinDTO = findByMember(id, password);

    if (joinDTO == null) {
      System.out.println("아이디와 암호가 일치하는 회원을 찾을 수 없습니다.");
    } else {
      System.out.printf("%s님 환영합니다!\n", joinDTO.getName());
      loginUser = joinDTO;
    }
  }

  private JoinDTO findByMember(String id, String password) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getId().equalsIgnoreCase(id) && 
          joinDTO.getPassword().equalsIgnoreCase(password)) {
        return joinDTO;
      }
    }
    return null;
  }
}

