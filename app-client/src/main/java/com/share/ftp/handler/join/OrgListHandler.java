package com.share.ftp.handler.join;

import static com.share.util.General.status.ACTIVE;
import static com.share.util.General.status.REJECT;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.domain.join.OrgDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class OrgListHandler implements Command {

  OrgDao orgDao;
  SqlSession sqlSession;


  public OrgListHandler(OrgDao orgDao, SqlSession sqlSession) {
    this.orgDao = orgDao;
    this.sqlSession = sqlSession;
  }

  //가입회원 목록 (관리자가 가입한 회원의 목록을 볼 수 있다) => 관리자 연결
  @Override
  public void execute(CommandRequest request) throws Exception {

    List<OrgDTO> orgUsers = orgDao.findAllWaitOrg();

    if (orgUsers.isEmpty()) {
      System.out.println("유저가 없습니다!");
    }

    System.out.println();
    System.out.println("[ 기관회원 목록 ]");
    for (OrgDTO loginUser : orgUsers) {
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
    System.out.println();
    int userNo = Prompt.inputInt("유저 번호를 입력하세요(0 입력 시 취소) ▶ ");

    if (userNo == 0) {
      return;
    }

    OrgDTO orgUser = orgDao.findByOrgNo(userNo);

    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 승인하기");
      System.out.println("2번 ▶ 반려하기");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");

      if (input == 1) {
        orgUser.setStatus(ACTIVE);
        orgDao.updateStatus(orgUser);
        sqlSession.commit();

        System.out.println();
        System.out.println("해당 유저를 승인하였습니다");
        return;

      } else if (input == 2) {
        orgUser.setStatus(REJECT);
        String note = Prompt.inputString("거절사유 입력 ▶ ");
        orgDao.updateStatus(orgUser);
        orgDao.updateStatusReject(orgUser.getNo(), note);
        sqlSession.commit();

        System.out.println();
        System.out.println("해당 유저를 반려하였습니다");
        return;

      } else {
        System.out.println("올바른 번호를 입력해주세요!");
        return;
      }
    }
  }
}




