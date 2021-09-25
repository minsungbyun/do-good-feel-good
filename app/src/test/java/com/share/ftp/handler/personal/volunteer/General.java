package com.share.ftp.handler.personal.volunteer;

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

    public static final int PERSONAL = 1;
    public static final int AUTH_PERSONAL = 2;
    public static final int ORG      = 3;
    public static final int GROUP    = 4;
  }

  public static class check {
    public static final String Waiting    = "승인대기";
    public static final String Applied    = "승인됨";
    public static final String Rejected   = "반려됨";
  }

  public static class point {
    public static final int CHALLENGE_POINT = 100;
    public static final int CHALLENGE_REVIEWPOINT = 10;
  }




}
