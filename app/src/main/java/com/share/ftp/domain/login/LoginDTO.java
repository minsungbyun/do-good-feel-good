package com.share.ftp.domain.login;

import java.util.Objects;

public class LoginDTO {
  private String meberId;
  private int password;

  @Override
  public int hashCode() {
    return Objects.hash(meberId, password);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    LoginDTO other = (LoginDTO) obj;
    return Objects.equals(meberId, other.meberId) && password == other.password;
  }

  @Override
  public String toString() {
    return "LoginDTO [meberId=" + meberId + ", password=" + password + "]";
  }

  public String getMeberId() {
    return meberId;
  }
  public void setMeberId(String meberId) {
    this.meberId = meberId;
  }
  public int getPassword() {
    return password;
  }
  public void setPassword(int password) {
    this.password = password;
  }

}
