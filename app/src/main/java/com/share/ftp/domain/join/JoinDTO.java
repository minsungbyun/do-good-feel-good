package com.share.ftp.domain.join;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@SuppressWarnings("serial")
public class JoinDTO implements Serializable {


  private int no;
  private String id;
  private String password;
  private String name;
  private Date birthdate;
  private String tel;
  private String email;
  private String address;
  private Date registerDate;
  private boolean isAdmin;
  private boolean isPersonal;
  private boolean isOrg;
  private int authNum = 1004; // getter setter 만 적용했음
  @Override
  public int hashCode() {
    return Objects.hash(address, authNum, birthdate, email, id, isAdmin, isOrg, isPersonal, name,
        no, password, registerDate, tel);
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
        && Objects.equals(birthdate, other.birthdate) && Objects.equals(email, other.email)
        && Objects.equals(id, other.id) && isAdmin == other.isAdmin && isOrg == other.isOrg
        && isPersonal == other.isPersonal && Objects.equals(name, other.name) && no == other.no
        && Objects.equals(password, other.password)
        && Objects.equals(registerDate, other.registerDate) && Objects.equals(tel, other.tel);
  }
  @Override
  public String toString() {
    return "JoinDTO [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name
        + ", birthdate=" + birthdate + ", tel=" + tel + ", email=" + email + ", address=" + address
        + ", registerDate=" + registerDate + ", isAdmin=" + isAdmin + ", isPersonal=" + isPersonal
        + ", isOrg=" + isOrg + ", authNum=" + authNum + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
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
  public boolean isAdmin() {
    return isAdmin;
  }
  public void setAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
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
  public int getAuthNum() {
    return authNum;
  }
  public void setAuthNum(int authNum) {
    this.authNum = authNum;
  }










}
