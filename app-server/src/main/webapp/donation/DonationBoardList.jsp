<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>모금함목록</title>
  <style>
  #box1 {
  visibility: hidden;
  }
  </style>
</head>
<body>
<h1>모금함 목록(MVC + EL + JSTL1)</h1>
<div><a href='boardForm'>모금함 개설 신청</a></div>
<table border='1'>
<thead>
  <tr>
    <th>개설번호</th>
    <th>모금함 분류</th>
    <th>주최자</th>
    <th>제목</th>
    <th>내용</th>
    <th>첨부파일</th>
    <th>개설시작일</th>
    <th>개설종료일</th>
    <th>총기간</th>
    <th>남은기간</th>
    <th>목표금액</th>
    <th>승인여부</th>
  </tr>
</thead>
<tbody>

<c:forEach items="${donationBoardList}" var="donationBoardDTO">
<tr>
	  <td>${donationBoardDTO.no}</td> 
	  <td>${donationBoardDTO.category.title}</td> 
	  <td>${donationBoardDTO.leader.name}</td> 
	  <td><a href='boardDetail?no=${donationBoardDTO.no}'>${donationBoardDTO.title}</a></td> 
	  <td>${donationBoardDTO.content}</td>
	  <td>${donationBoardDTO.fileNames}</td>
	  <td>${donationBoardDTO.startDate}</td>
	  <td>${donationBoardDTO.endDate}</td>
	  <td>${donationBoardDTO.totalDate}</td>
    <td>${donationBoardDTO.remainDate}</td>
	  <td>${donationBoardDTO.moneyTarget}</td>
	  <td>${donationBoardDTO.status}</td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>












    