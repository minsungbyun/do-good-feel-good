package com.share.ftp.table;

import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

public class ChallengeTable extends JsonDataTable<ChallengeDTO> implements DataProcessor {

  public ChallengeTable() {
    super("challenge.json",ChallengeDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "challenge.insert": insert(request, response); break;
      case "challenge.selectList": selectList(request, response); break;
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

  private void update(Request request, Response response) throws Exception {
    //    ChallengeDTO Challenge = request.getObject(ChallengeDTO.class);
    //    int challengeNo = request.getParameter("challengeNo"); // 클라이언트에서 안넘김
    //
    //
    //    int index = indexOf(challengeNo);
    //
    //    list.set(challengeNo, Challenge);
    //    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    JoinDTO loginUser = request.getObject(JoinDTO.class);

    list.remove(loginUser);
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
