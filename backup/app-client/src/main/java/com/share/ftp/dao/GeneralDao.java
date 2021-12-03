package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.support.QuestionCategory;

public interface GeneralDao {

  List<Category> findAllCategory() throws Exception;
  List<QuestionCategory> findAllQnaCategory() throws Exception;
  //  List<DonationRegisterPayType> findAllPayType() throws Exception;

  // 향후 확장성 위해서 나둠
  //  List<Status> findAllStatus() throws Exception;



}
