package com.share.ftp.domain.personal;

import java.sql.Date;
import java.util.Objects;

public class OrgRequestDTO {

  private int no;
  private String title;
  private String owner; // 나중에 JoinDTO 변경 예정
  private String sort;
  private String tel;
  private String email;
  private Date volStartDate;
  private Date volEndDate;
  private String volStartTime;
  private String volEndTime;
  private String volList;
  private int joinNum;
  private String content;
  private String fileUpload;
  private boolean isPersonal;
  private boolean isOrg;
  private boolean isChecked;
  private String isSigned;
  private Date volSubmitTime;
  @Override
  public int hashCode() {
    return Objects.hash(content, email, fileUpload, isChecked, isOrg, isPersonal, isSigned, joinNum,
        no, owner, sort, tel, title, volEndDate, volEndTime, volList, volStartDate, volStartTime,
        volSubmitTime);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OrgRequestDTO other = (OrgRequestDTO) obj;
    return Objects.equals(content, other.content) && Objects.equals(email, other.email)
        && Objects.equals(fileUpload, other.fileUpload) && isChecked == other.isChecked
        && isOrg == other.isOrg && isPersonal == other.isPersonal
        && Objects.equals(isSigned, other.isSigned) && joinNum == other.joinNum && no == other.no
        && Objects.equals(owner, other.owner) && Objects.equals(sort, other.sort)
        && Objects.equals(tel, other.tel) && Objects.equals(title, other.title)
        && Objects.equals(volEndDate, other.volEndDate)
        && Objects.equals(volEndTime, other.volEndTime) && Objects.equals(volList, other.volList)
        && Objects.equals(volStartDate, other.volStartDate)
        && Objects.equals(volStartTime, other.volStartTime)
        && Objects.equals(volSubmitTime, other.volSubmitTime);
  }
  @Override
  public String toString() {
    return "OrgRequestDTO [no=" + no + ", title=" + title + ", owner=" + owner + ", sort=" + sort
        + ", tel=" + tel + ", email=" + email + ", volStartDate=" + volStartDate + ", volEndDate="
        + volEndDate + ", volStartTime=" + volStartTime + ", volEndTime=" + volEndTime
        + ", volList=" + volList + ", joinNum=" + joinNum + ", content=" + content + ", fileUpload="
        + fileUpload + ", isPersonal=" + isPersonal + ", isOrg=" + isOrg + ", isChecked="
        + isChecked + ", isSigned=" + isSigned + ", volSubmitTime=" + volSubmitTime + "]";
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
  public void setTitle(String title) {
    this.title = title;
  }
  public String getOwner() {
    return owner;
  }
  public void setOwner(String owner) {
    this.owner = owner;
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
  public Date getVolStartDate() {
    return volStartDate;
  }
  public void setVolStartDate(Date volStartDate) {
    this.volStartDate = volStartDate;
  }
  public Date getVolEndDate() {
    return volEndDate;
  }
  public void setVolEndDate(Date volEndDate) {
    this.volEndDate = volEndDate;
  }
  public String getVolStartTime() {
    return volStartTime;
  }
  public void setVolStartTime(String volStartTime) {
    this.volStartTime = volStartTime;
  }
  public String getVolEndTime() {
    return volEndTime;
  }
  public void setVolEndTime(String volEndTime) {
    this.volEndTime = volEndTime;
  }
  public String getVolList() {
    return volList;
  }
  public void setVolList(String volList) {
    this.volList = volList;
  }
  public int getJoinNum() {
    return joinNum;
  }
  public void setJoinNum(int joinNum) {
    this.joinNum = joinNum;
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
  public boolean isPersonal() {
    return isPersonal;
  }
  public void setPersonal(boolean isPersonal) {
    this.isPersonal = isPersonal;
  }
  public boolean isOrg() {
    return isOrg;
  }
  public void setOrg(boolean isOrg) {
    this.isOrg = isOrg;
  }
  public boolean isChecked() {
    return isChecked;
  }
  public void setChecked(boolean isChecked) {
    this.isChecked = isChecked;
  }
  public String getIsSigned() {
    return isSigned;
  }
  public void setIsSigned(String isSigned) {
    this.isSigned = isSigned;
  }
  public Date getVolSubmitTime() {
    return volSubmitTime;
  }
  public void setVolSubmitTime(Date volSubmitTime) {
    this.volSubmitTime = volSubmitTime;
  }




}
