package com.example.springboot.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Admin {

    @TableId(type = IdType.AUTO)
    private int blogId;
    private String username;
    private String password;
    private String email;
    private String createdAt;
    // 管理员状态
    private boolean isActive;
    // 登录显示token码
    @TableField(exist = false)
    private String token;
    @TableField(exist = false)
    private String newPass;

}
