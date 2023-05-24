package com.example.springboot.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.config.JsonResult;
import com.example.springboot.entity.Post;

public interface IPostService extends IService<Post> {
    JsonResult addPost(Post post);
}
