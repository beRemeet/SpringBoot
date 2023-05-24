package com.example.springboot.controller;

import com.example.springboot.config.JsonResult;
import com.example.springboot.entity.Post;
import com.example.springboot.entity.dto.PostDto;
import com.example.springboot.mapper.PostMapper;
import com.example.springboot.service.IPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    IPostService postService;
    @Autowired
    PostMapper postMapper;

    @ApiOperation(value = "帖子的获取根据分类ID和博主ID")
    @GetMapping("/list")
    public JsonResult list() {
        List<Post> list = postService.list();
        return JsonResult.success(list);
    }

    @ApiOperation(value = "根据博主ID获取帖子")
    @GetMapping("/detail")
    public JsonResult detail(@RequestParam int blog_id) {
        List<PostDto> postDetail = postMapper.getPostDetail(blog_id);
        return JsonResult.success(postDetail);
    }

    @ApiOperation(value = "根据分类ID获取帖子")
    @GetMapping("/getPost")
    public JsonResult getPost(@RequestParam int topic_id) {
        List post = postMapper.getPost(topic_id);
        return JsonResult.success(post);
    }


    @ApiOperation(value = "发帖子  根据博主ID  完成")
    @PostMapping("/addPost")
    public JsonResult addPost(@RequestParam int post_id,int blog_id ,String title,String post_content,int topic_id) {
        boolean b = postMapper.addPost(post_id, blog_id, title, post_content, topic_id);
        if (b==false) {
            return JsonResult.error("发布失败！");
        }
        return JsonResult.success("发布成功！");
    }

}
