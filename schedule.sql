use schedule;

CREATE TABLE schedule (
    userId BIGINT NOT NULL COMMENT '사용자 식별자',
    userName VARCHAR(50) COMMENT '사용자 이름',
    password VARCHAR(50) COMMENT '비밀번호',
    scheduleId BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '일정 식별자',
    schedule VARCHAR(2500) COMMENT '할 일',
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성 시간',
    updateDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '수정 시간'
);
