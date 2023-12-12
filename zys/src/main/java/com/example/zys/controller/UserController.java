package com.example.zys.controller;
/**
 * @author zys
 * @date 2023/12/8
 * @Description
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.zys.entity.User;
import com.example.zys.mapper.UserMapper;
import com.example.zys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    // 查询所有数据
    @GetMapping("/get")
    public List<User> index(){
        return userService.list();
    }

    // 新增和修改
    @PostMapping("/insert")
    // 新增或者更新都在这个里边
    public boolean save(@RequestBody User user){
        return userService.saveUser(user);
    }

    // 删除
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

    // 批量删除
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){
        return userService.removeBatchByIds(ids);
    }

    // 分页查询
    // 接口路径：/user/page
    // @RequestParam接收 ?pageNum=1&pageSize=1
//    @GetMapping("/page")
//    public Map<String, Object> Page(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String username){
//        return userService.page(pageNum,pageSize,username);
//    }

    // 分页查询 - mybaits-plus
    @GetMapping("/page")
    public IPage<User> page(@RequestParam Integer pageNum,
                            @RequestParam Integer pageSize,
                            @RequestParam(defaultValue = "") String username,
                            @RequestParam(defaultValue = "") String nickname,
                            @RequestParam(defaultValue = "") String address){
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(!"".equals(username)){
            queryWrapper.like("username",username);
        }
        if(!"".equals(nickname)){
            queryWrapper.like("nickname",nickname);
        }
        if(!"".equals(address)){
            queryWrapper.like("address",address);
        }
        return userService.page(page,queryWrapper);
    }

}
