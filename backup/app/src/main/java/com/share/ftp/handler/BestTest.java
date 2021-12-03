package com.share.ftp.handler;

//public class BestTest implements Command {

//  //  public static void main(String[] args) {
//  //
//  //  }
//
//  public BestTest(
//      List<CommBoardDTO> commBoardDTOList,
//      List<CommBoardReplyDTO> commBoardReplyDTOList) {
//
//  }
//
//
//  public static List<CommBoardDTO> getLikeRank(List<CommBoardDTO> allBoards) {
//
//    List<CommBoardDTO> commBoardList = getCommBestList(allBoards);
//
//    for (int i = 0; i < commBoardList.size(); i++) {
//      for (int j = 0; j < commBoardList.size(); j++) {
//        if (commBoardList.get(i).getLike() < commBoardList.get(j).getLike()) {  
//          commBoardList.get(i).setRank(commBoardList.get(i).getRank() + 1);
//        }
//      }
//    }
//
//    for (int i = 0; i < commBoardList.size(); i++) {
//      commBoardList.get(i).setBestRank(commBoardList.get(i).getRank());
//    }
//
//    return commBoardList;
//  }
//
//
//  public static void printBestRank(List<CommBoardDTO> allBoards) {
//
//    List<CommBoardDTO> likeRank = getLikeRank(allBoards);
//
//    for (CommBoardDTO commBoard : likeRank) {
//      System.out.printf
//      ("작성자 : %s 제목 : %s 좋아요수 : %d\n" , 
//          commBoard.getOwner(),  commBoard.getTitle(), commBoard.getLike());
//    }
//  }
//
//  // 현재 로그인 한 회원의 포인트를 비교해서 나열함
//  public static List<CommBoardDTO> getCommBestList(List<CommBoardDTO> allBoards) {
//
//    CommBestComparator boardscomp = new CommBestComparator();
//
//    Collections.sort(allBoards, boardscomp);
//
//    for(CommBoardDTO commBoard : allBoards) {
//      System.out.printf
//      ("작성자 : %s 제목 : %s 좋아요수 : %d\n" , 
//          commBoard.getOwner(),  commBoard.getTitle(), commBoard.getLike());
//      System.out.println();
//    }
//    return allBoards;
//  }
//}


