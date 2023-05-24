package com.example.springboot.entity.dto;


import lombok.Data;

/**
 * 点入帖子查看详细
 */
@Data
public class PostDto {

    // 博主名
    private String username; // admin
    // 帖子名
    private String title;  // post

    // 帖子内容
    private String postContent;  // post

}
