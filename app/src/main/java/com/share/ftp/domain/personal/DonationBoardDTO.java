package com.share.ftp.domain.personal;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class DonationBoardDTO implements Serializable {


  private int no;

  private String sort;
  private String children = "아동";
  private String teen = "청소년";
  private String elder = "노인";
  private String handicappedPerson = "장애인";
  private String animal = "동물";
  private String environmental = "환경";
  private String other = "기타";

  private String title;
  private String leader;
  private String content;
  private String fileUpload;
  private Date registeredStartDate;
  private Date registeredEndDate;
  private boolean isOrg;
  private boolean isChecked;
  private String isSigned;
  private List<JoinDTO> members = new ArrayList<>();



  @Override
  public String toString() {
    return "DonationBoardDTO [no=" + no + ", sort=" + sort + ", children=" + children + ", teen="
        + teen + ", elder=" + elder + ", handicappedPerson=" + handicappedPerson + ", animal="
        + animal + ", environmental=" + environmental + ", other=" + other + ", title=" + title
        + ", leader=" + leader + ", content=" + content + ", fileUpload=" + fileUpload
        + ", registeredStartDate=" + registeredStartDate + ", registeredEndDate="
        + registeredEndDate + ", isOrg=" + isOrg + ", isChecked=" + isChecked + ", isSigned="
        + isSigned + ", members=" + members + "]";
  }
  @Override
  public int hashCode() {
    return Objects.hash(animal, children, content, elder, environmental, fileUpload,
        handicappedPerson, isChecked, isOrg, isSigned, leader, members, no, other,
        registeredEndDate, registeredStartDate, sort, teen, title);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DonationBoardDTO other = (DonationBoardDTO) obj;
    return Objects.equals(animal, other.animal) && Objects.equals(children, other.children)
        && Objects.equals(content, other.content) && Objects.equals(elder, other.elder)
        && Objects.equals(environmental, other.environmental)
        && Objects.equals(fileUpload, other.fileUpload)
        && Objects.equals(handicappedPerson, other.handicappedPerson)
        && isChecked == other.isChecked && isOrg == other.isOrg
        && Objects.equals(isSigned, other.isSigned) && Objects.equals(leader, other.leader)
        && Objects.equals(members, other.members) && no == other.no
        && Objects.equals(this.other, other.other)
        && Objects.equals(registeredEndDate, other.registeredEndDate)
        && Objects.equals(registeredStartDate, other.registeredStartDate)
        && Objects.equals(sort, other.sort) && Objects.equals(teen, other.teen)
        && Objects.equals(title, other.title);
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getSort() {
    return sort;
  }
  public void setSort(String sort) {
    this.sort = sort;
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
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getLeader() {
    return leader;
  }
  public void setLeader(String leader) {
    this.leader = leader;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getFileUpload() {
    return fileUpload;
  }
  public void setFileUpload(String fileUpload) {
    this.fileUpload = fileUpload;
  }
  public Date getRegisteredStartDate() {
    return registeredStartDate;
  }
  public void setRegisteredStartDate(Date registeredStartDate) {
    this.registeredStartDate = registeredStartDate;
  }
  public Date getRegisteredEndDate() {
    return registeredEndDate;
  }
  public void setRegisteredEndDate(Date registeredEndDate) {
    this.registeredEndDate = registeredEndDate;
  }
  public boolean isOrg() {
    return isOrg;
  }
  public void setOrg(boolean isOrg) {
    this.isOrg = isOrg;
  }
  public boolean isChecked() {
    return isChecked;
  }
  public void setChecked(boolean isChecked) {
    this.isChecked = isChecked;
  }
  public String getIsSigned() {
    return isSigned;
  }
  public void setIsSigned(String isSigned) {
    this.isSigned = isSigned;
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
