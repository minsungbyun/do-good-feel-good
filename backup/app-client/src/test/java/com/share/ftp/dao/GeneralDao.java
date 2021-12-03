package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.Status;

public interface GeneralDao {

  List<Category> findAllCategory() throws Exception;
  List<Status> findAllStatus() throws Exception;



}
