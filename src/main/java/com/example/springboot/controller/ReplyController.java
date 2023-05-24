package com.example.springboot.controller;


import com.example.springboot.config.JsonResult;
import com.example.springboot.entity.Replies;
import com.example.springboot.entity.dto.ReplyDTO;
import com.example.springboot.mapper.ReplyMapper;
import com.example.springboot.service.IReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    IReplyService replyService;

    @Autowired
   ReplyMapper replyMapper;
    @ApiOperation(value = "回复列表  已完成")
    @GetMapping("/list")
    public JsonResult list() {
        List<Replies> list = replyService.list();
        return JsonResult.success(list);
    }

    @ApiOperation(value = "回复详情   已完成")
    @GetMapping("/replyList")
    public JsonResult replyList() {
        List<ReplyDTO> reply = replyMapper.getReply();
        return JsonResult.success(reply);
    }
}
