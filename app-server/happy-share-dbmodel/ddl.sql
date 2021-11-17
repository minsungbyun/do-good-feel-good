-- 회원
DROP TABLE IF EXISTS ftp_user RESTRICT;

-- 봉사참여자
DROP TABLE IF EXISTS ftp_vol_apply RESTRICT;

-- 봉사게시판
DROP TABLE IF EXISTS ftp_vol_board RESTRICT;

-- 챌린지
DROP TABLE IF EXISTS ftp_challenge RESTRICT;

-- 기부금
DROP TABLE IF EXISTS ftp_donation RESTRICT;

-- 문의하기
DROP TABLE IF EXISTS ftp_support_qna RESTRICT;

-- 공지사항
DROP TABLE IF EXISTS ftp_support_notice RESTRICT;

-- 챌린지문의하기
DROP TABLE IF EXISTS ftp_challenge_qna RESTRICT;

-- 챌린지후기
DROP TABLE IF EXISTS ftp_challenge_review RESTRICT;

-- 봉사한줄후기
DROP TABLE IF EXISTS ftp_vol_shortreview RESTRICT;

-- 봉사문의하기
DROP TABLE IF EXISTS ftp_vol_qna RESTRICT;

-- 개인
DROP TABLE IF EXISTS ftp_user_personal RESTRICT;

-- 단체
DROP TABLE IF EXISTS ftp_user_group RESTRICT;

-- 기관
DROP TABLE IF EXISTS ftp_user_org RESTRICT;

-- 봉사
DROP TABLE IF EXISTS ftp_vol RESTRICT;

-- 봉사찜하기
DROP TABLE IF EXISTS ftp_vol_wish RESTRICT;

-- 봉사첨부파일
DROP TABLE IF EXISTS ftp_vol_file RESTRICT;

-- 봉사게시글좋아요
DROP TABLE IF EXISTS ftp_vol_board_like RESTRICT;

-- 봉사게시판첨부파일
DROP TABLE IF EXISTS ftp_vol_board_file RESTRICT;

-- 챌린지리뷰첨부파일
DROP TABLE IF EXISTS ftp_challenge_review_file RESTRICT;

-- 챌린지첨부파일
DROP TABLE IF EXISTS ftp_challenge_file RESTRICT;

-- 챌린지찜하기
DROP TABLE IF EXISTS ftp_challenge_wish RESTRICT;

-- 모금함
DROP TABLE IF EXISTS ftp_funding RESTRICT;

-- 모금함첨부파일
DROP TABLE IF EXISTS ftp_funding_file RESTRICT;

-- 문의하기첨부파일
DROP TABLE IF EXISTS ftp_support_qna_file RESTRICT;

-- 공지사항첨부파일
DROP TABLE IF EXISTS ftp_support_notice_file RESTRICT;

-- 회원사진
DROP TABLE IF EXISTS ftp_user_photo RESTRICT;

-- 문의카테고리
DROP TABLE IF EXISTS ftp_support_qna_category RESTRICT;

-- 결제유형
DROP TABLE IF EXISTS ftp_donation_pay RESTRICT;

-- 카테고리
DROP TABLE IF EXISTS ftp_category RESTRICT;

-- 알림
DROP TABLE IF EXISTS ftp_user_alert RESTRICT;

-- 메세지
DROP TABLE IF EXISTS ftp_user_message RESTRICT;

-- 챌린지참여자
DROP TABLE IF EXISTS ftp_challenge_apply RESTRICT;

-- 봉사게시판댓글
DROP TABLE IF EXISTS ftp_vol_comment RESTRICT;

-- 회원
CREATE TABLE ftp_user (
	user_no        INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	id             VARCHAR(30)  NOT NULL COMMENT '아이디', -- 아이디
	password       VARCHAR(100) NOT NULL COMMENT '암호', -- 암호
	name           VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	tel            VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
	email          VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	created_dt     DATE         NOT NULL DEFAULT CURDATE() COMMENT '가입일', -- 가입일
	post_no        VARCHAR(5)   NOT NULL COMMENT '우편번호', -- 우편번호
	basic_address  VARCHAR(255) NOT NULL COMMENT '기본주소', -- 기본주소
	detail_address VARCHAR(255) NOT NULL COMMENT '상세주소', -- 상세주소
	donation       BIGINT       NULL     COMMENT '기부금액', -- 기부금액
	type           INTEGER      NOT NULL COMMENT '회원유형', -- 회원유형
	status         INTEGER      NOT NULL COMMENT '상태', -- 상태
	note           TEXT         NULL     COMMENT '비고', -- 비고
	last_login     DATETIME     NOT NULL DEFAULT NOW() COMMENT '마지막접속일', -- 마지막접속일
	photo 		   varchar(255) NULL	 COMMENT '사진' -- 사진
)
COMMENT '회원';

-- 회원
ALTER TABLE ftp_user
	ADD CONSTRAINT PK_ftp_user -- 회원 기본키
		PRIMARY KEY (
			user_no -- 회원번호
		);

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_ftp_user
	ON ftp_user ( -- 회원
		id ASC -- 아이디
	);

-- 회원 인덱스
CREATE INDEX IX_ftp_user
	ON ftp_user( -- 회원
		id ASC -- 아이디
	);

ALTER TABLE ftp_user
	MODIFY COLUMN user_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 봉사참여자
CREATE TABLE ftp_vol_apply (
	user_no      INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	vol_no       INTEGER NOT NULL COMMENT '봉사번호', -- 봉사번호
	apply_dt     DATE    NOT NULL DEFAULT curdate() COMMENT '참여일', -- 참여일
	start_time   TIME    NOT NULL COMMENT '시작시간', -- 시작시간
	end_time     TIME    NOT NULL COMMENT '종료시간', -- 종료시간
	apply_status INTEGER NOT NULL DEFAULT 1 COMMENT '참여여부', -- 참여여부
	note         TEXT    NULL     COMMENT '비고' -- 비고
)
COMMENT '봉사참여자';

-- 봉사참여자
ALTER TABLE ftp_vol_apply
	ADD CONSTRAINT PK_ftp_vol_apply -- 봉사참여자 기본키
		PRIMARY KEY (
			user_no, -- 회원번호
			vol_no   -- 봉사번호
		);

-- 봉사게시판
CREATE TABLE ftp_vol_board (
	vol_board_no INTEGER      NOT NULL COMMENT '봉사게시판번호', -- 봉사게시판번호
	user_no      INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	title        VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	content      TEXT         NOT NULL COMMENT '내용', -- 내용
	created_dt   DATE         NOT NULL DEFAULT CURDATE() COMMENT '등록일', -- 등록일
	view_cnt     INTEGER      NULL     DEFAULT 0 COMMENT '조회수' -- 조회수
)
COMMENT '봉사게시판';

-- 봉사게시판
ALTER TABLE ftp_vol_board
	ADD CONSTRAINT PK_ftp_vol_board -- 봉사게시판 기본키
		PRIMARY KEY (
			vol_board_no -- 봉사게시판번호
		);

ALTER TABLE ftp_vol_board
	MODIFY COLUMN vol_board_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '봉사게시판번호';

-- 챌린지
CREATE TABLE ftp_challenge (
	challenge_no INTEGER      NOT NULL COMMENT '챌린지번호', -- 챌린지번호
	title        VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	content      TEXT         NOT NULL COMMENT '내용', -- 내용
	start_dt     DATE         NOT NULL COMMENT '시작일', -- 시작일
	end_dt       DATE         NOT NULL COMMENT '종료일', -- 종료일
	created_dt   DATE         NOT NULL DEFAULT curdate() COMMENT '등록일' -- 등록일
)
COMMENT '챌린지';

-- 챌린지
ALTER TABLE ftp_challenge
	ADD CONSTRAINT PK_ftp_challenge -- 챌린지 기본키
		PRIMARY KEY (
			challenge_no -- 챌린지번호
		);

ALTER TABLE ftp_challenge
	MODIFY COLUMN challenge_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '챌린지번호';

-- 기부금
CREATE TABLE ftp_donation (
	donation_no      INTEGER      NOT NULL COMMENT '모금함기부번호', -- 모금함기부번호
	user_no          INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	funding_no       INTEGER      NOT NULL COMMENT '모금함번호', -- 모금함번호
	pay_no           INTEGER      NOT NULL COMMENT '결제유형번호', -- 결제유형번호
	donation_money   INTEGER      NOT NULL COMMENT '기부금액', -- 기부금액
	pay_status       INTEGER      NOT NULL DEFAULT 0 COMMENT '결제상태', -- 결제상태
	donation_dt      DATE         NOT NULL DEFAULT curdate() COMMENT '기부일', -- 기부일
	registeration_no VARCHAR(255) NOT NULL COMMENT '주민번호' -- 주민번호
)
COMMENT '기부금';

-- 기부금
ALTER TABLE ftp_donation
	ADD CONSTRAINT PK_ftp_donation -- 기부금 기본키
		PRIMARY KEY (
			donation_no -- 모금함기부번호
		);

ALTER TABLE ftp_donation
	MODIFY COLUMN donation_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '모금함기부번호';

-- 문의하기
CREATE TABLE ftp_support_qna (
	qna_no          INTEGER      NOT NULL COMMENT '문의하기게시판번호', -- 문의하기게시판번호
	user_no         INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	qna_category_no INTEGER      NOT NULL COMMENT '카테고리번호', -- 카테고리번호
	title           VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	content         TEXT         NOT NULL COMMENT '내용', -- 내용
	password        INTEGER      NOT NULL COMMENT '문의비밀번호', -- 문의비밀번호
	created_dt      DATE         NOT NULL DEFAULT CURDATE() COMMENT '등록일', -- 등록일
	view_cnt        INTEGER      NULL     DEFAULT 0 COMMENT '조회수', -- 조회수
	reply           TEXT         NULL     COMMENT '답글', -- 답글
	status          INTEGER      NOT NULL DEFAULT 0 COMMENT '답글여부' -- 답글여부
)
COMMENT '문의하기';

-- 문의하기
ALTER TABLE ftp_support_qna
	ADD CONSTRAINT PK_ftp_support_qna -- 문의하기 기본키
		PRIMARY KEY (
			qna_no -- 문의하기게시판번호
		);

ALTER TABLE ftp_support_qna
	MODIFY COLUMN qna_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '문의하기게시판번호';

-- 공지사항
CREATE TABLE ftp_support_notice (
	notice_no  INTEGER      NOT NULL COMMENT '공지사항게시판번호', -- 공지사항게시판번호
	title      VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	content    TEXT         NOT NULL COMMENT '내용', -- 내용
	created_dt DATE         NOT NULL DEFAULT CURDATE() COMMENT '등록일', -- 등록일
	view_cnt   INTEGER      NULL     DEFAULT 0 COMMENT '조회수' -- 조회수
)
COMMENT '공지사항';

-- 공지사항
ALTER TABLE ftp_support_notice
	ADD CONSTRAINT PK_ftp_support_notice -- 공지사항 기본키
		PRIMARY KEY (
			notice_no -- 공지사항게시판번호
		);

ALTER TABLE ftp_support_notice
	MODIFY COLUMN notice_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '공지사항게시판번호';

-- 챌린지문의하기
CREATE TABLE ftp_challenge_qna (
	challenge_qna_no INTEGER NOT NULL COMMENT '챌린지문의번호', -- 챌린지문의번호
	challenge_no     INTEGER NOT NULL COMMENT '챌린지번호', -- 챌린지번호
	user_no          INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	content          TEXT    NOT NULL COMMENT '내용', -- 내용
	created_dt       DATE    NOT NULL DEFAULT CURDATE() COMMENT '등록일', -- 등록일
	reply            TEXT    NULL     COMMENT '답변' -- 답변
)
COMMENT '챌린지문의하기';

-- 챌린지문의하기
ALTER TABLE ftp_challenge_qna
	ADD CONSTRAINT PK_ftp_challenge_qna -- 챌린지문의하기 기본키
		PRIMARY KEY (
			challenge_qna_no -- 챌린지문의번호
		);

ALTER TABLE ftp_challenge_qna
	MODIFY COLUMN challenge_qna_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '챌린지문의번호';

-- 챌린지후기
CREATE TABLE ftp_challenge_review (
	challenge_review_no INTEGER NOT NULL COMMENT '챌린지리뷰번호', -- 챌린지리뷰번호
	challenge_no        INTEGER NOT NULL COMMENT '챌린지번호', -- 챌린지번호
	user_no             INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	content             TEXT    NOT NULL COMMENT '내용', -- 내용
	created_dt          DATE    NOT NULL DEFAULT CURDATE() COMMENT '등록일' -- 등록일
)
COMMENT '챌린지후기';

-- 챌린지후기
ALTER TABLE ftp_challenge_review
	ADD CONSTRAINT PK_ftp_challenge_review -- 챌린지후기 기본키
		PRIMARY KEY (
			challenge_review_no -- 챌린지리뷰번호
		);

ALTER TABLE ftp_challenge_review
	MODIFY COLUMN challenge_review_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '챌린지리뷰번호';

-- 봉사한줄후기
CREATE TABLE ftp_vol_shortreview (
	vol_shortreview_no INTEGER      NOT NULL COMMENT '봉사게시판한줄후기번호', -- 봉사게시판한줄후기번호
	user_no            INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	vol_no             INTEGER      NOT NULL COMMENT '봉사번호', -- 봉사번호
	content            VARCHAR(255) NOT NULL COMMENT '내용', -- 내용
	created_dt         DATE         NOT NULL DEFAULT CURDATE() COMMENT '등록일' -- 등록일
)
COMMENT '봉사한줄후기';

-- 봉사한줄후기
ALTER TABLE ftp_vol_shortreview
	ADD CONSTRAINT PK_ftp_vol_shortreview -- 봉사한줄후기 기본키
		PRIMARY KEY (
			vol_shortreview_no -- 봉사게시판한줄후기번호
		);

ALTER TABLE ftp_vol_shortreview
	MODIFY COLUMN vol_shortreview_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '봉사게시판한줄후기번호';

-- 봉사문의하기
CREATE TABLE ftp_vol_qna (
	vol_qna_no INTEGER NOT NULL COMMENT '봉사문의번호', -- 봉사문의번호
	user_no    INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	vol_no     INTEGER NOT NULL COMMENT '봉사번호', -- 봉사번호
	content    TEXT    NOT NULL COMMENT '내용', -- 내용
	created_dt DATE    NOT NULL DEFAULT CURDATE() COMMENT '등록일', -- 등록일
	reply      TEXT    NULL     COMMENT '답변' -- 답변
)
COMMENT '봉사문의하기';

-- 봉사문의하기
ALTER TABLE ftp_vol_qna
	ADD CONSTRAINT PK_ftp_vol_qna -- 봉사문의하기 기본키
		PRIMARY KEY (
			vol_qna_no -- 봉사문의번호
		);

ALTER TABLE ftp_vol_qna
	MODIFY COLUMN vol_qna_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '봉사문의번호';

-- 개인
CREATE TABLE ftp_user_personal (
	user_personal_no INTEGER     NOT NULL COMMENT '개인번호', -- 개인번호
	user_no          INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
	birthdate        DATE        NULL     COMMENT '생년월일', -- 생년월일
	level            VARCHAR(50) NOT NULL COMMENT '등급', -- 등급
	point            INTEGER     NOT NULL DEFAULT 0 COMMENT '포인트' -- 포인트
)
COMMENT '개인';

-- 개인
ALTER TABLE ftp_user_personal
	ADD CONSTRAINT PK_ftp_user_personal -- 개인 기본키
		PRIMARY KEY (
			user_personal_no -- 개인번호
		);

ALTER TABLE ftp_user_personal
	MODIFY COLUMN user_personal_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '개인번호';

-- 단체
CREATE TABLE ftp_user_group (
	user_group_no INTEGER NOT NULL COMMENT '단체번호', -- 단체번호
	user_no       INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	group_cnt     INTEGER NOT NULL COMMENT '소속인원' -- 소속인원
)
COMMENT '단체';

-- 단체
ALTER TABLE ftp_user_group
	ADD CONSTRAINT PK_ftp_user_group -- 단체 기본키
		PRIMARY KEY (
			user_group_no -- 단체번호
		);

ALTER TABLE ftp_user_group
	MODIFY COLUMN user_group_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '단체번호';

-- 기관
CREATE TABLE ftp_user_org (
	user_org_no INTEGER      NOT NULL COMMENT '기관번호', -- 기관번호
	user_no     INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	corp_no     VARCHAR(30)  NOT NULL COMMENT '사업자등록번호', -- 사업자등록번호
	fax         VARCHAR(30)  NULL     COMMENT '팩스', -- 팩스
	hp          VARCHAR(255) NULL     COMMENT '홈페이지' -- 홈페이지
)
COMMENT '기관';

-- 기관
ALTER TABLE ftp_user_org
	ADD CONSTRAINT PK_ftp_user_org -- 기관 기본키
		PRIMARY KEY (
			user_org_no -- 기관번호
		);

-- 기관 유니크 인덱스
CREATE UNIQUE INDEX UIX_ftp_user_org
	ON ftp_user_org ( -- 기관
		corp_no ASC -- 사업자등록번호
	);

ALTER TABLE ftp_user_org
	MODIFY COLUMN user_org_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '기관번호';

-- 봉사
CREATE TABLE ftp_vol (
	vol_no      INTEGER      NOT NULL COMMENT '봉사번호', -- 봉사번호
	user_no     INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	category_no INTEGER      NOT NULL COMMENT '카테고리번호', -- 카테고리번호
	title       VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	content     TEXT         NOT NULL COMMENT '내용', -- 내용
	tel         VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
	email       VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	start_dt    DATETIME     NOT NULL COMMENT '시작일', -- 시작일
	end_dt      DATETIME     NOT NULL COMMENT '종료일', -- 종료일
	start_time  TIME         NOT NULL COMMENT '시작시간', -- 시작시간
	end_time    TIME         NOT NULL COMMENT '종료시간', -- 종료시간
	total_cnt   INTEGER      NOT NULL COMMENT '총모집인원', -- 총모집인원
	approval    INTEGER      NOT NULL DEFAULT 2 COMMENT '승인여부', -- 승인여부
	note        TEXT         NULL     COMMENT '비고' -- 비고
)
COMMENT '봉사';

-- 봉사
ALTER TABLE ftp_vol
	ADD CONSTRAINT PK_ftp_vol -- 봉사 기본키
		PRIMARY KEY (
			vol_no -- 봉사번호
		);

ALTER TABLE ftp_vol
	MODIFY COLUMN vol_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '봉사번호';

-- 봉사찜하기
CREATE TABLE ftp_vol_wish (
	user_no INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	vol_no  INTEGER NOT NULL COMMENT '봉사번호' -- 봉사번호
)
COMMENT '봉사찜하기';

-- 봉사찜하기
ALTER TABLE ftp_vol_wish
	ADD CONSTRAINT PK_ftp_vol_wish -- 봉사찜하기 기본키
		PRIMARY KEY (
			user_no, -- 회원번호
			vol_no   -- 봉사번호
		);

-- 봉사첨부파일
CREATE TABLE ftp_vol_file (
	vol_file_no INTEGER     NOT NULL COMMENT '봉사첨부파일번호', -- 봉사첨부파일번호
	vol_no      INTEGER     NOT NULL COMMENT '봉사번호', -- 봉사번호
	filepath    VARCHAR(50) NULL     COMMENT '첨부파일명' -- 첨부파일명
)
COMMENT '봉사첨부파일';

-- 봉사첨부파일
ALTER TABLE ftp_vol_file
	ADD CONSTRAINT PK_ftp_vol_file -- 봉사첨부파일 기본키
		PRIMARY KEY (
			vol_file_no -- 봉사첨부파일번호
		);

ALTER TABLE ftp_vol_file
	MODIFY COLUMN vol_file_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '봉사첨부파일번호';

-- 봉사게시글좋아요
CREATE TABLE ftp_vol_board_like (
	user_no      INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	vol_board_no INTEGER NOT NULL COMMENT '봉사게시판번호' -- 봉사게시판번호
)
COMMENT '봉사게시글좋아요';

-- 봉사게시글좋아요
ALTER TABLE ftp_vol_board_like
	ADD CONSTRAINT PK_ftp_vol_board_like -- 봉사게시글좋아요 기본키
		PRIMARY KEY (
			user_no,      -- 회원번호
			vol_board_no  -- 봉사게시판번호
		);

-- 봉사게시판첨부파일
CREATE TABLE ftp_vol_board_file (
	vol_board_file_no INTEGER      NOT NULL COMMENT '봉사게시판첨부파일번호', -- 봉사게시판첨부파일번호
	vol_board_no      INTEGER      NOT NULL COMMENT '봉사게시판번호', -- 봉사게시판번호
	filepath          VARCHAR(255) NULL     COMMENT '첨부파일명' -- 첨부파일명
)
COMMENT '봉사게시판첨부파일';

-- 봉사게시판첨부파일
ALTER TABLE ftp_vol_board_file
	ADD CONSTRAINT PK_ftp_vol_board_file -- 봉사게시판첨부파일 기본키
		PRIMARY KEY (
			vol_board_file_no -- 봉사게시판첨부파일번호
		);

ALTER TABLE ftp_vol_board_file
	MODIFY COLUMN vol_board_file_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '봉사게시판첨부파일번호';

-- 챌린지리뷰첨부파일
CREATE TABLE ftp_challenge_review_file (
	challenge_review_file_no INTEGER      NOT NULL COMMENT '챌린지리뷰첨부파일번호', -- 챌린지리뷰첨부파일번호
	challenge_review_no      INTEGER      NOT NULL COMMENT '챌린지리뷰번호', -- 챌린지리뷰번호
	filepath                 VARCHAR(255) NULL     COMMENT '첨부파일명' -- 첨부파일명
)
COMMENT '챌린지리뷰첨부파일';

-- 챌린지리뷰첨부파일
ALTER TABLE ftp_challenge_review_file
	ADD CONSTRAINT PK_ftp_challenge_review_file -- 챌린지리뷰첨부파일 기본키
		PRIMARY KEY (
			challenge_review_file_no -- 챌린지리뷰첨부파일번호
		);

ALTER TABLE ftp_challenge_review_file
	MODIFY COLUMN challenge_review_file_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '챌린지리뷰첨부파일번호';

-- 챌린지첨부파일
CREATE TABLE ftp_challenge_file (
	challenge_file_no INTEGER      NOT NULL COMMENT '챌린지첨부파일번호', -- 챌린지첨부파일번호
	challenge_no      INTEGER      NOT NULL COMMENT '챌린지번호', -- 챌린지번호
	filepath          VARCHAR(255) NULL     COMMENT '첨부파일명' -- 첨부파일명
)
COMMENT '챌린지첨부파일';

-- 챌린지첨부파일
ALTER TABLE ftp_challenge_file
	ADD CONSTRAINT PK_ftp_challenge_file -- 챌린지첨부파일 기본키
		PRIMARY KEY (
			challenge_file_no -- 챌린지첨부파일번호
		);

ALTER TABLE ftp_challenge_file
	MODIFY COLUMN challenge_file_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '챌린지첨부파일번호';

-- 챌린지찜하기
CREATE TABLE ftp_challenge_wish (
	challenge_no INTEGER NOT NULL COMMENT '챌린지번호', -- 챌린지번호
	user_no      INTEGER NOT NULL COMMENT '회원번호' -- 회원번호
)
COMMENT '챌린지찜하기';

-- 챌린지찜하기
ALTER TABLE ftp_challenge_wish
	ADD CONSTRAINT PK_ftp_challenge_wish -- 챌린지찜하기 기본키
		PRIMARY KEY (
			challenge_no, -- 챌린지번호
			user_no       -- 회원번호
		);

-- 모금함
CREATE TABLE ftp_funding (
	funding_no  INTEGER      NOT NULL COMMENT '모금함번호', -- 모금함번호
	user_org_no INTEGER      NOT NULL COMMENT '기관번호', -- 기관번호
	category_no INTEGER      NULL     COMMENT '카테고리번호', -- 카테고리번호
	title       VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	content     TEXT         NOT NULL COMMENT '내용', -- 내용
	tel         VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
	email       VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	start_dt    DATE         NOT NULL COMMENT '시작일', -- 시작일
	end_dt      DATE         NOT NULL COMMENT '종료일', -- 종료일
	goal        BIGINT       NOT NULL DEFAULT 0 COMMENT '목표금액', -- 목표금액
	status      INTEGER      NOT NULL DEFAULT 0 COMMENT '승인여부', -- 승인여부
	note        TEXT         NULL     COMMENT '비고' -- 비고
)
COMMENT '모금함';

-- 모금함
ALTER TABLE ftp_funding
	ADD CONSTRAINT PK_ftp_funding -- 모금함 기본키
		PRIMARY KEY (
			funding_no -- 모금함번호
		);

ALTER TABLE ftp_funding
	MODIFY COLUMN funding_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '모금함번호';

-- 모금함첨부파일
CREATE TABLE ftp_funding_file (
	funding_file_no INTEGER      NOT NULL COMMENT '모금함첨부파일번호', -- 모금함첨부파일번호
	funding_no      INTEGER      NOT NULL COMMENT '모금함번호', -- 모금함번호
	filepath        VARCHAR(255) NULL     COMMENT '첨부파일명' -- 첨부파일명
)
COMMENT '모금함첨부파일';

-- 모금함첨부파일
ALTER TABLE ftp_funding_file
	ADD CONSTRAINT PK_ftp_funding_file -- 모금함첨부파일 기본키
		PRIMARY KEY (
			funding_file_no -- 모금함첨부파일번호
		);

ALTER TABLE ftp_funding_file
	MODIFY COLUMN funding_file_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '모금함첨부파일번호';

-- 문의하기첨부파일
CREATE TABLE ftp_support_qna_file (
	qna_file_no INTEGER      NOT NULL COMMENT '문의하기첨부파일번호', -- 문의하기첨부파일번호
	qna_no      INTEGER      NOT NULL COMMENT '문의하기게시판번호', -- 문의하기게시판번호
	filepath    VARCHAR(255) NULL     COMMENT '첨부파일명' -- 첨부파일명
)
COMMENT '문의하기첨부파일';

-- 문의하기첨부파일
ALTER TABLE ftp_support_qna_file
	ADD CONSTRAINT PK_ftp_support_qna_file -- 문의하기첨부파일 기본키
		PRIMARY KEY (
			qna_file_no -- 문의하기첨부파일번호
		);

ALTER TABLE ftp_support_qna_file
	MODIFY COLUMN qna_file_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '문의하기첨부파일번호';

-- 공지사항첨부파일
CREATE TABLE ftp_support_notice_file (
	notice_file_no INTEGER      NOT NULL COMMENT '공지사항첨부파일번호', -- 공지사항첨부파일번호
	notice_no      INTEGER      NOT NULL COMMENT '공지사항게시판번호', -- 공지사항게시판번호
	filepath       VARCHAR(255) NULL     COMMENT '첨부파일명' -- 첨부파일명
)
COMMENT '공지사항첨부파일';

-- 공지사항첨부파일
ALTER TABLE ftp_support_notice_file
	ADD CONSTRAINT PK_ftp_support_notice_file -- 공지사항첨부파일 기본키
		PRIMARY KEY (
			notice_file_no -- 공지사항첨부파일번호
		);

ALTER TABLE ftp_support_notice_file
	MODIFY COLUMN notice_file_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '공지사항첨부파일번호';

-- 회원사진
CREATE TABLE ftp_user_photo (
	user_photo_no INTEGER      NOT NULL COMMENT '회원사진번호', -- 회원사진번호
	user_no       INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	filepath      VARCHAR(255) NULL     COMMENT '사진파일명' -- 사진파일명
)
COMMENT '회원사진';

-- 회원사진
ALTER TABLE ftp_user_photo
	ADD CONSTRAINT PK_ftp_user_photo -- 회원사진 기본키
		PRIMARY KEY (
			user_photo_no -- 회원사진번호
		);

ALTER TABLE ftp_user_photo
	MODIFY COLUMN user_photo_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원사진번호';

-- 문의카테고리
CREATE TABLE ftp_support_qna_category (
	qna_category_no INTEGER     NOT NULL COMMENT '카테고리번호', -- 카테고리번호
	title           VARCHAR(50) NOT NULL COMMENT '카테고리명' -- 카테고리명
)
COMMENT '문의카테고리';

-- 문의카테고리
ALTER TABLE ftp_support_qna_category
	ADD CONSTRAINT PK_ftp_support_qna_category -- 문의카테고리 기본키
		PRIMARY KEY (
			qna_category_no -- 카테고리번호
		);

-- 문의카테고리 유니크 인덱스
CREATE UNIQUE INDEX UIX_ftp_support_qna_category
	ON ftp_support_qna_category ( -- 문의카테고리
		title ASC -- 카테고리명
	);

ALTER TABLE ftp_support_qna_category
	MODIFY COLUMN qna_category_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '카테고리번호';

-- 결제유형
CREATE TABLE ftp_donation_pay (
	pay_no INTEGER     NOT NULL COMMENT '결제유형번호', -- 결제유형번호
	title  VARCHAR(50) NOT NULL COMMENT '결제유형명' -- 결제유형명
)
COMMENT '결제유형';

-- 결제유형
ALTER TABLE ftp_donation_pay
	ADD CONSTRAINT PK_ftp_donation_pay -- 결제유형 기본키
		PRIMARY KEY (
			pay_no -- 결제유형번호
		);

-- 결제유형 유니크 인덱스
CREATE UNIQUE INDEX UIX_ftp_donation_pay
	ON ftp_donation_pay ( -- 결제유형
		title ASC -- 결제유형명
	);

ALTER TABLE ftp_donation_pay
	MODIFY COLUMN pay_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '결제유형번호';

-- 카테고리
CREATE TABLE ftp_category (
	category_no INTEGER      NOT NULL COMMENT '카테고리번호', -- 카테고리번호
	title       VARCHAR(255) NOT NULL COMMENT '카테고리명' -- 카테고리명
)
COMMENT '카테고리';

-- 카테고리
ALTER TABLE ftp_category
	ADD CONSTRAINT PK_ftp_category -- 카테고리 기본키
		PRIMARY KEY (
			category_no -- 카테고리번호
		);

-- 카테고리 유니크 인덱스
CREATE UNIQUE INDEX UIX_ftp_category
	ON ftp_category ( -- 카테고리
		title ASC -- 카테고리명
	);

ALTER TABLE ftp_category
	MODIFY COLUMN category_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '카테고리번호';

-- 알림
CREATE TABLE ftp_user_alert (
	user_notice_no INTEGER      NOT NULL COMMENT '알림번호', -- 알림번호
	user_no        INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	content        VARCHAR(255) NOT NULL COMMENT '내용', -- 내용
	created_dt     DATE         NOT NULL DEFAULT CURDATE() COMMENT '등록일' -- 등록일
)
COMMENT '알림';

-- 알림
ALTER TABLE ftp_user_alert
	ADD CONSTRAINT PK_ftp_user_alert -- 알림 기본키
		PRIMARY KEY (
			user_notice_no -- 알림번호
		);

ALTER TABLE ftp_user_alert
	MODIFY COLUMN user_notice_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '알림번호';

-- 메세지
CREATE TABLE ftp_user_message (
	message_no INTEGER NOT NULL COMMENT '메세지번호', -- 메세지번호
	user_from  INTEGER NOT NULL COMMENT '보내는이', -- 보내는이
	user_to    INTEGER NOT NULL COMMENT '받는이', -- 받는이
	content    TEXT    NOT NULL COMMENT '내용', -- 내용
	created_dt DATE    NOT NULL DEFAULT curdate() COMMENT '등록일' -- 등록일
)
COMMENT '메세지';

-- 메세지
ALTER TABLE ftp_user_message
	ADD CONSTRAINT PK_ftp_user_message -- 메세지 기본키
		PRIMARY KEY (
			message_no -- 메세지번호
		);

-- 챌린지참여자
CREATE TABLE ftp_challenge_apply (
	challenge_no INTEGER NOT NULL COMMENT '챌린지번호', -- 챌린지번호
	user_no      INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	apply_dt     DATE    NOT NULL DEFAULT curdate() COMMENT '신청일' -- 신청일
)
COMMENT '챌린지참여자';

-- 챌린지참여자
ALTER TABLE ftp_challenge_apply
	ADD CONSTRAINT PK_ftp_challenge_apply -- 챌린지참여자 기본키
		PRIMARY KEY (
			challenge_no, -- 챌린지번호
			user_no       -- 회원번호
		);

-- 봉사게시판댓글
CREATE TABLE ftp_vol_comment (
	vol_comment_no INTEGER NOT NULL COMMENT '봉사게시판댓글번호', -- 봉사게시판댓글번호
	vol_board_no   INTEGER NOT NULL COMMENT '봉사게시판번호', -- 봉사게시판번호
	user_no        INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	content        TEXT    NOT NULL COMMENT '내용', -- 내용
	created_dt     DATE    NOT NULL DEFAULT curdate() COMMENT '등록일' -- 등록일
)
COMMENT '봉사게시판댓글';

-- 봉사게시판댓글
ALTER TABLE ftp_vol_comment
	ADD CONSTRAINT PK_ftp_vol_comment -- 봉사게시판댓글 기본키
		PRIMARY KEY (
			vol_comment_no -- 봉사게시판댓글번호
		);

ALTER TABLE ftp_vol_comment
	MODIFY COLUMN vol_comment_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '봉사게시판댓글번호';

-- 봉사참여자
ALTER TABLE ftp_vol_apply
	ADD CONSTRAINT FK_ftp_user_TO_ftp_vol_apply -- 회원 -> 봉사참여자
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 봉사참여자
ALTER TABLE ftp_vol_apply
	ADD CONSTRAINT FK_ftp_vol_TO_ftp_vol_apply -- 봉사 -> 봉사참여자
		FOREIGN KEY (
			vol_no -- 봉사번호
		)
		REFERENCES ftp_vol ( -- 봉사
			vol_no -- 봉사번호
		);

-- 봉사게시판
ALTER TABLE ftp_vol_board
	ADD CONSTRAINT FK_ftp_user_TO_ftp_vol_board -- 회원 -> 봉사게시판
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 기부금
ALTER TABLE ftp_donation
	ADD CONSTRAINT FK_ftp_donation_pay_TO_ftp_donation -- 결제유형 -> 기부금
		FOREIGN KEY (
			pay_no -- 결제유형번호
		)
		REFERENCES ftp_donation_pay ( -- 결제유형
			pay_no -- 결제유형번호
		);

-- 기부금
ALTER TABLE ftp_donation
	ADD CONSTRAINT FK_ftp_user_TO_ftp_donation -- 회원 -> 기부금
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 기부금
ALTER TABLE ftp_donation
	ADD CONSTRAINT FK_ftp_funding_TO_ftp_donation -- 모금함 -> 기부금
		FOREIGN KEY (
			funding_no -- 모금함번호
		)
		REFERENCES ftp_funding ( -- 모금함
			funding_no -- 모금함번호
		);

-- 문의하기
ALTER TABLE ftp_support_qna
	ADD CONSTRAINT FK_ftp_user_TO_ftp_support_qna -- 회원 -> 문의하기
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 문의하기
ALTER TABLE ftp_support_qna
	ADD CONSTRAINT FK_ftp_support_qna_category_TO_ftp_support_qna -- 문의카테고리 -> 문의하기
		FOREIGN KEY (
			qna_category_no -- 카테고리번호
		)
		REFERENCES ftp_support_qna_category ( -- 문의카테고리
			qna_category_no -- 카테고리번호
		);

-- 챌린지문의하기
ALTER TABLE ftp_challenge_qna
	ADD CONSTRAINT FK_ftp_challenge_TO_ftp_challenge_qna -- 챌린지 -> 챌린지문의하기
		FOREIGN KEY (
			challenge_no -- 챌린지번호
		)
		REFERENCES ftp_challenge ( -- 챌린지
			challenge_no -- 챌린지번호
		);

-- 챌린지문의하기
ALTER TABLE ftp_challenge_qna
	ADD CONSTRAINT FK_ftp_user_TO_ftp_challenge_qna -- 회원 -> 챌린지문의하기
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 챌린지후기
ALTER TABLE ftp_challenge_review
	ADD CONSTRAINT FK_ftp_challenge_TO_ftp_challenge_review -- 챌린지 -> 챌린지후기
		FOREIGN KEY (
			challenge_no -- 챌린지번호
		)
		REFERENCES ftp_challenge ( -- 챌린지
			challenge_no -- 챌린지번호
		);

-- 챌린지후기
ALTER TABLE ftp_challenge_review
	ADD CONSTRAINT FK_ftp_user_TO_ftp_challenge_review -- 회원 -> 챌린지후기
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 챌린지후기
ALTER TABLE ftp_challenge_review
	ADD CONSTRAINT FK_ftp_challenge_apply_TO_ftp_challenge_review -- 챌린지참여자 -> 챌린지후기
		FOREIGN KEY (
			challenge_no, -- 챌린지번호
			user_no       -- 회원번호
		)
		REFERENCES ftp_challenge_apply ( -- 챌린지참여자
			challenge_no, -- 챌린지번호
			user_no       -- 회원번호
		);

-- 봉사한줄후기
ALTER TABLE ftp_vol_shortreview
	ADD CONSTRAINT FK_ftp_vol_apply_TO_ftp_vol_shortreview -- 봉사참여자 -> 봉사한줄후기
		FOREIGN KEY (
			user_no, -- 회원번호
			vol_no   -- 봉사번호
		)
		REFERENCES ftp_vol_apply ( -- 봉사참여자
			user_no, -- 회원번호
			vol_no   -- 봉사번호
		);

-- 봉사문의하기
ALTER TABLE ftp_vol_qna
	ADD CONSTRAINT FK_ftp_user_TO_ftp_vol_qna -- 회원 -> 봉사문의하기
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 봉사문의하기
ALTER TABLE ftp_vol_qna
	ADD CONSTRAINT FK_ftp_vol_TO_ftp_vol_qna -- 봉사 -> 봉사문의하기
		FOREIGN KEY (
			vol_no -- 봉사번호
		)
		REFERENCES ftp_vol ( -- 봉사
			vol_no -- 봉사번호
		);

-- 개인
ALTER TABLE ftp_user_personal
	ADD CONSTRAINT FK_ftp_user_TO_ftp_user_personal -- 회원 -> 개인
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 단체
ALTER TABLE ftp_user_group
	ADD CONSTRAINT FK_ftp_user_TO_ftp_user_group -- 회원 -> 단체
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 기관
ALTER TABLE ftp_user_org
	ADD CONSTRAINT FK_ftp_user_TO_ftp_user_org -- 회원 -> 기관
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 봉사
ALTER TABLE ftp_vol
	ADD CONSTRAINT FK_ftp_user_TO_ftp_vol -- 회원 -> 봉사
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 봉사
ALTER TABLE ftp_vol
	ADD CONSTRAINT FK_ftp_category_TO_ftp_vol -- 카테고리 -> 봉사
		FOREIGN KEY (
			category_no -- 카테고리번호
		)
		REFERENCES ftp_category ( -- 카테고리
			category_no -- 카테고리번호
		);

-- 봉사찜하기
ALTER TABLE ftp_vol_wish
	ADD CONSTRAINT FK_ftp_user_TO_ftp_vol_wish -- 회원 -> 봉사찜하기
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 봉사찜하기
ALTER TABLE ftp_vol_wish
	ADD CONSTRAINT FK_ftp_vol_TO_ftp_vol_wish -- 봉사 -> 봉사찜하기
		FOREIGN KEY (
			vol_no -- 봉사번호
		)
		REFERENCES ftp_vol ( -- 봉사
			vol_no -- 봉사번호
		);

-- 봉사첨부파일
ALTER TABLE ftp_vol_file
	ADD CONSTRAINT FK_ftp_vol_TO_ftp_vol_file -- 봉사 -> 봉사첨부파일
		FOREIGN KEY (
			vol_no -- 봉사번호
		)
		REFERENCES ftp_vol ( -- 봉사
			vol_no -- 봉사번호
		);

-- 봉사게시글좋아요
ALTER TABLE ftp_vol_board_like
	ADD CONSTRAINT FK_ftp_user_TO_ftp_vol_board_like -- 회원 -> 봉사게시글좋아요
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 봉사게시글좋아요
ALTER TABLE ftp_vol_board_like
	ADD CONSTRAINT FK_ftp_vol_board_TO_ftp_vol_board_like -- 봉사게시판 -> 봉사게시글좋아요
		FOREIGN KEY (
			vol_board_no -- 봉사게시판번호
		)
		REFERENCES ftp_vol_board ( -- 봉사게시판
			vol_board_no -- 봉사게시판번호
		);

-- 봉사게시판첨부파일
ALTER TABLE ftp_vol_board_file
	ADD CONSTRAINT FK_ftp_vol_board_TO_ftp_vol_board_file -- 봉사게시판 -> 봉사게시판첨부파일
		FOREIGN KEY (
			vol_board_no -- 봉사게시판번호
		)
		REFERENCES ftp_vol_board ( -- 봉사게시판
			vol_board_no -- 봉사게시판번호
		);

-- 챌린지리뷰첨부파일
ALTER TABLE ftp_challenge_review_file
	ADD CONSTRAINT FK_ftp_challenge_review_TO_ftp_challenge_review_file -- 챌린지후기 -> 챌린지리뷰첨부파일
		FOREIGN KEY (
			challenge_review_no -- 챌린지리뷰번호
		)
		REFERENCES ftp_challenge_review ( -- 챌린지후기
			challenge_review_no -- 챌린지리뷰번호
		);

-- 챌린지첨부파일
ALTER TABLE ftp_challenge_file
	ADD CONSTRAINT FK_ftp_challenge_TO_ftp_challenge_file -- 챌린지 -> 챌린지첨부파일
		FOREIGN KEY (
			challenge_no -- 챌린지번호
		)
		REFERENCES ftp_challenge ( -- 챌린지
			challenge_no -- 챌린지번호
		);

-- 챌린지찜하기
ALTER TABLE ftp_challenge_wish
	ADD CONSTRAINT FK_ftp_challenge_TO_ftp_challenge_wish -- 챌린지 -> 챌린지찜하기
		FOREIGN KEY (
			challenge_no -- 챌린지번호
		)
		REFERENCES ftp_challenge ( -- 챌린지
			challenge_no -- 챌린지번호
		);

-- 챌린지찜하기
ALTER TABLE ftp_challenge_wish
	ADD CONSTRAINT FK_ftp_user_TO_ftp_challenge_wish -- 회원 -> 챌린지찜하기
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 모금함
ALTER TABLE ftp_funding
	ADD CONSTRAINT FK_ftp_user_org_TO_ftp_funding -- 기관 -> 모금함
		FOREIGN KEY (
			user_org_no -- 기관번호
		)
		REFERENCES ftp_user_org ( -- 기관
			user_org_no -- 기관번호
		);

-- 모금함
ALTER TABLE ftp_funding
	ADD CONSTRAINT FK_ftp_category_TO_ftp_funding -- 카테고리 -> 모금함
		FOREIGN KEY (
			category_no -- 카테고리번호
		)
		REFERENCES ftp_category ( -- 카테고리
			category_no -- 카테고리번호
		);

-- 모금함첨부파일
ALTER TABLE ftp_funding_file
	ADD CONSTRAINT FK_ftp_funding_TO_ftp_funding_file -- 모금함 -> 모금함첨부파일
		FOREIGN KEY (
			funding_no -- 모금함번호
		)
		REFERENCES ftp_funding ( -- 모금함
			funding_no -- 모금함번호
		);

-- 문의하기첨부파일
ALTER TABLE ftp_support_qna_file
	ADD CONSTRAINT FK_ftp_support_qna_TO_ftp_support_qna_file -- 문의하기 -> 문의하기첨부파일
		FOREIGN KEY (
			qna_no -- 문의하기게시판번호
		)
		REFERENCES ftp_support_qna ( -- 문의하기
			qna_no -- 문의하기게시판번호
		);

-- 공지사항첨부파일
ALTER TABLE ftp_support_notice_file
	ADD CONSTRAINT FK_ftp_support_notice_TO_ftp_support_notice_file -- 공지사항 -> 공지사항첨부파일
		FOREIGN KEY (
			notice_no -- 공지사항게시판번호
		)
		REFERENCES ftp_support_notice ( -- 공지사항
			notice_no -- 공지사항게시판번호
		);

-- 회원사진
ALTER TABLE ftp_user_photo
	ADD CONSTRAINT FK_ftp_user_TO_ftp_user_photo -- 회원 -> 회원사진
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 알림
ALTER TABLE ftp_user_alert
	ADD CONSTRAINT FK_ftp_user_TO_ftp_user_alert -- 회원 -> 알림
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 메세지
ALTER TABLE ftp_user_message
	ADD CONSTRAINT FK_ftp_user_TO_ftp_user_message -- 회원 -> 메세지
		FOREIGN KEY (
			user_from -- 보내는이
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 메세지
ALTER TABLE ftp_user_message
	ADD CONSTRAINT FK_ftp_user_TO_ftp_user_message2 -- 회원 -> 메세지2
		FOREIGN KEY (
			user_to -- 받는이
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 챌린지참여자
ALTER TABLE ftp_challenge_apply
	ADD CONSTRAINT FK_ftp_user_TO_ftp_challenge_apply -- 회원 -> 챌린지참여자
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 챌린지참여자
ALTER TABLE ftp_challenge_apply
	ADD CONSTRAINT FK_ftp_challenge_TO_ftp_challenge_apply -- 챌린지 -> 챌린지참여자
		FOREIGN KEY (
			challenge_no -- 챌린지번호
		)
		REFERENCES ftp_challenge ( -- 챌린지
			challenge_no -- 챌린지번호
		);

-- 봉사게시판댓글
ALTER TABLE ftp_vol_comment
	ADD CONSTRAINT FK_ftp_user_TO_ftp_vol_comment -- 회원 -> 봉사게시판댓글
		FOREIGN KEY (
			user_no -- 회원번호
		)
		REFERENCES ftp_user ( -- 회원
			user_no -- 회원번호
		);

-- 봉사게시판댓글
ALTER TABLE ftp_vol_comment
	ADD CONSTRAINT FK_ftp_vol_board_TO_ftp_vol_comment -- 봉사게시판 -> 봉사게시판댓글
		FOREIGN KEY (
			vol_board_no -- 봉사게시판번호
		)
		REFERENCES ftp_vol_board ( -- 봉사게시판
			vol_board_no -- 봉사게시판번호
		);