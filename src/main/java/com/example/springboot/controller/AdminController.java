package com.example.springboot.controller;

import com.example.springboot.config.JsonResult;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.dto.UserInfo;
import com.example.springboot.mapper.AdminMapper;
import com.example.springboot.mapper.PostMapper;
import com.example.springboot.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IAdminService adminService;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    PostMapper postMapper;

    @ApiOperation(value = "登录验证/存在token  建议前往postman测试 已完成")
    @PostMapping("/login")
    public JsonResult login(@RequestBody Admin admin) {
        return adminService.login(admin);
    }


    @ApiOperation(value = "注册登录 已完成")
    @PostMapping("/register")
    public JsonResult register(@RequestBody Admin admin) {
        return adminService.add(admin);
    }



    @ApiOperation(value = "修改普通信息 已完成")
    @PutMapping("/changeInfo")
    public JsonResult changeInfo(@RequestBody Admin admin) {
        adminService.updateById(admin);
        return JsonResult.success();
    }


    @ApiOperation(value = "修改密码 已完成")
    @PutMapping("/changePwd")
    public JsonResult changePwd(@RequestBody Admin admin) {
       return adminService.changePass(admin);
    }


    /**
     * 通过外键约束改变关注的值
     * @param blogId
     * @return
     */
    @ApiOperation(value = "注销  注意注销时需要把关注此账号的字段全部修改 需要发布的帖子也要删除  已完成")
    @DeleteMapping("/delBlog/{blogId}")
    public JsonResult delBlog(@PathVariable int blogId) {
        boolean del = postMapper.delByBlogId(blogId);
        boolean removeById = adminService.removeById(blogId);
        if (removeById == false) {
            return JsonResult.error("删除失败");
        }
        return JsonResult.success();
    }

    /**
     * 获取当前登录账号信息
     */
    @ApiOperation(value = "获取当前登录账号信息")
    @GetMapping("/getInfo")
    public JsonResult getInfo(@RequestParam int blogId){
        List<UserInfo> info = adminMapper.getInfo(blogId);
        System.out.println(info);
        return JsonResult.success(info);
    }
}
