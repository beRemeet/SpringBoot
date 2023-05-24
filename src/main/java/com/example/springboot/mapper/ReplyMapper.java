package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Replies;
import com.example.springboot.entity.dto.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReplyMapper extends BaseMapper<Replies> {

    /**
     * 获取回复
     */
    @Select("select user.name,replies.reply_content,replies.timestamp from replies INNER JOIN user ON replies.user_id = user.user_id")
    List<ReplyDTO> getReply();
}
