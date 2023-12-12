package com.example.zys.service;
/**
 * @author zys
 * @date 2023/12/8
 * @Description
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zys.entity.User;
import com.example.zys.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {

    @Resource
    private UserMapper userMapper;

    public boolean saveUser(User user) {
        return saveOrUpdate(user);
    }


    // 新增、修改业务逻辑，若没有id新增，若有id修改
//    public int save(User user){
//        if(user.getId() == null){
//            return userMapper.insert(user);
//        }else {
//            return userMapper.update(user);
//        }
//    }


    // 分页业务逻辑
    // 分页查询的公式：(pageNum - 1) * pageSize
//    public Map<String,Object> page(Integer pageNum, Integer pageSize, String username){
//        pageNum = (pageNum - 1) * pageSize;
//        username = "%" + username + "%";
//        List<User> data = userMapper.Page(pageNum, pageSize, username);
//        Integer total = userMapper.selectTotal(username);
//        Map<String, Object> res = new HashMap<>();
//        res.put("data", data);
//        res.put("total", total);
//        return res;
//    }

}
