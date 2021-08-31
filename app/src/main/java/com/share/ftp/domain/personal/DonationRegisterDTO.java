package com.share.ftp.domain.personal;

import java.sql.Date;
import java.util.Objects;

public class DonationRegisterDTO {
  private int no;
  private int donationMoney;
  private String name;
  private String registerationNumber;
  private Date birthDate;
  private String tel;
  private String email;
  private String address;

  @Override
  public String toString() {
    return "DonationRegisterDTO [no=" + no + ", donationMoney=" + donationMoney + ", name=" + name
        + ", registerationNumber=" + registerationNumber + ", birthDate=" + birthDate + ", tel="
        + tel + ", email=" + email + ", address=" + address + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, birthDate, donationMoney, email, name, no, registerationNumber,
        tel);
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
        && Objects.equals(tel, other.tel);
  }


  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public int getDonationMoney() {
    return donationMoney;
  }
  public void setDonationMoney(int donationMoney) {
    this.donationMoney = donationMoney;
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


}