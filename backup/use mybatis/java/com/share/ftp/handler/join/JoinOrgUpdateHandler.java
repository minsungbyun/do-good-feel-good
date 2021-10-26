package com.share.ftp.handler.join;

import static com.share.util.General.member.ORG;
import static com.share.util.General.status.WAIT;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.domain.join.OrgDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class JoinOrgUpdateHandler implements Command {

  OrgDao orgDao;
  SqlSession sqlSession;

  public JoinOrgUpdateHandler(OrgDao orgDao, SqlSession sqlSession) {
    this.orgDao = orgDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 기관회원 양식 ]");
    System.out.println();

    JoinOrgHandler orgForm = new JoinOrgHandler(orgDao, sqlSession);



    OrgDTO orgUser = new OrgDTO();

    validId(orgUser);

    orgUser.setPassword(Prompt.inputString("Password ▶ "));

    while (true) {
      orgUser.setName(Prompt.inputString("Name ▶ "));

      if (!(orgUser.getName().length() == 0)) {
        break;
      }
      System.out.println("이름을 다시 입력해주세요!");
    }

    orgUser.setTel(Prompt.inputString("Tel ▶ "));

    while (true) {
      orgUser.setEmail(Prompt.inputString("Email ▶ "));
      if (!(orgUser.getEmail().contains("@") && 
          orgUser.getEmail().contains("."))) {
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

    orgUser.setPostNo(Prompt.inputInt("PostNo ▶ "));
    orgUser.setBasicAddress(Prompt.inputString("BasicAddress ▶ "));
    orgUser.setDetailAddress(Prompt.inputString("DetailAddress ▶ "));
    orgUser.setFax(Prompt.inputString("Fax ▶ "));
    orgUser.setCorpNo(Prompt.inputString("CorpNo ▶ "));
    orgUser.setHomepage(Prompt.inputString("Homepage ▶ "));

    System.out.println();

    orgUser.setType(ORG);
    orgUser.setStatus(WAIT);

    orgDao.insert(orgUser);
    orgDao.insertOrg(
        orgUser.getNo(),
        orgUser.getCorpNo(),
        orgUser.getFax(),
        orgUser.getHomepage());
    sqlSession.commit();

    System.out.println("happyshare 가입을 환영합니다.");
    System.out.println();
    System.out.println("[ 관리자의 승인 후 활동가능합니다. ]");
    System.out.println();
  }

  private void validId(OrgDTO orgUser) throws Exception {
    while (true) {

      orgUser.setId(Prompt.inputString("ID ▶ "));

      OrgDTO userId = orgDao.validId(orgUser);

      if (userId == null) {
        System.out.println("사용가능한 아이디입니다.");
        break;
      }

      System.out.println("해당 아이디는 중복되는 아이디입니다.");
      System.out.println();
    }
  }
}

