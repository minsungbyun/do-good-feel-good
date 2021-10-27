package com.share.ftp.handler.personal.support;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class QuestionAddHandler implements Command {

  QuestionDao questionDao;
  GeneralDao generalDao;
  SqlSession sqlSession;

  public QuestionAddHandler(QuestionDao questionDao, GeneralDao generalDao, SqlSession sqlSession) {
    this.questionDao = questionDao;
    this.generalDao = generalDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    QuestionListDTO questionListDTO = new QuestionListDTO();

    System.out.println();
    System.out.println("[ 문의하기 - 등록]");

    questionListDTO.setQnaType(new GeneralHelper(generalDao).promptQnaCategory());
    questionListDTO.setTitle(Prompt.inputString("제목: "));
    questionListDTO.setContent(Prompt.inputString("내용: "));
    questionListDTO.setOwner(AuthLoginHandler.getLoginUser());
    //    questionListDTO.setFileUpload(GeneralHelper.promptQnaFileUpload());
    questionListDTO.setQnaPassword(Prompt.inputString("비밀번호(숫자4자리): "));

    //    try {
    //      questionDao.insert(questionListDTO);
    //      for (QuestionAttachedFile questionAttachedFile : questionListDTO.getFileUpload()) {
    //        questionDao.insertFile(questionAttachedFile.getFilepath());
    //      }
    //      sqlSession.commit();
    //
    //    } catch (Exception e) {
    //      // 예외가 발생하기 전에 성공한 작업이 있으면 모두 취소한다.
    //      // 그래야 다음 작업에 영향을 끼치지 않는다.
    //      sqlSession.rollback();
    //    }

    questionDao.insert(questionListDTO);
    sqlSession.commit();

    System.out.println();
    System.out.println("게시글 등록이 완료 되었습니다.");

  }
}
//      } catch (NumberFormatException e) {
//        System.out.println("------------------------------------");
//        System.out.println("문의 분야를 선택해주세요.");
//        System.out.println("------------------------------------");
//        continue;
//      }
//      break;