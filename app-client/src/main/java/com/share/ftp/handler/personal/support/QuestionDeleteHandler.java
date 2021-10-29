package com.share.ftp.handler.personal.support;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class QuestionDeleteHandler implements Command {

  QuestionDao questionDao;
  GeneralDao generalDao;
  SqlSession sqlSession;

  public QuestionDeleteHandler(QuestionDao questionDao, GeneralDao generalDao, SqlSession sqlSession) {
    this.questionDao = questionDao;
    this.generalDao = generalDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    try {

      System.out.println();
      System.out.println("[ 문의하기 - 삭제]");

      int questionNo = (int) request.getAttribute("questionNo");

      QuestionListDTO questionListDTO = questionDao.findByNo(questionNo);

      if (questionListDTO == null) {
        System.out.println("해당 번호의 게시글이 없습니다.");
        return;
      }

      if ((questionListDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
          AuthLoginHandler.getLoginUser().getId().equals("admin")) {

      } else {
        System.out.println("삭제 권한이 없습니다.");
        return;
      }

      String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
      System.out.println();
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("게시글 삭제를 취소하였습니다.");
        return;
      } 

      try {
        questionDao.updateFile(questionListDTO);
        questionDao.delete(questionListDTO);
        sqlSession.commit();
      } catch (Exception e) {
        e.printStackTrace();
        // 예외가 발생하기 전에 성공한 작업이 있으면 모두 취소한다.
        // 그래야 다음 작업에 영향을 끼치지 않는다.
        sqlSession.rollback();
      }

      System.out.println("게시글을 삭제하였습니다."); 

      //        if (QuestionListDTO == null) {
      //          System.out.println("해당 번호의 게시글이 없습니다.");
      //          return;
      //        }
      //
      //        if (QuestionListDTO.getOwner().getId() == (AuthLoginHandler.getLoginUser().getId()) ||
      //            AuthLoginHandler.getLoginUser().getId().equals("admin")) {
      //
      //          String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
      //          if (input.equalsIgnoreCase("n") /*|| input.length() == 0 */) {
      //            System.out.println("게시글 삭제를 취소하였습니다.");
      //            return;
      //          } else if(input.equals("y")) {
      //            System.out.println("게시글을 삭제하였습니다.");
      //            myQuestionListDTOList.remove(QuestionListDTO);
      //            return;
      //          } else  {
      //            System.out.println("y 또는 n을 입력하세요.");
      //            continue;  
      //          } 
      //        }

      //      if (questionListDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
      //        System.out.println("삭제 권한이 없습니다.");
      //        return;
      //      }
    } catch (Throwable e) {

    }
  }
}