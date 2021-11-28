<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>나눔이야기 전체 리스트</title>
<div class="ad-main">
	<div class="ad-main-infor">
		<!-- serch -->
		<div class="serch">
			<label for="inforSerch">검색</label> <input type="text" class=""
				id="inforSerch">
			<button type="submit" class="searchBtn">검색</button>
		</div>
		<!-- //serch -->
		<div class="table01">
			<table class="table">
				<thead>
					<tr>
						<th scope="col" style="text-align: center;">번호</th>
						<th scope="col" style="text-align: center;">제목</th>
						<th scope="col" style="text-align: center;">작성자</th>
						<th scope="col" style="text-align: center;">등록일</th>
						<th scope="col" style="text-align: center;">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:if test='${empty volunteerBoardList}'>
						<p>작성된 게시글이 없습니다.</p>
					</c:if>

					<c:forEach items="${volunteerBoardList}" var="volunteerBoardDTO">

						<tr data-no='${volunteerBoardDTO.no}'>
							<td>${volunteerBoardDTO.no}</td>
							<td><a href='boardDetail?no=${volunteerBoardDTO.no}'>${volunteerBoardDTO.title}</a></td>
							<td>${volunteerBoardDTO.owner.id}</td>
							<td>${volunteerBoardDTO.registeredDate}</td>
							<td>${volunteerBoardDTO.viewCount}</td>
							<%-- 							<td>
								<button type="button" class="btn btn-primary x-delete-btn"
									data-bs-toggle="modal" data-bs-target="#noticeModal"
									data-no="${volunteerBoardDTO.no}">삭제</button>
							</td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<%-- 			<div class="ad-btn">
            <input type="button" id="delete" value="삭제" onClick="/admin//volunteer/boardDelete?no=${volunteerBoardDTO.no}">
            <!--<a href="noticeDelete?noticeNo=${noticeDTO.no}" class="btnSubmit">삭제</a>-->
          </div>
		</div> --%>
			<!-- //table-wrap -->


		<!-- //form -->
		<div class="col-12 my-5">
			<nav aria-label="Page Navigation">
				<ul class="pagination justify-content-center">
					<li class="page-item disabled"><a class="page-link" href="#"
						tabindex="-1" aria-disabled="true">Previous</a></li>
					<li class="page-item active" aria-current="page"><a
						class="page-link" href="#">1 <span class="sr-only">(current)</span></a>
					</li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</nav>
		</div>
		<!-- //pageNo -->
	</div>