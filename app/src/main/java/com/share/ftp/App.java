package com.share.ftp;

import com.share.ftp.domain.MyChallengeQuestionDTO;
import com.share.ftp.domain.MyChallengeReviewDTO;
import com.share.ftp.handler.ChallengeBoardHandler;
import com.share.ftp.handler.ChallengeHandler;
import com.share.ftp.handler.ChallengeListHandler;
import com.share.ftp.handler.RankingHandler;
import com.share.ftp.handler.ChallengeQuestionHandler;
import com.share.util.Prompt;

public class App {
	  static ChallengeBoardHandler challengeBoardHandler = new ChallengeBoardHandler();
	  static ChallengeHandler challengeHandler = new ChallengeHandler();
	  static ChallengeListHandler challengeListHandler = new ChallengeListHandler();
	  static ChallengeQuestionHandler challengeReviewHandler = new ChallengeQuestionHandler();

	  public static void main(String[] args) {
	    while (true) {
	      int menuNo = doMainMenu();

	      if (menuNo == 0) {
	        break;
	      } else if (menuNo == 1) {
	        doBoardMenu();
	      } else if (menuNo == 2) {
	        doMemberMenu();
	      } else if (menuNo == 3) {
	        doProjectMenu();
	      } else if (menuNo == 4) {
	        doTaskMenu();
	      } else {
	        System.out.println("메뉴 번호가 유효하지 않습니다.");
	      }
	      System.out.println();
	    }

	    Prompt.close();
	  }

	  static void doBoardMenu() {
	    while (true) {
	      System.out.println("[챌린지]");
	      System.out.println("1. 이달의 챌린지");
	      System.out.println("2. 이달의 랭킹");
	      System.out.println("0. 이전메뉴");

	      int menuNo = Prompt.inputInt("게시판> ");
	      switch (menuNo) {
	        case 1: challengeReviewHandler.add(); break;
	        case 2: challengeReviewHandler.list(); break;
	        case 3: challengeReviewHandler.detail(); break;
	        case 4: challengeReviewHandler.update(); break;
	        case 5: challengeReviewHandler.delete(); break;
	        case 0: return;
	        default:
	          System.out.println("무효한 메뉴 번호입니다.");
	      }
	      System.out.println();
	    }
	  }

	  static int doMainMenu() {
	    System.out.println("[메인]");
	    System.out.println("1. 챌린지");
	    System.out.println("0. 종료");
	    return Prompt.inputInt("번호> "); 
	  }
}












