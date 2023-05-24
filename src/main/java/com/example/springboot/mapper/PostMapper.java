package com.example.springboot.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Post;
import com.example.springboot.entity.dto.PostDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper extends BaseMapper<Post> {

    @Delete("delete from post where blog_id = #{id}")
    boolean delByBlogId(@Param("id") int id);

    /**
     * 根据博主ID获取帖子
     * @return
     */
    @Select("select admin.username,post.title,post.post_content from post  JOIN admin ON   admin.blog_id  =  post.blog_id  " +
            "where post.blog_id = #{blog_id};")
    List<PostDto> getPostDetail(@Param("blog_id") int blog_id);

    /**
     * 根据博主ID增加帖子
     * @return
     */
    @Insert("INSERT INTO post  ( post_id,blog_id, title, post_content, topic_id ) " +
            " VALUES  (#{post_id},#{blog_id},#{title},#{post_content},#{topic_id})")
    boolean addPost(@Param("post_id") int post_id,@Param("blog_id") int blog_id,@Param("title") String title,@Param("post_content") String post_content,@Param("topic_id") int topic_id);

    /**
     * 根据分类获取该模块的帖子
     */
    @Select("SELECT post_id,title,post_content,topic_id FROM post where topic_id = #{topic_id}")
    List<Post> getPost(@Param("topic_id") int topic_id);

}
