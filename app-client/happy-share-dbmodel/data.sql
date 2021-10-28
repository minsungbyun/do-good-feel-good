-- 회원 입력 (1=개인 2=단체 3=기관)(0.탈퇴 1.가입완료 2.승인대기 3.승인반려 4.휴면회원)
insert into ftp_user(user_no, id, password, name, tel, email, post_no, basic_address, detail_address, type, status)
values(1,'interface', password('1'), 'interface', '010-1111-1111', 'interface@naver.com', '05541', '서울시', '강남구',1,1);

insert into ftp_user(user_no, id, password, name, tel, email, post_no, basic_address, detail_address, type, status)
values(2,'object', password('1'), 'object', '010-2222-2222', 'object@naver.com', '08155', '경기도', '부평구',2,1);

insert into ftp_user(user_no, id, password, name, tel, email, post_no, basic_address, detail_address, type, status)
values(3,'sysout', password('1'), 'sysout', '010-3333-3333', 'sysout@naver.com', '06661', '서울시', '서초구',3,1);

insert into ftp_user(user_no, id, password, name, tel, email, post_no, basic_address, detail_address, type, status)
values(4,'public', password('1'), 'public', '010-4444-4444', 'public@naver.com', '06661', '서울시', '송파구',1,1);

insert into ftp_user(user_no, id, password, name, tel, email, post_no, basic_address, detail_address, type, status)
values(5,'java', password('1'), 'java', '010-5555-1111', 'java@naver.com', '22541', '서울시', '서초구',1,2);

insert into ftp_user(user_no, id, password, name, tel, email, post_no, basic_address, detail_address, type, status)
values(6,'eclipse', password('1'), 'eclipse', '010-6666-1111', 'eclipse@naver.com', '06641', '서울시', '강북구',1,3);


--개인회원
insert into ftp_user_personal(user_personal_no, user_no, birthdate, rank)
values(20, 3, '2020-1-1','천콩이');

insert into ftp_user_personal(user_personal_no, user_no, birthdate, rank)
values(21, 2, '2021-1-1','천이콩이');

insert into ftp_user_personal(user_personal_no, user_no, birthdate, rank)
values(22, 1, '2021-2-5','천콩이');

insert into ftp_user_personal(user_personal_no, user_no, birthdate, rank)
values(23, 6, '2021-2-5','천콩이');

--단체회원
insert into ftp_user_group(user_group_no, user_no, group_cnt)
values(2, 4, 5);

insert into ftp_user_group(user_group_no, user_no, group_cnt)
values(3, 5, 3);


--알림
insert into ftp_user_alert(user_notice_no, user_no, content)
values(1,1,'게시글이 등록되었습니다');

insert into ftp_user_alert(user_notice_no, user_no, content)
values(2,2,'게시글이 삭제되었습니다');

insert into ftp_user_alert(user_notice_no, user_no, content)
values(3,3,'회원가입이 완료되었습니다');

--회원사진
insert into ftp_user_photo(user_photo_no, user_no, filepath)
values(1, 1, 'a.gif');

insert into ftp_user_photo(user_photo_no, user_no, filepath)
values(2, 2, 'b.gif');

insert into ftp_user_photo(user_photo_no, user_no, filepath)
values(3, 3, 'c.gif');

--메세지
insert into ftp_user_message(message_no, user_from, user_to, content)
values(1,1,2,'안녕');

insert into ftp_user_message(message_no, user_from, user_to, content)
values(2,2,1,'반가워');




--봉사게시판
insert into ftp_vol_board(vol_board_no, user_no, title, content)
values(1, 1, '나눔이야기1', '내용1');

insert into ftp_vol_board(vol_board_no, user_no, title, content)
values(2, 3, '나눔이야기2', '내용2');

insert into ftp_vol_board(vol_board_no, user_no, title, content)
values(3, 4, '나눔이야기3', '내용3');

insert into ftp_vol_board(vol_board_no, user_no, title, content)
values(4, 2, '나눔이야기4', '내용4');

insert into ftp_vol_board(vol_board_no, user_no, title, content)
values(5, 1, '나눔이야기5', '내용5');

--봉사게시판댓글
insert into ftp_vol_comment(vol_comment_no, vol_board_no, user_no, content)
values(1, 1, 1, '댓글1');
insert into ftp_vol_comment(vol_comment_no, vol_board_no, user_no, content)
values(2, 2, 2, '댓글2');
insert into ftp_vol_comment(vol_comment_no, vol_board_no, user_no, content)
values(3, 3, 3, '댓글3');
insert into ftp_vol_comment(vol_comment_no, vol_board_no, user_no, content)
values(4, 1, 1, '댓글');



-- 봉사게시판 첨부파일
insert into ftp_vol_board_file(vol_board_file_no, vol_board_no, filepath) values(1, 1, 'nanoom1.jpg');

insert into ftp_vol_board_file(vol_board_file_no, vol_board_no, filepath) values(2, 3, 'nanoom3.jpg');

insert into ftp_vol_board_file(vol_board_file_no, vol_board_no, filepath) values(3, 4, 'nanoom4.jpg');

insert into ftp_vol_board_file(vol_board_file_no, vol_board_no, filepath) values(4, 2, 'nanoom2.jpg');

insert into ftp_vol_board_file(vol_board_file_no, vol_board_no, filepath) values(5, 5, 'nanoom5.jpg');


--봉사좋아요
insert into ftp_vol_board_like(user_no, vol_board_no)
values(1,1);

insert into ftp_vol_board_like(user_no, vol_board_no)
values(2,1);

insert into ftp_vol_board_like(user_no, vol_board_no)
values(3,1);

insert into ftp_vol_board_like(user_no, vol_board_no)
values(1,2);

--봉사첨부파일
insert into ftp_vol_file(vol_file_no, vol_no, filepath)
values(1,1,'haha.gif');

insert into ftp_vol_file(vol_file_no, vol_no, filepath)
values(2,2,'hoho.gif');


--한 줄 후기(봉사활동 후기)

insert into ftp_vol_shortreview(vol_shortreview_no, user_no, vol_no, content)
values(1, 3, 1, '한줄후기1'); 

insert into ftp_vol_shortreview(vol_shortreview_no, user_no, vol_no, content)
values(2, 2, 2, '한줄후기2'); 

insert into ftp_vol_shortreview(vol_shortreview_no, user_no, vol_no, content)
values(3, 4, 3, '한줄후기3');




--봉사 (승인여부 : 0.반려 1.승인 2.승인대기)
insert into ftp_vol(vol_no, user_no, category_no, title, content, tel, email, start_dt, end_dt, start_time, end_time, total_cnt, approval) 
values(1, 1, 7,'서울숲 자원봉사 - 떨어진 낙엽 정리하기','내용1','031-554-8888','fall@naver.com','2021-09-01','2021-11-30','9:00','18:00',100,1);

insert into ftp_vol(vol_no, user_no, category_no, title, content, tel, email, start_dt, end_dt, start_time, end_time, total_cnt, approval) 
values(2, 2, 3,'청소년 길잡이 멘토 모집','내용2','031-514-8878','child@naver.com','2021-07-02','2021-12-11','9:00','18:00',30,1);

insert into ftp_vol(vol_no, user_no, category_no, title, content, tel, email, start_dt, end_dt, start_time, end_time, total_cnt, approval) 
values(7, 3, 1,'비대면 - 베프지도(장벽없는) 만들기','내용3','031-514-1178','untact@gmail.com','2021-5-5','2021-12-30','9:00','18:00',50,1);

insert into ftp_vol(vol_no, user_no, category_no, title, content, tel, email, start_dt, end_dt, start_time, end_time, total_cnt, approval) 
values(5, 2, 1,'비대면','내용4','031-514-1178','untact22@gmail.com','2021-1-1','2021-12-30','11:00','14:00',10,0);


--봉사 승인대기 데이터  
insert into ftp_vol(vol_no, user_no, category_no, title, content, tel, email, start_dt, end_dt, start_time, end_time, total_cnt, approval) 
values(6, 1, 4,'사랑의 도시락','내용4','031-414-1118','soso@gmail.com','2021-8-5','2021-12-10','9:00','18:00',10,2);

insert into ftp_vol(vol_no, user_no, category_no, title, content, tel, email, start_dt, end_dt, start_time, end_time, total_cnt, approval) 
values(8, 1, 4,'봉사대기sample','내용5','031-111-2222','sasa@gmail.com','2021-8-5','2021-12-10','13:00','18:00',10,2);


--봉사참여자 (apply_status 1.승인 2.거절)

insert into ftp_vol_apply(user_no, vol_no, apply_dt, start_time, end_time, apply_status)
values(1,1,'2021-11-11','09:00','18:00',1);



--카테고리 (1.비대면 2.아동 3.청소년 4.노인 5.장애인 6.동물 7.환경 8.기타)
insert into ftp_category(category_no, category_title)
values(1,'비대면');

insert into ftp_category(category_no, category_title)
values(2,'아동');

insert into ftp_category(category_no, category_title)
values(3,'청소년');

insert into ftp_category(category_no, category_title)
values(4,'노인');

insert into ftp_category(category_no, category_title)
values(5,'장애인');

insert into ftp_category(category_no, category_title)
values(6,'동물');

insert into ftp_category(category_no, category_title)
values(7,'환경');

insert into ftp_category(category_no, category_title)
values(8,'기타');

-- 챌린지
insert into ftp_challenge(challenge_no, title, content, start_dt, end_dt) values(1, '덕분에 챌린지', '의료진에게 존경합니다 뜻하는 수화 동작 사진을 찍고 인증해보세요!', '2021-10-01', '2021-10-31');
insert into ftp_challenge(challenge_no, title, content, start_dt, end_dt) values(2, '거리두기 챌린지', '거리두기 챌린지 내용', '2021-10-15', '2021-11-15');
insert into ftp_challenge(challenge_no, title, content, start_dt, end_dt) values(3, '깜빡 챌린지', '깜빡 챌린지 내용', '2021-10-05', '2021-11-05');

-- 챌린지 첨부파일
insert into ftp_challenge_file(challenge_file_no, challenge_no, filepath) values(1, 1, '덕분에 챌린지 관련 첨부.gif');
insert into ftp_challenge_file(challenge_file_no, challenge_no, filepath) values(2, 2, '거리두기 챌린지 관련 첨부.gif');
insert into ftp_challenge_file(challenge_file_no, challenge_no, filepath) values(3, 3, '깜빡 챌린지 관련 첨부.gif');

-- 챌린지 문의
insert into ftp_challenge_qna(challenge_qna_no, challenge_no, user_no, content) values(1, 1, 6, '덕분에 챌린지는 어떻게 인증하나요?');
insert into ftp_challenge_qna(challenge_qna_no, challenge_no, user_no, content) values(2, 2, 1, '거리두기 챌린지는 어떻게 인증하나요?');
insert into ftp_challenge_qna(challenge_qna_no, challenge_no, user_no, content) values(3, 3, 1, '깜빡 챌린지는 어떻게 인증하나요?');

-- 챌린지 참여자
insert into ftp_challenge_apply(challenge_no, user_no, apply_dt) values(1, 6, '2021-10-27');
insert into ftp_challenge_apply(challenge_no, user_no, apply_dt) values(2, 6, '2021-10-26');
insert into ftp_challenge_apply(challenge_no, user_no, apply_dt) values(3, 6, '2021-10-28');

-- 챌린지 리뷰
insert into ftp_challenge_review(challenge_review_no, challenge_no, user_no, content) values(1, 1, 6, '덕분에 챌린지 인증합니다!');
insert into ftp_challenge_review(challenge_review_no, challenge_no, user_no, content) values(2, 2, 6, '거리두기 챌린지 인증합니다!');
insert into ftp_challenge_review(challenge_review_no, challenge_no, user_no, content) values(3, 3, 6, '깜빡 챌린지 인증합니다!');

-- 챌린지 리뷰 첨부파일
insert into ftp_challenge_review_file(challenge_review_file_no, challenge_review_no, filepath) values(1, 1, '덕분에 챌린지 인증 첨부.gif');
insert into ftp_challenge_review_file(challenge_review_file_no, challenge_review_no, filepath) values(2, 2, '거리두기 챌린지 인증 첨부.gif');
insert into ftp_challenge_review_file(challenge_review_file_no, challenge_review_no, filepath) values(3, 3, '깜빡 챌린지 인증 첨부.gif');

-- 공지사항 입력
insert into ftp_support_notice(title, content) values('공지사항1', '내용1');

insert into ftp_support_notice(notice_no, title, content) values(2, '공지사항2', '내용2');
insert into ftp_support_notice(notice_no, title, content) values(3, '공지사항3', '내용3');
insert into ftp_support_notice(notice_no, title, content) values(4, '공지사항4', '내용4');
insert into ftp_support_notice(notice_no, title, content) values(5, '공지사항5', '내용5');
insert into ftp_support_notice(notice_no, title, content) values(6, '공지사항6', '내용6');

-- 공지사항 첨부파일 입력
insert into ftp_support_notice_file(notice_no, filepath) values(14, 'notice01_1.jpg');

insert into ftp_support_notice_file(notice_file_no, notice_no, filepath) values(2, 1, 'notice01_2.gif');
insert into ftp_support_notice_file(notice_file_no, notice_no, filepath) values(3, 2, 'notice02_1.png');
insert into ftp_support_notice_file(notice_file_no, notice_no, filepath) values(4, 3, 'notice03_1.jpg');

-- 문의하기 카테고리
-- (1.함께해요 문의 2.나눔이야기 문의 3.모금함 문의 4.챌린지 문의 5.사이트이용 문의 6.기타 문의)
insert into ftp_support_qna_categroy(qna_category_no, category_title) values(1, '함께해요 문의');
insert into ftp_support_qna_categroy(qna_category_no, category_title) values(2, '나눔이야기 문의');
insert into ftp_support_qna_categroy(qna_category_no, category_title) values(3, '모금함 문의');
insert into ftp_support_qna_categroy(qna_category_no, category_title) values(4, '챌린지 문의');
insert into ftp_support_qna_categroy(qna_category_no, category_title) values(5, '사이트이용 문의');
insert into ftp_support_qna_categroy(qna_category_no, category_title) values(6, '기타 문의');

-- 문의하기
insert into ftp_support_qna(qna_no, user_no, qna_category_no, title, content, password, qna_reply, status)
  values(1, 1, 4, '문의1', '내용1', password('1'), '문의하기 답글1', 1);
insert into ftp_support_qna(qna_no, user_no, qna_category_no, title, content, password, qna_reply, status)
  values(2, 4, 2, '문의2', '내용2', password('1'), '문의하기 답글2', 1);
insert into ftp_support_qna(qna_no, user_no, qna_category_no, title, content, password, status)
  values(3, 6, 5, '문의3', '내용3', password('1'), 0);
insert into ftp_support_qna(qna_no, user_no, qna_category_no, title, content, password)
  values(4, 3, 4, '문의4', '내용4', password('1'));
insert into ftp_support_qna(qna_no, user_no, qna_category_no, title, content, password)
  values(5, 1, 4, '문의5', '내용5', password('1'));
insert into ftp_support_qna(qna_no, user_no, qna_category_no, title, content, password, qna_reply)
  values(6, 5, 3, '문의6', '내용6', password('1'), '문의하기 답글6');

  insert into ftp_support_qna(qna_no, user_no, qna_category_no, title, content, password)
  values(1, 13, 4, '문의1', '내용1', password('1'));
  insert into ftp_support_qna(user_no, qna_category_no, title, content, password)
  values(13, 2, '문의2', '내용2', password('2'));
  insert into ftp_support_qna(user_no, qna_category_no, title, content, password)
  values(17, 6, '문의3', '내용3', password('3'));
  
  
-- 문의하기 첨부파일
insert into ftp_support_qna_file(qna_file_no, qna_no, filepath) values(1, 1, 'qna01_1.jpg');
insert into ftp_support_qna_file(qna_file_no, qna_no, filepath) values(2, 1, 'qna01_2.png');

insert into ftp_support_qna_file(qna_file_no, qna_no, filepath) values(3, 2, 'qna02_1.gif');
insert into ftp_support_qna_file(qna_file_no, qna_no, filepath) values(4, 6, 'qna06_1.gif');
insert into ftp_support_qna_file(qna_file_no, qna_no, filepath) values(5, 6, 'qna06_2.jpg');
insert into ftp_support_qna_file(qna_file_no, qna_no, filepath) values(6, 6, 'qna06_3.gif');


