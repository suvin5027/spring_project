---
티켓: user-auth
제목: 회원 로그인/회원가입 API (MyBatis + MariaDB)
상태: 진행 중
시작일: 2026/05/07
---

## 개요
Spring Boot + MyBatis + MariaDB 기반으로 회원 로그인/회원가입 REST API 구현.
React(3000) ↔ Spring(8080) 연동 목적.

## 완성된 파일

| 파일 | 경로 | 비고 |
|------|------|------|
| `UserDTO.java` | `dto/UserDTO.java` | ⚠️ `userSEq` 오타 → `userSeq` 수정 필요 |
| `UserMapper.java` | `mapper/UserMapper.java` | login / register / findByUserId |
| `UserService.java` | `service/UserService.java` | 인터페이스 |
| `UserServiceImpl.java` | `service/impl/UserServiceImpl.java` | |
| `UserController.java` | `controller/UserController.java` | POST /api/user/login, POST /api/user/register |
| `CorsConfig.java` | `config/CorsConfig.java` | React 3000 허용 |
| `application.properties` | `resources/application.properties` | MariaDB react_project DB, MyBatis 설정 |

## 남은 작업

- [ ] `UserDTO.java` — `userSEq` → `userSeq` 오타 수정
- [ ] `src/main/resources/mapper/UserMapper.xml` 생성 (login / register / findByUserId 쿼리)
- [ ] 서버 실행 후 API 테스트 (Postman 등)

## DB 정보
- DB: `react_project` (MariaDB, localhost:3306)
- 테이블: `TB_USER`
- 컬럼: `USER_SEQ`, `USER_ID`, `USER_NAME`, `NICKNAME`, `PASSWORD`, `USER_ROLE`

## API 엔드포인트
| 메서드 | URL | 설명 |
|--------|-----|------|
| POST | `/api/user/login` | 로그인 (userId + password 매칭, 성공 시 UserDTO 반환) |
| POST | `/api/user/register` | 회원가입 (USER_ROLE은 'USER'로 고정) |

## 다음 예정 작업
- JWT 토큰 발급 / 세션 관리 (미정)
- 게시판 관련 API (Board CRUD)
