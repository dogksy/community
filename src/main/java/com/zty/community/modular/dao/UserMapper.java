package com.zty.community.modular.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zty.community.modular.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dogsky
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("SELEECT * FROM `user`")
    List<Map<String, Object>> selectMaps();


    /**
     * 狗天论坛登录验证
     * @param token
     * @return
     */
    @Select("SELECT account_id,`name`,token,gmt_create,gmt_modified FROM `user` where token=#{token}")
    User findByToken(@Param(value = "token") String token);
}