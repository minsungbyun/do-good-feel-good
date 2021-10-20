package com.share.ftp.dao.impl;

import java.sql.Connection;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeDTO;

// 게시글을 DBM서버를 통해 관리한다.

public class MybatisNoticeDao implements NoticeDao {

  Connection con;
  SqlSession sqlSession;

  public MybatisNoticeDao(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public void insert(NoticeDTO addNotice) throws Exception {
    sqlSession.insert("NoticeMapper.insert", addNotice);
    sqlSession.commit();

  }
  @Override
  public List<NoticeDTO> findAll() throws Exception {
    return sqlSession.selectList("NoticeMapper.findAll");
  }

  @Override
  public List<NoticeDTO> findByKeyword(String keyword) throws Exception {
    return sqlSession.selectList("NoticeMapper.findByKeyword", keyword);
  }

  @Override
  public NoticeDTO findByNoticeNo(int noticeNo) throws Exception {
    return sqlSession.selectOne("NoticeMapper.findByNoticeNo", noticeNo);
  }


  @Override
  public void update(NoticeDTO updateNotice) throws Exception {
    sqlSession.update("NoticeMapper.update", updateNotice);
    sqlSession.commit();
  }

  @Override
  public void delete(int noticeNo) throws Exception {
    sqlSession.delete("NoticeMapper.delete", noticeNo);
    sqlSession.commit();
  }


  //  @Override
  //  public int getNextNum() throws Exception {
  //
  //    requestAgent.request("notice.getNextNum", null);
  //
  //
  //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
  //      throw new Exception("게시글 번호 부여 중 오류 발생!");
  //    }
  //    System.out.println("확인");
  //    NoticeDTO noticeDTO = requestAgent.getObject(NoticeDTO.class);
  //
  //
  //    return noticeDTO.getNo();
  //  }

}
