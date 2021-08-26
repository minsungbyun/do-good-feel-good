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
        boardHandler.add(); 
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
        boardHandler.update(); 
      }});
    personalApply.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.delete(); 
      }});

    MenuGroup oragnizationApply = new MenuGroup("기관봉사등록");
    volunteerApply.add(oragnizationApply);

    oragnizationApply.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.add(); 
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
        boardHandler.update(); 
      }});
    oragnizationApply.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.delete(); 
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
        boardHandler.okMessage(); 
      }});
    donation.add(new Menu("기부내역") {
      @Override
      public void execute() {
        boardHandler.donationList(); 
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
        boardHandler.add(); 
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
        boardHandler.update(); 
      }});
    ask.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.delete(); 
      }});

    MenuGroup personalMyPage = new MenuGroup("마이페이지");
    personalMenu.add(personalMyPage);

    MenuGroup MyProfile = new MenuGroup("회원정보수정");
    personalMyPage.add(MyProfile);

    MyProfile.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.update(); 
      }});
    MyProfile.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.delete(); 
      }});

    MenuGroup MyVolunteer = new MenuGroup("나의 봉사");
    personalMyPage.add(MyVolunteer);

    MyVolunteer.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    MyVolunteer.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});    

    MenuGroup MyBoard = new MenuGroup("나의 작성글");
    personalMyPage.add(MyBoard);

    MyBoard.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    MyBoard.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});    

    MenuGroup MyPoint = new MenuGroup("나의 포인트");
    personalMyPage.add(MyPoint);

    MyPoint.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});    

    MenuGroup MyDonation = new MenuGroup("나의 모금함");
    personalMyPage.add(MyDonation);

    MyDonation.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});    

    MenuGroup OrganizationApprove = new MenuGroup("기관 승인 신청");
    personalMyPage.add(OrganizationApprove);

    OrganizationApprove.add(new Menu("상태보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});   

    MenuGroup CancelMember = new MenuGroup("회원 탈퇴");
    personalMyPage.add(CancelMember);

    CancelMember.add(new Menu("탈퇴") {
      @Override
      public void execute() {
        boardHandler.delete(); 
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
        memberHandler.list(); 
      }});
    donationMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        memberHandler.detail(); 
      }});
    donationMenu.add(new Menu("승인") {
      @Override
      public void execute() {
        memberHandler.update(); 
      }});
    donationMenu.add(new Menu("반려") {
      @Override
      public void execute() {
        memberHandler.delete(); 
      }});

    MenuGroup volunteerMenu = new MenuGroup("봉사활동 관리");
    adminMenu.add(volunteerMenu);

    volunteerMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        memberHandler.list(); 
      }});
    volunteerMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        memberHandler.detail(); 
      }});
    volunteerMenu.add(new Menu("승인") {
      @Override
      public void execute() {
        memberHandler.update(); 
      }});
    volunteerMenu.add(new Menu("반려") {
      @Override
      public void execute() {
        memberHandler.delete(); 
      }});


    MenuGroup noticeMenu = new MenuGroup("공지사항 관리");
    adminMenu.add(noticeMenu);

    noticeMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        memberHandler.add(); 
      }});
    noticeMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        memberHandler.list(); 
      }});
    noticeMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        memberHandler.detail(); 
      }});
    noticeMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        memberHandler.update(); 
      }});
    noticeMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        memberHandler.delete(); 
      }});


    MenuGroup askInfo = new MenuGroup("문의사항 관리");
    adminMenu.add(askInfo);

    askInfo.add(new Menu("등록") {
      @Override
      public void execute() {
        taskHandler.add(); 
      }});
    askInfo.add(new Menu("목록") {
      @Override
      public void execute() {
        taskHandler.list(); 
      }});
    askInfo.add(new Menu("상세보기") {
      @Override
      public void execute() {
        taskHandler.detail(); 
      }});
    askInfo.add(new Menu("변경") {
      @Override
      public void execute() {
        taskHandler.update(); 
      }});
    askInfo.add(new Menu("삭제") {
      @Override
      public void execute() {
        taskHandler.delete(); 
      }});

    MenuGroup challengeInfo = new MenuGroup("챌린지 관리");
    adminMenu.add(challengeInfo);

    challengeInfo.add(new Menu("등록") {
      @Override
      public void execute() {
        taskHandler.add(); 
      }});
    challengeInfo.add(new Menu("목록") {
      @Override
      public void execute() {
        taskHandler.list(); 
      }});
    challengeInfo.add(new Menu("상세보기") {
      @Override
      public void execute() {
        taskHandler.detail(); 
      }});
    challengeInfo.add(new Menu("변경") {
      @Override
      public void execute() {
        taskHandler.update(); 
      }});
    challengeInfo.add(new Menu("삭제") {
      @Override
      public void execute() {
        taskHandler.delete(); 
      }});

    MenuGroup approveInfo = new MenuGroup("기관 승인");
    adminMenu.add(approveInfo);

    approveInfo.add(new Menu("목록") {
      @Override
      public void execute() {
        taskHandler.list(); 
      }});
    approveInfo.add(new Menu("상세보기") {
      @Override
      public void execute() {
        taskHandler.detail(); 
      }});
    approveInfo.add(new Menu("승인") {
      @Override
      public void execute() {
        taskHandler.update(); 
      }});
    approveInfo.add(new Menu("반려") {
      @Override
      public void execute() {
        taskHandler.delete(); 
      }});



    return mainMenuGroup;
  }
}












