package com.share.ftp.handler;

import java.util.Collections;
import java.util.List;
import com.share.ftp.domain.personal.CommBestComparator;
import com.share.ftp.domain.personal.CommBoardDTO;

public class BestTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public static List<CommBoardDTO> getUserRank(List<CommBoardDTO> allUser) {

    List<CommBoardDTO> pointList = getUserPointList(allUser);

    for (int i = 0; i < pointList.size(); i++) {
      for (int j = 0; j < pointList.size(); j++) {
        if (pointList.get(i).getViewCount() < pointList.get(j).getViewCount()) {  
          pointList.get(i).setViewCount(pointList.get(i).getBestRank() + 1);
        }
      }
    }

    for (int i = 0; i < pointList.size(); i++) {
      pointList.get(i).setFinalRank(pointList.get(i).getBestRank());
    }

    return pointList;
  }


  public static void printUserRank(List<CommBoardDTO> allUser) {

    List<CommBoardDTO> userRank = getUserRank(allUser);

    for (CommBoardDTO loginUser : userRank) {
      //      System.out.printf("이름 : %s 내용 : %s점 등수 : %d등\n" , loginUser.getOwner(),  loginUser.getContent(), loginUser.getLike());
    }
  }

  public static int printIndividualUserRank(CommBoardDTO loginUser) {
    return loginUser.getLike();
  }

  // 현재 로그인 한 회원의 포인트를 비교해서 나열함
  public static List<CommBoardDTO> getUserPointList(List<CommBoardDTO> allUser) {

    CommBestComparator userPointComp = new CommBestComparator();

    Collections.sort(allUser, userPointComp);

    for(CommBoardDTO loginUser : allUser) {
      System.out.printf("이름 : %s 내용 : %s점 등수 : %d등\n" , loginUser.getOwner(),  loginUser.getContent(), loginUser.getLike());
      System.out.println();
    }
    return allUser;
  }
}


