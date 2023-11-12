package com.lin.core.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.core.Mapper.LinBaseMapper;
import com.lin.core.entity.Users;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService{

    @Autowired
    private LinBaseMapper linBaseMapper;

    public String test(Users u){
        LambdaQueryWrapper<Users> user = new LambdaQueryWrapper<>();
        user.eq(Users::getUsername,u.getUsername());
        return linBaseMapper.selectOne(user).toString();
    }
}
