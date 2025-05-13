package com.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class User {

    // 속성
    private long userId;
    private String userName;
    private String password;

    // 생성자
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // 기능

}
