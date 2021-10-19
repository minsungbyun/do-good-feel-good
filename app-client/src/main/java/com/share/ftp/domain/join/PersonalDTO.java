package com.share.ftp.domain.join;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


public class PersonalDTO extends JoinDTO implements Serializable {

  private static final long serialVersionUID = 2397935818210730479L;

  private int point; // 유저 포인트
  private int rank = 1; // 유저 랭킹
  private int finalRank; // 유저 랭킹
  private Date birthdate;
  private String level; // 유저등급



  @Override
  public String toString() {
    return "PersonalDTO [point=" + point + ", rank=" + rank + ", finalRank=" + finalRank
        + ", birthdate=" + birthdate + ", level=" + level + "]";
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(birthdate, finalRank, level, point, rank);
    return result;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    PersonalDTO other = (PersonalDTO) obj;
    return Objects.equals(birthdate, other.birthdate) && finalRank == other.finalRank
        && Objects.equals(level, other.level) && point == other.point && rank == other.rank;
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
