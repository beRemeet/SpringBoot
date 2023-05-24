package com.example.springboot.entity.dto;


import lombok.Data;

@Data
public class ReplyDTO {
    // 用户名
    private String name;  //user

    // 帖子回复
    private String replyContent;  // reply
    // 回复时间
    private String timestamp;  // reply

}
