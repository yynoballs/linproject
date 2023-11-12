package com.lin.core.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.core.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LinBaseMapper extends BaseMapper<Users> {
}
