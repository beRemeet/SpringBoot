package com.example.springboot.service.Impl;


import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.config.JsonResult;
import com.example.springboot.config.TokenUtils;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.dto.LoginDTO;
import com.example.springboot.mapper.AdminMapper;
import com.example.springboot.service.IAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Admin的实现类
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {


    @Autowired
    private AdminMapper adminMapper;

    @Override
    public JsonResult login(Admin admin) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("username", admin.getUsername());
        Admin user = adminMapper.selectOne(qw);
        /**
         * 判断用户是否存在
         */
        if (user == null) {
            return JsonResult.error("用户名或者密码错误");
        }
        /**
         * 判断密码是否正确
         */
        String securePass = securePass(admin.getPassword());
        if (!securePass.equals(user.getPassword())) {
            return JsonResult.error("用户名或者密码错误");
        }
        // 创建dto层传输数据到前端
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(user, loginDTO);
        // 生成token
        String token = TokenUtils.genToken(String.valueOf(admin.getBlogId()), admin.getPassword());
        loginDTO.setToken(token);
        return JsonResult.success(loginDTO);
    }

    /**
     * 密码加密处理
     */
    private String securePass(String password) {
        return SecureUtil.md5(password);
    }


    /**
     * 增加用户
     * @param admin
     * @return
     */
    @Override
    public JsonResult add(Admin admin) {
        // 先查询是否存在该用户
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",admin.getUsername());
        Admin username = adminMapper.selectOne(queryWrapper);
        if (username != null){
            return JsonResult.error("该用户已存在");
        }
        // 登录状态默认为true  前台按钮直接禁用即可
        admin.setActive(true);
        int insert = adminMapper.insert(admin);
        if (insert <= 0){
            return JsonResult.error("添加失败");
        }
        return JsonResult.success("添加成功");
    }

    /**
     * 修改密码
     * @param admin
     * @return
     */
    @Override
    public JsonResult changePass(Admin admin) {
        admin.setPassword(securePass(admin.getNewPass()));
        int count = adminMapper.updateById(admin);
        if (count <= 0) {
            return JsonResult.error("修改密码失败");
        }
        return JsonResult.success("修改密码成功");
    }

}
