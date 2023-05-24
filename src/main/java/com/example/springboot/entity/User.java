package com.example.springboot.entity;


import lombok.Data;


@Data
public class User {

    private int userId;
    private String name;
    private String gender;
    private String birthday;
    private String email;
    private String region;

    // 关注博主的id
    private int followingBlogId;

}
