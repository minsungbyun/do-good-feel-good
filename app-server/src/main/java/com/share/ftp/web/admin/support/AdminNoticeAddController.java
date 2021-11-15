package com.share.ftp.web.admin.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeAttachedFile;
import com.share.ftp.domain.admin.NoticeDTO;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/admin/support/noticeAdd")
public class AdminNoticeAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  NoticeDao noticeDao;
  //  GeneralDao generalDao;


  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    noticeDao = (NoticeDao) 웹애플리케이션공용저장소.getAttribute("noticeDao");
    //    generalDao = (GeneralDao) 웹애플리케이션공용저장소.getAttribute("generalDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    try {
      NoticeDTO noticeDTO = new NoticeDTO();

      noticeDTO.setTitle(request.getParameter("title"));
      noticeDTO.setContent(request.getParameter("content")); 
      //    noticeDTO.setFileUpload((List<NoticeAttachedFile>)request.getAttribute("fileUpload"));

      Part photoPart = request.getPart("fileUpload");
      if (photoPart.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        photoPart.write(getServletContext().getRealPath("/upload/support") + "/" + filename);
        NoticeAttachedFile fn = new NoticeAttachedFile();
        fn.setFilepath(filename);
        List<NoticeAttachedFile> fc = new ArrayList<>();
        fc.add(fn);
        noticeDTO.setFileUpload(fc);

        Thumbnails.of(getServletContext().getRealPath("/upload/support") + "/" + filename)
        .size(20, 20)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        //.toFiles(Rename.PREFIX_DOT_THUMBNAIL);
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_20x20";
          }
        });

        Thumbnails.of(getServletContext().getRealPath("/upload/support") + "/" + filename)
        .size(100, 100)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        //.toFiles(Rename.PREFIX_DOT_THUMBNAIL);
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_100x100";
          }
        });
      }

      noticeDao.insert(noticeDTO);
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=noticeList");
      request.getRequestDispatcher("/admin/support/AdminNoticeAdd.jsp").forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);

      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }

    //    try {
    //      noticeDao.insert(noticeDTO);
    //      for (NoticeAttachedFile noticeAttachedFile : noticeDTO.getFileUpload()) {
    //        noticeDao.insertFile(noticeDTO.getNo(), noticeAttachedFile.getFilepath());
    //      }
    //      sqlSession.commit();
    //
    //    } catch (Exception e) {
    //      e.printStackTrace(); 
    //      sqlSession.rollback();
    //    }


  }
}
