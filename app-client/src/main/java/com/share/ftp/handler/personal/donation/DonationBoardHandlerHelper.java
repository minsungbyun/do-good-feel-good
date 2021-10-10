package com.share.ftp.handler.personal.donation;

public class DonationBoardHandlerHelper {

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

}
