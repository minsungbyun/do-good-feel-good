package com.share.ftp.domain.join;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


public abstract class JoinDTO implements Serializable {

  private static final long serialVersionUID = 2397935818210730479L;

  private int no;
  private int type; // 1. 개인, 2. 기관, 3. 그룹
  private int donationMoney; // 유저 기부금액
  private int adminPassword = -1;
  private String id;
  private String password;
  private String name;
  private String tel;
  private String email;
  private int postNo;
  private String basicAddress;
  private String detailAddress;
  private int status;
  private String note;
  private Date registerDate;





  @Override
  public String toString() {
    return "JoinDTO [no=" + no + ", type=" + type + ", donationMoney=" + donationMoney
        + ", adminPassword=" + adminPassword + ", id=" + id + ", password=" + password + ", name="
        + name + ", tel=" + tel + ", email=" + email + ", postNo=" + postNo + ", basicAddress="
        + basicAddress + ", detailAddress=" + detailAddress + ", status=" + status + ", note="
        + note + ", registerDate=" + registerDate + "]";
  }
  @Override
  public int hashCode() {
    return Objects.hash(adminPassword, basicAddress, detailAddress, donationMoney, email, id, name,
        no, note, password, postNo, registerDate, status, tel, type);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    JoinDTO other = (JoinDTO) obj;
    return adminPassword == other.adminPassword && Objects.equals(basicAddress, other.basicAddress)
        && Objects.equals(detailAddress, other.detailAddress)
        && donationMoney == other.donationMoney && Objects.equals(email, other.email)
        && Objects.equals(id, other.id) && Objects.equals(name, other.name) && no == other.no
        && Objects.equals(note, other.note) && Objects.equals(password, other.password)
        && postNo == other.postNo && Objects.equals(registerDate, other.registerDate)
        && status == other.status && Objects.equals(tel, other.tel) && type == other.type;
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
  public int getPostNo() {
    return postNo;
  }
  public void setPostNo(int postNo) {
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
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }














}
