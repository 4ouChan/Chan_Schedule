# API 명세서

<details><summary> 필수 기능 </summary>

| 기능 | 메서드 | URL | 요청 | 응답 | 상태코드
|:---:|:---:|:---:|:---:|:---:|:---:|
|일정 생성|POST|/api/schedules|요청 body|생성된 일정|200 OK|
|전체 일정 조회|GET|/api/schedules|요청 param|전체 일정 목록|200 OK|
|선택 일정 조회|GET|/api/schedules/{id}|요청 param|선택 일정 내용|200 OK|
|일정 수정|PATCH|/api/schedules/{id}|요청 body|수정된 내용|200 OK|
|일정 삭제|DELETE|/api/schedules/{id}|요청 param| - | 200 OK|
</details>


# ERD

<details><summary> 다이어그램 </summary>
  
<img src = "https://github.com/user-attachments/assets/7438fd42-b473-490f-b7e8-eb47453cbabb" width = "1000" height = "400">
</details>
