--회원 조인
select
  user.id 아이디,
  user.email 이메일,
  personal.rank 등급,
  personal.point 포인트,
  photo.filepath 첨부파일,
  message.content 메세지,
  alert.content 알림
from 
  ftp_user user
inner join ftp_user_personal personal on user.user_no=personal.user_no
left outer join ftp_user_photo photo on user.user_no=photo.user_no
left outer join ftp_user_message message on user.user_no=message.user_from
left outer join ftp_user_alert alert on user.user_no=alert.user_no

select
  user.id,
  user.name,
  user.email,
  user.status,
  personal.birthdate,
  personal.rank,
  personal.point
from 
  ftp_user user
inner join ftp_user_personal personal on user.user_no=personal.user_no
