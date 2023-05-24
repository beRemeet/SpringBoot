package com.example.springboot.entity.dto;

import lombok.Data;

/**
 * 每个版块的帖子
 */
@Data
public class CategoryPost {
    // 主题
    private String title;
    // 内容
    private String post_content;
    // 博主名字
    private String username;


}
