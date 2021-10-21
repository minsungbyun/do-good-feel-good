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
values(6, 3, '2020-1-1','천콩이');

insert into ftp_user_personal(user_personal_no, user_no, birthdate, rank)
values(7, 2, '2021-1-1','천이콩이');

insert into ftp_user_personal(user_personal_no, user_no, birthdate, rank)
values(3, 1, '2021-2-5','천콩이');

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
insert into ftp_vol_board_file(vol_board_file_no, vol_board_no, filepath)
values(1,1,'haha.gif');

insert into ftp_vol_board_file(vol_board_file_no, vol_board_no, filepath)
values(2,2,'hoho.gif');


--한 줄 후기(봉사활동 후기) - 봉사 입력 후 입력 가능

insert into ftp_vol_shortreview(vol_shortreview_no, user_no, vol_no, content)
values(1, 3, 1, '한줄후기1'); 

insert into ftp_vol_shortreview(vol_shortreview_no, user_no, vol_no, content)
values(2, 2, 2, '한줄후기2'); 

insert into ftp_vol_shortreview(vol_shortreview_no, user_no, vol_no, content)
values(3, 4, 3, '한줄후기3');




--봉사 (승인여부 : 1.승인 2.반려)
insert into ftp_vol(vol_no, user_no, vol_category_no, title, content, tel, email, start_dt, end_dt, start_time, end_time, total_cnt, approval) 
values(1, 1, 7,'서울숲 자원봉사 - 떨어진 낙엽 정리하기','내용1','031-554-8888','fall@naver.com','2021-09-01','2021-11-30','9:00','18:00',100,1);

insert into ftp_vol(vol_no, user_no, vol_category_no, title, content, tel, email, start_dt, end_dt, start_time, end_time, total_cnt, approval) 
values(2, 2, 3,'청소년 길잡이 멘토 모집','내용2','031-514-8878','child@naver.com','2021-07-02','2021-12-11','9:00','18:00',30,1);

insert into ftp_vol(vol_no, user_no, vol_category_no, title, content, tel, email, start_dt, end_dt, start_time, end_time, total_cnt, approval) 
values(3, 3, 1,'비대면 - 베프지도(장벽없는) 만들기','내용3','031-514-1178','untact@gmail.com','2021-5-5','2021-12-30','9:00','18:00',50,1);

--봉사 반려 데이터  
insert into ftp_vol(vol_no, user_no, vol_category_no, title, content, tel, email, start_dt, end_dt, start_time, end_time, total_cnt, approval) 
values(4, 1, 4,'사랑의 도시락','내용4','031-414-1118','soso@gmail.com','2021-8-5','2021-12-10','9:00','18:00',10,2);


--봉사참여자 (apply_status 1.승인 2.거절)
-- 잘못된 데이터 고쳐야함
insert into ftp_vol_apply(user_no, vol_no, apply_dt, start_time, end_time, apply_status)
values(1,1,'2021-11-11','09:00','18:00',1);



--봉사카테고리 (1.비대면 2.아동 3.청소년 4.노인 5.장애인 6.동물 7.환경 8.기타)
insert into ftp_vol_category(vol_category_no, category_title)
values(1,'비대면');

insert into ftp_vol_category(vol_category_no, category_title)
values(2,'아동');

insert into ftp_vol_category(vol_category_no, category_title)
values(3,'청소년');

insert into ftp_vol_category(vol_category_no, category_title)
values(4,'노인');

insert into ftp_vol_category(vol_category_no, category_title)
values(5,'장애인');

insert into ftp_vol_category(vol_category_no, category_title)
values(6,'동물');

insert into ftp_vol_category(vol_category_no, category_title)
values(7,'환경');

insert into ftp_vol_category(vol_category_no, category_title)
values(8,'기타');


-- 공지사항 입력
insert into ftp_support_notice(notice_no, title, content) values(1, '공지사항1', '내용1');
insert into ftp_support_notice(notice_no, title, content) values(2, '공지사항2', '내용2');
insert into ftp_support_notice(notice_no, title, content) values(3, '공지사항3', '내용3');
insert into ftp_support_notice(notice_no, title, content) values(4, '공지사항4', '내용4');
insert into ftp_support_notice(notice_no, title, content) values(5, '공지사항5', '내용5');
insert into ftp_support_notice(notice_no, title, content) values(6, '공지사항6', '내용6');

-- 공지사항 첨부파일 입력
insert into ftp_support_notice_file(notice_file_no, notice_no, filepath) values(1, 1, 'notice01_1.jpg');
insert into ftp_support_notice_file(notice_file_no, notice_no, filepath) values(2, 1, 'notice01_2.gif');
insert into ftp_support_notice_file(notice_file_no, notice_no, filepath) values(3, 2, 'notice02_1.png');
insert into ftp_support_notice_file(notice_file_no, notice_no, filepath) values(4, 3, 'notice02_2.jpg');
insert into ftp_support_notice_file(notice_file_no, filepath, notice_no) values(15, 'notice02_3.jpg', 2);
insert into ftp_support_notice_file(notice_file_no, filepath, notice_no) values(16, 'notice03_1.gif', 3);
insert into ftp_support_notice_file(notice_file_no, filepath, notice_no) values(17, 'notic03_2.gif', 3);
insert into ftp_support_notice_file(notice_file_no, filepath, notice_no) values(18, 'notice03_3.gif', 3);
insert into ftp_support_notice_file(notice_file_no, filepath, notice_no) values(19, 'notice05_1.gif', 5);
insert into ftp_support_notice_file(notice_file_no, filepath, notice_no) values(20, 'notice05_2.gif', 5);
insert into ftp_support_notice_file(notice_file_no, filepath, notice_no) values(21, 'notice05_3.gif', 5);
insert into ftp_support_notice_file(notice_file_no, filepath, notice_no) values(22, 'notice06_1.gif', 6);
insert into ftp_support_notice_file(notice_fil_noe, filepath, notice_no) values(23, 'notice06_2.gif', 6);

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
  
  
insert into ftp_support_qna(qna_no, user_no, qna_category_no, title, content, password, qna_reply, status)
  values(1, 1, 4, '문의1', '내용1', password('1'), '문의하기 답글1', 1);
insert into ftp_support_qna(qna_no, user_no, qna_category_no, title, content, password, qna_reply, status)
  values(1, 1, 4, '문의1', '내용1', password('1'), '문의하기 답글1', 1);
insert into ftp_support_qna(qna_no, user_no, qna_category_no, title, content, password, qna_reply, status)
  values(1, 1, 4, '문의1', '내용1', password('1'), '문의하기 답글1', 1);
insert into ftp_support_qna(qna_no, user_no, qna_category_no, title, content, password, qna_reply, status)
  values(1, 1, 4, '문의1', '내용1', password('1'), '문의하기 답글1', 1);

  

-- 문의하기 첨부파일
insert into ftp_support_qna_file(qna_file, filepath, qna_no) values(11, 'qna01_1.jpg', 1);
insert into ftp_support_qna_file(qna_file, filepath, qna_no) values(12, 'qna01_2.png', 1);
insert into ftp_support_qna_file(qna_file, filepath, qna_no) values(13, 'qna02_1.gif', 2);
insert into ftp_support_qna_file(qna_file, filepath, qna_no) values(14, 'qna04_1.gif', 4);
insert into ftp_support_qna_file(qna_file, filepath, qna_no) values(15, 'qna04_2.jpg', 4);
insert into ftp_support_qna_file(qna_file, filepath, qna_no) values(16, 'qna04_3.gif', 4);
insert into ftp_support_qna_file(qna_file, filepath, qna_no) values(17, 'qna05_1.jpg', 5);
insert into ftp_support_qna_file(qna_file, filepath, qna_no) values(18, 'qna05_2.png', 5);
insert into ftp_support_qna_file(qna_file, filepath, qna_no) values(19, 'qna05_3.jpg', 5);
insert into ftp_support_qna_file(qna_file, filepath, qna_no) values(20, 'qna06_1.jpg', 6);














-- 나중에 재입력 예정
--봉사게시판(나눔이야기)
insert into ftp_vol_board(vol_board_no, user_no, title, content)
values(1, 1, '유기견 봉사 활동 후기', '입구에서부터 반갑게 맞아주는 강아지들과 함께봉사활동 하러갔다가 되려 귀요미들에게 힐링 받고 왔습니다. 견사 청소와 열악한 시설 보수 공사, 그리고 목욕시키기를 마치고나니 하루가 훌쩍 흘러갔네요.  몸은 고되었지만 뿌듯하고 보람찬 하루였습니다.');

insert into ftp_vol_board(vol_board_no, user_no, title, content)
values(2, 3, '점자 벽보 만들기', '시각 장애인들을 위한 점자 벽보를 만들었습니다. 비대면 봉사활동으로 누구나 참여할 수 있다는게 큰 장점입니다. 봉사를 신청하면 재료가 집으로 배달됩니다. 벽보를 제작하면 이 벽보를 가지고 시각장애인들이 점자를 배울 수 있는 자료가 된다고 해요. 저의 작은 재능 기부로 도움을 줄 수 있다는 것에 뿌듯하고 보람찬 시간이었습니다.');

insert into ftp_vol_board(vol_board_no, user_no, title, content)
values(3, 4, '청소년 멘토링 봉사활동', '제가 아이들에게 어떤 도움이 될 수 있을 지 시작전에는 고민이 많았지만, 교육 봉사를 하며 작은 것이나마 나누어줄 수 있다는 것만으로도 의미가 있다는 것을 알게되었어요. 제가 참여한 활동은 아이들과 보드게임을 하는 것이었습니다. 보드게임룰을 한 명씩 돌아가면서 설명하고 소통하는 것에 큰 의미가 있었습니다. 앞으로도 제가 할 수 있는 봉사활동을 찾아나가고 싶습니다.');

insert into ftp_vol_board(vol_board_no, user_no, title, content)
values(4, 2, '한강 환경 정비 봉사활동', '즐거운 일요일, 한강변을 걸으며 쓰레기를 주우며 보람찬 하루를 보냈습니다. 무더위로 많은 땀이 흘러내렸고 담배꽁초를 줍고 있는 와중에도 새로운 꽁초를 버리는 사람들을 보면서 아, 앞으로도 지속적인 봉사활동이 필요하겠구나 하는 생각이 들었습니다. 여러분! 쓰레기는 늘 쓰레기통에 버리는 습관을 가집시다.^^')


--한 줄 후기(봉사활동 후기) - 봉사 입력 후 입력 가능

insert into ftp_vol_shortreview(vol_shortreview_no, user_no, vol_no, content)
values(1, 3, 1, '가을의 청취를 느낄 수 있었던 봉사'); 

insert into ftp_vol_shortreview(vol_shortreview_no, user_no, vol_no, content)
values(2, 2, 2, '저도 같이 성장하는 느낌이었습니다.'); 

insert into ftp_vol_shortreview(vol_shortreview_no, user_no, vol_no, content)
values(3, 4, 3, '누구나 쉽게 참여할 수 있어요!');