package com.share.ftp.domain.volunteer;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;


public class VolunteerJoinDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private int volNo;
  private int userNo;
  private int getCount;
  private int applyStatus;
  private Date applyDate;
  private String startTime;
  private String endTime;

  private List<JoinDTO> members = new ArrayList<>(); // 봉사 참여한 멤버들

  private int shortReviewNo;
  private String shortReviewContent;
  private JoinDTO shortReviewOwner;
  private Date registeredDate;





  @Override
  public String toString() {
    return "VolunteerJoinDTO [volNo=" + volNo + ", userNo=" + userNo + ", getCount=" + getCount
        + ", applyStatus=" + applyStatus + ", applyDate=" + applyDate + ", startTime=" + startTime
        + ", endTime=" + endTime + ", note=" + note + ", members=" + members + ", shortReviewNo="
        + shortReviewNo + ", shortReviewContent=" + shortReviewContent + ", shortReviewOwner="
        + shortReviewOwner + ", registeredDate=" + registeredDate + "]";
  }






  public int getVolNo() {
    return volNo;
  }






  public void setVolNo(int volNo) {
    this.volNo = volNo;
  }






  public int getUserNo() {
    return userNo;
  }






  public void setUserNo(int userNo) {
    this.userNo = userNo;
  }






  public int getGetCount() {
    return getCount;
  }






  public void setGetCount(int getCount) {
    this.getCount = getCount;
  }






  public int getApplyStatus() {
    return applyStatus;
  }






  public void setApplyStatus(int applyStatus) {
    this.applyStatus = applyStatus;
  }






  public Date getApplyDate() {
    return applyDate;
  }






  public void setApplyDate(Date applyDate) {
    this.applyDate = applyDate;
  }






  public String getStartTime() {
    return startTime;
  }






  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }






  public String getEndTime() {
    return endTime;
  }






  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }






  public String getNote() {
    return note;
  }






  public void setNote(String note) {
    this.note = note;
  }






  public List<JoinDTO> getMembers() {
    return members;
  }






  public void setMembers(List<JoinDTO> members) {
    this.members = members;
  }






  public int getShortReviewNo() {
    return shortReviewNo;
  }






  public void setShortReviewNo(int shortReviewNo) {
    this.shortReviewNo = shortReviewNo;
  }






  public String getShortReviewContent() {
    return shortReviewContent;
  }






  public void setShortReviewContent(String shortReviewContent) {
    this.shortReviewContent = shortReviewContent;
  }






  public JoinDTO getShortReviewOwner() {
    return shortReviewOwner;
  }






  public void setShortReviewOwner(JoinDTO shortReviewOwner) {
    this.shortReviewOwner = shortReviewOwner;
  }






  public Date getRegisteredDate() {
    return registeredDate;
  }






  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }






  public void addMembers(JoinDTO members) {
    this.members.add(members);
  }

  public void removeMembers(JoinDTO members) {
    this.members.remove(members);
  }


  public String getMemberNames() {
    if (members == null) {
      return "";
    }
    StringBuilder names = new StringBuilder();


    for (JoinDTO joinDTO : members) {
      if (names.length() > 0) {
        names.append("\n");
      }
      names.append(joinDTO.getId()).append("("+joinDTO.getName()+")");
    }
    return names.toString();
  }
}

