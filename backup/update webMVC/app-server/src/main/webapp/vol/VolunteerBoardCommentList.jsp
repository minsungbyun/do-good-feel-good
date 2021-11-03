<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>나눔이야기 댓글 목록</title>
</head>
<body>
<h1>봉사게시판 - 게시글 댓글 목록</h1>
<a href='form'>후기 작성</a><br>
<table border='1'>
<thead>
  <tr>
    <th>번호</th>
    <th>게시글번호</th>
    <th>작성자</th>
    <th>내용</th>
    <th>등록일</th>
    <th>변경/ 삭제</th>
    
  </tr>
</thead>
<tbody>

<c:forEach items="${volunteerBoardCommentList}" var="volunteerBoardCommentDTO">
<tr>
    <td>${volunteerBoardCommentDTO.no}</td> 
    <td>${volunteerBoardCommentDTO.volBoardNo}</td> 
    <td>${volunteerBoardCommentDTO.owner.id}</td> 
    <td>${volunteerBoardCommentDTO.commentContent}</td> 
    <td>${volunteerBoardCommentDTO.registeredDate}</td>
    <td><button>변경</button> <a href='delete?no=${volunteerBoardCommentDTO.no}'>[삭제]</a></td> 
</tr>


 
</c:forEach>

</tbody>
</table>
</body>
</html>








