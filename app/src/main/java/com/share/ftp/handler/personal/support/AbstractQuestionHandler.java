package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.handler.Command;
import com.share.util.Prompt;

public abstract class AbstractQuestionHandler implements Command {

  protected List<QuestionListDTO> myQuestionListDTOList;

  public AbstractQuestionHandler(List<QuestionListDTO> myQuestionListDTOList) {
    this.myQuestionListDTOList = myQuestionListDTOList;
  }

  protected static String getSortLabel(int sort) {
    // [1.함께해요 문의] [2.나눔이야기 문의] [3.모금함 문의]
    // [4.챌린지 문의] [5.사이트 이용 문의] [6.기타]");
    switch (sort) {
      case 1: return "함께해요 문의";
      case 2: return "나눔이야기 문의";
      case 3: return "모금함 문의";
      case 4: return "챌린지 문의";
      case 5: return "사이트 이용 문의";
      case 6: return "기타";
      default: return null;
    }
  }

  protected static int promptSort() {
    return promptSort(-1);
  }

  protected static int promptSort(int sort) {
    if (sort == -1) {
      System.out.println("문의목록:");
    } 
    System.out.println("[0: 선택안함]");
    System.out.println("[1: 함께해요 문의]");
    System.out.println("[2: 나눔이야기 문의]");
    System.out.println("[3: 모금함 문의]");
    System.out.println("[4: 챌린지 문의]");
    System.out.println("[5: 사이트 이용 문의]");
    System.out.println("[6: 기타]");
    return Prompt.inputInt("> ");

  } 

  public DonationRegisterDTO promptProject() {
    System.out.println("문의분류:");
    for (MyQuestionListDTO myQuestionListDTO : myQuestionListDTOList) {
      System.out.printf(" [1. %s]\n [2. %s]\n [3. %s]\n [4. %s]\n [5. %s]\n [6. %s]\n", 
          myQuestionListDTO.getVolunteerAsk(), 
          myQuestionListDTO.getCommuityAsk(),
          myQuestionListDTO.getElder(),
          myQuestionListDTO.getHandicappedPerson(),
          myQuestionListDTO.getAnimal(),
          myQuestionListDTO.getEnvironmental(),
          myQuestionListDTO.getOther());
    }



    while (true) {
      int projectNo = Prompt.inputInt("문의 분류 선택? (취소: 0) ");
      if (projectNo == 0) {
        return null;
      } else if (projectNo == 1) {
        System.out.println("아동");
      } else if (projectNo == 2) {
        System.out.println("청소년");
      } else if (projectNo == 3) {
        System.out.println("어르신");
      } else if (projectNo == 4) {
        System.out.println("장애인");
      } else if (projectNo == 5) {
        System.out.println("장애인");
      } else if (projectNo == 6) {
        System.out.println("동물");
      } else if (projectNo == 7) {
        System.out.println("기타");
      }

      DonationRegisterDTO selectedProject = findByNo(projectNo);
      if (selectedProject != null) {
        return selectedProject;
      }
      System.out.println("프로젝트 번호가 옳지 않습니다.");
    }
  }

  protected MyQuestionListDTO findByNo(int no) {
    for (MyQuestionListDTO myQuestionListDTO : myQuestionListDTOList) {
      if (myQuestionListDTO.getNo() == no) {
        return myQuestionListDTO;
      }
    }
    return null;
  }

}





