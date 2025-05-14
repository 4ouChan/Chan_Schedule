# API 명세서

<details><summary> 필수 기능 </summary>

| 기능 | 메서드 | URL | 요청 | 응답 | 상태코드
|:---:|:---:|:---:|:---:|:---:|:---:|
|일정 생성|POST|/api/schedules|요청 body|생성된 일정|200 OK|
|전체 일정 조회|GET|/api/schedules|요청 param|전체 일정 목록|200 OK|
|선택 일정 조회|GET|/api/schedules/{scheduleId}|요청 param|선택 일정 내용|200 OK|
|일정 수정|PUT|/api/schedules/{scheduleId}|요청 body|수정된 내용|200 OK|
|일정 삭제|DELETE|/api/schedules/{scheduleId}|요청 param|전체 일정 목록| 200 OK|

<p>일정 생성 시 비밀번호를 입력받아 DB에 저장합니다.</p>
<p>수정 및 삭제 시 반드시 알맞은 비밀번호를 입력해야 기능이 정상작동 합니다.</p>
<p>일정 생성 시 생성한 일정의 식별자, 유저명, 스케줄, 생성 날짜, 수정 날짜를 표기합니다. (비밀번호는 null로 표기됩니다.)</p>
<p>전체 일정 조회 시 리스트형태로 표기됩니다. (생성 기능의 표기와 동일하게 표기합니다.)</p>
<p>선택 일정 조회 시 조회할 Schedule의 Id를 URL에 입력해야 합니다. (생성 기능의 표기와 동일하게 표기합니다.)</p>
<p>일정 수정은 유저명과 스케줄만 수정 가능합니다. 사용 시 수정할 Schedule의 Id를 URL에 입력해야 합니다. 수정 후 표기될 때 updateDate는 현재 시간으로 표기됩니다.</p>
<p>일정 삭제 시 삭제할 Schedule의 Id를 URL에 입력해야 합니다. 삭제 후 삭제 결과가 반영된 전체 일정 목록을 리스트 형태로 표기합니다.</p>
</details>



# ERD

<details><summary> 다이어그램 </summary>
  
<img src = "https://github.com/user-attachments/assets/81dfa3b8-96ec-400b-9e6b-6f4a1cfaa94b" width = "1000" height = "400">
</details>

# 구현 중 문제사항

처음 설계했던 구조는 Entity를 User와 Schedule 두 개로 만들고 User테이블의 userId를 외래키로 Schedule 테이블에 넣어 사용하는 것 이었습니다.

구현 중 몇몇 트러블이 발생해 해당 내용을 블로그에 작성했습니다. [트러블 내용](https://velog.io/@4ou_chan/Spring-%EC%9D%BC%EC%A0%95-%EA%B4%80%EB%A6%AC-%EC%95%B1-%EB%A7%8C%EB%93%A4%EA%B8%B0-%EA%B5%AC%ED%98%84-%EC%A4%91-%EB%AC%B8%EC%A0%9C%EC%A0%90)
작성 이후에도 지속적으로 트러블이 발생했으나, 원인 파악 이 어려워 구조를 단순화시키면 좀 더 쉽게 다가갈 수 있을거라 생각해 전부 엎고, 다시 작성하여, 지금의 구조가 되었습니다. 

<p>일정 수정 부분에서도 지속적으로 트러블이 발생했는데, 처음 구상했던 바로는 PACTH를 사용해서 유저 명, 스케줄을 각각 따로 수정하게끔 의도했었으나, 트러블 원인 파악이 어려워 그냥 PUT을 사용하였습니다.</p>

3계층 구조를 왜 사용하고, 어느 흐름으로 이어지는지도 이해했으나, 그 흐름을 내가 원하는 형태로 가공하는것에서 많이 애먹었습니다.
