package com.share.ftp.table;

import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

public class ChallengeJoinTable extends JsonDataTable<ChallengeDTO> implements DataProcessor {

  public ChallengeJoinTable() {
    super("challengeJoin.json", ChallengeDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "challengeJoin.insert": insert(request, response); break;
      case "challengeJoin.selectList": selectList(request, response); break;
      //      case "join.validId": validId(request, response); break;
    }
  }

  private void insert(Request request, Response response) throws Exception {
    ChallengeDTO challengeJoin = request.getObject(ChallengeDTO.class);

    list.add(challengeJoin);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }
}
