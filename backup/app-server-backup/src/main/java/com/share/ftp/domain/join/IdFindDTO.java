package com.share.ftp.domain.join;

import java.util.Objects;

public class IdFindDTO {
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
    IdFindDTO other = (IdFindDTO) obj;
    return Objects.equals(name, other.name) && Objects.equals(tel, other.tel);
  }

  @Override
  public String toString() {
    return "IdFindDTO [name=" + name + ", tel=" + tel + "]";
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
