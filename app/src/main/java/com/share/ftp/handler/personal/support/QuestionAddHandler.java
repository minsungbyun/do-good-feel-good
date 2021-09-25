package com.share.ftp.handler.personal.support;

import static com.share.util.General.questionType.CHALLENGEASK;
import static com.share.util.General.questionType.COMMUITYASK;
import static com.share.util.General.questionType.DONATIONASK;
import static com.share.util.General.questionType.OTHERASK;
import static com.share.util.General.questionType.SITEASK;
import static com.share.util.General.questionType.VOLUNTEERASK;
import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class QuestionAddHandler extends AbstractQuestionHandler {

  public QuestionAddHandler(List<QuestionListDTO> myQuestionListDTOList) {
    super (myQuestionListDTOList);
  }
  @Override
  public void execute(CommandRequest request) throws Exception {

    while (true) {
      try {

        QuestionListDTO myQuestionListDTO = new QuestionListDTO();

        System.out.println();
        System.out.println("문의하려는 분야를 선택해주세요.");

        System.out.println("[1. 함께해요 문의]");
        System.out.println("[2. 나눔이야기 문의]");
        System.out.println("[3. 모금함 문의]");
        System.out.println("[4. 챌린지 문의]");
        System.out.println("[5. 사이트이용 문의]");
        System.out.println("[6. 기타 문의]");
        System.out.println("[0. 이전]");

        int input = Prompt.inputInt("> ");

        switch(input) {
          case 1: myQuestionListDTO.setQnaType(VOLUNTEERASK);   break;
          case 2: myQuestionListDTO.setQnaType(COMMUITYASK);   break;
          case 3: myQuestionListDTO.setQnaType(DONATIONASK);   break;
          case 4: myQuestionListDTO.setQnaType(CHALLENGEASK);   break;
          case 5: myQuestionListDTO.setQnaType(SITEASK);   break;
          case 6: myQuestionListDTO.setQnaType(OTHERASK);   break;
          default: System.out.println("올바른 번호를 입력해주세요"); continue;
        }



        myQuestionListDTO.setTitle(Prompt.inputString("제목? "));
        myQuestionListDTO.setContent(Prompt.inputString("내용? "));
        myQuestionListDTO.setOwner(AuthLoginHandler.getLoginUser());
        myQuestionListDTO.setPassword(Prompt.inputInt("비밀번호? "));
        myQuestionListDTO.setFileUpload(Prompt.inputString("파일첨부? "));
        myQuestionListDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

        // 고유회원번호 부여
        myQuestionListDTO.setNo(getNextNum());

        myQuestionListDTOList.add(myQuestionListDTO);

      } catch (NumberFormatException e) {
        System.out.println("------------------------------------");
        System.out.println("문의 분야를 선택해주세요.");
        System.out.println("------------------------------------");
        continue;
      }


      break;
    }


    //    System.out.println();
    //    System.out.println("[고객센터/문의하기/문의하기 등록]");
    //
    //
    //    QuestionListDTO myQuestionListDTO = new QuestionListDTO();
    //
    //    myQuestionListDTO.setTitle(Prompt.inputString("제목? "));
    //    myQuestionListDTO.setContent(Prompt.inputString("내용? "));
    //    myQuestionListDTO.setOwner(AuthLoginHandler.getLoginUser());
    //    myQuestionListDTO.setFileUpload(Prompt.inputString("파일첨부? "));
    //    myQuestionListDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    //    myQuestionListDTO.setBoardNo(++boardNo);
    //
    //    myQuestionListDTOList.add(myQuestionListDTO);
  }



}