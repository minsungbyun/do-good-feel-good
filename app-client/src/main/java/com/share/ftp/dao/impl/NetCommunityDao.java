package com.share.ftp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.request.RequestAgent;

// 게시글 데이터를 서버를 통해 관리한다.

public class NetCommunityDao implements CommunityDao {

  RequestAgent requestAgent;

  public NetCommunityDao(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public void insert(CommBoardDTO addCommBoard) throws Exception {
    requestAgent.request("commBoard.insert", addCommBoard);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("[ 게시글 등록이 정상적으로 완료되었습니다! ]");

    } else {
      throw new Exception("게시글 등록 실패!");
    }
  }

  @Override
  public List<CommBoardDTO> findAll() throws Exception {

    requestAgent.request("commBoard.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 목록 조회 실패!");
    }
    return new ArrayList<>(requestAgent.getObjects(CommBoardDTO.class));
  }

  @Override
  public List<CommBoardDTO> findByKeyword(String keyword) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("keyword", keyword);
    requestAgent.request("commBoard.selectListByKeyword", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 검색 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(CommBoardDTO.class));
  }

  @Override
  public CommBoardDTO findByCommNo(int commBoardNo) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("commBoardNo", String.valueOf(commBoardNo));

    requestAgent.request("commBoard.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(CommBoardDTO.class);
  }


  @Override
  public void update(CommBoardDTO updateCommBoard) throws Exception {
    requestAgent.request("commBoard.update", updateCommBoard);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 변경 실패!");
    }

  }

  @Override
  public void delete(CommBoardDTO deleteCommBoard) throws Exception {
    requestAgent.request("commBoard.delete", deleteCommBoard);
    // HashMap<String,String> params = new HashMap<>();
    // params.put("deleteCommBoardNo", String.valueOf(commReviewNo));

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 삭제 실패!");
    }
  }

  @Override
  public void like(CommBoardDTO likeCommBoard) throws Exception {
    requestAgent.request("commBoard.like", likeCommBoard);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("좋아요 반영 실패!");
    }
  }

  @Override
  public int getNextNum() throws Exception {

    requestAgent.request("commBoard.getNextNum", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 번호 부여 중 오류 발생!");
    }
    CommBoardDTO commBoardDTO = requestAgent.getObject(CommBoardDTO.class);


    return commBoardDTO.getCommNo();
  }


  // 한 줄 후기

  @Override
  public void insertReview(CommReviewDTO addCommReview) throws Exception {
    requestAgent.request("commReview.insert", addCommReview);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("[ 한 줄 후기 등록이 정상적으로 완료되었습니다! ]");

    } else {
      throw new Exception("한 줄 후기 등록 실패!");
    }
  }

  @Override
  public List<CommReviewDTO> findAllCommReview() throws Exception {

    requestAgent.request("commReview.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("한 줄 후기 목록 조회 실패!");
    }
    return new ArrayList<>(requestAgent.getObjects(CommReviewDTO.class));
  }

  @Override
  public List<CommReviewDTO> findByCommReviewKeyword(String keyword) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("keyword", keyword);
    requestAgent.request("commReview.selectListByKeyword", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("한 줄 후기 검색 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(CommReviewDTO.class));
  }

  @Override
  public CommReviewDTO findByCommReviewNo(int commReviewNo) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("commReviewNo", String.valueOf(commReviewNo));

    requestAgent.request("commReview.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(CommReviewDTO.class);
  }


  @Override
  public void updateCommReview(CommReviewDTO updateCommReview) throws Exception {
    requestAgent.request("commReview.update", updateCommReview);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("한 줄 후기 변경 실패!");
    }

  }

  @Override
  public void deleteCommeReview(CommReviewDTO deleteCommReview) throws Exception {
    requestAgent.request("commReview.delete", deleteCommReview);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("한 줄 후기 삭제 실패!");
    }
  }

  @Override
  public int getNextNumCommReview() throws Exception {

    requestAgent.request("commReview.getNextNum", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("한 줄 후기 번호 부여 중 오류 발생!");
    }
    CommReviewDTO commReviewDTO = requestAgent.getObject(CommReviewDTO.class);


    return commReviewDTO.getCommReviewNo();
  }

  // 나눔이야기 댓글

  @Override
  public void insertReply(CommBoardReplyDTO addcommReply) throws Exception {
    requestAgent.request("commReply.insert", addcommReply);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("[ 댓글 등록이 정상적으로 완료되었습니다! ]");

    } else {
      throw new Exception("댓글 등록 실패!");
    }
  }


  @Override
  public List<CommBoardReplyDTO> findAllCommReply() throws Exception {

    requestAgent.request("commReply.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("댓글 목록 조회 실패!");
    }
    return new ArrayList<>(requestAgent.getObjects(CommBoardReplyDTO.class));
  }


  @Override
  public CommBoardReplyDTO findByCommReplyNo(int commBoardNo, int commReplywNo) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("commBoardNo", String.valueOf(commBoardNo));
    params.put("commReplywNo", String.valueOf(commReplywNo));
    requestAgent.request("commReply.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(CommBoardReplyDTO.class);
  }


  @Override
  public CommBoardReplyDTO findByCommReplyNo(int commReplyNo) throws Exception {
    return null;
  }


  @Override
  public void updateCommReply(CommBoardReplyDTO updateCommReply) throws Exception {
    requestAgent.request("commReply.update", updateCommReply);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("한 줄 후기 변경 실패!");
    }
  }


  @Override
  public void deleteCommeReply(CommBoardReplyDTO deleteCommReply) throws Exception {
    requestAgent.request("commReply.delete", deleteCommReply);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("한 줄 후기 삭제 실패!");
    }
  }


  @Override
  public int getNextNumCommReply() throws Exception {

    requestAgent.request("commReply.getNextNum", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("한 줄 후기 번호 부여 중 오류 발생!");
    }
    CommBoardReplyDTO commBoardReplyDTO = requestAgent.getObject(CommBoardReplyDTO.class);


    return commBoardReplyDTO.getCommReplyNo();
  }




}
