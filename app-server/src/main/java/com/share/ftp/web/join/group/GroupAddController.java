package com.share.ftp.web.join.group;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.GroupDao;
import com.share.ftp.domain.join.GroupDTO;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/join/group/add")
public class GroupAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  GroupDao groupDao;

  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    groupDao = (GroupDao) 웹애플리케이션공용저장소.getAttribute("groupDao");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {

      GroupDTO groupDTO = new GroupDTO();

      groupDTO.setId(request.getParameter("id"));
      groupDTO.setPassword(request.getParameter("password"));
      groupDTO.setName(request.getParameter("name"));
      groupDTO.setTel(request.getParameter("tel"));
      groupDTO.setEmail(request.getParameter("email"));
      groupDTO.setPostNo(request.getParameter("postNo"));
      groupDTO.setBasicAddress(request.getParameter("basicAddress"));
      groupDTO.setDetailAddress(request.getParameter("detailAddress"));
      groupDTO.setType(2);
      groupDTO.setStatus(2);

      groupDTO.setGroupCount(Integer.valueOf(request.getParameter("groupCount")));

      Part photoPart = request.getPart("photo");
      if (photoPart.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        photoPart.write(getServletContext().getRealPath("/upload/user") + "/" + filename);
        groupDTO.setPhoto(filename);

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

      groupDao.insert(groupDTO);
      groupDao.insertGroup(groupDTO.getNo(), groupDTO.getGroupCount());
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=../../home");
      request.setAttribute("contentUrl", "/join/group/GroupUserAdd.jsp");
      request.getRequestDispatcher("/template1.jsp").forward(request, response);
      //      request.getRequestDispatcher("/join/group/GroupUserAdd.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);

    }
  }
}







