package com.share.ftp.table;

import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

public class ChallengeReviewTable extends JsonDataTable<ChallengeReviewDTO> implements DataProcessor {

  public ChallengeReviewTable() {
    super("challengeReview.json",ChallengeReviewDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "challengeReview.insert": insertReview(request, response); break;
      case "challengeReview.selectList": selectReviewList(request, response); break;
      case "challengeReview.selectOne": selectReviewOne(request, response); break;
      case "challengeReview.update": updateReview(request, response); break;
      case "challengeReview.delete": deleteReview(request, response); break;
      case "challengeReview.getNextNum": getNextReivewNum(request, response); break;
    }
  }

  private void insertReview(Request request, Response response) throws Exception {
    ChallengeReviewDTO challenge = request.getObject(ChallengeReviewDTO.class);
    System.out.println(challenge);
    list.add(challenge);
    response.setStatus(Response.SUCCESS);
  }

  private void selectReviewList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }


  private void selectReviewOne(Request request, Response response) throws Exception {
    int challengeReviewNo = Integer.parseInt(request.getParameter("challengeNo"));

    ChallengeReviewDTO challengeReviewDTO = null;
    for (ChallengeReviewDTO challengeList : list) {
      if (challengeList.getNo() == challengeReviewNo) {
        challengeReviewDTO = challengeList; 
      }
    }

    if (challengeReviewDTO == null) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 챌린지가 없습니다!");
      return;
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(challengeReviewDTO);
  }

  private void updateReview(Request request, Response response) throws Exception {
    ChallengeReviewDTO updateChallenge = request.getObject(ChallengeReviewDTO.class);

    int index = indexOf(updateChallenge.getNo());

    list.set(index, updateChallenge);
    response.setStatus(Response.SUCCESS);
  }

  private void deleteReview(Request request, Response response) throws Exception {
    ChallengeReviewDTO deleteChallenge = request.getObject(ChallengeReviewDTO.class);

    list.remove(deleteChallenge);
    response.setStatus(Response.SUCCESS);
  }


  private void getNextReivewNum(Request request, Response response) throws Exception {
    ChallengeReviewDTO challenge = new ChallengeReviewDTO();

    challenge.setNo(getLastNum());

    response.setStatus(Response.SUCCESS);
    response.setValue(challenge);
  }

  private int getLastNum() {
    if (list.size() > 0) {
      return list.get(list.size() - 1).getNo() + 1;
    } else {
      return 1;
    }
  }

  private int indexOf(int no) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}
