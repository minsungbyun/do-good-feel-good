<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<div class="ad-main">
	<div class="ad-main-infor">
		<div class="container">
			<div class="board-wrap padding-board">
				<h4 class="mb-5">공지사항</h4>
				<form action="noticeUpdate" method="post" id="notice-form"
					enctype="multipart/form-data">
					<div class="form-group">
						<label for="f-no">번호</label> <input type="text"
							class="form-control col-sm-1" id="f-no" name="noticeNo"
							value="${noticeDTO.no}" readonly>
					</div>
					<!-- //번호 -->
					<div class=" q q-date">
						<label for="f-registeredDate">등록일</label>
						<span id='f-registeredDate' style="color:#999;">${noticeDTO.registeredDate}</span>
					</div>
					<!-- //등록일 -->
					<div class=" q q-view">
						<label for="f-viewCount" style=" margin-left:25px;">조회수</label>
						<span id='f-viewCount' style="color:#999;">${noticeDTO.viewCount}</span>
					</div>
					<!-- //조회수 -->
					<div class="form-group">
						<label for="f-title">제목</label> <input type="text"
							class="form-control" id="f-title" name="title"
							value="${noticeDTO.title}" readonly>
					</div>
					<!-- //제목 -->
					<div class="form-group">
						<label for="f-content">내용</label>
						<textarea name="content" id="f-content" cols="30" rows="8"
							class="form-control" readonly>${noticeDTO.content}</textarea>
					</div>
					<!-- //내용 -->
					<%-- <div class="form-group row">
						<label for="f-file" class="col-sm-1 col-form-label">첨부파일</label>
						<div class="col-sm-11">
							<img id="f-file-image"
								src="../upload/notice/${notice.fileUpload}"> <input
								type="file" class="form-control-file" id="f-file"
								name="fileUpload">
						</div>
					</div> --%>
					<!-- //파일첨부 -->
					<div>
						<a href="noticeList" class="btn no-btn" style="color:#fff;">목록</a>
					</div>
					<!-- //ad-btn -->
				</form>
			</div>
			<!-- //board-wrap -->
		</div>
	</div>
	<!-- //ad-main-infor -->
</div>
<!-- //ad-main -->