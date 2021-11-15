package com.share.ftp.domain.join;

import java.sql.Date;


public class JoinDTO {


  private int no;
  private int type; // 1. 개인, 2. 기관, 3. 그룹
  private int donationMoney; // 유저 기부금액
  private int adminPassword = -1;
  private String id;
  private String password;
  private String name;
  private String tel;
  private String email;
  private String postNo;
  private String basicAddress;
  private String detailAddress;
  private int status;
  private String note;
  private Date registerDate;
  private String photo;


  @Override
  public String toString() {
    return "JoinDTO [no=" + no + ", type=" + type + ", donationMoney=" + donationMoney
        + ", adminPassword=" + adminPassword + ", id=" + id + ", password=" + password + ", name="
        + name + ", tel=" + tel + ", email=" + email + ", postNo=" + postNo + ", basicAddress="
        + basicAddress + ", detailAddress=" + detailAddress + ", status=" + status + ", note="
        + note + ", registerDate=" + registerDate + ", photo=" + photo + "]";
  }


  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getType() {
    return type;
  }
  public void setType(int type) {
    this.type = type;
  }
  public int getDonationMoney() {
    return donationMoney;
  }
  public void setDonationMoney(int donationMoney) {
    this.donationMoney = donationMoney;
  }
  public int getAdminPassword() {
    return adminPassword;
  }
  public void setAdminPassword(int adminPassword) {
    this.adminPassword = adminPassword;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
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
  public String getPostNo() {
    return postNo;
  }
  public void setPostNo(String postNo) {
    this.postNo = postNo;
  }
  public String getBasicAddress() {
    return basicAddress;
  }
  public void setBasicAddress(String basicAddress) {
    this.basicAddress = basicAddress;
  }
  public String getDetailAddress() {
    return detailAddress;
  }
  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
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
  public Date getRegisterDate() {
    return registerDate;
  }
  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }

}
