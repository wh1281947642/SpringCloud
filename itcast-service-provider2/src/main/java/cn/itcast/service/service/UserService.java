package cn.itcast.service.service;

import cn.itcast.service.mapper.UserMapper;
import cn.itcast.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * <code>UserService</code>
 * </p>
 *
 * @author huiwang45@iflytek.com
 * @description
 * @date 2019/10/19 14:30
 */

@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;

    public User queryUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> queryList() {
        return this.userMapper.selectAll();
    }
}


