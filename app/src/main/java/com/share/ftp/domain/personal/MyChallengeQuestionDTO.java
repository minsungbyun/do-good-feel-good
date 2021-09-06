package com.share.ftp.domain.personal;

import java.util.List;
import java.util.Objects;

import com.share.ftp.domain.join.JoinDTO;

public class MyChallengeQuestionDTO {
  public int no;
  public String title;
  public String content;
  private JoinDTO owner;
  private List<JoinDTO> joinDTO;

  @Override
  public String toString() {
    return "MyChallengeQuestionDTO [no=" + no + ", memberId=" + title + ", content=" + content + ", owner=" + owner
        + ", joinDTO=" + joinDTO + "]";
  }

@Override
  public int hashCode() {
    return Objects.hash(content, title, no);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    MyChallengeQuestionDTO other = (MyChallengeQuestionDTO) obj;
    return Objects.equals(content, other.content) && Objects.equals(title, other.title)
        && no == other.no;
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
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
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
