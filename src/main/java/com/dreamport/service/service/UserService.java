package com.dreamport.service.service;

import com.dreamport.bo.UserBO;
import com.dreamport.domain.User;

import java.util.List;

/**
 * Created by ren.xiaobo on 2017/7/28.
 */
public interface UserService {
    int insert(User entity);

    List<User> list(UserBO param);
}
