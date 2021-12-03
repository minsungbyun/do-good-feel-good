package com.share.ftp.domain.support;

import java.util.Comparator;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;

public class QuestionComparator implements Comparator<ChallengeQuestionDTO> {

  @Override
  public int compare(ChallengeQuestionDTO firstQuestion, ChallengeQuestionDTO secondQuestion) {
    int first = firstQuestion.getQuestionNo();
    int second = secondQuestion.getQuestionNo();

    if (first > second) {
      return -1;

    } else if (first < second) {
      return 1;

    } else {
      return 0;
    }
  }



}
