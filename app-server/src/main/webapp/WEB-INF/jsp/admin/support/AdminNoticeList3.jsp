<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="ad-main">
	<div class="ad-main-infor">

		<!-- serch -->
		<div class="serch">
			<label for="f-search">검색</label> <input type="search" class=""
				id="f-search" name="keword" placeholder="검색">
			<button type="submit" class="searchBtn">검색</button>
		</div>
		<!-- //serch -->

		<div class="table01">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">등록일</th>
						<th scope="col">조회수</th>
						<!-- <th scope="col">첨부파일</th> -->
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:if test='${empty noticeList}'>
						<p>작성된 게시글이 없습니다.</p>
					</c:if>

					<c:forEach items="${noticeList}" var="noticeDTO">
						<tr data-no="${noticeDTO.no}">
							<td>${noticeDTO.no}</td>
							<td><a href='noticeDetail?noticeNo=${noticeDTO.no}'>${noticeDTO.title}</a></td>
							<td>${noticeDTO.registeredDate}</td>
							<td>${noticeDTO.viewCount}</td>
							<%-- <td>${noticeDTO.fileUpload}</td> --%>
							<td>
								<button type="button" class="btn btn-primary x-delete-btn" 
				                data-bs-toggle="modal" 
				                data-bs-target="#memberModal"
				                data-no="${noticeDTO.no}">
				            삭제
				        </button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<!-- 모달창 -->
			<div class="modal fade" id="memberModal" tabindex="-1"
				aria-labelledby="memberModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- 모달 header -->
						<div class="modal-header">
							<h5 class="modal-title" id="memberModalLabel">공지사항 삭제</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<!-- //모달 header -->

						<!-- 모달 상세 -->
						<div class="modal-body">
							<h1>공지사항 상세</h1>
							<div class="mb-3 row">
								<label for='f-no' class="col-sm-2 col-form-label">번호</label>
								<div class="col-sm-6">
									<input id='f-no' type='text' class="form-control-plaintext"
										value='1' readonly>
								</div>
							</div>
							<div class="mb-3 row">
								<label for='f-title' class="col-sm-2 col-form-label">제목</label>
								<div class="col-sm-6">
									<input id='f-title' type='text' name='title' class="form-control"
										value="aaa">
								</div>
							</div>
							<div class="mb-3 row">
								<label for='f-content' class="col-sm-2 col-form-label">내용</label>
								<div class="col-sm-10">
									<input id='f-content' type='text' name='content'
										class="form-control" value="aaaa">
								</div>
							</div>
						</div>
						<!-- //모달 상세 -->

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">닫기</button>
							<button type="button" class="btn btn-primary">삭제</button>
						</div>
					</div>
				</div>
			</div>
			<!-- //모달창 -->

			<div class="ad-btn">
				<a href="noticeForm" class="btnSubmit">글쓰기</a>
				<%-- <a href="noticeDelete?noticeNo=${noticeDTO.no}" class="btnSubmit">삭제</a> --%>
			</div>
		</div>
		<!-- //table01 -->
	</div>
	<!-- //ad-main-infor -->

	<!-- 페이징 -->
	<div class="col-12 my-5">
		<nav aria-label="Page Navigation">
			<ul class="pagination justify-content-center">
				<li class="page-item disabled"><a class="page-link" href="#"
					tabindex="-1" aria-disabled="true">이전</a></li>
				<li class="page-item active" aria-current="page"><a
					class="page-link" href="#">1 <span class="sr-only">(current)</span></a>
				</li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">다음</a></li>
			</ul>
		</nav>
	</div>
	<!-- //페이징 -->
</div>
<!-- //ad-main -->

<script src="${contextPath}/assets/js/jquery-3.5.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
var modalNo = document.querySelector("#f-no");
var modalTitle = document.querySelector("#f-title");
var modalContent = document.querySelector("#f-content");

document.querySelectorAll(".x-delete-btn").forEach((tag) => {
  tag.onclick = (e) => {
    e.stopPropagation();
    var no = e.target.getAttribute("data-no");
    var tr = document.querySelector("tbody tr[data-no='" + no + "']");
    var title = tr.querySelector("td:nth-child(2) a").textContent;
    var content = tr.querySelector("td:nth-child(3)").textContent;
    
    modalNo.value = no;
    modalTitle.value = title;
    modalContent.value = content;
  }
});
</script>

<!-- 체크박스
<script>
	$(document).ready(function() {
		$("#checkAll").click(function() {
			if ($("#checkAll").is(":checked"))
				$("input[name=checkRow]").prop("checked", true);
			else
				$("input[name=checkRow]").prop("checked", false);
		});

		$("input[name=checkRow]").click(function() {
			var total = $("input[name=checkRow]").length;
			var checked = $("input[name=checkRow]:checked").length;

			if (total != checked)
				$("#checkAll").prop("checked", false);
			else
				$("#checkAll").prop("checked", true);
		});
	});
</script>
-->









