package com.example.springboot.entity.dto;

import lombok.Data;

/**
 * 用于前端显示的数据
 */
@Data
public class LoginDTO {
    private int blogId;
    private String username;
    private String token;
}
