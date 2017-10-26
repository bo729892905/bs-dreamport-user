package com.dreamport.service.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dreamport.bo.UserBO;
import com.dreamport.domain.User;
import com.dreamport.service.mapper.UserMapper;
import com.dreamport.service.service.UserService;
import org.apache.commons.lang.StringUtils;
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
    public List<User> selectList(UserBO param) {
        Wrapper<User> wrapper=new EntityWrapper<>();
        if (StringUtils.isNotBlank(param.getRealName())) {
            wrapper.like("real_name",param.getRealName());
        }

        return userMapper.selectList(wrapper);
    }

    @Override
    public Page<User> selectUserPage(Page<User> page, UserBO param) {
        page.setRecords(userMapper.selectUserList(page, param));
        return page;
    }
}
