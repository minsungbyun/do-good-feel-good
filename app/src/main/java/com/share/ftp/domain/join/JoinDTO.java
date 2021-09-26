package com.share.ftp.domain.join;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


public class JoinDTO implements Serializable {

  private static final long serialVersionUID = 2397935818210730479L;

  private int no;
  private int type; // 1. 개인, 2. 기관, 3. 그룹
  private int point; // 유저 포인트
  private int donationMoney; // 유저 기부금액
  private int authNum = 1004; 
  private String id;
  private String password;
  private String name;
  private Date birthdate;
  private String tel;
  private String email;
  private String address;
  private Date registerDate;
  private String level; // 유저등급









  @Override
  public String toString() {
    return "JoinDTO [no=" + no + ", type=" + type + ", point=" + point + ", donationMoney="
        + donationMoney + ", authNum=" + authNum + ", id=" + id + ", password=" + password
        + ", name=" + name + ", birthdate=" + birthdate + ", tel=" + tel + ", email=" + email
        + ", address=" + address + ", registerDate=" + registerDate + ", level=" + level + "]";
  }
  @Override
  public int hashCode() {
    return Objects.hash(address, authNum, birthdate, donationMoney, email, id, level, name, no,
        password, point, registerDate, tel, type);
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
    return Objects.equals(address, other.address) && authNum == other.authNum
        && Objects.equals(birthdate, other.birthdate) && donationMoney == other.donationMoney
        && Objects.equals(email, other.email) && Objects.equals(id, other.id)
        && Objects.equals(level, other.level) && Objects.equals(name, other.name) && no == other.no
        && Objects.equals(password, other.password) && point == other.point
        && Objects.equals(registerDate, other.registerDate) && Objects.equals(tel, other.tel)
        && type == other.type;
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
  public int getPoint() {
    return point;
  }
  public void setPoint(int point) {
    this.point = point;
  }
  public int getAuthNum() {
    return authNum;
  }
  public void setAuthNum(int authNum) {
    this.authNum = authNum;
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
  public Date getBirthdate() {
    return birthdate;
  }
  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
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
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public Date getRegisterDate() {
    return registerDate;
  }
  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }
  public String getLevel() {
    return level;
  }
  public void setLevel(String level) {
    this.level = level;
  }
  public int getDonationMoney() {
    return donationMoney;
  }
  public void setDonationMoney(int donationMoney) {
    this.donationMoney = donationMoney;
  }











}
