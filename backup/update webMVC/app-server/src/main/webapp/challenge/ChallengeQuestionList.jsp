<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>챌린지문의목록</title>
</head>
<body>
<h1>문의 목록</h1>
<a href='form'>문의 등록</a><br>
<table border='1'>
<thead>
  <tr>
    <th>번호</th>
    <th>내용</th>
<!--     <th>파일첨부</th> -->
    <th>작성자</th>
  </tr>
</thead>
<tbody>

<c:forEach items="${challengeQuestionList}" var="challengeQuestionDTO">
<tr>
    <td>${challengeQuestionDTO.questionNo}</td>
    <td><a href='detail?no=${challengeQuestionDTO.questionNo}'>${challengeQuestionDTO.content}</a></td> 
<!--    <td>${challengeReviewDTO.fileUpload}</td> -->
    <td>${challengeQuestionDTO.owner.id}</td> 
    <td><a href='questionDelete?questionNo=${challengeQuestionDTO.questionNo}'>[삭제]</a></td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>