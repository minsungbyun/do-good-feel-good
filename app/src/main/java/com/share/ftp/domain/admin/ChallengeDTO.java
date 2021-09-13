package com.share.ftp.domain.admin;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class ChallengeDTO implements Serializable{

  private int no;
  private JoinDTO admin;
  private String title;
  private String content;
  private String fileUpload;
  private Date registeredDate;
  private int viewCount;
  private List<JoinDTO> members = new ArrayList<>();  // 관리자가 등록한 챌린지에 참여한 멤버

  @Override
  public int hashCode() {
    return Objects.hash(admin, content, fileUpload, members, no, registeredDate, title, viewCount);
  }

  @Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ChallengeDTO other = (ChallengeDTO) obj;
	return Objects.equals(admin, other.admin) && Objects.equals(content, other.content)
			&& Objects.equals(fileUpload, other.fileUpload) && Objects.equals(members, other.members) && no == other.no
			&& Objects.equals(registeredDate, other.registeredDate) && Objects.equals(title, other.title)
			&& viewCount == other.viewCount;
}

  @Override
  public String toString() {
    return "ChallengeDTO [no=" + no + ", admin=" + admin + ", title=" + title + ", content=" + content + ", fileUpload="
        + fileUpload + ", registeredDate=" + registeredDate + ", viewCount=" + viewCount + ", members=" + members
        + "]";
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
  public JoinDTO getAdmin() {
	  return admin;
  }
  public void setAdmin(JoinDTO admin) {
	  this.admin = admin;
  }
  public void setTitle(String title) {
    this.title = title;
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
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
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
