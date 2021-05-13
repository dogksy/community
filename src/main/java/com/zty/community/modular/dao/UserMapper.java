package com.zty.community.modular.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zty.community.modular.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author dogsky
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 注册用户信息
     * @return
     * @param user
     */
    Integer addUserInfo(User user);
}