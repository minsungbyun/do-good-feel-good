package com.share.ftp.domain.admin;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;


public class ChallengeDTO implements Serializable{


  private static final long serialVersionUID = 1L;
  private int no;
  private int reviewCount;
  private int point;
  private JoinDTO admin;
  private String title;
  private String content;
  private String fileUpload;
  private Date registeredDate;
  private Date startDate;
  private Date endDate;
  private int viewCount;
  private int questionCount;
  private int totalJoinCount;
  private boolean isChecked;
  private int like;
  private JoinDTO wish;
  private List<JoinDTO> members = new ArrayList<>();  // 관리자가 등록한 챌린지에 참여한 멤버
  private List<JoinDTO> reviewers = new ArrayList<>();







  @Override
  public int hashCode() {
    return Objects.hash(admin, content, endDate, fileUpload, isChecked, like, members, no, point,
        questionCount, registeredDate, reviewCount, reviewers, startDate, title, totalJoinCount,
        viewCount, wish);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ChallengeDTO other = (ChallengeDTO) obj;
    return Objects.equals(admin, other.admin) && Objects.equals(content, other.content)
        && Objects.equals(endDate, other.endDate) && Objects.equals(fileUpload, other.fileUpload)
        && isChecked == other.isChecked && like == other.like
        && Objects.equals(members, other.members) && no == other.no && point == other.point
        && questionCount == other.questionCount
        && Objects.equals(registeredDate, other.registeredDate) && reviewCount == other.reviewCount
        && Objects.equals(reviewers, other.reviewers) && Objects.equals(startDate, other.startDate)
        && Objects.equals(title, other.title) && totalJoinCount == other.totalJoinCount
        && viewCount == other.viewCount && Objects.equals(wish, other.wish);
  }
  @Override
  public String toString() {
    return "ChallengeDTO [no=" + no + ", reviewCount=" + reviewCount + ", point=" + point
        + ", admin=" + admin + ", title=" + title + ", content=" + content + ", fileUpload="
        + fileUpload + ", registeredDate=" + registeredDate + ", startDate=" + startDate
        + ", endDate=" + endDate + ", viewCount=" + viewCount + ", questionCount=" + questionCount
        + ", totalJoinCount=" + totalJoinCount + ", isChecked=" + isChecked + ", like=" + like
        + ", wish=" + wish + ", members=" + members + ", reviewers=" + reviewers + "]";
  }
  public JoinDTO getWish() {
    return wish;
  }
  public void setWish(JoinDTO wish) {
    this.wish = wish;
  }
  public int getLike() {
    return like;
  }
  public void setLike(int like) {
    this.like = like;
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public JoinDTO getAdmin() {
    return admin;
  }
  public void setAdmin(JoinDTO admin) {
    this.admin = admin;
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
  public String getFileUpload() {
    return fileUpload;
  }
  public void setFileUpload(String fileUpload) {
    this.fileUpload = fileUpload;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public List<JoinDTO> getMembers() {
    return members;
  }
  public void setMembers(List<JoinDTO> members) {
    this.members = members;
  }





  public int getPoint() {
    return point;
  }
  public void setPoint(int point) {
    this.point = point;
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



  public int getTotalJoinCount() {
    return totalJoinCount;
  }
  public void setTotalJoinCount(int totalJoinCount) {
    this.totalJoinCount = totalJoinCount;
  }


  public List<JoinDTO> getReviewers() {
    return reviewers;
  }
  public void setReviewers(List<JoinDTO> reviewers) {
    this.reviewers = reviewers;
  }

  public void addMembers(JoinDTO member) {
    this.members.add(member);
  }
  public void removeMembers(JoinDTO member) {
    this.members.remove(member);
  }

  public void addReviewer(JoinDTO reviwer) {
    this.reviewers.add(reviwer);
  }

  public void removeReviewer(JoinDTO reviwer) {
    this.reviewers.remove(reviwer);
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
  public boolean isChecked() {
    return isChecked;
  }
  public void setChecked(boolean isChecked) {
    this.isChecked = isChecked;
  }

}
