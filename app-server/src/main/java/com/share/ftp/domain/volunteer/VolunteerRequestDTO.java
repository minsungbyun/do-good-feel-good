package com.share.ftp.domain.volunteer;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.join.JoinDTO;


public class VolunteerRequestDTO {

  private int no;
  private JoinDTO owner;
  private Category category;
  private String title;
  private String content;
  private String tel;
  private String email;
  private Date startDate;
  private Date endDate;
  private String startTime;
  private String endTime;
  private int limitNum; // 총 정원
  private int status;
  private String note;
  private List<VolunteerAttachedFile> fileUpload;
  private JoinDTO wish;
  private String photo;

  private String totalDate;
  private String remainDate;
  private int currentNum = 1; // 현재 참여 인원 (주최자는 미리 포함)



  @Override
  public String toString() {
    return "VolunteerRequestDTO [no=" + no + ", owner=" + owner + ", category=" + category
        + ", title=" + title + ", content=" + content + ", tel=" + tel + ", email=" + email
        + ", startDate=" + startDate + ", endDate=" + endDate + ", startTime=" + startTime
        + ", endTime=" + endTime + ", limitNum=" + limitNum + ", status=" + status + ", note="
        + note + ", fileUpload=" + fileUpload + ", wish=" + wish + ", photo=" + photo
        + ", totalDate=" + totalDate + ", remainDate=" + remainDate + ", currentNum=" + currentNum
        + "]";
  }


  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public JoinDTO getOwner() {
    return owner;
  }
  public void setOwner(JoinDTO owner) {
    this.owner = owner;
  }
  public Category getCategory() {
    return category;
  }
  public void setCategory(Category category) {
    this.category = category;
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
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
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
  public int getLimitNum() {
    return limitNum;
  }
  public void setLimitNum(int limitNum) {
    this.limitNum = limitNum;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }
  public List<VolunteerAttachedFile> getFileUpload() {
    return fileUpload;
  }
  public void setFileUpload(List<VolunteerAttachedFile> fileUpload) {
    this.fileUpload = fileUpload;
  }
  public JoinDTO getWish() {
    return wish;
  }
  public void setWish(JoinDTO wish) {
    this.wish = wish;
  }
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
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
  public int getCurrentNum() {
    return currentNum;
  }
  public void setCurrentNum(int currentNum) {
    this.currentNum = currentNum;
  }




}

