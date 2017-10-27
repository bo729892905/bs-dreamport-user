package com.dreamport.service.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.dreamport.bo.UserBO;
import com.dreamport.domain.User;

import java.util.List;

/**
 * Created by ren.xiaobo on 2017/7/28.
 */
public interface UserService {
    User selectById(Long id);

    int insert(User entity);

    int update(User entity);

    Page<User> selectUserPage(Page<User> page, UserBO param);

    int deleteById(Long id);
}
