package com.example.springboot.controller;


import com.example.springboot.config.JsonResult;
import com.example.springboot.entity.User;
import com.example.springboot.entity.dto.FlowingBlog;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;
    @Autowired
    UserMapper userMapper;

    /**
     * 此功能不用于博客项目中
     * @return
     */
    @ApiOperation(value = "用户列表 已完成")
    @GetMapping("/list")
    public JsonResult list() {
        List<User> list = userService.list();
        return JsonResult.success(list);
    }

    /**
     * 登陆时在前台需要把博主的id储存 用来查询关注用户  后续添加按关注时间排序
     * @param blog_id
     * @return
     */
    @ApiOperation(value = "获取当前登录博主的关注用户   已完成")
    @GetMapping("/followingList")
    public JsonResult followingList(@RequestParam int blog_id) {
        List<FlowingBlog> list = userMapper.getFlowingBlog(blog_id);
        return JsonResult.success(list);
    }

    /**
     * 前台需要把用户ID储存
     * @param id
     * @return
     */
    @ApiOperation(value = "点击关注人员进入主页查看信息  已完成")
    @GetMapping("/followingInfo")
    public JsonResult followingInfo(@RequestParam int id) { // 传递此用户ID
        List<User> byUserIdUsers = userMapper.getByUserIdUsers(id);
        return JsonResult.success(byUserIdUsers);
    }

    @ApiOperation(value = "删除关注人员 注意 : 是改变该用户关注的信息  并非是删除用户  已完成")
    @PutMapping("/delUser/{id}")
    public JsonResult delUser(@PathVariable int id) {  //根据ID修改信息
        userMapper.delFlowingBlog(id);
        return JsonResult.success("移除成功");
    }
}
