package com.share.ftp.domain.personal;

import java.sql.Date;
import java.util.List;

import com.share.ftp.domain.join.JoinDTO;

public class MyChallengeJoinDTO {
  private String userId;
  private JoinDTO joiner;
  public Date registeredDate;
  private List<JoinDTO> members;

  @Override
  public String toString() {
    return "MyChallengeJoinDTO [userId=" + userId + ", joiner=" + joiner + ", registeredDate=" + registeredDate
            + ", members=" + members + "]";
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
  public List<JoinDTO> getMembers() {
    return members;
  }
  public void setMembers(List<JoinDTO> members) {
    this.members = members;
  }
}
