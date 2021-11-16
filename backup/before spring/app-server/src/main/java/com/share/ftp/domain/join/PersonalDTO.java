package com.share.ftp.domain.join;

import java.io.Serializable;
import java.sql.Date;


public class PersonalDTO extends JoinDTO implements Serializable {

  private static final long serialVersionUID = 2397935818210730479L;

  private int personalNo;
  private int point; // 유저 포인트
  private int rank = 1; // 유저 랭킹
  private int finalRank; // 유저 랭킹
  private Date birthdate;
  private String level; // 유저등급


  @Override
  public String toString() {
    return "PersonalDTO [personalNo=" + personalNo + ", point=" + point + ", rank=" + rank
        + ", finalRank=" + finalRank + ", birthdate=" + birthdate + ", level=" + level + "]";
  }





  public int getPersonalNo() {
    return personalNo;
  }

  public void setPersonalNo(int personalNo) {
    this.personalNo = personalNo;
  }

  public int getPoint() {
    return point;
  }
  public void setPoint(int point) {
    this.point = point;
  }
  public int getRank() {
    return rank;
  }
  public void setRank(int rank) {
    this.rank = rank;
  }
  public int getFinalRank() {
    return finalRank;
  }
  public void setFinalRank(int finalRank) {
    this.finalRank = finalRank;
  }
  public Date getBirthdate() {
    return birthdate;
  }
  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }
  public String getLevel() {
    return level;
  }
  public void setLevel(String level) {
    this.level = level;
  }

















}
