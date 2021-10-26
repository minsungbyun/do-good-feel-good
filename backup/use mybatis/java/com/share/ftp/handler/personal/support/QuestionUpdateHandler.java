package com.share.ftp.handler.personal.support;

import org.apache.ibatis.session.SqlSession;
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
  SqlSession sqlSession;

  public QuestionUpdateHandler(QuestionDao questionDao, SqlSession sqlSession) {
    this.questionDao = questionDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    while (true) {

      System.out.println();
      System.out.println("[ 문의하기 - 수정 ]");
      int questionNo = (int)request.getAttribute("questionNo");

      QuestionListDTO questionListDTO = questionDao.findByNo(questionNo);

      try {
        if (questionListDTO == null) {
          System.out.println("해당 번호의 게시글이 없습니다.");
          return;
        }

        if (!questionListDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
          System.out.println("수정 권한이 없습니다.");
          return;
        }

        String title = Prompt.inputString(String.format("제목(%s): ", questionListDTO.getTitle()));
        String content = Prompt.inputString(String.format("내용(%s): ", questionListDTO.getTitle()));
        String fileUpload = Prompt.inputString(String.format("첨부파일(%s): ", questionListDTO.getFileUpload()));

        String input = Prompt.inputString("정말 수정하시겠습니까?(y/N) ");

        if (input.equalsIgnoreCase("n") || input.length() == 0) {
          System.out.println();
          System.out.println("게시글 수정을 취소하였습니다.");
          return;
        } else if (input.equals("y")) {
          questionListDTO.setTitle(title);
          questionListDTO.setContent(content);
          questionListDTO.setFileUpload(GeneralHelper.promptQnaFileUpload());

          try {
            questionDao.update(questionListDTO);
            for (QuestionAttachedFile questionAttachedFile : questionListDTO.getFileUpload()) {
              questionDao.insertFile(questionAttachedFile.getFilepath());
            }
            sqlSession.commit();

          } catch (Exception e) {
            // 예외가 발생하기 전에 성공한 작업이 있으면 모두 취소한다.
            // 그래야 다음 작업에 영향을 끼치지 않는다.
            sqlSession.rollback();
          }

          System.out.println();
          System.out.println("게시글 수정이 완료되었습니다.");
          return;
        }
      } catch (Throwable e) {
      }
    }
  }

}