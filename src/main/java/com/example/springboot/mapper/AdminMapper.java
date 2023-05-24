package com.example.springboot.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.dto.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 获取当前登录账号资料
     */
    @Select("select user.name,user.gender,user.birthday,user.region,user.following_blog_id,admin.blog_id,admin.email,admin.created_at,admin.username " +
            "from  user " +
            " JOIN admin on admin.blog_id = user.user_id WHERE admin.blog_id = #{blog_id}")
    List<UserInfo> getInfo(@Param("blog_id") int blog_id);
}
