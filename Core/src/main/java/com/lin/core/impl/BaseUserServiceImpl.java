package com.lin.core.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.core.Mapper.LinBaseMapper;
import com.lin.core.entity.Users;
import com.lin.core.service.BaseUserService;
import org.springframework.stereotype.Service;

@Service
public class BaseUserServiceImpl extends ServiceImpl<LinBaseMapper, Users> implements BaseUserService {
}
