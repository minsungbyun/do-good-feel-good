package com.share.ftp.domain.donation;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;


public class DonationRegisterDTO implements Serializable{


  private static final long serialVersionUID = 1L;


  private int no;
  private int userNo;
  private int donationBoardNo;
  private List<DonationRegisterPayType> payTypeNo;
  private int donationMoney;
  private int payStatus;
  private Date registeredDate;
  private String registerationNumber;


  @Override
  public String toString() {
    return "DonationRegisterDTO [no=" + no + ", userNo=" + userNo + ", donationBoardNo="
        + donationBoardNo + ", payTypeNo=" + payTypeNo + ", donationMoney=" + donationMoney
        + ", payStatus=" + payStatus + ", registeredDate=" + registeredDate
        + ", registerationNumber=" + registerationNumber + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getUserNo() {
    return userNo;
  }
  public void setUserNo(int userNo) {
    this.userNo = userNo;
  }
  public int getDonationBoardNo() {
    return donationBoardNo;
  }
  public void setDonationBoardNo(int donationBoardNo) {
    this.donationBoardNo = donationBoardNo;
  }
  public List<DonationRegisterPayType> getPayTypeNo() {
    return payTypeNo;
  }
  public void setPayTypeNo(List<DonationRegisterPayType> payTypeNo) {
    this.payTypeNo = payTypeNo;
  }
  public int getDonationMoney() {
    return donationMoney;
  }
  public void setDonationMoney(int donationMoney) {
    this.donationMoney = donationMoney;
  }
  public int getPayStatus() {
    return payStatus;
  }
  public void setPayStatus(int payStatus) {
    this.payStatus = payStatus;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public String getRegisterationNumber() {
    return registerationNumber;
  }
  public void setRegisterationNumber(String registerationNumber) {
    this.registerationNumber = registerationNumber;
  }
}