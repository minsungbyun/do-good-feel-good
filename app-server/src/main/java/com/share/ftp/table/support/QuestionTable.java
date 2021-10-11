package com.share.ftp.table.support;

import java.util.ArrayList;
import com.share.ftp.domain.support.QuestionListDTO;
import com.share.ftp.table.JsonDataTable;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

// 게시글 데이터를 처리하는 일을 한다.
public class QuestionTable extends JsonDataTable<QuestionListDTO> implements DataProcessor {

  public QuestionTable() {
    super("question.json", QuestionListDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand() ) {
      case "question.insert": insert(request, response); break;
      case "question.selectList": selectList(request, response); break;
      case "question.selectListByKeyword": selectListByKeyword(request, response); break;
      case "question.selectOne": selectOne(request, response); break;
      case "question.update": update(request, response); break;
      case "question.delete": delete(request, response); break;
      case "question.getNextNum": getNextNum(request, response); break;
      default:
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }

  private void insert(Request request, Response response) throws Exception {
    QuestionListDTO question = request.getObject(QuestionListDTO.class);
    System.out.println(question);
    list.add(question);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectListByKeyword(Request request, Response response) throws Exception {
    String keyword = request.getParameter("keyword");

    ArrayList<QuestionListDTO> searchResult = new ArrayList<>();
    for (QuestionListDTO questionListDTO : list) {
      if (!questionListDTO.getTitle().contains(keyword) &&
          !questionListDTO.getContent().contains(keyword) &&
          !questionListDTO.getOwner().getId().contains(keyword)) {
        continue;
      }
      searchResult.add(questionListDTO);
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(searchResult);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int questionNo = Integer.parseInt(request.getParameter("questionNo"));
    QuestionListDTO questionListDTO = findByNo(questionNo);

    if (questionListDTO != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(questionListDTO);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
    }
  }

  private void update(Request request, Response response) throws Exception {
    QuestionListDTO updateQuestion = request.getObject(QuestionListDTO.class);

    int index = indexOf(updateQuestion.getNo());
    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
      return;
    }

    list.set(index, updateQuestion);
    response.setStatus(Response.SUCCESS);
  }


  private void delete(Request request, Response response) throws Exception {
    //    QuestionListDTO deleteQuestion = request.getObject(QuestionListDTO.class);

    int questionNo = Integer.parseInt(request.getParameter("questionNo"));
    int index = indexOf(questionNo);

    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
      return;
    }

    list.remove(index);
    response.setStatus(Response.SUCCESS);
  }

  private void getNextNum(Request request, Response response) throws Exception {
    QuestionListDTO question = new QuestionListDTO();

    question.setNo(getLastNum());

    response.setStatus(Response.SUCCESS);
    response.setValue(question);
  }

  private int getLastNum() {
    if (list.size() > 0) {
      return list.get(list.size() - 1).getNo() + 1;
    } else {
      return 1;
    }
  }

  private QuestionListDTO findByNo(int questionNo) {
    for (QuestionListDTO questionListDTO : list) {
      if (questionListDTO.getNo() == questionNo) {
        return questionListDTO;
      }
    }
    return null;
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