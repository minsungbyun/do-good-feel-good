package com.share.ftp.domain.guest;

import java.sql.Date;
import java.util.Objects;

public class JoinDTO {
  private String id;
  private String password;
  private String name;
  private String tel;
  private String email;
  private String adress;
  private Date registerDate;
  public String getId() {
    return id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(adress, email, id, name, password, registerDate, tel);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    JoinDTO other = (JoinDTO) obj;
    return Objects.equals(adress, other.adress) && Objects.equals(email, other.email)
        && Objects.equals(id, other.id) && Objects.equals(name, other.name)
        && Objects.equals(password, other.password)
        && Objects.equals(registerDate, other.registerDate) && Objects.equals(tel, other.tel);
  }

  @Override
  public String toString() {
    return "JoinDTO [id=" + id + ", password=" + password + ", name=" + name + ", tel=" + tel
        + ", email=" + email + ", adress=" + adress + ", registerDate=" + registerDate + "]";
  }

  public void setId(String id) {
    this.id = id;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
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
  public Date getRegisterDate() {
    return registerDate;
  }
  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }


}
