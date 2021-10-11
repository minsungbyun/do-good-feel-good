package com.share.ftp.table.challenge;

import java.util.ArrayList;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;
import com.share.ftp.table.JsonDataTable;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

public class ChallengeQuestionTable extends JsonDataTable<ChallengeQuestionDTO> implements DataProcessor {

  public ChallengeQuestionTable() {
    super("challengeQuestion.json",ChallengeQuestionDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "challengeQuestion.insert": insert(request, response); break;
      case "challengeQuestion.selectList": selectList(request, response); break;
      case "challengeQuestion.selectListKeyword": selectListKeyword(request, response); break;
      case "challengeQuestion.selectOne": selectOne(request, response); break;
      case "challengeQuestion.update": update(request, response); break;
      case "challengeQuestion.delete": delete(request, response); break;
    }
  }

  private void insert(Request request, Response response) throws Exception {
    ChallengeQuestionDTO challengeQuestion = request.getObject(ChallengeQuestionDTO.class);
    list.add(challengeQuestion);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {

    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectListKeyword(Request request, Response response) throws Exception {
    String keyword = request.getParameter("challengeQuestionKeyword");

    ArrayList<ChallengeQuestionDTO> searchResult = new ArrayList<>();
    for (ChallengeQuestionDTO challengeQuestion : list) {
      if (!challengeQuestion.getTitle().contains(keyword) &&
          !challengeQuestion.getContent().contains(keyword) &&
          !challengeQuestion.getOwner().getName().contains(keyword)) {
        continue;
      }
      searchResult.add(challengeQuestion);
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(searchResult);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int challengeNo = Integer.parseInt(request.getParameter("challengeNo"));
    int challengeQuestionNo = Integer.parseInt(request.getParameter("challengeQuestionNo"));

    ChallengeQuestionDTO challengeQuestionDTO = null;

    challengeQuestionDTO = findByChallengeQuestionNo(challengeNo, challengeQuestionNo);

    if (challengeQuestionDTO == null) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 챌린지문의가 없습니다!");
      return;
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(challengeQuestionDTO);
  }

  private void update(Request request, Response response) throws Exception {

    ChallengeQuestionDTO updateChallengeQuestion = request.getObject(ChallengeQuestionDTO.class);

    int index = indexOf(updateChallengeQuestion.getNo(), updateChallengeQuestion.getQuestionNo());

    list.set(index, updateChallengeQuestion);
    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    ChallengeQuestionDTO deleteChallenge = request.getObject(ChallengeQuestionDTO.class);

    list.remove(deleteChallenge);
    response.setStatus(Response.SUCCESS);
  }


  private ChallengeQuestionDTO findByChallengeQuestionNo(int challengeNo, int challengeQuestionNo) {
    for (ChallengeQuestionDTO challengeQuestionList : list) {
      if (challengeQuestionList.getNo() == challengeNo) {
        if (challengeQuestionList.getQuestionNo() == challengeQuestionNo) {
          return challengeQuestionList; 
        }
      }
    }
    return null;
  }

  private int indexOf(int challengeNo, int challengeQuestionNo) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == challengeNo) {
        if (list.get(i).getQuestionNo() == challengeQuestionNo) {
          return i;
        }
      }
    }
    return -1;
  }

}
