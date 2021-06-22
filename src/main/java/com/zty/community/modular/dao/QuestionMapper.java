package com.zty.community.modular.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zty.community.modular.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zty
 * @date 2021/06/09
 */
@Repository
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
    /**
     * 问题发布更新表
     * @return
     */
    @Insert("INSERT INTO community.question (title,description,create_time,modified_time,creator,tag) " +
            "VALUES(#{title},#{description},#{create_time},#{modified_time},#{creator},#{tag})")
     int create();
}
