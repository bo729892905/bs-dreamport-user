package com.dreamport.service.service.impl;

import com.dreamport.bo.UserBO;
import com.dreamport.domain.User;
import com.dreamport.service.mapper.UserMapper;
import com.dreamport.service.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ren.xiaobo on 2017/7/28.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 36000,
            rollbackFor = Exception.class)
    public int insert(User entity) {
        return userMapper.insert(entity);
    }

    @Override
    public List<User> list(UserBO parma) {
        return userMapper.list(parma);
    }
}
