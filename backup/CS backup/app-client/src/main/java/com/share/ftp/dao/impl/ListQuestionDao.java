//package com.share.ftp.dao.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//import com.share.ftp.dao.QuestionDao;
//import com.share.ftp.domain.personal.QuestionListDTO;
//
//// 게시글 데이터를 컬렉션 객체를 이용하여 관리한다.
////
//public class ListQuestionDao implements QuestionDao {
//  List<QuestionListDTO> myQuestionListDTOList = new ArrayList<>();
//
//  @Override
//  public void insert(QuestionListDTO myQuestionListDTO) throws Exception {
//    myQuestionListDTOList.add(myQuestionListDTO);
//  }
//
//  @Override
//  public List<QuestionListDTO> findAll() throws Exception {
//    return myQuestionListDTOList;
//  }
//
//  @Override
//  public List<QuestionListDTO> findByKeyword(String keyword) throws Exception {
//    ArrayList<QuestionListDTO> result = new ArrayList<>();
//    for (QuestionListDTO question : myQuestionListDTOList) {
//      if (question.getTitle().equalsIgnoreCase(keyword) ||
//          question.getContent().equalsIgnoreCase(keyword) ||
//          question.get.getId().equalsIgnoreCase(keyword)) {
//        result.add(question);
//      }
//    }
//    return result;
//  }
//
//  @Override
//  public QuestionListDTO findByNo(int no) throws Exception {
//    for (QuestionListDTO question : myQuestionListDTOList) {
//      if (question.getNo() == no) {
//        return question;
//      }
//    }
//    return null;
//  }
//
//  @Override
//  public void update(QuestionListDTO myQuestionListDTO) throws Exception {
//    for (int i = 0; i < myQuestionListDTOList.size(); i++) {
//      if (myQuestionListDTOList.get(i).getNo() == myQuestionListDTO.getNo()) {
//        myQuestionListDTOList.set(i, myQuestionListDTO);
//        return;
//      }
//    }
//  }
//
//  @Override
//  public void delete(int no) throws Exception {
//    for (int i = 0; i < myQuestionListDTOList.size(); i++) {
//      if (myQuestionListDTOList.get(i).getNo() == no) {
//        myQuestionListDTOList.remove(i);
//        return;
//      }
//    }
//  }
//
//  @Override
//  public int getNextNum() throws Exception {
//    if (myQuestionListDTOList.size() > 0) {
//      return myQuestionListDTOList.get(myQuestionListDTOList.size() - 1).getNo() + 1;
//    } else {
//      return 1;
//    }
//  }
//}
//
//
//
