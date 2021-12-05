package com.share.ftp.handler.join;

import static com.share.util.General.member.GROUP;
import static com.share.util.General.status.WAIT;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.GroupDao;
import com.share.ftp.domain.join.GroupDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class GroupFormUpdateHandler implements Command {

  GroupDao groupDao;
  SqlSession sqlSession;

  public GroupFormUpdateHandler(GroupDao groupDao,SqlSession sqlSession) {
    this.groupDao = groupDao;
    this.sqlSession = sqlSession;
  }

  // 마이페이지 나의 정보 수정 -> 비밀번호 입력시 변경가능
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 단체 신청서 수정 ]");


    String userId = Prompt.inputString("아이디 ▶ ");
    String userPassword = Prompt.inputString("비밀번호 ▶ ");

    GroupDTO groupUser = groupDao.findByIdPassword(userId, userPassword);

    if (groupUser == null) {
      System.out.println("해당 아이디의 회원이 없습니다.");
      return;
    }

    groupDao.deleteGroup(groupUser);
    groupDao.delete(groupUser);

    groupUser.setId(userId);
    groupUser.setPassword(userPassword);

    groupUser.setTel(Prompt.inputString("Tel ▶ "));

    while (true) {
      groupUser.setEmail(Prompt.inputString("Email ▶ "));
      if (!(groupUser.getEmail().contains("@") && 
          groupUser.getEmail().contains("."))) {
        System.out.println("이메일 양식에 맞추어 작성바랍니다. ex) aaa@test.com");
        System.out.println();
        continue;
      }
      System.out.println();
      System.out.println("[  해당 이메일로 인증번호가 전송되었습니다. ]");
      System.out.println();

      int authNum = Prompt.inputInt("인증번호 입력 ▶ ");

      if (authNum == 1004) {
        System.out.println("[  인증이 정상적으로 완료되었습니다!  ]");
        System.out.println();
        break;
      } else {
        System.out.println("잘못 입력하셨습니다.");
      }
    }
    groupUser.setPostNo(Prompt.inputInt("PostNo ▶ "));
    groupUser.setBasicAddress(Prompt.inputString("BasicAddress ▶ "));
    groupUser.setDetailAddress(Prompt.inputString("DetailAddress ▶ "));

    groupUser.setGroupCount(Prompt.inputInt("GroupCount ▶ "));
    System.out.println();

    groupUser.setType(GROUP);
    groupUser.setStatus(WAIT);


    groupDao.insert(groupUser);
    groupDao.insertGroup(
        groupUser.getNo(), groupUser.getGroupCount());

    sqlSession.commit();

    System.out.println("단체 신청서를 변경하였습니다.");
    System.out.println();
    System.out.println("관리자의 승인 후 로그인이 가능합니다.");
  }
}



