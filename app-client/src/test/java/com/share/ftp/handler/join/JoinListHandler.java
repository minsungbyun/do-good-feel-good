package com.share.ftp.handler.join;

import java.util.Collection;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.join.PersonalDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class JoinListHandler implements Command {

  PersonalDao personalDao;

  public JoinListHandler(PersonalDao personalDao) {
    this.personalDao = personalDao;

  }

  // 가입회원 목록 (관리자가 가입한 회원의 목록을 볼 수 있다) => 관리자 연결
  @Override
  public void execute(CommandRequest request) throws Exception {

    Collection<PersonalDTO> list = joinDao.findAll();

    System.out.println();
    System.out.println("[ 회원 목록 ]");
    for (JoinDTO loginUser : list) {
      System.out.printf("%d, %s, %s, %s, %d, %s, %s, %s\n", 
          loginUser.getNo(), 
          loginUser.getId(), 
          //          loginUser.getPassword(), 
          loginUser.getTel(), 
          loginUser.getEmail(), 
          loginUser.getPostNo(),
          loginUser.getBasicAddress(),
          loginUser.getDetailAddress(),
          loginUser.getRegisterDate());
    }
  }
}




