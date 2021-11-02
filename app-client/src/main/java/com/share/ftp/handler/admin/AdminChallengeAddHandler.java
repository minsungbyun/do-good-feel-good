package com.share.ftp.handler.admin;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeAttachedFile;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class AdminChallengeAddHandler implements Command {

  ChallengeDao challengeDao;
  SqlSession sqlSession;

  public AdminChallengeAddHandler(ChallengeDao challengeDao, SqlSession sqlSession) {
    this.challengeDao = challengeDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 챌린지 등록 ]");

    ChallengeDTO challengeDTO = new ChallengeDTO();

    challengeDTO.setTitle(Prompt.inputString("제목 ▶ "));
    challengeDTO.setContent(Prompt.inputString("내용 ▶ ")); 
    challengeDTO.setFileUpload(GeneralHelper.promptChllengeFileUpload()); 
    //    challengeDTO.setAdmin(AuthLoginHandler.getLoginUser());

    while (true) {
      challengeDTO.setStartDate(Prompt.inputDate("시작일 ▶ "));
      challengeDTO.setEndDate(Prompt.inputDate("종료일 ▶ "));

      if (challengeDTO.getStartDate().compareTo(challengeDTO.getEndDate()) > 0) {
        System.out.println("종료일을 지난 시작일은 존재하지 않습니다. 올바른 날짜를 입력해주세요!");

      } else if (challengeDTO.getStartDate().compareTo(challengeDTO.getEndDate()) == 0) {
        System.out.println("시작일과 종료일은 같을 수 없습니다. 올바른 날짜를 입력해주세요!");

      } else {
        break;
      }
    }
    //    challengeDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    //    challengeDTO.setNo(challengeDao.getNextNum()); 

    try {
      challengeDao.insert(challengeDTO);
      for (ChallengeAttachedFile challengeAttachedFile : challengeDTO.getFileUpload()) {
        challengeDao.insertFile(challengeDTO.getNo(), challengeAttachedFile.getFilepath());
      }
      sqlSession.commit();
    } catch (Exception e) {
      //      e.printStackTrace();
      sqlSession.rollback();
    }
    System.out.println();
    System.out.println("[ 챌린지가 정상적으로 등록되었습니다. ]");
  }
}
