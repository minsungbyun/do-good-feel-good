package com.share.ftp.web.join.org;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.domain.join.OrgDTO;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

//@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
//@WebServlet("/join/org/add")
public class OrgAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  OrgDao orgDao;

  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    orgDao = (OrgDao) 웹애플리케이션공용저장소.getAttribute("orgDao");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    try {
      OrgDTO orgDTO = new OrgDTO();

      orgDTO.setId(request.getParameter("id"));
      orgDTO.setPassword(request.getParameter("password"));
      orgDTO.setName(request.getParameter("name"));
      orgDTO.setTel(request.getParameter("tel"));
      orgDTO.setEmail(request.getParameter("email"));
      orgDTO.setPostNo(request.getParameter("postNo"));
      orgDTO.setBasicAddress(request.getParameter("basicAddress"));
      orgDTO.setDetailAddress(request.getParameter("detailAddress"));
      orgDTO.setCorpNo(request.getParameter("corpNo"));
      orgDTO.setFax(request.getParameter("fax"));
      orgDTO.setHomepage(request.getParameter("homepage"));
      orgDTO.setType(3);
      orgDTO.setStatus(2);

      Part photoPart = request.getPart("photo");
      if (photoPart.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        photoPart.write(getServletContext().getRealPath("/upload/user") + "/" + filename);
        orgDTO.setPhoto(filename);

        Thumbnails.of(getServletContext().getRealPath("/upload/user") + "/" + filename)
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

        Thumbnails.of(getServletContext().getRealPath("/upload/user") + "/" + filename)
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

      orgDao.insert(orgDTO);
      orgDao.insertOrg(orgDTO.getNo(), orgDTO.getCorpNo(), orgDTO.getFax(), orgDTO.getHomepage());
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=../../home");
      request.setAttribute("contentUrl", "/join/org/OrgUserAdd.jsp");
      request.getRequestDispatcher("/template1.jsp").forward(request, response);
      //      request.getRequestDispatcher("OrgUserAdd.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);

    }
  }
}







