package com.share.ftp.handler.personal.support;

import static com.share.util.General.qnaStatus.ANSWER;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionAttachedFile;
import com.share.ftp.domain.support.QuestionListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class QuestionAdminReplyHandler implements Command {

  QuestionDao questionDao;
  SqlSession sqlSession;

  public QuestionAdminReplyHandler(QuestionDao questionDao, SqlSession sqlSession) {
    this.questionDao = questionDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[ 문의사항 - 답글 등록]");

    int questionNo = (int) request.getAttribute("questionNo");
    QuestionListDTO adminQuestionListDTO = questionDao.findByNo(questionNo);

    QuestionListDTO questionListDTO = new QuestionListDTO();

    questionListDTO.setTitle(Prompt.inputString("제목? "));
    questionListDTO.setContent(Prompt.inputString("내용? "));
    questionListDTO.setOwner(AuthLoginHandler.getLoginUser());
    questionListDTO.setQnaPassword(null);
    //    questionListDTO.setPassword(AuthLoginHandler.getLoginUser().getAdminPassword());
    questionListDTO.setFileUpload(GeneralHelper.promptQnaFileUpload());
    questionListDTO.setStatus(ANSWER);


    try {
      questionDao.insert(questionListDTO);
      for (QuestionAttachedFile questionAttachedFile : questionListDTO.getFileUpload()) {
        questionDao.insertFile(questionListDTO.getNo(), questionAttachedFile.getFilepath());
      }
      sqlSession.commit();

    } catch (Exception e) {
      sqlSession.rollback();
    }

    System.out.println();
    System.out.println("문의 답글이 등록되었습니다.");

  }

  //  @Override
  //  public void execute(CommandRequest request) throws Exception {
  //
  //    System.out.println();
  //    System.out.println("[ 문의사항 - 답글]");
  //
  //    int questionNo = (int) request.getAttribute("adminNo");
  //    QuestionListDTO adminQuestionListDTO = findByNo(questionNo);
  //
  //    QuestionListDTO questionListDTO = new QuestionListDTO();
  //
  //    questionListDTO.setTitle(Prompt.inputString("제목? "));
  //    questionListDTO.setContent(Prompt.inputString("내용? "));
  //    questionListDTO.setQnaType(adminQuestionListDTO.getQnaType());
  //    questionListDTO.setOwner(AuthLoginHandler.getLoginUser());
  //    questionListDTO.setPassword(AuthLoginHandler.getLoginUser().getAdminPassword());
  //    questionListDTO.setFileUpload(Prompt.inputString("파일첨부? "));
  //    questionListDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
  //
  //    myQuestionListDTO.setNo(adminQuestionListDTO.getNo());

  //  int a = indexOf(adminQuestionListDTO.getNo());
  //
  //  myQuestionListDTOList.add(a + 1, myQuestionListDTO);
  //
  //    System.out.println();
  //    System.out.println("문의 답글이 등록되었습니다.");
  //
  //  }



}
