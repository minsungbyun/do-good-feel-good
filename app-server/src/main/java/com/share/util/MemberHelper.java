package com.share.util;

import static com.share.util.General.level.FROM_B_TO_A;
import static com.share.util.General.level.FROM_C_TO_B;
import static com.share.util.General.level.FROM_D_TO_C;
import static com.share.util.General.level.FROM_E_TO_D;
import static com.share.util.General.level.LEVEL_A;
import static com.share.util.General.level.LEVEL_B;
import static com.share.util.General.level.LEVEL_C;
import static com.share.util.General.level.LEVEL_D;
import static com.share.util.General.level.LEVEL_E;
import java.util.Collections;
import java.util.List;
import com.share.ftp.domain.join.JoinComparator;
import com.share.ftp.domain.join.PersonalDTO;
import com.share.ftp.handler.join.AuthLoginHandler;

// 역할
// - 사용자 데이터를 처리하는 static 메서드를 보관하는 클래스
public class MemberHelper {

  public static int getUserPoint(PersonalDTO loginUser) {

    return loginUser.getPoint();
  }


  public static String getUserLevel(PersonalDTO loginUser) {

    int userPoint = loginUser.getPoint();

    if (userPoint < 0) {
      return "오류가 발생했습니다! 존재하지 않는 포인트입니다.";

    } else if (0 <= userPoint && userPoint < FROM_E_TO_D) {
      loginUser.setLevel(LEVEL_E);

    } else if (FROM_E_TO_D <= userPoint && userPoint < FROM_D_TO_C) {
      loginUser.setLevel(LEVEL_D);

    } else if (FROM_D_TO_C <= userPoint && userPoint < FROM_C_TO_B) {
      loginUser.setLevel(LEVEL_C);

    } else if (FROM_C_TO_B <= userPoint && userPoint < FROM_B_TO_A) {
      loginUser.setLevel(LEVEL_B);

    } else if (userPoint >= FROM_B_TO_A) {
      loginUser.setLevel(LEVEL_A);
    }

    return loginUser.getLevel();
  }

  public static int getUserRemainPoint(PersonalDTO loginUser) {

    int needPoint = 0;
    int userPoint = loginUser.getPoint();

    if (userPoint < 0) {
      return -1;

    } else if (0 <= userPoint && userPoint < FROM_E_TO_D) {
      needPoint = FROM_E_TO_D - userPoint;

    } else if (FROM_D_TO_C <= userPoint && userPoint < FROM_D_TO_C) {
      needPoint = FROM_D_TO_C - userPoint;

    } else if (FROM_D_TO_C <= userPoint && userPoint < FROM_C_TO_B) {
      needPoint = FROM_C_TO_B - userPoint;

    } else if (FROM_C_TO_B <= userPoint && userPoint < FROM_B_TO_A) {
      needPoint = FROM_B_TO_A - userPoint;

    } 
    return needPoint;
  }

  public static List<PersonalDTO> getUserRank(List<PersonalDTO> allUser) {

    List<PersonalDTO> pointList = getUserPointList(allUser);

    for (int i = 0; i < pointList.size(); i++) {
      for (int j = 0; j < pointList.size(); j++) {
        if (pointList.get(i).getPoint() < pointList.get(j).getPoint()) {  
          pointList.get(i).setRank(pointList.get(i).getRank() + 1);
        }
      }
    }

    for (int i = 0; i < pointList.size(); i++) {
      pointList.get(i).setFinalRank(pointList.get(i).getRank());
    }

    return pointList;
  }


  public static void printUserRank(List<PersonalDTO> allUser) {

    List<PersonalDTO> userRank = getUserRank(allUser);

    for (PersonalDTO loginUser : userRank) {
      System.out.printf("     %d등  %-10s   [%5d점]\n" , loginUser.getFinalRank(), loginUser.getId(), loginUser.getPoint());
    }
  }

  public static int printMyRank(List<PersonalDTO> allUser) {

    List<PersonalDTO> userRank = getUserRank(allUser);

    for (PersonalDTO loginUser : userRank) {
      if (loginUser.getId().equals(AuthLoginHandler.getLoginUser().getId())) {
        return loginUser.getFinalRank();
      }
    }
    return -1;
  }

  public static int printIndividualUserRank(PersonalDTO loginUser) {
    return loginUser.getFinalRank();
  }

  // 현재 로그인 한 회원의 포인트를 비교해서 나열함
  public static List<PersonalDTO> getUserPointList(List<PersonalDTO> allUser) {

    JoinComparator userPointComp = new JoinComparator();

    Collections.sort(allUser, userPointComp);

    for(PersonalDTO loginUser : allUser) {
      loginUser.setRank(1);
      //    System.out.printf("유저 이름 : %s\n포인트 : %d\n", loginUser.getName(), loginUser.getPoint());
    }
    return allUser;
  }


}
