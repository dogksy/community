package com.zty.community.modular.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zty
 * @date 2021/06/09
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("Question")
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Date createTime;
    private Date modified_time;
    private Integer creator;
    private Integer comment_count;
    private Integer view_count;
    private Integer like_count;
    private String tag;
}
