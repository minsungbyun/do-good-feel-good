package com.share.ftp.handler.personal.community;

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
    int max = 0;
    //    
    //    for (CommBoardDTO commBoardDTO : commBoardDTOList) {
    //      System.out.printf("%d번 게시글 조회수 : %d\n", commBoardDTO.getCommNo(), commBoardDTO.getViewCount());
    //      // 조회수가 높은 것부터 순서대로 출력(내림차순 정렬)
    //      // 1. 조회수가 가장 높은 것을 뽑는다.;
    //      
    //    }


    for (int i = 0; i < commBoardDTOList.size(); i++) {
      max = commBoardDTOList.get(0).getViewCount();
      //      System.out.printf("현재 가장 높은 조회수는 %d 게시물의 %d 입니다.",commBoardDTOList.get(i).getCommNo(),commBoardDTOList.get(i).getViewCount());
      if (max < commBoardDTOList.get(i).getViewCount()) {
        max = commBoardDTOList.get(i).getViewCount();
      } 
    }

    System.out.println("가장 높은 조회수는? : " + max);


    //    Comparator<CommBoardDTO> comparator = Comparator.comparing(CommBoardDTO::getViewCount);
    //    //CommBoardDTO minObject = commBoardDTOList.stream().min(comparator).get();
    //    CommBoardDTO maxObject = commBoardDTOList.stream().max(comparator).get();
    //    System.out.println("가장높은조회수 " + maxObject);
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
