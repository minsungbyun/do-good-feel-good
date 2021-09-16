package com.share.ftp.handler.personal.community;

import java.util.Comparator;
import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;

public class CommBestListHandler extends AbstractCommBestHandler /*implements Comparable<CommBoardDTO>*/ {

  public CommBestListHandler(List<CommBoardDTO> commBoardDTOList) {
    super(commBoardDTOList);
  }

  @Override
  public void execute() {

    //  System.out.println("[소통해요/나눔이야기Best/목록]");


    //  List<CommBoardDTO> commBoardDTOList;

    Comparator<CommBoardDTO> comparator = Comparator.comparing(CommBoardDTO::getViewCount);
    //CommBoardDTO minObject = commBoardDTOList.stream().min(comparator).get();
    CommBoardDTO maxObject = commBoardDTOList.stream().max(comparator).get();
    System.out.println("가장높은조회수 " + maxObject);
    // System.out.println("Min Object " + minObject);



    //  Collections.sort(commBoardDTOList);
    //
    //
    //
    //    for(CommBoardDTO commBoardDTO : commBoardDTOList) {
    //
    //
    //      System.out.printf("%d, %s, %s, %s, %s, %s, %d\n", 
    //          // AuthLoginHandler.loginUser.getId(),
    //          commBoardDTO.getNo(), 
    //          commBoardDTO.getOwner().getId(),
    //          commBoardDTO.getTitle(), 
    //          commBoardDTO.getContent(),
    //          commBoardDTO.getFileUpload(),
    //          //commBoardDTO.getPassword(),
    //          commBoardDTO.getRegisteredDate(), 
    //          commBoardDTO.getViewCount());
    //
    //        @Override
    //        public int compareTo(CommBoardDTO o) {
    //      
    //          return commBoardDTO.getViewCount()-o.getViewCount;
    //        }




  }
}
