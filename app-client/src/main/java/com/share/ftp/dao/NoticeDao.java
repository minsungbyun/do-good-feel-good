package com.share.ftp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.share.ftp.domain.admin.NoticeDTO;

// 게시글 데이터를 처리하는 객체 사용법을 정의
public interface NoticeDao {

  void insert(NoticeDTO addNotice) throws Exception;
  void insertFile(
      @Param("no") int no,
      @Param("filepath") String filepath) throws Exception;
  List<NoticeDTO> findAll() throws Exception;
  List<NoticeDTO> findByKeyword(String keyword) throws Exception;
  NoticeDTO findByNo(int noticeNo) throws Exception;
  void update(NoticeDTO updateNotice) throws Exception;
  void updateFile(NoticeDTO updateNotice) throws Exception;
  void delete(NoticeDTO deleteNotice) throws Exception;
  void deleteFile(NoticeDTO deleteNotice) throws Exception;

}
