package com.share.ftp.domain.personal;

import java.sql.Date;

public class DonationRegisterDTO {
  private int no;
<<<<<<< HEAD
  private int donationMoney;
=======
  private int DonationMoney;

>>>>>>> 22dc14b705c1b80efcd4c2cccfc40fc9256607eb
  private String name;
  private String registerationNumber;
  private Date birthDate;
  private String tel;
  private String email;
  private String address;
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
<<<<<<< HEAD
    return donationMoney;
  }
  public void setDonationMoney(int donationMoney) {
    this.donationMoney = donationMoney;
=======
    return DonationMoney;
  }
  public void setDonationMoney(int donationMoney) {
    DonationMoney = donationMoney;
>>>>>>> 22dc14b705c1b80efcd4c2cccfc40fc9256607eb
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