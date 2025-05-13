package com.example.schedule.repository;

import com.example.schedule.dto.ResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MyRepository {

    // 속성
    private final JdbcTemplate jdbcTemplate;

    public MyRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 생성자

    // 기능
    public ResponseDto createSchedule(User user, Schedule schedule) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("user").usingGeneratedKeyColumns("id");

        Map<String, Object> cheduleData = new HashMap<>();
        cheduleData.put("userId", user.getUserId());
        cheduleData.put("userName", user.getUserName());
        cheduleData.put("scheduleId", schedule.getScheduleId());
        cheduleData.put("schedule", schedule.getSchedule());

        // 저장 후 생성된 key값을 Number 타입으로 반환하는 메서드
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(cheduleData));


        return new ResponseDto(key.longValue(), user.getUserName(), key.longValue(), schedule.getSchedule());
    }
}
// 일정 생성 기능