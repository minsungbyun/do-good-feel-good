package com.share.ftp.domain.personal;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import com.share.ftp.domain.guest.JoinDTO;

public class MyChallengeReviewDTO {
  public int no;
  public String content;
  public String memberId;
  public String fileUpload;
  public Date registeredDate;
  private JoinDTO owner;
  private List<JoinDTO> joinDTO;

  @Override
  public String toString() {
	return "MyChallengeReviewDTO [no=" + no + ", content=" + content + ", memberId=" + memberId + ", fileUpload="
		+ fileUpload + ", registeredDate=" + registeredDate + ", owner=" + owner + ", joinDTO=" + joinDTO + "]";
}

@Override
  public int hashCode() {
    return Objects.hash(content, fileUpload, memberId, no, registeredDate);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    MyChallengeReviewDTO other = (MyChallengeReviewDTO) obj;
    return Objects.equals(content, other.content) && Objects.equals(fileUpload, other.fileUpload)
        && Objects.equals(memberId, other.memberId) && no == other.no
        && Objects.equals(registeredDate, other.registeredDate);
  }


  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getMemberId() {
    return memberId;
  }
  public void setMemberId(String memberId) {
    this.memberId = memberId;
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
  public JoinDTO getOwner() {
	return owner;
}
  public void setOwner(JoinDTO owner) {
	this.owner = owner;
}
public List<JoinDTO> getJoinDTO() {
	return joinDTO;
  }
  public void setJoinDTO(List<JoinDTO> joinDTO) {
	this.joinDTO = joinDTO;
  }
}
