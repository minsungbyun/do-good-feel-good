package com.share.ftp.domain;

import java.sql.Date;

public class OrgRequestDTO {

  private int no;
  private String title;
  private String sort;
  private String tel;
  private String email;
  private Date volunteerPeriod;
  private Date volunteerTime;
  private String volunteerList;
  private String content;
  private String fileUpload;
  private boolean isOrg;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getSort() {
    return sort;
  }
  public void setSort(String sort) {
    this.sort = sort;
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
  public Date getVolunteerPeriod() {
    return volunteerPeriod;
  }
  public void setVolunteerPeriod(Date volunteerPeriod) {
    this.volunteerPeriod = volunteerPeriod;
  }
  public Date getVolunteerTime() {
    return volunteerTime;
  }
  public void setVolunteerTime(Date volunteerTime) {
    this.volunteerTime = volunteerTime;
  }
  public String getVolunteerList() {
    return volunteerList;
  }
  public void setVolunteerList(String volunteerList) {
    this.volunteerList = volunteerList;
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
  public boolean isOrg() {
    return isOrg;
  }
  public void setIsOrg(boolean isOrg) {
    this.isOrg = isOrg;
  }




}
