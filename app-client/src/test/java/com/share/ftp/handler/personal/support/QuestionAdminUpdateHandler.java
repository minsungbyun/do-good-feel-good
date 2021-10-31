package com.share.ftp.handler.personal.support;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class QuestionAdminUpdateHandler implements Command {

  QuestionDao questionDao;
  SqlSession sqlSession;

  public QuestionAdminUpdateHandler(QuestionDao questionDao, SqlSession sqlSession) {
    this.questionDao = questionDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    while (true) {

      System.out.println();
      System.out.println("[ 문의하기 - 관리자 답글 수정 ]");
      int questionNo = (int)request.getAttribute("questionNo");

      QuestionListDTO questionListDTO = questionDao.findByNo(questionNo);

      if (questionListDTO == null) {
        System.out.println("해당 번호의 게시글이 없습니다.");
        return;
      }

      String reply = Prompt.inputString(String.format("내용(%s): ", questionListDTO.getReply()));

      String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println();
        System.out.println("게시글 수정을 취소하였습니다.");
        return;
      }

      questionListDTO.setReply(reply);

      questionDao.updateReply(questionListDTO);
      sqlSession.commit();

      System.out.println("게시글 수정이 완료되었습니다.");
      break;
    }
  }

}