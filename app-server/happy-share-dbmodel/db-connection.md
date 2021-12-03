## DB 인스턴스 식별자
happyshare-RDS

## 마스터 사용자 이름
happyshare, master

## 비밀번호
11111111

## 엔드포인트
```
happyshare-rds.c4z80zzhtr4d.ap-northeast-2.rds.amazonaws.com
```

## MariaDB접근
```
mysql -h happyshare-rds.c4z80zzhtr4d.ap-northeast-2.rds.amazonaws.com -u happyshare -p 11111111
```

```
자신의 ip를 RDB의 인바운드 규칙에 넣어야 DB접근가능
```

## 윈도우 가상 서버 배포
<윈도우 가상 컴퓨터를 이용해서 graalvm과 톰캣 설치>

1. EC2에서 인스턴스를 실행하고 우측 상단 연결을 누른다.

2. RDP 클라이언트를 통해 원격 데스트톱 파일 다운로드를 누른다.

3. 사용자 이름은 Administrator 암호는 암호가져오기를 통해 .pem파일을 해독하여 나온 암호를 복사 붙여넣기 한다.

4. 윈도우 가상 컴퓨터에 기존 local에 있던 graalvm과 tomcat파일이 있는 tools파일을 복사해서 가상 컴퓨터 c드라이브 밑에 붙여넣기한다.

5. 환경변수 설정을 통해 path에 graalvm 경로를 설정하고 (/bin 까지)
JAVA_HOME을 만들어준다.(/bin 빼고)

6. 톰캣 폴더 들어가서 bin/startup 실행해서 서버 실행되는지 확인 후
인터넷 들어가서 localhost:8080으로 확인한다.

7. 확인된다면 방화벽(firewall)을 들어가서 advanced settings > inbound rules > 우측 new rule 클릭해서 port를 클릭해서 8080 입력후 이름 지정하고 완료 

8. EC2에도 똑같이 인바운드 규칙을 정해줘야함 대시보드 들어가서 보안그룹 들어가서 launch-wizard-1에서 밑에 인바운드 규칙 편집에 들어가 모든 TCP로 바꾼다.

9. 내 local에서 가상 컴퓨터의 tomcat을 접속해서 확인한다.
localhost:8080에서 나오면 성공

<WAR 배포하기>

1. 이클립스 프로젝트 우측 클릭한 후에 export > war file 

2. 경로 설정한 후에 복사해서 가상 컴퓨터의 톰캣서버의 webapps에 붙여넣기한다.

3. 톰캣 서버를 재실행하면 WAR파일을 자동으로 풀어준다.

4. 경로 - 공개ip:8080/배포명/폴더경로

```
인스턴스 실행 후 종료하기 전 반드시 인스턴스 중지를 해주세요

그렇지 않으면 무료 사용시간 720시간이 줄어듭니다.

자세한 내용는 로그인 후 billing 검색 후 확인바랍니다.
```


## 배포 관련 문제사항
- Amazon EC2 배포 
- 원격 서버(윈도우)에서 톰캣 설치와 graalvm 설치로 배포는 완료된 상태
- DB가 연동안된 프로젝트는 정상적으로 동작하지만 DB가 연동되어 있는 프로젝트는 연동문제가 발생
- 현재 MariaDB(10.6.4)를 사용 중이며 원격 서버에서 현재 나의 로컬(localhost)에 있는 DB 데이터를 조회해서 화면을 띄우려고 함.

- 원격 서버에서 MariaDB를 설치해서 데이터를 다시 넣고 해야하는지
- 원격 서버에서 나의 로컬 DB에 접근해서 데이터를 조회해서 배포를 할 수 있는지 궁금합니다.
- 그리고 따로 프로젝트에도 DB관련 설정 파일을 수정해야하는지
(현재 jdbc-properties에 db계정이 설정되어 있고, mybatis-config.xml에도 설정이 되어있는데 이 것들을 수정해야하는지)
