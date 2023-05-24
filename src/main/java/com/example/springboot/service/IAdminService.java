package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.config.JsonResult;
import com.example.springboot.entity.Admin;



public interface IAdminService extends IService<Admin> {
    JsonResult login(Admin admin);
    JsonResult add(Admin admin);
    JsonResult changePass(Admin admin);

}
