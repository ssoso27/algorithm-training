# MySQL Event Scheduler.md

## 이벤트 등록

EVENT: 특정 시간에 어떠한 쿼리 프로시저 함수 등을 실행시키는 것.

MySQL 5.1.17 부터 지원.

## 구문

```mysql
CREATE EVENT [IF NOT EXISTS] 이벤트명

ON SCHEDULE 스케줄

[ON COMPLETION [NOT] PRESERVE]

[ENABLE | DISABLE]

[COMMENT '주석']

DO [BEGIN] 실행할 sql문; [실행할 sql문]; [END]
```

스케줄:

```mysql
{ AT 타임 [+ INTERVAL 간격 [+INTERVAL 간격...]]

| EVERY 간격 [STARTS 타임][ENDS 타임] }
```

타임:

```mysql
{CURRENT_TIMESTAMP | 년월일시의 리터럴}
```

간격:

```mysql
{YEAR|QUARTER|MONTH|DAY|HOUR|MINUTE|WEEK|SECOND|YEAR_MONTH|DAY|HOUR|MINUTE| WEEK| SECOND | YEAR_MONTH|DAY_HOUR|DAY_MINUTE| DAY_SECOND| HOUR_MINUTE | HOUR_SECOND | MINUTE_SECOND}
```



또, DO이하에 지정하는 SQL문이 한개 인경우에는 BEGIN, END, DELIMITER 지정은 필요없다.

복수의 문을 지정하는 경우는 BEGIN ~END로 문장을 감싼다. 이때 안에 있는 SQL문은「 ;」로 구별하기 때문에 CREATE EVENT문 끝을 의미하는 「 ;」하고 구별할 수 없게 된다.

그래서 stored procedure와 마찬가지로 CREATE EVENT실행전에 DELIMITER 를 지정해서 문장의 끝을 나타내는 마크를 변경해 두어야한다.



예시:

일반적 : 

```mysql
mysql> delimiter // # sql문의 ;과는 다른 delimiter 설정
mysql> CREATE EVENT test_event
-> ON SCHEDULE EVERY 1 DAY # 1 DAY 주기로 loop 수행.
-> STARTS ' 2010-06-27 11:01:00'
-> ENABLE # ?
-> DO
-> BEGIN
-> DELETE FROM test.log
-> WHERE test.log.artime < NOW();
-> END // # 설정했던 delimiter로 end
```

start, end 지정 :

~~~mysql
create event IF NOT EXISTS e2
   ON SCHEDULE 
       EVERY 1 MINUTE # 1분 마다. (순환)
       STARTS CURRENT_TIMESTAMP + INTERVAL 1 MINUTE # 지금으로부터 1분 후 부터
       ENDS CURRENT_TIMESTAMP + INTERVAL 5 MINUTE # 지금으로부터 5분 후 까지 수행
   DO insert into test.e set regdate=now();
# ENDS 시간까지 실행되고 나면, mysql.event 에서 삭제된다. (자동삭제)
~~~

At 지정 :

~~~mysql
create event IF NOT EXISTS e2
   ON SCHEDULE 
       AT CURRENT_TIMESTAMP + INTERVAL 1 MINUTE # 지금으로부터 1분 후에. (한 번)
    DO insert into test.e set regdate=now();
# 한 번 실행되고 나면, mysql.event 에서 삭제된다. (자동삭제)
~~~

이벤트 남기기 : 

~~~mysql
create event IF NOT EXISTS e2
   ON SCHEDULE 
       AT CURRENT_TIMESTAMP + INTERVAL 1 MINUTE
        ON COMPLETION PRESERVE # AT 이지만, 이 구문을 추가하면 실행 후 mysql.event에서 사라지지 않음.
   DO insert into test.e set regdate=now();
~~~



출처 : http://linuxism.tistory.com/854



## EVENT 설정 프로세스

0) 기타 명령어

~~~mysql
SHOW EVENTS; # 이벤트 목록 보기
SHOW CREATE EVENT 이벤트명; # 등록되어 있는 이벤트 내용 보기
ALTER EVENT `이벤트명`
	ON SCHEDULE EVERY 1 MONTH STARTS '2014-05-27 01:00:00'; # 등록되어 있는 이벤트 수정하기
SHOW variables like 'event%'; # 이벤트 스케줄러 환경변수 조회
SHOW PROCESSLIST \G ; # 이벤트 프로세스 동작 확인 
~~~

1) Event ON

1. 서버가 동작중이라면 아래와 같은 SQL문을 통해 실행할수 있다.

   ```mysql
   SET GLOBAL event_scheduler = ON;
   또는
   SET @@global.event_scheduler = ON;
   또는
   SET GLOBAL event_scheduler = 1;
   또는
   SET @@global.event_scheduler = 1;
   ```

2. my.cnf or my.ini 에 옵션(event_scheduler=On)을 추가하고 mysql 을 시작한다.

2) Event Off

1. 서버가 동작중이라면 아래와 같은 SQL문을 통해 종료할수 있다.

   ~~~mysql
   SET GLOBAL event_scheduler = OFF;
   또는
   SET @@global.event_scheduler = OFF;
   또는
   SET GLOBAL event_scheduler = 0;
   또는
   SET @@global.event_scheduler = 0;
   ~~~

2. my.cnf or my.ini 에 옵션(event_scheduler=Off)을 추가하고 mysql 을 시작한다.

3) Event 등록

~~~mysql
create event IF NOT EXISTS e1
    ON SCHEDULE
        EVERY 30 SECOND
        STARTS CURRENT_TIMESTAMP
    DO insert into test.e set regdate=now();
~~~

4) Event 삭제

```mysql
drop event 이벤트명;
```

