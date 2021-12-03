package com.share.ftp.handler.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {

  public static void main(String[] args) {




    List<Integer> list = new ArrayList<>();
    list.add(300);
    list.add(500);
    list.add(400);
    list.add(200);
    list.add(100);

    System.out.printf("인덱스는 %d\n",list.indexOf(400));


    System.out.println("정렬 전");
    for (Integer num : list) {
      System.out.println(num);
    }

    Collections.sort(list);
    Collections.reverse(list);
    System.out.println();

    System.out.println("정렬 후");
    for (Integer num : list) {
      System.out.println(num);
    }




    //  Map<String,Integer> map = new HashMap<>();
    //    map.put("1번 유저", 200);
    //    map.put("2번 유저", 500);
    //    map.put("3번 유저", 100);
    //    map.put("4번 유저", 700);
    //    map.put("5번 유저", 300);
    //
    //
    //
    //    //    System.out.println("정렬 전");
    //
    //    int point = map.get("3번 유저");
    //
    //    System.out.println(point);


  }

}
