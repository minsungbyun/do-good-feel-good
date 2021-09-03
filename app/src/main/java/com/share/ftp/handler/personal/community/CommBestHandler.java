package com.share.ftp.handler.personal.community;

import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.org.CommBoardHandler;

public class CommBestHandler {
  CommBoardHandler commBoardHandler;
  public CommBestHandler(CommBoardHandler commBoardHandler) {
    this.commBoardHandler = commBoardHandler;
  }

  public void showList() {
    System.out.println("소통해요/ 나눔이야기Best/ 목록");

    //  전체 목록중에서 조회수가 가장 높은 3개
    CommBoardDTO[] arr = commBoardHandler.chooseBoard();

    System.out.printf("%d, %s, %s, %s, %s, %d\n", 
        arr[0].getNo(), 
        arr[0].getTitle(), 
        arr[0].getContent(),
        arr[0].getFileUpload(),
        //this.commBoardsDTO[i].getPassword(),
        arr[0].getRegisteredDate(), 
        arr[0].getViewCount());


    //    //  전체 목록중에서 조회수가 가장 높은 3개
    //    CommBoardDTO[] arr = commBoardHandler.chooseBoard();
    //
    //    System.out.printf("%d, %s, %s, %s, %s, %d\n", 
    //        arr[0].getNo(), 
    //        arr[0].getTitle(), 
    //        arr[0].getContent(),
    //        arr[0].getFileUpload(),
    //        //this.commBoardsDTO[i].getPassword(),
    //        arr[0].getRegisteredDate(), 
    //        arr[0].getViewCount());




  }

  public void showDetail() {
    System.out.println("소통해요/ 나눔이야기Best/ 상세보기");
    System.out.println();

  }
}