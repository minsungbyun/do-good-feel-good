package com.share.ftp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.share.ftp.domain.Board;
import com.share.ftp.domain.MemberDTO;
import com.share.ftp.domain.Project;
import com.share.ftp.domain.Task;
import com.share.ftp.handler.BoardHandler;
import com.share.ftp.handler.MemberHandler;
import com.share.ftp.handler.ProjectHandler;
import com.share.ftp.handler.TaskHandler;
import com.share.menu.Menu;
import com.share.menu.MenuGroup;
import com.share.util.Prompt;

public class App {
  List<Board> boardList = new ArrayList<>();
  List<MemberDTO> memberList = new LinkedList<>();
  List<Project> projectList = new ArrayList<>();
  List<Task> taskList = new LinkedList<>();

  BoardHandler boardHandler = new BoardHandler(boardList);
  MemberHandler memberHandler = new MemberHandler(memberList);
  ProjectHandler projectHandler = new ProjectHandler(projectList, memberHandler);
  TaskHandler taskHandler = new TaskHandler(taskList, memberHandler);

  public static void main(String[] args) {
    App app = new App(); 
    app.service();
  }

  void service() {
    createMenu().execute();
    Prompt.close();
  }

  Menu createMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("로그인");
    mainMenuGroup.setPrevMenuTitle("종료");


    MenuGroup personalMenu = new MenuGroup("개인");
    mainMenuGroup.add(personalMenu);

    MenuGroup personalvolunteerMenu = new MenuGroup("함께해요");
    personalMenu.add(personalvolunteerMenu);

    MenuGroup volunteerApply = new MenuGroup("봉사신청");
    personalvolunteerMenu.add(volunteerApply);

    MenuGroup personalApply = new MenuGroup("개인봉사등록");
    volunteerApply.add(personalApply);

    personalApply.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.registerFinish(); 
      }});
    personalApply.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    personalApply.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    personalApply.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.volunteerupdate(); 
      }});
    personalApply.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.volunteerdelete(); 
      }});

    MenuGroup oragnizationApply = new MenuGroup("기관봉사등록");
    volunteerApply.add(oragnizationApply);

    oragnizationApply.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.registerFinish(); 
      }});
    oragnizationApply.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    oragnizationApply.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    oragnizationApply.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.volunteerupdate(); 
      }});
    oragnizationApply.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.volunteerdelete(); 
      }});

    MenuGroup volunteerBoard = new MenuGroup("봉사목록");
    personalvolunteerMenu.add(volunteerBoard);

    MenuGroup personalCommunityMenu = new MenuGroup("소통해요");
    personalMenu.add(personalCommunityMenu);

    MenuGroup reviewMenu = new MenuGroup("나눔 이야기");
    personalCommunityMenu.add(reviewMenu);

    reviewMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.add(); 
      }});
    reviewMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    reviewMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    reviewMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.update(); 
      }});
    reviewMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.delete(); 
      }});

    MenuGroup bestReviewMenu = new MenuGroup("나눔 이야기 BEST");
    personalCommunityMenu.add(bestReviewMenu);

    bestReviewMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        memberHandler.list(); 
      }});

    MenuGroup shortReviewMenu = new MenuGroup("한 줄 후기");
    personalCommunityMenu.add(shortReviewMenu);

    shortReviewMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        memberHandler.add(); 
      }});

    shortReviewMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        memberHandler.list(); 
      }});

    shortReviewMenu.add(new Menu("수정") {
      @Override
      public void execute() {
        memberHandler.update(); 
      }});
    shortReviewMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        memberHandler.delete(); 
      }});

    MenuGroup personalChallengeMenu = new MenuGroup("챌린지");
    personalMenu.add(personalChallengeMenu);

    MenuGroup monthlyChallengeMenu = new MenuGroup("이달의 챌린지");
    personalChallengeMenu.add(monthlyChallengeMenu);


    monthlyChallengeMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        projectHandler.list(); 
      }});
    monthlyChallengeMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        projectHandler.detail(); 
      }});


    MenuGroup monthlyRankingMenu = new MenuGroup("이달의 랭킹");
    personalChallengeMenu.add(monthlyRankingMenu);


    monthlyRankingMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        projectHandler.list(); 
      }});
    monthlyRankingMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        projectHandler.detail(); 
      }});

    monthlyRankingMenu.add(new Menu("나의 랭킹보기") {
      @Override
      public void execute() {
        projectHandler.detail(); 
      }});


    MenuGroup personalDonationMenu = new MenuGroup("모금함");
    personalMenu.add(personalDonationMenu);

    MenuGroup donationList = new MenuGroup("모금함 목록");
    personalDonationMenu.add(donationList);

    MenuGroup donation = new MenuGroup("모금함 기부하기");
    donationList.add(donation);

    donation.add(new Menu("기부하기") {
      @Override
      public void execute() {
        taskHandler.add(); 
      }});
    donation.add(new Menu("기부내역") {
      @Override
      public void execute() {
        taskHandler.list(); 
      }});

    MenuGroup personalDonationTotal = new MenuGroup("전체 모금액");
    personalDonationMenu.add(personalDonationTotal);


    MenuGroup support = new MenuGroup("고객센터");
    personalMenu.add(support);

    MenuGroup notice = new MenuGroup("공지사항");
    support.add(notice);

    notice.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    notice.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});

    MenuGroup faQ = new MenuGroup("FAQ");
    support.add(faQ);

    faQ.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    faQ.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});

    MenuGroup ask = new MenuGroup("문의하기");
    support.add(ask);

    ask.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.askMesasge(); 
      }});
    ask.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    ask.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    ask.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.finish(); 
      }});
    ask.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.ask(); 
      }});

    MenuGroup personalMyPage = new MenuGroup("마이페이지");
    personalMenu.add(personalMyPage);

    MenuGroup myProfile = new MenuGroup("회원정보수정");
    personalMyPage.add(myProfile);

    myProfile.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.checkchange(); 
      }});
    myProfile.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.checkDelete(); 
      }});

    MenuGroup myVolunteer = new MenuGroup("나의 봉사");
    personalMyPage.add(myVolunteer);

    myVolunteer.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    myVolunteer.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});    

    MenuGroup myBoard = new MenuGroup("나의 게시글");
    personalMyPage.add(myBoard);

    MenuGroup myBoardList = new MenuGroup("목록");
    myBoard.add(myBoardList);

    MenuGroup myBoardDetail = new MenuGroup("상세보기");
    myBoard.add(myBoardDetail);

    myBoardDetail.add(new Menu("수정") {
      @Override
      public void execute() {
        boardHandler.checkUpdate(); 
      }});
    myBoardDetail.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.checkDelete(); 
      }});    

    MenuGroup myPoint = new MenuGroup("나의 포인트");
    personalMyPage.add(myPoint);

    myPoint.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});    

    MenuGroup myDonation = new MenuGroup("나의 모금함");
    personalMyPage.add(myDonation);

    myDonation.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});    

    MenuGroup organizationApprove = new MenuGroup("기관 승인 신청");
    personalMyPage.add(organizationApprove);

    organizationApprove.add(new Menu("승인 요청하기") {
      @Override
      public void execute() {
        boardHandler.okSubmit(); 
      }});  

    organizationApprove.add(new Menu("승인 현황보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});   

    MenuGroup cancelMember = new MenuGroup("회원 탈퇴");
    personalMyPage.add(cancelMember);

    cancelMember.add(new Menu("탈퇴") {
      @Override
      public void execute() {
        boardHandler.getOutHere(); 
      }});


    //////////////////////////////////////////////////////////////////////////////////////////////////////    

    MenuGroup organizationMenu = new MenuGroup("기관");
    mainMenuGroup.add(organizationMenu);

    MenuGroup organizationBoardMenu = new MenuGroup("함께해요");
    organizationMenu.add(organizationBoardMenu);

    organizationBoardMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.add(); 
      }});
    organizationBoardMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    organizationBoardMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    organizationBoardMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.update(); 
      }});
    organizationBoardMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.delete(); 
      }});

    MenuGroup organizationMemberMenu = new MenuGroup("소통해요");
    organizationMenu.add(organizationMemberMenu);

    organizationMemberMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        memberHandler.add(); 
      }});
    organizationMemberMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        memberHandler.list(); 
      }});
    organizationMemberMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        memberHandler.detail(); 
      }});
    organizationMemberMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        memberHandler.update(); 
      }});
    organizationMemberMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        memberHandler.delete(); 
      }});

    MenuGroup organizationProjectMenu = new MenuGroup("챌린지");
    organizationMenu.add(organizationProjectMenu);

    organizationProjectMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        projectHandler.add(); 
      }});
    organizationProjectMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        projectHandler.list(); 
      }});
    organizationProjectMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        projectHandler.detail(); 
      }});
    organizationProjectMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        projectHandler.update(); 
      }});
    organizationProjectMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        projectHandler.delete(); 
      }});

    MenuGroup organizationtaskMenu = new MenuGroup("모금함");
    organizationMenu.add(organizationtaskMenu);

    MenuGroup organizationDonationApply = new MenuGroup("모금함 신청");
    organizationtaskMenu.add(organizationDonationApply);

    organizationDonationApply.add(new Menu("등록") {
      @Override
      public void execute() {
        taskHandler.add(); 
      }});
    organizationDonationApply.add(new Menu("목록") {
      @Override
      public void execute() {
        taskHandler.list(); 
      }});

    organizationDonationApply.add(new Menu("상세보기") {
      @Override
      public void execute() {
        taskHandler.detail(); 
      }});
    organizationDonationApply.add(new Menu("변경") {
      @Override
      public void execute() {
        taskHandler.update(); 
      }});
    organizationDonationApply.add(new Menu("삭제") {
      @Override
      public void execute() {
        taskHandler.delete(); 
      }});
    MenuGroup organizationServiceCenter = new MenuGroup("고객센터");
    organizationMenu.add(organizationServiceCenter);

    //////////////////////////////////////////////////////////////////////////////////////////////
    MenuGroup adminMenu = new MenuGroup("관리자");
    mainMenuGroup.add(adminMenu);


    MenuGroup memberMenu = new MenuGroup("회원정보 조회");
    adminMenu.add(memberMenu);

    memberMenu.add(new Menu("회원목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    memberMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    memberMenu.add(new Menu("추방하기") {
      @Override
      public void execute() {
        boardHandler.update(); 
      }});

    MenuGroup donationMenu = new MenuGroup("모금 관리");
    adminMenu.add(donationMenu);

    donationMenu.add(new Menu("신청기관목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    donationMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    donationMenu.add(new Menu("승인") {
      @Override
      public void execute() {
        boardHandler.update(); 
      }});
    donationMenu.add(new Menu("반려") {
      @Override
      public void execute() {
        boardHandler.delete(); 
      }});

    MenuGroup volunteerMenu = new MenuGroup("봉사활동 관리");
    adminMenu.add(volunteerMenu);

    volunteerMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    volunteerMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    volunteerMenu.add(new Menu("승인") {
      @Override
      public void execute() {
        boardHandler.update(); 
      }});
    volunteerMenu.add(new Menu("반려") {
      @Override
      public void execute() {
        boardHandler.delete(); 
      }});


    MenuGroup noticeMenu = new MenuGroup("공지사항 관리");
    adminMenu.add(noticeMenu);

    noticeMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.add(); 
      }});
    noticeMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    noticeMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    noticeMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.update(); 
      }});
    noticeMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.delete(); 
      }});


    MenuGroup askInfo = new MenuGroup("문의사항 관리");
    adminMenu.add(askInfo);

    askInfo.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.add(); 
      }});
    askInfo.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    askInfo.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    askInfo.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.update(); 
      }});
    askInfo.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.delete(); 
      }});

    MenuGroup challengeInfo = new MenuGroup("챌린지 관리");
    adminMenu.add(challengeInfo);

    challengeInfo.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.add(); 
      }});
    challengeInfo.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    challengeInfo.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    challengeInfo.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.update(); 
      }});
    challengeInfo.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.delete(); 
      }});

    MenuGroup approveInfo = new MenuGroup("기관 승인");
    adminMenu.add(approveInfo);

    approveInfo.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    approveInfo.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    approveInfo.add(new Menu("승인") {
      @Override
      public void execute() {
        boardHandler.update(); 
      }});
    approveInfo.add(new Menu("반려") {
      @Override
      public void execute() {
        boardHandler.delete(); 
      }});



    return mainMenuGroup;
  }
}












