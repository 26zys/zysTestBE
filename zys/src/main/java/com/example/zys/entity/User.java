package com.example.zys.entity;
/**
 * @author zys
 * @date 2023/12/8
 * @Description
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//创建无参构造
@NoArgsConstructor
//创建有参构造
@AllArgsConstructor
@TableName(value = "sys_user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    // 忽略某个不展示的字段，在标准的出入对象中（dto，vo）可以用
    @JsonIgnore
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;

    @TableField(value = "avatar_url")  //指定数据库字段名
    private String avatar;

}
