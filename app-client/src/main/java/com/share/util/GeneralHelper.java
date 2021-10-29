package com.share.util;

import java.util.ArrayList;
import java.util.List;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.admin.ChallengeAttachedFile;
import com.share.ftp.domain.admin.NoticeAttachedFile;
import com.share.ftp.domain.challenge.ChallengeReviewAttachedFile;
import com.share.ftp.domain.community.VolunteerBoardAttachedFile;
import com.share.ftp.domain.donation.DonationRegisterPayType;
import com.share.ftp.domain.support.QuestionAttachedFile;
import com.share.ftp.domain.support.QuestionCategory;
import com.share.ftp.domain.volunteer.VolunteerAttachedFile;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

public class GeneralHelper {

  GeneralDao generalDao;

  public GeneralHelper(GeneralDao generalDao) {
    this.generalDao = generalDao;
  }

  public static String getRemainTime(long millis) {

    long sec =  millis / 1000;
    long min = sec / 60;
    long hour = min / 60;
    long day = (millis / 1000) / (24 * 60 * 60);

    hour = hour % 24; 
    sec = sec % 60;
    min = min % 60;

    return String.format("남은시간 ▶ %d일 %d시간 %d분 %d초 남았습니다\n", day, hour, min, sec);
  }

  public static void promptVolunteerTime(VolunteerRequestDTO volunteerRequestDTO) throws Exception {

    System.out.println();

    for (int i = 9; i < 18; i++) {
      System.out.printf(" ▶ %d시 ~ %d시", i, i + 1);
    }

    String startTime = null;
    String endTime = null;


    startTime = Prompt.inputString("시작시간 (enter입력 시 종료) ▶ ");
    endTime = Prompt.inputString("종료시간 (enter입력 시 종료) ▶ ");

    if (startTime.length() == 0 || endTime.length() == 0) {
      return;
    } 

    volunteerRequestDTO.setStartTime(startTime);
    volunteerRequestDTO.setEndTime(endTime);

  }
  public Category promptCategory() throws Exception {

    List<Category> categoryList = generalDao.findAllCategory();

    System.out.println(" ▶ 카테고리 유형 ");
    System.out.println();

    while (true) {
      for (int i = 0; i < categoryList.size(); i++) {
        Category category = categoryList.get(i);
        System.out.printf("%d ▶ %s\n", i + 1, category.getTitle());
      }

      int input = Prompt.inputInt("유형 ▶ ");

      if (0 < input && input < categoryList.size()) {
        return categoryList.get(input - 1);
      }
      System.out.println("올바른 번호를 입력해주세요");

    }
  }

  public QuestionCategory promptQnaCategory() throws Exception {

    List<QuestionCategory> categoryList = generalDao.findAllQnaCategory();

    System.out.println();
    System.out.println(" ▶ 문의분야 유형을 선택해주세요. ");
    System.out.println();

    while (true) {
      for (int i = 0; i < categoryList.size(); i++) {
        QuestionCategory qnaCategory = categoryList.get(i);
        System.out.printf("%d ▶ %s\n", i + 1, qnaCategory.getTitle(), qnaCategory.getNo());
      }

      System.out.println();
      int input = Prompt.inputInt("분야선택 ▶ ");

      if (0 < input && input <= categoryList.size()) {
        return categoryList.get(input - 1);
      }
      System.out.println();
      System.out.println("올바른 번호를 입력해주세요");

    }
  }

  public DonationRegisterPayType promptPayType() throws Exception {

    List<DonationRegisterPayType> payTypeList = generalDao.findAllPayType();

    System.out.println();
    System.out.println(" ▶ 결제 유형을 선택해주세요. ");
    System.out.println();

    while (true) {
      for (int i = 0; i < payTypeList.size(); i++) {
        DonationRegisterPayType payType = payTypeList.get(i);
        System.out.printf("%d ▶ %s\n", i + 1, payType.getTitle());
      }

      System.out.println();
      int input = Prompt.inputInt("결제선택 ▶ ");

      if (0 < input && input <= payTypeList.size()) {
        return payTypeList.get(input - 1);
      }
      System.out.println();
      System.out.println("올바른 번호를 입력해주세요");

    }
  }

  public static List<VolunteerAttachedFile> promptFileUpload() {
    System.out.println();

    VolunteerAttachedFile filepath = null;
    String file = null;

    List<VolunteerAttachedFile> fileList = new ArrayList<>();
    while(true) {

      filepath = new VolunteerAttachedFile();
      file = Prompt.inputString("첨부파일 (enter입력 시 종료) ▶ ");

      if (file.length() == 0) {
        return fileList;
      }

      filepath.setFilepath(file);

      fileList.add(filepath);
    }
  }

  public static List<NoticeAttachedFile> promptNoticeFileUpload() {
    System.out.println();

    NoticeAttachedFile filepath = null;
    String file = null;

    List<NoticeAttachedFile> fileList = new ArrayList<>();
    while(true) {

      filepath = new NoticeAttachedFile();
      file = Prompt.inputString("첨부파일 (enter입력 시 종료) ▶ ");

      if (file.length() == 0) {
        return fileList;
      }

      filepath.setFilepath(file);

      fileList.add(filepath);
    }
  }


  public static List<QuestionAttachedFile> promptQnaFileUpload() {
    System.out.println();

    QuestionAttachedFile filepath = null;
    String file = null;

    List<QuestionAttachedFile> fileList = new ArrayList<>();
    while(true) {

      filepath = new QuestionAttachedFile();
      file = Prompt.inputString("첨부파일 (enter입력 시 종료) ▶ ");
      filepath.setFilepath(file);

      fileList.add(filepath);

      if (file.length() == 0) {
        return fileList;
      }
    }
  }


  public static List<VolunteerBoardAttachedFile> promptBoardFileUpload() {
    System.out.println();

    VolunteerBoardAttachedFile filepath = null;
    String file = null;

    List<VolunteerBoardAttachedFile> fileList = new ArrayList<>();
    while(true) {

      filepath = new VolunteerBoardAttachedFile();
      file = Prompt.inputString("첨부파일 (enter입력 시 종료) ▶ ");
      if (file.length() == 0) {
        return fileList;
      }
      filepath.setFilepath(file);

      fileList.add(filepath);

    }
  }


  public static List<ChallengeAttachedFile> promptChllengeFileUpload() {
    System.out.println();

    ChallengeAttachedFile filepath = null;
    String file = null;

    List<ChallengeAttachedFile> fileList = new ArrayList<>();
    while(true) {

      filepath = new ChallengeAttachedFile();
      file = Prompt.inputString("첨부파일 (enter입력 시 종료) ▶ ");
      if (file.length() == 0) {
        return fileList;
      }
      filepath.setFilepath(file);

      fileList.add(filepath);

    }
  }


  public static List<ChallengeReviewAttachedFile> promptChllengeReviewFileUpload() {
    System.out.println();

    ChallengeReviewAttachedFile filepath = null;
    String file = null;

    List<ChallengeReviewAttachedFile> fileList = new ArrayList<>();
    while(true) {

      filepath = new ChallengeReviewAttachedFile();
      file = Prompt.inputString("첨부파일 (enter입력 시 종료) ▶ ");
      if (file.length() == 0) {
        return fileList;
      }
      filepath.setFilepath(file);

      fileList.add(filepath);

    }
  }
  // 향후 확장성을 위해 나둠 지금은 필요없음
  //  public Status promptStatus() throws Exception {
  //
  //    List<Status> statusList = generalDao.findAllStatus();
  //
  //    System.out.println(" ▶ 신청상태 ");
  //    System.out.println();
  //
  //    while (true) {
  //      for (int i = 0; i < statusList.size(); i++) {
  //        Status status = statusList.get(i);
  //        System.out.printf("%d ▶ %s\n", i + 1, status.getTitle());
  //      }
  //
  //      int input = Prompt.inputInt("상태 ▶ ");
  //
  //      if (0 < input && input < statusList.size()) {
  //        return statusList.get(input - 1);
  //      }
  //      System.out.println("올바른 번호를 입력해주세요");
  //    }
  //  }
}


