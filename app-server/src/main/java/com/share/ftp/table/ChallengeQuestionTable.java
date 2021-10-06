package com.share.ftp.table;

import java.util.ArrayList;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
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
      case "challengeQuestion.insert": insertQuestion(request, response); break;
      case "challengeQuestion.selectList": selectQuestionList(request, response); break;
      case "challengeQuestion.selectListKeyword": selectListKeyword(request, response); break;
      case "challengeQuestion.selectOne": selectQuestionOne(request, response); break;
      case "challengeQuestion.update": updateQuestion(request, response); break;
      case "challengeQuestion.delete": deleteQuestion(request, response); break;
      case "challengeQuestion.deleteIndex": deleteQuestionByIndex(request, response); break;
      case "challengeQuestion.getNextNum": getNextQuestionNum(request, response); break;
    }
  }

  private void insertQuestion(Request request, Response response) throws Exception {
    ChallengeQuestionDTO challengeQuestion = request.getObject(ChallengeQuestionDTO.class);
    list.add(challengeQuestion);
    response.setStatus(Response.SUCCESS);
  }

  private void selectQuestionList(Request request, Response response) throws Exception {

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

  private void selectQuestionOne(Request request, Response response) throws Exception {
    int challengeNo = Integer.parseInt(request.getParameter("challengeNo"));
    int challengeQuestionNo = Integer.parseInt(request.getParameter("challengeQuestionNo"));


    ChallengeQuestionDTO selectChallenge = null;
    for (ChallengeQuestionDTO ChallengeQuestionDTO : list) {
      if (ChallengeQuestionDTO.getNo() == challengeNo) {
        if (ChallengeQuestionDTO.getQuestionNo() == challengeQuestionNo) {
          selectChallenge = ChallengeQuestionDTO;
        }
      }
    }

    if (selectChallenge == null) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 챌린지문의가 없습니다!");
      return;
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(selectChallenge);
  }

  private void updateQuestion(Request request, Response response) throws Exception {
    int challengeNo = Integer.parseInt(request.getParameter("challengeNo"));
    ChallengeQuestionDTO updateChallengeQuestion = request.getObject(ChallengeQuestionDTO.class);

    int index = indexOf(challengeNo, updateChallengeQuestion);

    list.set(index, updateChallengeQuestion);
    response.setStatus(Response.SUCCESS);
  }

  private void deleteQuestion(Request request, Response response) throws Exception {
    ChallengeQuestionDTO deleteChallenge = request.getObject(ChallengeQuestionDTO.class);

    list.remove(deleteChallenge);
    response.setStatus(Response.SUCCESS);
  }

  private void deleteQuestionByIndex(Request request, Response response) throws Exception {
    int challengeNo = Integer.parseInt(request.getParameter("challengeNo"));
    ChallengeQuestionDTO deleteChallengeQuestion = request.getObject(ChallengeQuestionDTO.class);


    int index = indexOf(challengeNo, deleteChallengeQuestion);

    list.remove(index);
    response.setStatus(Response.SUCCESS);
  }


  private void getNextQuestionNum(Request request, Response response) throws Exception {
    ChallengeDTO challenge = request.getObject(ChallengeDTO.class);

    if (list.size() > 0) {
      response.setStatus(Response.SUCCESS);
      response.setValue(challenge.getQuestionCount() + 1);
    } else {
      response.setStatus(Response.FAIL);
    }
  }

  //  private int getLastNum(ChallengeDTO challengeDTO) {
  //    if (list.size() > 0) {
  //      return challengeDTO.getQuestionCount() + 1;
  //    } else {
  //      return 1;
  //    }
  //  }

  private int indexOf(int challengeNo, ChallengeQuestionDTO challengeQuestionDTO) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == challengeNo) {
        if (list.get(i).getQuestionNo() == challengeQuestionDTO.getQuestionNo()) {
          return i;
        }
      }
    }
    return -1;
  }

}
