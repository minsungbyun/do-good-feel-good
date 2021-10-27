package com.share.ftp.handler.join;

import java.util.Collection;
import com.share.ftp.dao.GroupDao;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.GroupDTO;
import com.share.ftp.domain.join.OrgDTO;
import com.share.ftp.domain.join.PersonalDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class JoinListHandler implements Command {

  PersonalDao personalDao;
  GroupDao groupDao;
  OrgDao orgDao;

  public JoinListHandler(PersonalDao personalDao,GroupDao groupDao,OrgDao orgDao) {
    this.personalDao = personalDao;
    this.groupDao = groupDao;
    this.orgDao = orgDao;

  }

  // 가입회원 목록 (관리자가 가입한 회원의 목록을 볼 수 있다) => 관리자 연결
  @Override
  public void execute(CommandRequest request) throws Exception {

    Collection<PersonalDTO> personalList = personalDao.findAllPersonal();
    Collection<GroupDTO> groupList = groupDao.findAllGroup();
    Collection<OrgDTO> OrgList = orgDao.findAllOrg();

    System.out.println();
    System.out.println("[ 회원 목록 ]");
    for (PersonalDTO loginUser : personalList) {
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

    for (GroupDTO loginUser : groupList) {
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

    for (OrgDTO loginUser : OrgList) {
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




