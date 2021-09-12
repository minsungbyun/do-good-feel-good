package com.share.ftp.domain;

public class CorpMemberDTO {
  private String userId;
  private String userPassword;
  private String userName;
  private String userTel;
  private String userEmail;
  private String userAddress;

  public String getUserId() {
    return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }
  public String getUserPassword() {
    return userPassword;
  }
  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getUserTel() {
    return userTel;
  }
  public void setUserTel(String userTel) {
    this.userTel = userTel;
  }
  public String getUserEmail() {
    return userEmail;
  }
  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }
  public String getUserAddress() {
    return userAddress;
  }
  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

}
