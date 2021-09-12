package com.share.ftp.domain.personal;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class PersonalRequestDTO implements Serializable {


  private int no;
  private String title;
  private String name;
  private JoinDTO owner; // 나중에 JoinDTO 변경 예정
  private String userId;
  private String sort;
  private String tel;
  private String email;
  private Date volStartDate;
  private Date volEndDate;
  private String volStartTime;
  private String volEndTime;
  private String volList;
  private int joinNum;
  private String content;
  private String fileUpload;
  private boolean isPersonal;
  private boolean isOrg;
  private boolean isChecked;
  private String isSigned = "승인대기"; // 관리자 승인 여부확인
  private Date volSubmitTime;
  private boolean isJoin; // 참여여부 확인
  private List<JoinDTO> members = new ArrayList<>(); // 참여한 멤버들
  private int totalJoinCount = 1; // 참여 총 횟수














  @Override
  public int hashCode() {
    return Objects.hash(content, email, fileUpload, isChecked, isJoin, isOrg, isPersonal, isSigned,
        joinNum, members, name, no, owner, sort, tel, title, totalJoinCount, userId, volEndDate,
        volEndTime, volList, volStartDate, volStartTime, volSubmitTime);
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PersonalRequestDTO other = (PersonalRequestDTO) obj;
    return Objects.equals(content, other.content) && Objects.equals(email, other.email)
        && Objects.equals(fileUpload, other.fileUpload) && isChecked == other.isChecked
        && isJoin == other.isJoin && isOrg == other.isOrg && isPersonal == other.isPersonal
        && Objects.equals(isSigned, other.isSigned) && joinNum == other.joinNum
        && Objects.equals(members, other.members) && Objects.equals(name, other.name)
        && no == other.no && Objects.equals(owner, other.owner) && Objects.equals(sort, other.sort)
        && Objects.equals(tel, other.tel) && Objects.equals(title, other.title)
        && totalJoinCount == other.totalJoinCount && Objects.equals(userId, other.userId)
        && Objects.equals(volEndDate, other.volEndDate)
        && Objects.equals(volEndTime, other.volEndTime) && Objects.equals(volList, other.volList)
        && Objects.equals(volStartDate, other.volStartDate)
        && Objects.equals(volStartTime, other.volStartTime)
        && Objects.equals(volSubmitTime, other.volSubmitTime);
  }


  @Override
  public String toString() {
    return "PersonalRequestDTO [no=" + no + ", title=" + title + ", name=" + name + ", owner="
        + owner + ", userId=" + userId + ", sort=" + sort + ", tel=" + tel + ", email=" + email
        + ", volStartDate=" + volStartDate + ", volEndDate=" + volEndDate + ", volStartTime="
        + volStartTime + ", volEndTime=" + volEndTime + ", volList=" + volList + ", joinNum="
        + joinNum + ", content=" + content + ", fileUpload=" + fileUpload + ", isPersonal="
        + isPersonal + ", isOrg=" + isOrg + ", isChecked=" + isChecked + ", isSigned=" + isSigned
        + ", volSubmitTime=" + volSubmitTime + ", isJoin=" + isJoin + ", members=" + members
        + ", totalJoinCount=" + totalJoinCount + "]";
  }




  public int getNo() {
    return no;
  }


  public void setNo(int no) {
    this.no = no;
  }


  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public JoinDTO getOwner() {
    return owner;
  }


  public void setOwner(JoinDTO owner) {
    this.owner = owner;
  }


  public String getUserId() {
    return userId;
  }


  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getSort() {
    return sort;
  }


  public void setSort(String sort) {
    this.sort = sort;
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


  public Date getVolStartDate() {
    return volStartDate;
  }


  public void setVolStartDate(Date volStartDate) {
    this.volStartDate = volStartDate;
  }


  public Date getVolEndDate() {
    return volEndDate;
  }


  public void setVolEndDate(Date volEndDate) {
    this.volEndDate = volEndDate;
  }


  public String getVolStartTime() {
    return volStartTime;
  }


  public void setVolStartTime(String volStartTime) {
    this.volStartTime = volStartTime;
  }


  public String getVolEndTime() {
    return volEndTime;
  }


  public void setVolEndTime(String volEndTime) {
    this.volEndTime = volEndTime;
  }


  public String getVolList() {
    return volList;
  }


  public void setVolList(String volList) {
    this.volList = volList;
  }


  public int getJoinNum() {
    return joinNum;
  }


  public void setJoinNum(int joinNum) {
    this.joinNum = joinNum;
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


  public boolean isPersonal() {
    return isPersonal;
  }


  public void setPersonal(boolean isPersonal) {
    this.isPersonal = isPersonal;
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


  public Date getVolSubmitTime() {
    return volSubmitTime;
  }


  public void setVolSubmitTime(Date volSubmitTime) {
    this.volSubmitTime = volSubmitTime;
  }


  public boolean isJoin() {
    return isJoin;
  }


  public void setJoin(boolean isJoin) {
    this.isJoin = isJoin;
  }


  public List<JoinDTO> getMembers() {
    return members;
  }


  public void setMembers(List<JoinDTO> members) {
    this.members = members;
  }


  public int getTotalJoinCount() {
    return totalJoinCount;
  }


  public void setTotalJoinCount(int totalJoinCount) {
    this.totalJoinCount = totalJoinCount;
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