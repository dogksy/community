package com.zty.community.modular.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zty
 * @date 2021/06/09
 */
@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("question")
public class Question implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private Date createTime;
    private Date modifiedTime;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private String language;
}
