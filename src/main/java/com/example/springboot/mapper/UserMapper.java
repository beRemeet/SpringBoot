package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.User;
import com.example.springboot.entity.dto.FlowingBlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {


    /**
     * 用来查询登录博主的关注人员
     * @param blog_id
     * @return
     */
    @Select("SELECT user.name,user.user_id FROM admin INNER JOIN  user ON admin.blog_id =user.following_blog_id " +
            "where admin.blog_id = #{blog_id}")
    List<FlowingBlog> getFlowingBlog(@Param("blog_id") int blog_id);

    /**
     * 取消用户对博主的关注
     */
    @Update("UPDATE user SET following_blog_id = null WHERE user_id = #{id};")
    boolean delFlowingBlog(@Param("id") int id);


    @Select("select * from user where user_id = #{id}")
    List<User> getByUserIdUsers(@Param("id") int id);
}
