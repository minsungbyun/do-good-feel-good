package com.share.ftp.domain.join;

import java.util.Comparator;

public class RankComparator implements Comparator<JoinDTO> {

  @Override
  public int compare(JoinDTO firstRank, JoinDTO secondRank) {
    int first = firstRank.getRank();
    int second = secondRank.getRank();

    if (first > second) {
      return firstRank.getRank() + 1;

    } else if (first < second) {
      return secondRank.getRank() + 1;

    } else {
      return 0;
    }
  }



}
