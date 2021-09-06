package com.share.ftp.domain.personal;

import java.util.Objects;

public class MyChallengeQuestionDTO {
  public int no;
  public String memberId;
  public String content;

  @Override
  public String toString() {
    return "MyChallengeQuestionDTO [no=" + no + ", memberId=" + memberId + ", content=" + content
        + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, memberId, no);
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
    return Objects.equals(content, other.content) && Objects.equals(memberId, other.memberId)
        && no == other.no;
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getMemberId() {
    return memberId;
  }
  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }

}
