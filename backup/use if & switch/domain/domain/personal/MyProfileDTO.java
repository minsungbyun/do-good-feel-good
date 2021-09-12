package com.share.ftp.domain.personal;

public class MyProfileDTO {
  public String photo;
  public String password;
  public String email;
  public String adress;

  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getAdress() {
    return adress;
  }
  public void setAdress(String adress) {
    this.adress = adress;
  }
}
