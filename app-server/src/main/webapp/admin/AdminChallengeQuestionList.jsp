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
<a href='questionForm?no=${challengeDTO.no}'>문의 등록</a><br>
<table border='1'>
<thead>
  <tr>
    <th>번호</th>
    <th>내용</th>
    <th>작성자</th>
    <th>등록일</th>
  </tr>
</thead>
<tbody>

<c:forEach items="${challengeQuestionList}" var="challengeQuestionDTO">
<tr>
    <td>${challengeQuestionDTO.questionNo}</td>
    <td>${challengeQuestionDTO.content}</td> 
    <td>${challengeQuestionDTO.owner.id}</td> 
    <td>${challengeQuestionDTO.registeredDate}</td>
    <td><a href='questionUpdateDetail?questionNo=${challengeQuestionDTO.questionNo}&no=${challengeQuestionDTO.no}'>[답글등록]</a></td>
    <td><a href='questionDelete?questionNo=${challengeQuestionDTO.questionNo}&no=${challengeQuestionDTO.no}'>[삭제]</a></td>
</tr>
  <tr>
    <th>답글</th>
    <td>${challengeQuestionDTO.reply}</td> 
    <td><a href='questionUpdateDetail?questionNo=${challengeQuestionDTO.questionNo}&no=${challengeQuestionDTO.no}'>[답글변경]</a></td>
    <td><a href='questionDelete?questionNo=${challengeQuestionDTO.questionNo}&no=${challengeQuestionDTO.no}'>[답글삭제]</a></td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>