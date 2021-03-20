package com.ywst.spring.boot.entity;

import lombok.Data;

@Data
public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String role;
}
