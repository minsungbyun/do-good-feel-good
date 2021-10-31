package com.share.ftp.handler.personal.support;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class QuestionAdminReplyDeleteHandler implements Command {

  QuestionDao questionDao;
  SqlSession sqlSession;

  public QuestionAdminReplyDeleteHandler(QuestionDao questionDao, SqlSession sqlSession) {
    this.questionDao = questionDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[ 문의사항 - 관리자 답글 삭제]");

    int questionNo = (int) request.getAttribute("questionNo");
    QuestionListDTO questionListDTO = questionDao.findByNo(questionNo);

    if (questionListDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    if (questionListDTO.getReply() == null) {
      System.out.println("등록된 답변이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    System.out.println();
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    questionListDTO.setReply(null);
    questionListDTO.setStatus(0);

    questionDao.updateReply(questionListDTO);
    sqlSession.commit();

    //    try {
    //      questionDao.insert(questionListDTO);
    //      for (QuestionAttachedFile questionAttachedFile : questionListDTO.getFileUpload()) {
    //        questionDao.insertFile(questionListDTO.getNo(), questionAttachedFile.getFilepath());
    //      }
    //      sqlSession.commit();
    //
    //    } catch (Exception e) {
    //      e.printStackTrace();
    //      sqlSession.rollback();
    //    }

    System.out.println();
    System.out.println("문의 답글이 삭제되었습니다.");

  }
}
