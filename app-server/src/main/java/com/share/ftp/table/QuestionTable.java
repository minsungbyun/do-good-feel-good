package com.share.ftp.table;

import java.util.ArrayList;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.QuestionListDTO;
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
      case "qeustion.selectListByKeyword": selectListByKeyword(request, response); break;
      case "qeustion.selectOne": selectOne(request, response); break;
      case "qeustion.update": update(request, response); break;
      case "qeustion.delete": delete(request, response); break;
      case "qeustion.getNextNum": getNextNum(request, response); break;
      default:
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }
  private void insert(Request request, Response response) throws Exception {
    QuestionListDTO myQuestionListDTO = request.getObject(QuestionListDTO.class);
    list.add(myQuestionListDTO);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectListByKeyword(Request request, Response response) throws Exception {
    String keyword = request.getParameter("keyword");

    ArrayList<Board> searchResult = new ArrayList<>();
    for (Board board : list) {
      if (!board.getTitle().contains(keyword) &&
          !board.getContent().contains(keyword) &&
          !board.getWriter().getName().contains(keyword)) {
        continue;
      }
      searchResult.add(board);
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(searchResult);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    Board b = findByNo(no);

    if (b != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(b);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
    }
  }

  private void update(Request request, Response response) throws Exception {
    Board board = request.getObject(Board.class);

    int index = indexOf(board.getNo());
    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
      return;
    }

    list.set(index, board);
    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    int index = indexOf(no);

    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
      return;
    }

    list.remove(index);
    response.setStatus(Response.SUCCESS);
  }
  private void getNextNum(Request request, Response response) throws Exception {
    ChallengeDTO challenge = new ChallengeDTO();

    challenge.setNo(getLastNum());

    response.setStatus(Response.SUCCESS);
    response.setValue(challenge);
  }
}