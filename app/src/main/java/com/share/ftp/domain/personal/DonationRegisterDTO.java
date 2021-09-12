package com.share.ftp.domain.personal;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class DonationRegisterDTO implements Serializable{

  private String children = "아동";
  private String teen = "청소년";
  private String elder = "어르신";
  private String handicappedPerson = "장애인";
  private String animal = "동물";
  private String environmental = "환경";
  private String other = "기타";
  private String sort;

  private int no;
  private int donationMoney;
  private int myTotaldonationMoney;
  private String name;
  private String registerationNumber;
  private Date birthDate;
  private String tel;
  private String email;
  private String address;
  private Date registeredDate;
  private List<JoinDTO> members = new ArrayList<>();



  @Override
  public String toString() {
    return "DonationRegisterDTO [children=" + children + ", teen=" + teen + ", elder=" + elder
        + ", handicappedPerson=" + handicappedPerson + ", animal=" + animal + ", environmental="
        + environmental + ", other=" + other + ", sort=" + sort + ", no=" + no + ", donationMoney="
        + donationMoney + ", myTotaldonationMoney=" + myTotaldonationMoney + ", name=" + name
        + ", registerationNumber=" + registerationNumber + ", birthDate=" + birthDate + ", tel="
        + tel + ", email=" + email + ", address=" + address + ", registeredDate=" + registeredDate
        + ", members=" + members + "]";
  }
  @Override
  public int hashCode() {
    return Objects.hash(address, animal, birthDate, children, donationMoney, elder, email,
        environmental, handicappedPerson, members, myTotaldonationMoney, name, no, other,
        registerationNumber, registeredDate, sort, teen, tel);
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
    return Objects.equals(address, other.address) && Objects.equals(animal, other.animal)
        && Objects.equals(birthDate, other.birthDate) && Objects.equals(children, other.children)
        && donationMoney == other.donationMoney && Objects.equals(elder, other.elder)
        && Objects.equals(email, other.email) && Objects.equals(environmental, other.environmental)
        && Objects.equals(handicappedPerson, other.handicappedPerson)
        && Objects.equals(members, other.members)
        && myTotaldonationMoney == other.myTotaldonationMoney && Objects.equals(name, other.name)
        && no == other.no && Objects.equals(this.other, other.other)
        && Objects.equals(registerationNumber, other.registerationNumber)
        && Objects.equals(registeredDate, other.registeredDate) && Objects.equals(sort, other.sort)
        && Objects.equals(teen, other.teen) && Objects.equals(tel, other.tel);
  }
  public String getChildren() {
    return children;
  }
  public void setChildren(String children) {
    this.children = children;
  }
  public String getTeen() {
    return teen;
  }
  public void setTeen(String teen) {
    this.teen = teen;
  }
  public String getElder() {
    return elder;
  }
  public void setElder(String elder) {
    this.elder = elder;
  }
  public String getHandicappedPerson() {
    return handicappedPerson;
  }
  public void setHandicappedPerson(String handicappedPerson) {
    this.handicappedPerson = handicappedPerson;
  }
  public String getAnimal() {
    return animal;
  }
  public void setAnimal(String animal) {
    this.animal = animal;
  }
  public String getEnvironmental() {
    return environmental;
  }
  public void setEnvironmental(String environmental) {
    this.environmental = environmental;
  }
  public String getOther() {
    return other;
  }
  public void setOther(String other) {
    this.other = other;
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
  public int getMyTotaldonationMoney() {
    return myTotaldonationMoney;
  }
  public void setMyTotaldonationMoney(int myTotaldonationMoney) {
    this.myTotaldonationMoney = myTotaldonationMoney;
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