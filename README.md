# 스프링부트 블로그 V2

## 기획끝

##화면설계 끝 ##화면코드 끝 ##테이블설계

## 1단계기능

- (특징:자바스크립트,예외처리) -회원가입 -로그인 -회원정보 보기 -회원정보 수정하기 -게시물 작성보기 -게시글 목록하기 -게시글 상세하기 -게시글 삭제하기 -게시글 수정하기 -댓글쓰기 -댓글삭제하기

## 2단계기능

-유저네임 중복체크(ajax) -페이징하기 -검색하기

## 3단계기능

-필터(filter) -유효성검사(aop) -인증검사(inteerceptor) -이메일보기(댓글작성이되면 게시글 주인에게)

## 테이블 쿼리

```sql
create database blogdb;
use blogdb;
create table user_tb (
    id integer auto_increment,
    created_at timestamp,
    email varchar(20) not null,
    password varchar(60) not null,
    username varchar(20) not null unique,
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
create table board_tb (
    id integer auto_increment,
    content varchar(10000),
    created_at timestamp,
    title varchar(100) not null,
    user_id integer,
    primary key (id),
    constraint fk_board_user_id foreign key (user_id) references user_tb (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
create table reply_tb (
    id integer auto_increment,
    comment varchar(100) not null,
    created_at timestamp,
    board_id integer,
    user_id integer,
    primary key (id),
    constraint fk_reply_board_id foreign key (board_id) references board_tb (id),
    constraint fk_reply_user_id foreign key (user_id) references user_tb (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
```
