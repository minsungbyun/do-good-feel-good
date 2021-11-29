<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
	.pagination {
		display: flex;
		padding-left: 0;
		list-style: none;
		border-radius: 0.25rem;
		margin-bottom: 110px;
	}
</style>

<div class="ad-main">
	<div class="ad-main-infor">
		<div class="table01">
			<!-- serch -->
			<div>
				<form class="form-inline" style="float: right; margin-bottom: 25px">
					<input class="form-control mr-sm-2 search-box" type="search"
						id="f-search" name="keword" placeholder="검색" aria-label="Search">
					<button class="btn btn-secondary my-2 my-sm-0 search-btn"
						type="submit" style="background: #666;">검색</button>
				</form>
			</div>
			<!-- //serch -->
			
			<!-- table -->
			<table class="table">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">내용</th>
						<th scope="col">등록일</th>
						<th scope="col">조회수</th>
						<!-- <th scope="col">첨부파일</th> -->
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:if test='${empty noticeList}'>
						<p>작성된 게시글이 없습니다.</p>
					</c:if>

					<c:forEach items="${noticeList}" var="noticeDTO" varStatus="vs">
						<tr data-no="${noticeDTO.no}">
							<td>${noticeDTO.no}</td>
							<td><a href='noticeDetail?noticeNo=${noticeDTO.no}'>${noticeDTO.title}</a></td>
							<td>${noticeDTO.content}</td>
							<td>${noticeDTO.registeredDate}</td>
							<td>${noticeDTO.viewCount}</td>
							<%-- <td>${noticeDTO.fileUpload}</td> --%>
							<td><a href="#noticeList${vs.index}" class="btn btn-primary"
								data-toggle="modal"<%-- data-no="${noticeDTO.no}" --%>> 삭제 </a></td>
						</tr>
						
						<!-- 모달창 -->
						<div class="modal fade modal-p" id="noticeList${vs.index}" role="dialog">
							<div class="modal-dialog">
								<div class="modal-content">
								  <!-- modal-header -->
									<div class="modal-header">
										<h4 class="modal-title">공지사항 삭제</h4>
										<button type="button" class="close" data-dismiss="modal">×</button>
									</div>
									<!-- //modal-header -->
									<!-- modal-body -->
									<div class="modal-body">
										<div class="mb-3 row">
											<label for='f-no' class="col-sm-2 col-form-label">번호</label>
											<input id='f-no' class="col-sm-2 form-control" type='text'
											     name='no' value='${noticeDTO.no}' readonly>
										</div>
										<!-- 번호 -->
										<div class="mb-3 row">
										  <label for='f-title' class="col-sm-2 col-form-label">제목</label>
										  <input id='f-title' class="col-sm-9 form-control" type="text"
										          name="title" value="${noticeDTO.title}">
										</div>
                    <!-- //제목 -->
                    <div class="mb-3 row">
                      <label for='f-content' class="col-sm-2 col-form-label">내용</label>
                      <textarea id='f-content' class="col-sm-9 form-control"
                           name="content"  cols="15" rows="5">${noticeDTO.content}</textarea>
                    </div>
                    <!-- //내용 -->
									</div>
									<!-- //modal-body -->
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">닫기</button>
										<a href="noticeDelete?noticeNo=${noticeDTO.no}"
											class="btn btn-primary">삭제</a>
										<!-- <button type="button" class="btn btn-primary">삭제</button> -->
									</div>
								</div>
							</div>
							<!-- //modal-dialog -->
						</div>
            <!-- //모달창 -->
            
					</c:forEach>
				</tbody>
			</table>
			<!-- //table -->
			<div class="ad-btn">
				<a href="noticeForm" class="btnSubmit">글쓰기</a>
				<%-- <a href="noticeDelete?noticeNo=${noticeDTO.no}" class="btnSubmit">삭제</a> --%>
			</div>
			<!-- //ad-btn -->
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









