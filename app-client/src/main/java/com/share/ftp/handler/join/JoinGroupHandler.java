package com.share.ftp.handler.join;

import static com.share.util.General.member.GROUP;
import static com.share.util.General.status.WAITING;
import com.share.ftp.dao.GroupDao;
import com.share.ftp.domain.join.GroupDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class JoinGroupHandler implements Command {

  GroupDao groupDao;

  public JoinGroupHandler(GroupDao groupDao) {
    this.groupDao = groupDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 단체회원 양식 ]");
    System.out.println();


    GroupDTO groupUser = new GroupDTO();

    //    아이디 유효성검사
    //    while (true) {

    groupUser.setId(Prompt.inputString("ID ▶ "));

    //      JoinDTO userId = joinDao.validId(joinUser);
    //
    //      if (userId != null) {
    //        System.out.println("사용가능한 아이디입니다.");
    //        break;
    //      }
    //
    //      System.out.println("해당 아이디는 중복되는 아이디입니다.");
    //    }

    groupUser.setPassword(Prompt.inputString("Password ▶ "));

    while (true) {
      groupUser.setName(Prompt.inputString("Name ▶ "));

      if (!(groupUser.getName().length() == 0)) {
        break;
      }
      System.out.println("이름을 다시 입력해주세요!");
    }

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
    groupUser.setStatus(WAITING);

    groupDao.insert(groupUser);

    System.out.println("happyshare 가입을 환영합니다.");
    System.out.println();
    System.out.println("[ 관리자의 승인 후 활동가능합니다. ]");
    System.out.println();
  }
}
//    AuthLoginHandler.userAccessLevel = ACCESS_GROUP | ACCESS_LOGOUT;

