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
  //  private String children = "아동";
  //  private String teen = "청소년";
  //  private String elder = "노인";
  //  private String handicappedPerson = "장애인";
  //  private String animal = "동물";
  //  private String environmental = "환경";
  //  private String other = "기타";

  private String title;
  private String leader;
  private String content;
  private String fileUpload;
  private Date registeredStartDate;
  private Date registeredEndDate;
  //  private boolean isOrg;
  //  private boolean isChecked;
  private String isSigned;
  private List<JoinDTO> members = new ArrayList<>();



  @Override
  public String toString() {
    return "DonationBoardDTO [no=" + no + ", sort=" + sort + ", title=" + title + ", leader="
        + leader + ", content=" + content + ", fileUpload=" + fileUpload + ", registeredStartDate="
        + registeredStartDate + ", registeredEndDate=" + registeredEndDate + ", isSigned="
        + isSigned + ", members=" + members + "]";
  }
  @Override
  public int hashCode() {
    return Objects.hash(content, fileUpload, isSigned, leader, members, no, registeredEndDate,
        registeredStartDate, sort, title);
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
    return Objects.equals(content, other.content) && Objects.equals(fileUpload, other.fileUpload)
        && Objects.equals(isSigned, other.isSigned) && Objects.equals(leader, other.leader)
        && Objects.equals(members, other.members) && no == other.no
        && Objects.equals(registeredEndDate, other.registeredEndDate)
        && Objects.equals(registeredStartDate, other.registeredStartDate)
        && Objects.equals(sort, other.sort) && Objects.equals(title, other.title);
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
