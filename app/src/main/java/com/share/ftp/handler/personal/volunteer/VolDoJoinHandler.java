package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.handler.Command;
import com.share.util.Prompt;

public class VolDoJoinHandler implements Command {


  List<PersonalRequestDTO> personalRequestApplyDTOList;
  VolRequestPersonalAppliedListDetailHandler volRequestPersonalAppliedListDetailHandler;

  public VolDoJoinHandler(List<PersonalRequestDTO> personalRequestApplyDTOList,
      VolRequestPersonalAppliedListDetailHandler volRequestPersonalAppliedListDetailHandler) {

    this.personalRequestApplyDTOList = personalRequestApplyDTOList;
    this.volRequestPersonalAppliedListDetailHandler = volRequestPersonalAppliedListDetailHandler;
  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  봉사 참여자 목록  ]");
    System.out.println();
    System.out.println(" ▶ 참여인원을 확인하고 싶은 봉사번호를 입력해주세요.");
    System.out.println();

    int volNo = Prompt.inputInt("봉사번호 > ");
    System.out.println();

    PersonalRequestDTO volJoinList = findByVol(volNo); 

    if (volJoinList == null) {
      System.out.println("해당 봉사가 없습니다.");
      return;
    }

    // 주최자 이름이 있으면 제거 (따로 명시되게끔 설정함)
    if (volJoinList.getMembers().contains(volJoinList.getOwner())) {
      volJoinList.getMembers().remove(volJoinList.getOwner());
    }

    System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n\n주최자명: %s(%s)\n\n           [  봉사자명  ]\n\n%s\n",
        volJoinList.getVolTitle(),
        volJoinList.getTotalJoinCount(),
        volJoinList.getVolLimitNum(),
        volJoinList.getOwnerId(), // 주최자 아이디
        volJoinList.getOwner().getName(), // 주최자 이룸
        volJoinList.getMemberNames());
  }

  private PersonalRequestDTO findByVol(int no) {
    for (PersonalRequestDTO volJoinList : personalRequestApplyDTOList) {
      if (volJoinList.getVolNo() == no) {
        return volJoinList;
      }
    }
    return null;
  }
}






// 열람만 하는 경우
//
//    // 주최자가 최초로 목록을 보는 경우
//    if (AuthLoginHandler.getLoginUser().getName().equals(volJoinList.getOwner().getName())) {
//      System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n\n주최자명: %s(%s)\n",
//          volJoinList.getTitle(),
//          volJoinList.getJoinCount(), // 최초 주최자 1명
//          volJoinList.getJoinNum(),
//          volJoinList.getUserId(),
//          volJoinList.getOwner().getName());
//
//
//    } else {
//      // 주최자 제외한 새로운 사람이 등록한 경우


//      if (no == 1) {
//        System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n\n주최자명: %s(%s)\n\n           [  봉사자명  ]\n\n%s\n",
//            owner.getTitle(),
//            personalRequestSelectedDTO.getTotalJoinCount1(),
//            owner.getJoinNum(),
//            owner.getUserId(), // 주최자 아이디
//            owner.getOwner().getName(), // 주최자 이룸
//            personalRequestSelectedDTO.getMemberNames1());
//      } else if (no ==2) {
//        System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n\n주최자명: %s(%s)\n\n           [  봉사자명  ]\n\n%s\n",
//            owner.getTitle(),
//            personalRequestSelectedDTO.getTotalJoinCount2(),
//            owner.getJoinNum(),
//            owner.getUserId(), // 주최자 아이디
//            owner.getOwner().getName(), // 주최자 이룸
//            personalRequestSelectedDTO.getMemberNames2());
//
//      } else if (no ==3) {
//        System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n\n주최자명: %s(%s)\n\n           [  봉사자명  ]\n\n%s\n",
//            owner.getTitle(),
//            personalRequestSelectedDTO.getTotalJoinCount3(),
//            owner.getJoinNum(),
//            owner.getUserId(), // 주최자 아이디
//            owner.getOwner().getName(), // 주최자 이룸
//            personalRequestSelectedDTO.getMemberNames3());
//
//      }

//  }


//  private PersonalRequestDTO findBySelectedVol(int no) {
//    for (PersonalRequestDTO personalRequestSelectedDTO : personalSelectedList) {
//      if (personalRequestSelectedDTO.getNo() == no) {
//        return personalRequestSelectedDTO;
//      }
//    }
//    return null;
//  }



//  private int totalJoinCount() {

//    int sum = volRequestPersonalAppliedListDetailHandler.joinCounts + volRequestPersonalAppliedListDetailHandler.ownerCount;

//    return sum;

//}


