package com.share.ftp.domain.admin;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;


public class ChallengeDTO {

  private int no;
  private int point;
  private String title;
  private String content;
  private String totalDate;
  private String remainDate;
  private Date registeredDate;
  private Date applyDate;
  private Date startDate;
  private Date endDate;
  private int viewCount;
  private int reviewCount;
  private int questionCount;
  private int totalJoinCount;
  private JoinDTO wish;
  private List<JoinDTO> members;  // 관리자가 등록한 챌린지에 참여한 멤버
  private List<ChallengeAttachedFile> fileUpload;


  @Override
  public String toString() {
    return "ChallengeDTO [no=" + no + ", point=" + point + ", title=" + title + ", content="
        + content + ", totalDate=" + totalDate + ", remainDate=" + remainDate + ", registeredDate="
        + registeredDate + ", applyDate=" + applyDate + ", startDate=" + startDate + ", endDate="
        + endDate + ", viewCount=" + viewCount + ", reviewCount=" + reviewCount + ", questionCount="
        + questionCount + ", totalJoinCount=" + totalJoinCount + ", wish=" + wish + ", members="
        + members + ", fileUpload=" + fileUpload + "]";
  }

  public Date getApplyDate() {
    return applyDate;
  }
  public void setApplyDate(Date applyDate) {
    this.applyDate = applyDate;
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getPoint() {
    return point;
  }
  public void setPoint(int point) {
    this.point = point;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getTotalDate() {
    return totalDate;
  }
  public void setTotalDate(String totalDate) {
    this.totalDate = totalDate;
  }
  public String getRemainDate() {
    return remainDate;
  }
  public void setRemainDate(String remainDate) {
    this.remainDate = remainDate;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public int getReviewCount() {
    return reviewCount;
  }
  public void setReviewCount(int reviewCount) {
    this.reviewCount = reviewCount;
  }
  public int getQuestionCount() {
    return questionCount;
  }
  public void setQuestionCount(int questionCount) {
    this.questionCount = questionCount;
  }
  public int getTotalJoinCount() {
    return totalJoinCount;
  }
  public void setTotalJoinCount(int totalJoinCount) {
    this.totalJoinCount = totalJoinCount;
  }
  public JoinDTO getWish() {
    return wish;
  }
  public void setWish(JoinDTO wish) {
    this.wish = wish;
  }
  public List<JoinDTO> getMembers() {
    return members;
  }
  public void setMembers(List<JoinDTO> members) {
    this.members = members;
  }
  public List<ChallengeAttachedFile> getFileUpload() {
    return fileUpload;
  }
  public void setFileUpload(List<ChallengeAttachedFile> fileUpload) {
    this.fileUpload = fileUpload;
  }





}
