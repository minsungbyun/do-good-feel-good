package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.util.Prompt;

public class QuestionSearchHandler extends AbstractQuestionHandler {

  public QuestionSearchHandler(List<QuestionListDTO> myQuestionListDTOList) {
    super(myQuestionListDTOList);
  }

  @Override
  public void execute() {
    System.out.println("[고객센터/문의하기/문의하기 검색]");

    String input = Prompt.inputString("검색어? ");

    for (QuestionListDTO myQuestionListDTO : myQuestionListDTOList) {
      if (!myQuestionListDTO.getTitle().contains(input) &&
          !myQuestionListDTO.getContent().contains(input) &&
          !myQuestionListDTO.getWriter().contains(input)) {
        continue;
      }
      System.out.printf("%d, %s, %s, %s, %d\n", 
          myQuestionListDTO.getNo(), 
          myQuestionListDTO.getTitle(), 
          myQuestionListDTO.getWriter(),
          myQuestionListDTO.getRegisteredDate(),
          myQuestionListDTO.getViewCount()); 
    }
  }
}







