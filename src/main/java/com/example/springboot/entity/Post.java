package com.example.springboot.entity;

import lombok.Data;

@Data
public class Post {

    private int postId;
    private String title;
    private String postContent;
    private int topicId;
}
