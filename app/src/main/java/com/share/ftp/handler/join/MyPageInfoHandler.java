package com.share.ftp.handler.join;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class MyPageInfoHandler extends AbstractJoinHandler {

  public MyPageInfoHandler(List<JoinDTO> joinDTOList) {
    super(joinDTOList);

  }

  // 마이페이지 나의 정보 수정 -> 비밀번호 입력시 변경가능
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[회원 변경]");
    String password = Prompt.inputString("비밀번호? ");

    JoinDTO joinDTO = findByMember(password);

    if (joinDTO == null) {
      System.out.println("해당 아이디의 회원이 없습니다.");
      return;
    }

    String name = Prompt.inputString("이름(" + joinDTO.getName()  + ")? ");
    String tel = Prompt.inputString("전화(" + joinDTO.getTel() + ")? ");
    String email = Prompt.inputString("이메일(" + joinDTO.getEmail() + ")? ");
    String adress = Prompt.inputString("주소(" + joinDTO.getAddress() + ")? ");
    String passwords = Prompt.inputString("암호? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    joinDTO.setName(name);
    joinDTO.setTel(tel);
    joinDTO.setEmail(email);
    joinDTO.setAddress(adress);
    joinDTO.setPassword(passwords);

    System.out.println("회원을 변경하였습니다.");
  }
}



