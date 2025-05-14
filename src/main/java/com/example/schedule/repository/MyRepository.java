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

    private Map<String, Object> scheduleData = new HashMap<>();

    // 생성자


    // 기능
    private RowMapper<ResponseDto> rowMapper() {
        return new RowMapper<ResponseDto>() {
            @Override
            public ResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ResponseDto(
                        rs.getLong("scheduleId"),
                        rs.getString("userName"),
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

        scheduleData.put("userName", schedule.getUserName());
        scheduleData.put("password", schedule.getPassword());
        scheduleData.put("schedule", schedule.getSchedule());
        scheduleData.put("createDate", schedule.getCreateDate());
        scheduleData.put("updateDate", schedule.getUpdateDate());

        // 저장 후 생성된 key값을 Number 타입으로 반환하는 메서드
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(scheduleData));


        return new ResponseDto(key.longValue(), schedule.getUserName(), schedule.getSchedule(), schedule.getCreateDate(), schedule.getUpdateDate());
    }

    public List<ResponseDto> scheduleList() {
        String sql = "SELECT scheduleId, userName, schedule, createDate, updateDate FROM schedule";
        return jdbcTemplate.query(sql, rowMapper());
    }

    public ResponseDto getSchedule(long id) {
        String sql = "SELECT scheduleId, userName, schedule, createDate, updateDate FROM schedule WHERE scheduleId = ?";

        return jdbcTemplate.queryForObject(sql, rowMapper(), id);
    }

    public int updateSchedule(long id, String userName, String schedule, String password, LocalDateTime updateDate) {
        String sql = "UPDATE schedule SET userName = ?, schedule = ?, updateDate = ? WHERE scheduleid = ? AND password = ?";

        scheduleData.put("updateDate", updateDate);

        return jdbcTemplate.update(sql, userName, schedule, updateDate, id, password);
    }

    public int deleteSchedule(long id) {

        String sql = "DELETE FROM schedule WHERE scheduleid = ?";

        return jdbcTemplate.update(sql, id);
    }
}
