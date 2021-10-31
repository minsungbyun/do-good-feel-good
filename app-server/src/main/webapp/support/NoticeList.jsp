<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>공지사항 목록</title>
</head>
<body>
<h1>공지사항 목록</h1>
<a href='noticeForm'>글쓰기</a><br>
<table border='1'>
<thead>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>등록일</th>
    <th>조회수</th>
   <!--  <th>첨부파일</th> --> 
  </tr>
</thead>
<tbody>
<c:forEach items="${noticeList}" var="notice" >
<tr>
    <td>${notice.no}</td>
    <td><a href='noticeDetail?no=${notice.no}'>${notice.title}</a></td> 
    <td>${notice.registeredDate}</td> 
    <td>${notice.viewCount}</td> 
    <!-- <td>${notice.fileUpload}</td> -->
</tr>
</c:forEach>
<label for='f-search'>검색어</label>
<input id='f-search' type="search" name='keword'>
<button>검색</button>
</tbody>
</table>
</body>
</html>








