package com.share.ftp.domain.challenge;

import java.sql.Date;

import com.share.ftp.domain.join.JoinDTO;

public class ChallengeJoinDTO {
  private String userId;
  private JoinDTO joiner;
  public Date registeredDate;

  @Override
  public String toString() {
    return "ChallengeJoinDTO [userId=" + userId + ", joiner=" + joiner + ", registeredDate=" + registeredDate + "]";
}


  public String getUserId() {
    return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }
  public JoinDTO getJoiner() {
    return joiner;
  }
  public void setJoiner(JoinDTO joiner) {
    this.joiner = joiner;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
}
