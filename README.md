# Lv.2과제 API 설계서

## 프로젝트 과제

### Github

[🔱 https://github.com/SangYoungBaek/Spring-Lv2](https://github.com/SangYoungBaek/Spring-Lv2)

### 완성 Documentation

[📙 lv.2 Documentation](https://documenter.getpostman.com/view/29503606/2s9Y5eMK9q#088aa669-342b-41ba-952e-43de1b3b9b4d)

## 과제 설명

### 설명

회원 가입과 로그인 기능이 들어간 게시판 서비스

### 참여 팀원

🐢 **김혜린** :

filter에 Auth 기능 추가, 게시판 Controller, Service 수정

API계획서 작성

🐈 **백상용** `Github Owner` :

Entity, 전체 로직 (회원가입, 로그인, 게시판CRUD)

## 구현

### 구현 환경

**OS :** `Windows10 이상`

**Language : Java 17**

**FrameWork : SpringBoot 3.1.3**

**Other: Git, Github**

### 구현 목표

- [x]  회원 가입, 로그인 기능이 있어야 한다.
- [x]  인증, 인가된 사용자가 게시글을 작성, 수정, 삭제가 가능해야한다.
    - [x]  Jwt 토큰으로 인증-인가를 수행한다.
- [x]  누구나 게시글을 조회할 수 있어야 한다.

### 구현 리스트

**회원**

- [x]  회원 가입 API
    - [x]  username 4-10자 소문자, 숫자 가능
    - [x]  password 8 - 15자 대소문자, 숫자 가능
- [x]  로그인 API
    - [x]  성공 시, Header에 token 포함하여 반환

**게시글**

- [x]  게시글 생성 API
    - [x]  유효한 token을 가진 사용자가 요청 시 성공하도록
- [x]  게시글 수정 API
    - [x]  유효한 token과 게시글 작성자가 요청 시 성공하도록
- [x]  게시글 삭제API
    - [x]  유효한 token과 게시글 작성자가 요청 시 성공하도록
- [x]  게시글 전체 조회 API - 생성일 내림차순 조회
- [x]  게시글 하나조회 API - 게시글 id로 조회

### 구현 설계

### ERD

![Copy of Copy of Copy of lv2.png](https://file.notion.so/f/f/34d7453b-5e8b-4602-8745-f7b0f278fb41/21b4123e-fe59-4c16-8ff2-1319468a10a6/Copy_of_Copy_of_Copy_of_lv2.png?id=e283f5fa-7f52-44c2-ac40-60f5e5439a11&table=block&spaceId=34d7453b-5e8b-4602-8745-f7b0f278fb41&expirationTimestamp=1693908000000&signature=NU6x39Q7Avfw_TTtqZl06o2MS48Qp5ESaiOj5jcsh3U&downloadName=Copy+of+Copy+of+Copy+of+lv2.png)

[//]: # (![Copy of Copy of Copy of lv2.png]&#40;Copy of Copy of Copy of lv2.png&#41;)

### API 명세서
[🏃‍♀️ 명세서 링크 ](https://www.notion.so/Lv-2-API-d0ebb438bf10409d93f682e8c6cfb454)