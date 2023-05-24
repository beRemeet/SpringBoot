package com.example.springboot.entity;

import lombok.Data;

@Data
public class Replies {

    private int id;
    private int postId;
    private int userId;
    private String replyContent;
    private String timestamp;
}
