<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<layoutTag:layout>
 
<div class="container">
    <div class="col-xs-12" style="margin:15px auto;">
        <label style="font-size:20px;"><span class="glyphicon glypshicon-list-alt"></span>봉사 게시판 상세</label>
    </div>
 
    <div class="col-xs-12">
        <form action="/insertProc" method="post">
            <dl class="dl-horizontal">
              <dt>제목</dt>
              <dd>${volunteerBoardDTO.title}</dd>
              
              <dt>작성자</dt>
              <dd>${volunteerBoardDTO.owner.id}</dd>
              
              <dt>작성일</dt>
              <dd>
                  <fmt:formatDate value="${volunteerBoardDTO.registeredDate}" pattern="yyyy.MM.dd HH:mm:ss"/>
              </dd>
           
              <%--          <dt>첨부파일</dt>
              <dd><a href="/fileDown/${files.bno}">${files.fileOriName}</a></dd>--%>
     
              <dt>내용</dt>
              <dd>${volunteerBoardDTO.content}</dd>
            </dl>
        </form>
        <div class="btn-group btn-group-sm" role="group" style="float:right;">
          <button type="button" class="btn btn-default" onclick="location.href='/boardDelete?no=${volunteerBoardDTO.no}'">삭제</button>
          <button type="button" class="btn btn-default" onclick="location.href='/boardUpdate/${volunteerBoardDTO.no}'">수정</button>
          <button type="button" class="btn btn-default" onclick="location.href='/boardList'"> 목록 </button>
        </div>
    </div>
    
    <!--                     추가                         -->
    <!--  댓글  -->
    <div class="container">
        <label for="content">comment</label>
        <form name="commentInsertForm">
            <div class="input-group">
               <input type="hidden" name="bno" value="${detail.bno}"/>
               <input type="text" class="form-control" id="content" name="content" placeholder="내용을 입력하세요.">
               <span class="input-group-btn">
                    <button class="btn btn-default" type="button" name="commentInsertBtn">등록</button>
               </span>
              </div>
        </form>
    </div>
    
    <div class="container">
        <div class="commentList"></div>
    </div>
</div>
 
<!--                     추가                         -->
<%@ include file="VolunteerBoardCommentList.jsp" %>
</layoutTag:layout>

