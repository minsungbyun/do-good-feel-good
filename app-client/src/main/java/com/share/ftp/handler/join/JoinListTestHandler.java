package com.share.ftp.handler.join;

import java.util.Collection;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.PersonalDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class JoinListTestHandler implements Command {

  PersonalDao personalDao;

  public JoinListTestHandler(PersonalDao personalDao) {
    this.personalDao = personalDao;

  }

  // 가입회원 목록 (관리자가 가입한 회원의 목록을 볼 수 있다) => 관리자 연결
  @Override
  public void execute(CommandRequest request) throws Exception {

    Collection<PersonalDTO> list = personalDao.findAllPersonal();

    System.out.println();
    System.out.println("[ 개인회원 목록 ]");
    for (PersonalDTO loginUser : list) {
      System.out.printf("%d, %d, %s, %s, %s, %d, %s, %s, %s, %s, %s, %s\n", 
          loginUser.getPersonalNo(), 
          loginUser.getNo(),
          loginUser.getId(), 
          //          loginUser.getPassword(), 
          loginUser.getTel(), 
          loginUser.getEmail(), 
          loginUser.getPostNo(),
          loginUser.getBasicAddress(),
          loginUser.getDetailAddress(),
          loginUser.getRegisterDate(),
          loginUser.getLevel(),
          loginUser.getPoint(),
          loginUser.getBirthdate());
    }
  }
}




