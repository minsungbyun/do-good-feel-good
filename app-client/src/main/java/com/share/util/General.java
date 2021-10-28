package com.share.util;

public class General {

  public static class type {   

    public static final String UNTACT       = "비대면";
    public static final String CHILDREN     = "아동";
    public static final String TEEN         = "청소년";
    public static final String ELDER        = "노인";
    public static final String HANDICAPPED  = "장애인";
    public static final String ANIMAL       = "동물";
    public static final String ENVIRONMENT  = "환경";
    public static final String OTHER        = "기타";
  }

  public static class member {

    public static final int PERSONAL        = 1;
    public static final int GROUP           = 2;
    public static final int ORG             = 3;
  }

  public static class status {

    public static final int WITHDRAW        = 0; // 탈퇴회원
    public static final int ACTIVE          = 1; // 가입완료
    public static final int WAIT            = 2; // 승인대기
    public static final int REJECT          = 3; // 승인반려
    public static final int INACTIVE        = 4; // 휴면회원
  }

  public static class check {

    public static final int REJECTED   = 0; // 반려됨
    public static final int APPLIED    = 1; // 승인됨
    public static final int WAITING    = 2; // 승인대기
  }

  public static class point {

    public static final int VOLUNTEER_POINT         = 50;
    public static final int VOLUNTEER_REVIEWPOINT   = 10;

    //    public static final int COMMUNITY_POINT         = 10;
    //    public static final int COMMUNITY_REVIEWPOINT   = 1;

    //    public static final int CHALLENGE_POINT         = 100;
    public static final int CHALLENGE_REVIEWPOINT   = 30;

    public static final int DONATION_POINT          = 50;

  }

  public static class level {
    // 기준 같이 정할 것 
    public static final String LEVEL_A  = "천사콩이";
    public static final String LEVEL_B  = "천삼콩이";
    public static final String LEVEL_C  = "천이콩이";
    public static final String LEVEL_D  = "천일콩이";
    public static final String LEVEL_E  = "천콩이";

    public static final int FROM_B_TO_A  = 10000;
    public static final int FROM_C_TO_B  = 5000;
    public static final int FROM_D_TO_C  = 1000;
    public static final int FROM_E_TO_D  = 0;

  }

  public static class questionType {

    public static final String VOLUNTEERQNA    = "함께해요 문의";
    public static final String COMMUITYQNA     = "나눔이야기 문의";
    public static final String DONATIONQNA     = "모금함 문의";
    public static final String CHALLENGEQNA    = "챌린지 문의";
    public static final String SITEQNA         = "사이트이용 문의";
    public static final String OTHERQNA        = "기타 문의";

  }

  public static class qnaStatus {

    public static final int UNANSWERED   = 0; // 미답변
    public static final int ANSWER    = 1; // 답변완료
  }



}
