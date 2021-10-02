package com.share.ftp.handler;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {



  public static void main(String[] args) {

    List<String> list = new LinkedList<>();

    list.add("1번 사용자 댓글"); // 0

    list.add("2번 사용자 댓글"); // 1
    list.add("3번 사용자 댓글"); // 2
    list.add("4번 사용자 댓글"); // 3

    list.add(1, "1번 관리자 댓글");
    list.add(3, "2번 관리자 댓글");



    for(int i = 0; i < list.size(); i++) {
      System.out.printf("현재 값은? %s입니다. \n", list.get(i));
    }


    System.out.printf("현재 인덱스는 %s번째 입니다\n", list.indexOf("1번 사용자 댓글"));
    System.out.printf("현재 인덱스는 %s번째 입니다\n", list.indexOf("2번 사용자 댓글"));
    System.out.printf("현재 인덱스는 %s번째 입니다\n", list.indexOf("3번 사용자 댓글"));
    System.out.printf("현재 인덱스는 %s번째 입니다\n", list.indexOf("4번 사용자 댓글"));
    System.out.printf("현재 인덱스는 %s번째 입니다\n", list.indexOf("1번 관리자 댓글"));

    // 문의 등록 



  }

}
