# spring_project

Spring Boot + MyBatis + MariaDB 기반 REST API 서버.
React 프론트엔드(`react_project`)와 연동하는 백엔드 프로젝트.

---

## 기술 스택

| 항목 | 값 |
|------|----|
| Language | Java 21 |
| Framework | Spring Boot 3.5.14 |
| Build Tool | Gradle |
| ORM | MyBatis 3.0.5 |
| Database | MariaDB |
| 기타 | Lombok |

---

## 실행 방법

```bash
./gradlew bootRun
```

서버 포트: `http://localhost:8080`

---

## DB 설정

- DB명: `react_project`
- Host: `localhost:3306`
- 드라이버: MariaDB

`src/main/resources/application.properties` 에서 DB 접속 정보 수정 가능.

---

## 프로젝트 구조

```
src/main/java/com/colar/spring_project/
├── config/         ← CORS 등 설정
├── controller/     ← REST 컨트롤러
├── dto/            ← 데이터 전달 객체
├── mapper/         ← MyBatis 매퍼 인터페이스
└── service/
    └── impl/       ← 서비스 구현체

src/main/resources/
├── application.properties
└── mapper/         ← MyBatis XML 쿼리
```

---

## API 목록

### User

| 메서드 | URL | 설명 |
|--------|-----|------|
| POST | `/api/user/login` | 로그인 |
| POST | `/api/user/register` | 회원가입 |

---

## 연동 프론트엔드

- 위치: `C:\dev\workspace\react_project`
- React 실행 포트: `http://localhost:3000`
