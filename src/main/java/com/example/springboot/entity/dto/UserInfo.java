package com.example.springboot.entity.dto;

import lombok.Data;

@Data
public class UserInfo {
    private String username;
    private String name;
    private String gender;
    private String birthday;
    private String region;
    private String followingBlogId;
    private String email;
    private String createdAt;
    private int blogId;
}
