package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolDoJoinHandler implements Command {


  List<PersonalRequestDTO> personalSelectedList;
  List<PersonalRequestDTO> personalRequestApplyDTOList;
  VolRequestPersonalAppliedListDetailHandler volRequestPersonalAppliedListDetailHandler;
  public VolDoJoinHandler(
      List<PersonalRequestDTO> personalSelectedList,
      VolRequestPersonalAppliedListDetailHandler volRequestPersonalAppliedListDetailHandler,
      List<PersonalRequestDTO> personalRequestApplyDTOList
      ) {
    this.personalSelectedList = personalSelectedList;
    this.volRequestPersonalAppliedListDetailHandler = volRequestPersonalAppliedListDetailHandler;
    this.personalRequestApplyDTOList = personalRequestApplyDTOList;


  }

  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  봉사 참여자 목록  ]");
    System.out.println();
    System.out.println(" ▶ 참여인원을 확인하고 싶은 봉사번호를 입력해주세요.");
    System.out.println();

    int no = Prompt.inputInt("봉사번호 > ");

    PersonalRequestDTO owner = findByOwnerVol(no);
    PersonalRequestDTO personalRequestSelectedDTO = findBySelectedVol(no);

    if (owner == null) {
      System.out.println("해당 봉사가 없습니다.");
      return;
    }
    System.out.println("111111111111111");
    // 주최자면? 목록보기
    if (AuthLoginHandler.getLoginUser().getName().equals(owner.getOwner().getName())) {
      System.out.println("난 주최자라구 들어왔어");

      System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n봉사자명: %s(%s)\n",
          owner.getTitle(),
          totalJoinCount(),
          owner.getJoinNum(),
          owner.getUserId(),
          owner.getOwner().getName());
      // 주최자 아니면?
    } else {

      if (personalRequestSelectedDTO == null) {
        System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n봉사자명: %s(%s)\n",
            owner.getTitle(),
            totalJoinCount(),
            owner.getJoinNum(),
            owner.getUserId(),
            owner.getOwner().getName());


      } else {
        System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n봉사자명: %s(%s) , %s\n",
            personalRequestSelectedDTO.getTitle(),
            totalJoinCount(),
            personalRequestSelectedDTO.getJoinNum(),
            owner.getUserId(),
            owner.getOwner().getName(),
            personalRequestSelectedDTO.getMemberNames());

      }

    }





  }



  private PersonalRequestDTO findBySelectedVol(int no) {
    for (PersonalRequestDTO personalRequestSelectedDTO : personalSelectedList) {
      if (personalRequestSelectedDTO.getNo() == no) {
        return personalRequestSelectedDTO;
      }
    }
    return null;
  }

  public  PersonalRequestDTO findByOwnerVol(int no) {
    for (PersonalRequestDTO owner : personalRequestApplyDTOList) {
      if (owner.getNo() == no) {
        return owner;
      }
    }
    return null;
  }

  private int totalJoinCount() {


    return volRequestPersonalAppliedListDetailHandler.joinCounts;



    //    PersonalRequestDTO personalRequestSelectedDTO = findBySelectedVol(no);



    //    
    //    int sum = 0;
    //    for (PersonalRequestDTO personalRequestApplyDTO : personalSelectedList) {
    //      sum += personalRequestApplyDTO.getJoinCount();
    //    }
    //    return sum;
  }



}
