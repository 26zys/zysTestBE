package com.example.zys.mapper;
/**
 * @author zys
 * @date 2023/12/8
 * @Description
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.zys.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM sys_user")
    List<User> findAll();

    @Insert("INSERT INTO sys_user(username,password,nickname,email,phone,address) VALUES (#{username},#{password},#{nickname},#{email},#{phone},#{address})")
    int insert(User user);

    int update(User user);

    @Delete("DELETE FROM sys_user WHERE id = #{id}")
        // @Param中的参数要和sql语句中#{}占位字符的名字要一样
    Integer deleteById(@Param("id") Integer id);

    // 分页查询
    // 并且包含模糊查询的接口
    @Select("SELECT * FROM sys_user WHERE username LIKE '%' #{username} '%' LIMIT #{pageNum}, #{pageSize}")
    List<User> Page(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,@Param("username") String username);

    // 查询表中总条数
    @Select("SELECT COUNT(*) FROM sys_user WHERE username LIKE CONCAT('%',#{username},'%')")
    Integer selectTotal(String username);

}
