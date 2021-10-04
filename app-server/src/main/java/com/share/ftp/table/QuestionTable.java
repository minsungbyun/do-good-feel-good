package com.share.ftp.table;

import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

public class QuestionTable extends JsonDataTable<QuestionListDTO> implements DataProcessor {

  public QuestionTable() {
    super("question.json",QuestionListDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand() ) {
      //      case "qeustion.a

    }
  }
}