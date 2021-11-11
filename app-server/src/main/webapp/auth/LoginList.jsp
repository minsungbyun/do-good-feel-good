<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원목록</title>
</head>
<body>
<h1>회원 목록(MVC + EL + JSTL)</h1>
<div><a href='form'>새회원</a></div>
<table border='1'>

<thead>
  <tr>
    <th>회원번호</th>
    <th>아이디</th>
    <th>이름</th>
    <th>전화</th>
    <th>이메일</th>
    <th>우편번호</th>
    <th>기본주소</th>
    <th>상세주소</th>
    <th>승인상태</th>
    <th>등록일</th>
  </tr>
</thead>
<tbody>



<c:forEach items="${joinUserList}" var="joinDTO">
<tr>
	  <td>${joinDTO.no}</td> 
	  <td><a href='../donation/myDonationMoney?no=${joinDTO.no}'>${joinDTO.id}</a></td> 
	  <td>${joinDTO.name}</td> 
	  <td>${joinDTO.tel}</td> 
	  <td>${joinDTO.email}</td> 
	  <td>${joinDTO.postNo}</td> 
	  <td>${joinDTO.basicAddress}</td> 
	  <td>${joinDTO.detailAddress}</td> 
	  <td>${joinDTO.status}</td> 
	  <td>${joinDTO.registerDate}</td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>












    