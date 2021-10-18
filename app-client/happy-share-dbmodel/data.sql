-- 회원 입력
insert into ftp_user(user_id, password, name, tel, email, pst_no, bas_addr, det_addr, user_status)
values('interface', password('1'), 'interface', '010-1111-1111', 'interface@naver.com', '05541', '서울시', '강남구',/* 1=개인 2=단체 3=기관*/ '1');

insert into ftp_user(user_id, password, name, tel, email, pst_no, bas_addr, det_addr, user_status)
values('object', password('1'), 'object', '010-2222-2222', 'object@naver.com', '08155', '경기도', '부평구',/*2=단체 3=기관*/ '2');

insert into ftp_user(user_id, password, name, tel, email, pst_no, bas_addr, det_addr, user_status)
values('sysout', password('1'), 'sysout', '010-3333-3333', 'sysout@naver.com', '06661', '서울시', '서초구',/* 1=개인 2=단체 3=기관*/ '3');

insert into ftp_user(user_id, password, name, tel, email, pst_no, bas_addr, det_addr, user_status)
values('public', password('1'), 'public', '010-4444-4444', 'public@naver.com', '06661', '서울시', '송파구',/* 1=개인 2=단체 3=기관*/ '1');
