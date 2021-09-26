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
    public static final int AUTH_PERSONAL   = 2;
    public static final int ORG             = 3;
    public static final int GROUP           = 4;
  }

  public static class check {

    public static final String Waiting    = "승인대기";
    public static final String Applied    = "승인됨";
    public static final String Rejected   = "반려됨";
  }

  public static class point {

    public static final int VOLUNTEER_POINT         = 100;
    public static final int VOLUNTEER_REVIEWPOINT   = 10;
    public static final int CHALLENGE_POINT         = 100;
    public static final int CHALLENGE_REVIEWPOINT   = 10;
  }

  public static class level {

    public static final String LEVEL_A = "a등급";
    public static final String LEVEL_B = "b등급";
    public static final String LEVEL_C = "c등급";
    public static final String LEVEL_D = "d등급";
    public static final String LEVEL_E = "e등급";
  }

  public static class questionType {
    public static final String VOLUNTEERASK   = "함께해요 문의";
    public static final String COMMUITYASK    = "나눔이야기 문의";
    public static final String DONATIONASK    = "모금함 문의";
    public static final String CHALLENGEASK   = "챌린지 문의";
    public static final String SITEASK        = "사이트이용 문의";
    public static final String OTHERASK       = "기타 문의";
  }



}
