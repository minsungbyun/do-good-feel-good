package com.share.ftp.handler.join;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;

public class JoinListHandler extends AbstractJoinHandler {

  public JoinListHandler(List<JoinDTO> joinDTOList) {
    super(joinDTOList);

  }

  // 가입회원 목록 (관리자가 가입한 회원의 목록을 볼 수 있다) => 관리자 연결
  @Override
  public void execute() {
    System.out.println();
    System.out.println("[회원 목록]");
    for (JoinDTO joinDTO : joinDTOList) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n", 
          joinDTO.getNo(), 
          joinDTO.getId(), 
          joinDTO.getPassword(), 
          joinDTO.getTel(), 
          joinDTO.getEmail(), 
          joinDTO.getAddress(),
          joinDTO.getRegisterDate());
    }
  }
}




