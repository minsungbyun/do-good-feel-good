package com.share.ftp.table.volunteer;

import com.share.ftp.domain.admin.
import com.share.ftp.domain.volunteer.PersonalRequestDTO;
import com.share.ftp.table.JsonDataTable;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

public class VolPersonalTable extends JsonDataTable<PersonalRequestDTO> implements DataProcessor {

  public VolPersonalTable() {
    super("personalRequestDTO.json",PersonalRequestDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "challenge.insert": insert(request, response); break;
      case "challenge.selectList": selectList(request, response); break;
      case "challenge.selectOne": selectOne(request, response); break;
      case "challenge.update": update(request, response); break;
      case "challenge.delete": delete(request, response); break;
      case "challenge.getNextNum": getNextNum(request, response); break;
    }
  }

  private void insert(Request request, Response response) throws Exception {
    ChallengeDTO challenge = request.getObject(ChallengeDTO.class);
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

    ChallengeDTO challengeDTO = null;
    for (ChallengeDTO challengeList : list) {
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
    ChallengeDTO updateChallenge = request.getObject(ChallengeDTO.class);

    int index = indexOf(updateChallenge.getNo());

    list.set(index, updateChallenge);
    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    ChallengeDTO deleteChallenge = request.getObject(ChallengeDTO.class);

    list.remove(deleteChallenge);
    response.setStatus(Response.SUCCESS);
  }


  private void getNextNum(Request request, Response response) throws Exception {
    ChallengeDTO challenge = new ChallengeDTO();

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
