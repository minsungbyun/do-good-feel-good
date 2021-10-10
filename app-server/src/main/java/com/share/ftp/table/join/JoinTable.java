package com.share.ftp.table.join;

import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.table.JsonDataTable;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

public class JoinTable extends JsonDataTable<JoinDTO> implements DataProcessor {



  public JoinTable() {
    super("join.json",JoinDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "join.insert": insert(request, response); break;
      case "join.update": update(request, response); break;
      case "join.delete": delete(request, response); break;
      case "join.selectList": selectList(request, response); break;
      case "join.selectOneByIdPassword" : selectOneByIdPassword(request,response); break;
      case "join.selectOneByIdEmail" : selectOneByIdEmail(request,response); break;
      case "join.selectOneByUser" : selectOneByUser(request,response); break;
      case "join.selectOneByEmail" : selectOneByEmail(request,response); break;
      case "join.selectOneByTel" : selectOneByTel(request,response); break;
      case "join.validId": validId(request, response); break;
      case "join.getNextNum": getNextNum(request, response); break;

    }

  }

  private void insert(Request request, Response response) throws Exception {
    JoinDTO loginUser = request.getObject(JoinDTO.class);

    list.add(loginUser);
    response.setStatus(Response.SUCCESS);
  }

  private void update(Request request, Response response) throws Exception {
    JoinDTO loginUser = request.getObject(JoinDTO.class);

    int index = indexOf(loginUser.getNo());
    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 회원을 찾을 수 없습니다.");
      return;
    }
    list.set(index, loginUser);
    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    JoinDTO loginUser = request.getObject(JoinDTO.class);

    list.remove(loginUser);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
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

  private void selectOneByIdEmail(Request request, Response response) throws Exception {
    String userId = request.getParameter("loginId");
    String userEmail = request.getParameter("loginEmail");

    JoinDTO loginUser = null;
    for (JoinDTO user : list) {
      if (user.getId().equals(userId) && user.getEmail().equals(userEmail)) {
        loginUser = user;
        break;
      }
    }

    if (loginUser != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(loginUser);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 아이디와 이메일을 가진 회원을 찾을 수 없습니다.");
    }
  }

  private void selectOneByUser(Request request, Response response) throws Exception {
    String userId = request.getParameter("userId");
    String userPassword = request.getParameter("userPassword");

    JoinDTO loginUser = null;
    for (JoinDTO user : list) {
      if (user.getId().equals(userId) && 
          user.getPassword().equals(userPassword)) {
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

  private void selectOneByEmail(Request request, Response response) throws Exception {
    String userEmail = request.getParameter("userEmail");

    JoinDTO loginUser = null;
    for (JoinDTO user : list) {
      if (user.getEmail().equals(userEmail)) {
        loginUser = user;
        break;
      }
    }

    if (loginUser != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(loginUser);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 이메일을 가진 회원을 찾을 수 없습니다.");
    }
  }

  private void selectOneByTel(Request request, Response response) throws Exception {
    String userTel = request.getParameter("userTel");

    JoinDTO loginUser = null;
    for (JoinDTO user : list) {
      if (user.getTel().equals(userTel)) {
        loginUser = user;
        break;
      }
    }

    if (loginUser != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(loginUser);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 전화번호를 가진 회원을 찾을 수 없습니다.");
    }
  }

  private void validId(Request request, Response response) throws Exception {
    JoinDTO loginUser = request.getObject(JoinDTO.class);

    for (JoinDTO user : list) {
      if (user.getId().equals(loginUser.getId())) {
        response.setStatus(Response.FAIL);
        response.setValue("이미 존재하는 아이디입니다. 다시 입력해주세요!");
        return;
      }
    }
    response.setStatus(Response.SUCCESS);
    response.setValue(loginUser);
  }

  private void getNextNum(Request request, Response response) throws Exception {
    JoinDTO loginUser = new JoinDTO();

    loginUser.setNo(getLastNum());

    response.setStatus(Response.SUCCESS);
    response.setValue(loginUser);
  }

  private int getLastNum() {
    if (list.size() > 0) {
      return list.get(list.size() - 1).getNo() + 1;
    } else {
      return 1;
    }
  }

  private int indexOf(int joinNo) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == joinNo) {
        return i;
      }
    }
    return -1;
  }

}
