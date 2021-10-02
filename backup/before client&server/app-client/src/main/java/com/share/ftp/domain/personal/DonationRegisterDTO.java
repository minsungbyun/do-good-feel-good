package com.share.ftp.domain.personal;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;


public class DonationRegisterDTO implements Serializable{


  private static final long serialVersionUID = 1L;


  private int no;
  private int donationMoney;
  public static int totalDonationMoney;
  private String name;
  private String sort;
  private String registerationNumber;
  private Date birthDate;
  private String tel;
  private String email;
  private String address;
  private Date registeredDate;
  private List<JoinDTO> members = new ArrayList<>();




  @Override
  public String toString() {
    return "DonationRegisterDTO [no=" + no + ", donationMoney=" + donationMoney + ", name=" + name
        + ", sort=" + sort + ", registerationNumber=" + registerationNumber + ", birthDate="
        + birthDate + ", tel=" + tel + ", email=" + email + ", address=" + address
        + ", registeredDate=" + registeredDate + ", members=" + members + "]";
  }
  @Override
  public int hashCode() {
    return Objects.hash(address, birthDate, donationMoney, email, members, name, no,
        registerationNumber, registeredDate, sort, tel);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DonationRegisterDTO other = (DonationRegisterDTO) obj;
    return Objects.equals(address, other.address) && Objects.equals(birthDate, other.birthDate)
        && donationMoney == other.donationMoney && Objects.equals(email, other.email)
        && Objects.equals(members, other.members) && Objects.equals(name, other.name)
        && no == other.no && Objects.equals(registerationNumber, other.registerationNumber)
        && Objects.equals(registeredDate, other.registeredDate) && Objects.equals(sort, other.sort)
        && Objects.equals(tel, other.tel);
  }

  public String getSort() {
    return sort;
  }
  public void setSort(String sort) {
    this.sort = sort;
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getDonationMoney() {
    return donationMoney;
  }
  public void setDonationMoney(int donationMoney) {
    this.donationMoney = donationMoney;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getRegisterationNumber() {
    return registerationNumber;
  }
  public void setRegisterationNumber(String registerationNumber) {
    this.registerationNumber = registerationNumber;
  }
  public Date getBirthDate() {
    return birthDate;
  }
  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
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
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public List<JoinDTO> getMembers() {
    return members;
  }
  public void setMembers(List<JoinDTO> members) {
    this.members = members;
  }
  public void addMembers(JoinDTO member) {
    this.members.add(member);
  }

  public void removeMembers(JoinDTO member) {
    this.members.remove(member);
  }

  public String getMemberNames() {
    if (members == null) {
      return "";
    }
    StringBuilder names = new StringBuilder();
    for (JoinDTO joinDTO : members) {
      if (names.length() > 0) {
        names.append("\n");
      }
      names.append(joinDTO.getId()).append("("+joinDTO.getName()+")");
    }
    return names.toString();
  }


}