package com.example.springboot.entity.dto;


import lombok.Data;

/**
 * 关注列表只显示名字和ID
 */
@Data
public class FlowingBlog {
    private int userId;
    private String name;
}
