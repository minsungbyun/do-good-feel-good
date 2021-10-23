package com.share.ftp.handler.join;

import static com.share.util.General.level.LEVEL_E;
import static com.share.util.General.member.PERSONAL;
import static com.share.util.General.status.ACTIVE;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.PersonalDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class JoinPersonalHandler implements Command {

  PersonalDao personalDao;
  SqlSession sqlSession;

  public JoinPersonalHandler(PersonalDao personalDao, SqlSession sqlSession) {
    this.personalDao = personalDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 개인회원 양식 ]");

    PersonalDTO personalUser = new PersonalDTO();

    //    아이디 유효성검사
    validId(personalUser);

    personalUser.setPassword(Prompt.inputString("Password ▶ "));

    while (true) {
      personalUser.setName(Prompt.inputString("Name ▶ "));

      if (!(personalUser.getName().length() == 0)) {
        break;
      }
      System.out.println("이름을 다시 입력해주세요!");
    }

    personalUser.setBirthdate(Prompt.inputDate("Birthdate ▶ "));
    personalUser.setTel(Prompt.inputString("Tel ▶ "));

    while (true) {
      personalUser.setEmail(Prompt.inputString("Email ▶ "));
      if (!(personalUser.getEmail().contains("@") && 
          personalUser.getEmail().contains("."))) {
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

    personalUser.setPostNo(Prompt.inputInt("PostNo ▶ "));
    personalUser.setBasicAddress(Prompt.inputString("BasicAddress ▶ "));
    personalUser.setDetailAddress(Prompt.inputString("DetailAddress ▶ "));
    System.out.println();

    personalUser.setType(PERSONAL);
    personalUser.setStatus(ACTIVE);
    personalUser.setLevel(LEVEL_E);

    personalDao.insert(personalUser);
    personalDao.insertPersonal(
        personalUser.getNo(), 
        personalUser.getBirthdate(), 
        personalUser.getLevel());

    sqlSession.commit();


    System.out.println("happyshare 가입을 환영합니다.");
    System.out.println();
    System.out.println("[회원 등록이 완료 되었습니다.]");
    System.out.println();
  }

  private void validId(PersonalDTO personalUser) throws Exception {
    while (true) {

      personalUser.setId(Prompt.inputString("ID ▶ "));

      PersonalDTO userId = personalDao.validId(personalUser);

      if (userId == null) {
        System.out.println("사용가능한 아이디입니다.");
        break;
      }

      System.out.println("해당 아이디는 중복되는 아이디입니다.");
      System.out.println();
    }
  }
}

