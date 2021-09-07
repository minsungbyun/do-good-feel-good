package com.share.ftp.domain.personal;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@SuppressWarnings("serial")
public class DonationRegisterDTO implements Serializable{
  private int no;
  private int donationMoney;
  private String name;
  private String registerationNumber;
  private Date birthDate;
  private String tel;
  private String email;
  private String address;
  private Date registeredDate;
  private int sort;

  @Override
  public int hashCode() {
    return Objects.hash(address, birthDate, donationMoney, email, name, no, registerationNumber,
        registeredDate, sort, tel);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DonationRegisterDTO other = (DonationRegisterDTO) obj;
    return Objects.equals(address, other.address) && Objects.equals(birthDate, other.birthDate)
        && donationMoney == other.donationMoney && Objects.equals(email, other.email)
        && Objects.equals(name, other.name) && no == other.no
        && Objects.equals(registerationNumber, other.registerationNumber)
        && Objects.equals(registeredDate, other.registeredDate) && sort == other.sort
        && Objects.equals(tel, other.tel);
  }
  @Override
  public String toString() {
    return "DonationRegisterDTO [no=" + no + ", donationMoney=" + donationMoney + ", name=" + name
        + ", registerationNumber=" + registerationNumber + ", birthDate=" + birthDate + ", tel="
        + tel + ", email=" + email + ", address=" + address + ", registeredDate=" + registeredDate
        + ", sort=" + sort + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getDonationMoney() {
    return donationMoney;
  }
  public void setDonationMoney(int donationMoney) {
    this.donationMoney = donationMoney;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getRegisterationNumber() {
    return registerationNumber;
  }
  public void setRegisterationNumber(String registerationNumber) {
    this.registerationNumber = registerationNumber;
  }
  public Date getBirthDate() {
    return birthDate;
  }
  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
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
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public int getSort() {
    return sort;
  }
  public void setSort(int sort) {
    this.sort = sort;
  }
}