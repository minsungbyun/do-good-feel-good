package com.share.ftp.handler;

import java.util.Scanner;

public class TimeTest {

  public static void main(String[] args) {


    //    Scanner scanner = new Scanner(System.in);
    //
    //    System.out.print("날짜를 입력해주세요 > ");
    //    String input = scanner.nextLine();
    //    String input2 = scanner.nextLine();
    //    Date date1 = Date.valueOf(input);
    //    Date date2 = Date.valueOf(input2);
    //
    //    System.out.println(date1);
    //    System.out.println(date2);
    //
    //    System.out.println(date1.getTime());
    //    System.out.println(date2.getTime());
    //
    //
    //
    //    // 남은 일 수 
    //    System.out.println(((date2.getTime() - date1.getTime()) / 1000) / (24*60*60));
    //
    //    // 남은 시간 
    //    System.out.println(((date2.getTime() - date1.getTime()) / 1000 * 60 * 60 * 24));
    //
    //    // 남은 분 
    //    System.out.println(((date2.getTime() - date1.getTime()) / 1000 * 60));
    //
    //    // 남은 초 
    //    System.out.println(((date2.getTime() - date1.getTime()) / 1000));


    int hour, min, sec; 
    Scanner s = new Scanner(System.in);
    System.out.println("초를 입력>> ");
    sec = s.nextInt();

    min = sec / 60;
    hour = min / 60;
    System.out.printf("%d시 %d분 %d초 남음", hour, min, sec);

    hour = hour % 12;
    sec = sec % 60;
    min = min % 60;

    System.out.printf("%d시 %d분 %d초 남음", hour, min, sec);

    //    System.out.printf("남은일수 ▶ %d일 남았습니다.\n",   ((((challengeDTO.getEndDate().getTime() - System.currentTimeMillis()) / 1000)) / (24*60*60)));

    System.out.printf(String.format("%d초",sec));



  }

}
