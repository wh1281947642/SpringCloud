package cn.itcast.service.controller;

import cn.itcast.service.pojo.User;
import cn.itcast.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * <code>UserController</code>
 * </p>
 *
 * @author huiwang45@iflytek.com
 * @description
 * @date 2019/10/19 14:34
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("{id}")
    public User queryUserById(@PathVariable("id") String id) {
        User user = this.userService.queryUserById(id);
        return user;
    }

    @RequestMapping("query-list")
    public List<User> queryList() {
        return this.userService.queryList();
    }
}
