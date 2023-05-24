package com.example.springboot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.config.JsonResult;
import com.example.springboot.entity.Post;
import com.example.springboot.mapper.PostMapper;
import com.example.springboot.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {
    @Autowired
    PostMapper postMapper;
    public JsonResult addPost(Post post){
        int insert = postMapper.insert(post);
        if (insert == 0) {
            return JsonResult.error("发布失败！");
        }
        return JsonResult.success("发布成功！");
    }
}
