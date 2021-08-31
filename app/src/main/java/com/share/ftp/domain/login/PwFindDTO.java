package com.share.ftp.domain.login;

import java.util.Objects;

public class PwFindDTO {
  private String name;
  private String tel;

  @Override
  public int hashCode() {
    return Objects.hash(name, tel);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PwFindDTO other = (PwFindDTO) obj;
    return Objects.equals(name, other.name) && Objects.equals(tel, other.tel);
  }

  @Override
  public String toString() {
    return "PwFindDTO [name=" + name + ", tel=" + tel + "]";
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }


}
