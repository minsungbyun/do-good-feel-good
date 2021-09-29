package com.share.ftp.domain.personal;

import java.util.Comparator;

public class CommBestComparator implements Comparator<CommBoardDTO> {

  @Override
  public int compare(CommBoardDTO firstCommBoard, CommBoardDTO secondCommBoard) {
    int first = firstCommBoard.getLike();
    int second = secondCommBoard.getLike();

    if (first > second) {
      return -1;

    } else if (first < second) {
      return 1;

    } else {
      return 0;
    }
  }



}
