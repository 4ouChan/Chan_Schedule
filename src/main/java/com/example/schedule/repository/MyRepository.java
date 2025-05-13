package com.example.schedule.repository;

import com.example.schedule.dto.ResponseDto;
import com.example.schedule.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
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

    private RowMapper<ResponseDto> rowMapper() {

        return new RowMapper<ResponseDto>() {
            @Override
            public ResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ResponseDto(
                        rs.getLong("userId"),
                        rs.getString("userName"),
                        rs.getLong("scheduleId"),
                        rs.getString("schedule"),
                        rs.getTimestamp("createDate").toLocalDateTime(),
                        rs.getTimestamp("updateDate").toLocalDateTime()
                );
            }
        };
    }


    public ResponseDto createSchedule(Schedule schedule) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("scheduleId");


        Map<String, Object> cheduleData = new HashMap<>();
        cheduleData.put("userId", schedule.getUserId());
        cheduleData.put("userName", schedule.getUserName());
        cheduleData.put("password", schedule.getPassword());
        cheduleData.put("scheduleId", schedule.getScheduleId());
        cheduleData.put("schedule", schedule.getSchedule());
        cheduleData.put("createDate", schedule.getCreateDate());
        cheduleData.put("updateDate", schedule.getUpdateDate());

        // 저장 후 생성된 key값을 Number 타입으로 반환하는 메서드
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(cheduleData));


        return new ResponseDto(key.longValue(), schedule.getUserName(), key.longValue(), schedule.getSchedule(), schedule.getCreateDate(), schedule.getUpdateDate());
    }

    public List<ResponseDto> scheduleList() {
        return jdbcTemplate.query("select userId, userName, scheduleId, schedule, createDate, updateDate from schedule", rowMapper());
    }

}
