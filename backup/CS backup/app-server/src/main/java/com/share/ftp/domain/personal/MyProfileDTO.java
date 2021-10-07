package com.share.ftp.domain.personal;

import java.util.Objects;

public class MyProfileDTO {
  public String photo;
  public String password;
  public String email;
  public String adress;

  @Override
  public String toString() {
    return "MyProfileDTO [photo=" + photo + ", password=" + password + ", email=" + email
        + ", adress=" + adress + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(adress, email, password, photo);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    MyProfileDTO other = (MyProfileDTO) obj;
    return Objects.equals(adress, other.adress) && Objects.equals(email, other.email)
        && Objects.equals(password, other.password) && Objects.equals(photo, other.photo);
  }

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
