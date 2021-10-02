package com.share.ftp.table;

import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.server.DataProcessor;
import com.share.ftp.server.Request;
import com.share.ftp.server.Response;

public class JoinDTOTable extends JsonDataTable<JoinDTO> implements DataProcessor {

  public JoinDTOTable() {
    super("join.json",JoinDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "join.insert": insert(request, response); break;
      case "join.selectOneByIdPassword" : selectOneByIdPassword(request,response); break;
      case "join.validId": validId(request, response); break;
      case "join.validName": validName(request, response); break;

    }

  }

  private void insert(Request request, Response response) throws Exception {
    JoinDTO loginUser = request.getObject(JoinDTO.class);
    list.add(loginUser);
    response.setStatus(Response.SUCCESS);
  }

  private void selectOneByIdPassword(Request request, Response response) throws Exception {
    String id = request.getParameter("loginId");
    String password = request.getParameter("loginPassword");

    JoinDTO loginUser = null;
    for (JoinDTO user : list) {
      if (user.getId().equals(id) && user.getPassword().equals(password)) {
        loginUser = user;
        break;
      }
    }

    if (loginUser != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(loginUser);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 아이디와 암호를 가진 회원을 찾을 수 없습니다.");
    }
  }

  private void validId(Request request, Response response) throws Exception {
    String id = request.getParameter("validId");

    JoinDTO loginUser = null;
    for (JoinDTO user : list) {
      if (user.getId().contains(id)) {
        loginUser = user;
        break;
      }
    }
    if (loginUser != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue("이미 존재하는 아이디입니다. 다시 입력해주세요!");

    } else {
      response.setStatus(Response.FAIL);
      response.setValue(loginUser);
    }
  }

  private void validName(Request request, Response response) throws Exception {
    String name = request.getParameter("validName");



    if (!(name.length() == 0)) {
      response.setStatus(Response.SUCCESS);
      response.setValue();

    } else {
      response.setStatus(Response.FAIL);
      response.setValue(loginUser);
    }
  }






}
