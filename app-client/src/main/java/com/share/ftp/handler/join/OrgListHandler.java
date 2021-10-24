package com.share.ftp.handler.join;

import java.util.Collection;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.domain.join.OrgDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class OrgListHandler implements Command {

  OrgDao orgDao;


  public OrgListHandler(OrgDao orgDao) {
    this.orgDao = orgDao;

  }

  //가입회원 목록 (관리자가 가입한 회원의 목록을 볼 수 있다) => 관리자 연결
  @Override
  public void execute(CommandRequest request) throws Exception {

    Collection<OrgDTO> list = orgDao.findAllOrg();

    System.out.println();
    System.out.println("[ 기관회원 목록 ]");
    for (OrgDTO loginUser : list) {
      System.out.printf("%d, %s, %s, %s, %d, %s, %s, %s\n", 
          loginUser.getOrgNo(),
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




