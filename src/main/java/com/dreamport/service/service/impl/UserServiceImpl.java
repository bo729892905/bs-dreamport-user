package com.dreamport.service.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.dreamport.bo.UserBO;
import com.dreamport.common.StateEnum;
import com.dreamport.domain.User;
import com.dreamport.service.mapper.UserMapper;
import com.dreamport.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by ren.xiaobo on 2017/7/28.
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User selectById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 36000,
            rollbackFor = Exception.class)

    public int insert(User entity) {
        entity.setState(StateEnum.VALID.value());
        entity.setCreateDate(new Date());
        int result = userMapper.insert(entity);
        if (result > 0) result = entity.getId().intValue();
        return result;
    }

    @Override
    public int update(User entity) {
        entity.setState(StateEnum.VALID.value());
        return userMapper.updateById(entity);
    }

    @Override
    public Page<User> selectUserPage(Page<User> page, UserBO param) {
        page.setRecords(userMapper.selectUserList(page, param));
        return page;
    }

    @Override
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }
}
