package com.share.ftp.domain.guest;

import java.util.Objects;

public class LoginDTO {
  private String memberId;
  private int password;

  @Override
  public int hashCode() {
    return Objects.hash(memberId, password);
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
    return Objects.equals(memberId, other.memberId) && password == other.password;
  }

  @Override
  public String toString() {
    return "LoginDTO [meberId=" + memberId + ", password=" + password + "]";
  }

  public String getMeberId() {
    return memberId;
  }
  public void setMeberId(String meberId) {
    this.memberId = meberId;
  }
  public int getPassword() {
    return password;
  }
  public void setPassword(int password) {
    this.password = password;
  }

}
