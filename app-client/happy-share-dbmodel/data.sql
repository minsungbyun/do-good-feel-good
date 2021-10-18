-- 회원 입력
insert into ftp_user(id, password, name, tel, email, post_no, basic_address, detail_address, status)
values('interface', password('1'), 'interface', '010-1111-1111', 'interface@naver.com', '05541', '서울시', '강남구',/* 1=개인 2=단체 3=기관*/ '1');

insert into ftp_user(id, password, name, tel, email, post_no, basic_address, detail_address, status)
values('object', password('1'), 'object', '010-2222-2222', 'object@naver.com', '08155', '경기도', '부평구',/*2=단체 3=기관*/ '2');

insert into ftp_user(id, password, name, tel, email, post_no, basic_address, detail_address, status)
values('sysout', password('1'), 'sysout', '010-3333-3333', 'sysout@naver.com', '06661', '서울시', '서초구',/* 1=개인 2=단체 3=기관*/ '3');

insert into ftp_user(id, password, name, tel, email, post_no, basic_address, detail_address, status)
values('public', password('1'), 'public', '010-4444-4444', 'public@naver.com', '06661', '서울시', '송파구',/* 1=개인 2=단체 3=기관*/ '1');

-- 공지사항 입력
insert into ftp_support_notice(notice_no, title, content) values(1, '공지사항1', '내용1');
insert into ftp_support_notice(notice_no, title, content) values(2, '공지사항2', '내용2');
insert into ftp_support_notice(notice_no, title, content) values(3, '공지사항3', '내용3');
insert into ftp_support_notice(notice_no, title, content) values(4, '공지사항4', '내용4');
insert into ftp_support_notice(notice_no, title, content) values(5, '공지사항5', '내용5');
insert into ftp_support_notice(notice_no, title, content) values(6, '공지사항6', '내용6');

-- 공지사항 첨부파일 입력
insert into ftp_support_notice_file(notice_file, filepath, notice_no) values(11, 'notice01_1.jpg', 1);
insert into ftp_support_notice_file(notice_file, filepath, notice_no) values(12, 'notice01_2.gif', 1);
insert into ftp_support_notice_file(notice_file, filepath, notice_no) values(13, 'notice02_1.png', 2);
insert into ftp_support_notice_file(notice_file, filepath, notice_no) values(14, 'notice02_2.jpg', 2);
insert into ftp_support_notice_file(notice_file, filepath, notice_no) values(15, 'notice02_3.jpg', 2);
insert into ftp_support_notice_file(notice_file, filepath, notice_no) values(16, 'notice03_1.gif', 3);
insert into ftp_support_notice_file(notice_file, filepath, notice_no) values(17, 'notic03_2.gif', 3);
insert into ftp_support_notice_file(notice_file, filepath, notice_no) values(18, 'notice03_3.gif', 3);
insert into ftp_support_notice_file(notice_file, filepath, notice_no) values(19, 'notice05_1.gif', 5);
insert into ftp_support_notice_file(notice_file, filepath, notice_no) values(20, 'notice05_2.gif', 5);
insert into ftp_support_notice_file(notice_file, filepath, notice_no) values(21, 'notice05_3.gif', 5);
insert into ftp_support_notice_file(notice_file, filepath, notice_no) values(22, 'notice06_1.gif', 6);
insert into ftp_support_notice_file(notice_file, filepath, notice_no) values(23, 'notice06_2.gif', 6);

-- 문의하기 카테고리
insert into ftp_support_qna_categroy(qna_category_no, category_title) values(1, '함께해요 문의');
insert into ftp_support_qna_categroy(qna_category_no, category_title) values(2, '나눔이야기 문의');
insert into ftp_support_qna_categroy(qna_category_no, category_title) values(3, '모금함 문의');
insert into ftp_support_qna_categroy(qna_category_no, category_title) values(4, '챌린지 문의');
insert into ftp_support_qna_categroy(qna_category_no, category_title) values(5, '사이트이용 문의');
insert into ftp_support_qna_categroy(qna_category_no, category_title) values(6, '기타 문의');

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


