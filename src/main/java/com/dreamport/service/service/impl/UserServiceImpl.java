package com.dreamport.service.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dreamport.bo.UserBO;
import com.dreamport.domain.User;
import com.dreamport.service.mapper.UserMapper;
import com.dreamport.service.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 36000,
            rollbackFor = Exception.class)

    public int insert(User entity) {
        entity.setState(1);
        return userMapper.insert(entity);
    }

    @Override
    public int update(User entity) {
        return 0;
    }

    @Override
    public List<User> selectList(UserBO param) {
        Wrapper<User> wrapper = new EntityWrapper<>();
        if (StringUtils.isNotBlank(param.getRealName())) {
            wrapper.like("real_name", param.getRealName());
        }

        return userMapper.selectList(wrapper);
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
