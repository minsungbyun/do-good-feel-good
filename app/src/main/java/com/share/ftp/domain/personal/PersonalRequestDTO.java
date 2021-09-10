package com.share.ftp.domain.personal;

import java.io.Serializable;
import java.sql.Date;
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
  private List<JoinDTO> members; // 참여한 멤버들
  private List<JoinDTO> members1; // 참여한 멤버들
  private List<JoinDTO> members2; // 참여한 멤버들
  private List<JoinDTO> members3; // 참여한 멤버들
  private int joinCount; // 최초 주최자 1명
  private int totalJoinCount = 1; // 참여 총 횟수











  @Override
  public int hashCode() {
    return Objects.hash(content, email, fileUpload, isChecked, isJoin, isOrg, isPersonal, isSigned,
        joinCount, joinNum, members, name, no, owner, sort, tel, title, userId, volEndDate,
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
        && Objects.equals(isSigned, other.isSigned) && joinCount == other.joinCount
        && joinNum == other.joinNum && Objects.equals(members, other.members)
        && Objects.equals(name, other.name) && no == other.no && Objects.equals(owner, other.owner)
        && Objects.equals(sort, other.sort) && Objects.equals(tel, other.tel)
        && Objects.equals(title, other.title) && Objects.equals(userId, other.userId)
        && Objects.equals(volEndDate, other.volEndDate)
        && Objects.equals(volEndTime, other.volEndTime) && Objects.equals(volList, other.volList)
        && Objects.equals(volStartDate, other.volStartDate)
        && Objects.equals(volStartTime, other.volStartTime)
        && Objects.equals(volSubmitTime, other.volSubmitTime);
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











  public List<JoinDTO> getMembers1() {
    return members1;
  }

  public void setMembers1(List<JoinDTO> members1) {
    this.members1 = members1;
  }

  public List<JoinDTO> getMembers2() {
    return members2;
  }

  public void setMembers2(List<JoinDTO> members2) {
    this.members2 = members2;
  }

  public List<JoinDTO> getMembers3() {
    return members3;
  }

  public void setMembers3(List<JoinDTO> members3) {
    this.members3 = members3;
  }

  public int getJoinCount() {
    return joinCount;
  }


  public void setJoinCount(int joinCount) {
    this.joinCount = joinCount;
  }




  public int getTotalJoinCount() {
    return totalJoinCount;
  }

  public void setTotalJoinCount(int totalJoinCount) {
    this.totalJoinCount = totalJoinCount;
  }

  public  String getMemberNames() {

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

  public  String getMemberNames1() {

    if (members1 == null) {
      return "";
    }

    StringBuilder names = new StringBuilder();

    for (JoinDTO joinDTO : members1) {
      if (names.length() > 0) {
        names.append("\n");
      }
      names.append(joinDTO.getId()).append("("+joinDTO.getName()+")");
    }

    return names.toString();
  }

  public  String getMemberNames2() {

    if (members2 == null) {
      return "";
    }

    StringBuilder names = new StringBuilder();

    for (JoinDTO joinDTO : members2) {
      if (names.length() > 0) {
        names.append("\n");
      }
      names.append(joinDTO.getId()).append("("+joinDTO.getName()+")");
    }

    return names.toString();
  }

  public  String getMemberNames3() {

    if (members3 == null) {
      return "";
    }

    StringBuilder names = new StringBuilder();

    for (JoinDTO joinDTO : members3) {
      if (names.length() > 0) {
        names.append("\n");
      }
      names.append(joinDTO.getId()).append("("+joinDTO.getName()+")");
    }

    return names.toString();
  }




  //    String memberInfo = "";
  //    for (JoinDTO joinDTO : this.members) {
  //      if (joinDTO.getNo() > 0) {
  //        memberInfo = ",";
  //      }
  //      memberInfo += System.out.printf("%s(%s) " ,joinDTO.getId(),joinDTO.getName());
  //    }
  //    return memberInfo.toString();
  //
  //
  //  StringBuilder names = new StringBuilder();
  //  
  //  for (JoinDTO joinDTO : this.members) {
  //    if (names.length() > 0) {
  //      names.append(",");
  //    }
  //    names.append(joinDTO.getId()).append("("+joinDTO.getName()+")");
  //    
  //  }
  //  
  //  return names.toString();
  //}




}