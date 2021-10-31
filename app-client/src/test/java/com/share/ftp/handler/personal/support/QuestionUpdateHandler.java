package com.share.ftp.handler.personal.support;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionAttachedFile;
import com.share.ftp.domain.support.QuestionListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class QuestionUpdateHandler implements Command {

  QuestionDao questionDao;
  GeneralDao generalDao;
  SqlSession sqlSession;

  public QuestionUpdateHandler(QuestionDao questionDao, GeneralDao generalDao, SqlSession sqlSession) {
    this.questionDao = questionDao;
    this.generalDao = generalDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    while (true) {

      System.out.println();
      System.out.println("[ 문의하기 - 수정 ]");
      int questionNo = (int)request.getAttribute("questionNo");

      QuestionListDTO questionListDTO = questionDao.findByNo(questionNo);

      if (questionListDTO == null) {
        System.out.println("해당 번호의 게시글이 없습니다.");
        return;
      }

      if (!questionListDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
        System.out.println("수정 권한이 없습니다.");
        return;
      }


      //        questionListDTO.setQnaType(new GeneralHelper(generalDao).promptQnaCategory());
      String title = Prompt.inputString(String.format("제목(%s): ", questionListDTO.getTitle()));
      String content = Prompt.inputString(String.format("내용(%s): ", questionListDTO.getContent()));
      questionListDTO.setFileUpload(GeneralHelper.promptQnaFileUpload());

      String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println();
        System.out.println("게시글 수정을 취소하였습니다.");
        return;
      }

      questionListDTO.setTitle(title);
      questionListDTO.setContent(content);

      try {
        questionDao.update(questionListDTO);
        questionDao.deleteFile(questionListDTO);
        for (QuestionAttachedFile questionAttachedFile : questionListDTO.getFileUpload()) {
          questionDao.insertFile(questionListDTO.getNo(), questionAttachedFile.getFilepath());
        }
        sqlSession.commit();
      } catch (Exception e) {
        // 예외검사
        e.printStackTrace();
        // 예외 발생하면, 발생하기 전 작업이 모두 취소됨
        sqlSession.rollback();
      }

      System.out.println("게시글 수정이 완료되었습니다.");
      break;
    }
  }

}