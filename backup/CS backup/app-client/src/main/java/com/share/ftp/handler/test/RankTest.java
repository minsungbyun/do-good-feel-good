package com.share.ftp.handler.test;

import java.util.ArrayList;

public class RankTest {

  public static void main(String[] args) {


    //[1] 입력
    int[] score = {90,87,100, 95, 80};
    int[] rank = {1,1,1,1,1}; //3,4,1,2,5

    //[2] 처리

    for(int i=0; i<score.length; i++){
      //      rank[i] = 1; //1등으로 초기화

      for (int j = 0; j < score.length; j++) { //기준데이터와 나머지데이터비교                             
        if(score[i]<score[j]){   //기준데이터가 나머지데이터라 비교했을때 적으면 rank[i] 카운트
          rank[i]++; //COUNT                 
        }              
      }          
    }      

    //[3] 출력
    for (int i = 0; i < score.length; i++) {
      System.out.println(score[i]+"점 : "+rank[i]+"등");           
    }


    ArrayList<Integer> list = new ArrayList<>();

    list.add(1);
    list.add(1);
    list.add(1);
    list.add(1);

    for (Integer i : list) {
      System.out.println(i);
    }
  }






}
