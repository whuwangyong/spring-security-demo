package cn.whu.wy.usermanager.service;

import cn.whu.wy.usermanager.dto.Result;
import cn.whu.wy.usermanager.entity.User;
import cn.whu.wy.usermanager.mapper.IUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    private IUserMapper userMapper;

    public User queryUserByName(String name) {
        return userMapper.selectByName(name);
    }

    public Result update(User user) {
        Result result = Result.failure();
        try {
            if (userMapper.updateByPrimaryKeySelective(user) == 1)
                result = Result.success();
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            log.error("update user ex:", e);
        }
        return result;
    }

    public List<User> getAllUsers(){
        return userMapper.selectAll();
    }
}
