package com.share.ftp.handler.personal.donation;

import java.util.List;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.handler.Command;
import com.share.util.Prompt;

public abstract class AbstractDonationRegisterHandler implements Command { // 모금함 기부하기 양식 쓰는곳

  List<DonationRegisterDTO> donationRegisterDTOList;
  int total;

  public AbstractDonationRegisterHandler(List<DonationRegisterDTO> donationRegisterDTOList) {
    this.donationRegisterDTOList = donationRegisterDTOList;
  }


  protected static String getSortLabel(int sort) {
    //[1.아동] [2.청소년] [3.어르신] [4.장애인] [5.동물] [6.환경] [7.기타]");
    switch (sort) {
      case 1: return "아동";
      case 2: return "청소년";
      case 3: return "어르신";
      case 4: return "장애인";
      case 5: return "동물";
      case 6: return "환경";
      case 7: return "기타";
      default: return null;
    }
  }

  protected static int promptSort() {
    return promptSort(-1);
  }

  protected static int promptSort(int sort) {
    if (sort == -1) {
      System.out.println("기부목록:");
    } 
    System.out.println("[0: 선택안함]");
    System.out.println("[1: 아동]");
    System.out.println("[2: 청소년]");
    System.out.println("[3: 어르신]");
    System.out.println("[4: 장애인]");
    System.out.println("[5: 동물]");
    System.out.println("[6: 환경]");
    System.out.println("[7: 기타]");
    return Prompt.inputInt("> ");

  } 

  public DonationRegisterDTO promptProject() {
    System.out.println("기부분류:");
    for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
      System.out.printf(" [1. %s]\n [2. %s]\n [3. %s]\n [4. %s]\n [5. %s]\n [6. %s]\n [7. %s]\n", 
          donationRegisterDTO.getChildren(), 
          donationRegisterDTO.getTeen(),
          donationRegisterDTO.getElder(),
          donationRegisterDTO.getHandicappedPerson(),
          donationRegisterDTO.getAnimal(),
          donationRegisterDTO.getEnvironmental(),
          donationRegisterDTO.getOther());
    }
    while (true) {
      int projectNo = Prompt.inputInt("기부 분류 선택? (취소: 0) ");
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

  protected DonationRegisterDTO findByNo(int no) {
    for (DonationRegisterDTO donationRegisterDTO : donationRegisterDTOList) {
      if (donationRegisterDTO.getNo() == no) {
        return donationRegisterDTO;
      }
    }
    return null;
  }
}



















