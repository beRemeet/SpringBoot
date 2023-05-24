package com.example.springboot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.entity.Replies;
import com.example.springboot.mapper.ReplyMapper;
import com.example.springboot.service.IReplyService;
import org.springframework.stereotype.Service;


@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Replies> implements IReplyService {
}
