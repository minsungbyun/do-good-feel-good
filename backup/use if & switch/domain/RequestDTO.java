package com.share.ftp.domain;

import java.util.Date;

public class RequestDTO {

  private String title;
  private String sort;
  private String tel;
  private String email;
  private Date period;
  private String hour;
  private String volunteerList;
  private String content;
  private String photo;
  private boolean isChecked;

  public boolean isChecked() {
    return isChecked;
  }
  public void setChecked(boolean isChecked) {
    this.isChecked = isChecked;
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
  public Date getPeriod() {
    return period;
  }
  public void setPeriod(Date period) {
    this.period = period;
  }
  public String getHour() {
    return hour;
  }
  public void setHour(String hour) {
    this.hour = hour;
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
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }





}
