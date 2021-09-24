package com.share.ftp.handler;

import java.sql.Date;
import java.util.Scanner;

public class TestHa {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("날짜를 입력해주세요 > ");
    String input = scanner.nextLine();
    String input2 = scanner.nextLine();
    Date date1 = Date.valueOf(input);
    Date date2 = Date.valueOf(input2);

    System.out.println(date1);
    System.out.println(date2);

    System.out.println(date1.getTime());
    System.out.println(date2.getTime());

    System.out.println(((date2.getTime() - date1.getTime()) / 1000) / (24*60*60));

    //    System.out.println((int)((date1.getTime() / (1000*60*60)) % 24));
    //    System.out.println((int)((date2.getTime() / (1000*60*60)) % 24));





  }

}
