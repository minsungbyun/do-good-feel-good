package com.share.ftp.domain.personal;

import java.sql.Date;

import com.share.ftp.domain.join.JoinDTO;

public class MyChallengeJoinDTO {
  private JoinDTO joiner;
  public Date registeredDate;

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
