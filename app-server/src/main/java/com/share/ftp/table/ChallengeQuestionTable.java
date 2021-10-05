package com.share.ftp.table;

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
      case "challengeQuestion.insert": insert(request, response); break;
      case "challengeQuestion.selectList": selectList(request, response); break;
      case "challengeQuestion.selectOne": selectOne(request, response); break;
      case "challengeQuestion.update": update(request, response); break;
      case "challengeQuestion.delete": delete(request, response); break;
      case "challengeQuestion.getNextNum": getNextNum(request, response); break;
    }
  }

  private void insert(Request request, Response response) throws Exception {
    ChallengeQuestionDTO challenge = request.getObject(ChallengeQuestionDTO.class);
    System.out.println(challenge);
    list.add(challenge);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }


  private void selectOne(Request request, Response response) throws Exception {
    int challengeNo = Integer.parseInt(request.getParameter("challengeNo"));

    ChallengeQuestionDTO challengeDTO = null;
    for (ChallengeQuestionDTO challengeList : list) {
      if (challengeList.getNo() == challengeNo) {
        challengeDTO = challengeList; 
      }
    }

    if (challengeDTO == null) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 챌린지가 없습니다!");
      return;
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(challengeDTO);
  }

  private void update(Request request, Response response) throws Exception {
    ChallengeQuestionDTO updateChallenge = request.getObject(ChallengeQuestionDTO.class);

    int index = indexOf(updateChallenge.getNo());

    list.set(index, updateChallenge);
    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    ChallengeQuestionDTO deleteChallenge = request.getObject(ChallengeQuestionDTO.class);

    list.remove(deleteChallenge);
    response.setStatus(Response.SUCCESS);
  }


  private void getNextNum(Request request, Response response) throws Exception {
    ChallengeQuestionDTO challenge = new ChallengeQuestionDTO();

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
