package com.share.ftp.domain.donation;

import java.sql.Date;
import com.share.ftp.domain.join.JoinDTO;


public class DonationRegisterDTO {

  private int no;
  private JoinDTO donator;
  private DonationBoardDTO donationBoard;
  private DonationRegisterPayType payTypeNo;
  private int donationMoney;
  private int payStatus;
  private Date registeredDate;
  private String registerationNumber;


  @Override
  public String toString() {
    return "DonationRegisterDTO [no=" + no + ", donator=" + donator + ", donationBoard="
        + donationBoard + ", payTypeNo=" + payTypeNo + ", donationMoney=" + donationMoney
        + ", payStatus=" + payStatus + ", registeredDate=" + registeredDate
        + ", registerationNumber=" + registerationNumber + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public JoinDTO getDonator() {
    return donator;
  }
  public void setDonator(JoinDTO donator) {
    this.donator = donator;
  }
  public DonationBoardDTO getDonationBoard() {
    return donationBoard;
  }
  public void setDonationBoard(DonationBoardDTO donationBoard) {
    this.donationBoard = donationBoard;
  }
  public DonationRegisterPayType getPayTypeNo() {
    return payTypeNo;
  }
  public void setPayTypeNo(DonationRegisterPayType payTypeNo) {
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