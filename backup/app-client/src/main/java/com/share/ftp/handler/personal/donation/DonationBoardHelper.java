package com.share.ftp.handler.personal.donation;

import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.donation.DonationBoardAttachedFile;
import com.share.util.Prompt;

public class DonationBoardHelper {

  public static String getRemainTime(long millis) {

    long sec = millis / 1000;
    long min = sec / 60;
    long hour = min / 60;
    long day = millis / 1000 / (24 * 60 * 60);

    hour = hour % 24; 
    sec = sec % 60;
    min = min % 60;

    return String.format("남은시간 ▶ %d일 %d시간 %d분 %d초 남았습니다\n", day, hour, min, sec);
  }

  public static List<DonationBoardAttachedFile> promptFileUpload() {
    System.out.println();

    DonationBoardAttachedFile filepath = null;
    String file = null;

    List<DonationBoardAttachedFile> fileList = new ArrayList<>();
    while(true) {

      filepath = new DonationBoardAttachedFile();
      file = Prompt.inputString("첨부파일 (enter입력 시 종료) ▶ ");
      if (file.length() == 0) {
        return fileList;
      }

      filepath.setFilepath(file);

      fileList.add(filepath);

    }
  }

}
