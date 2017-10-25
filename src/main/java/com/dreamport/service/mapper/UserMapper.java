package com.dreamport.service.mapper;

import com.dreamport.bo.UserBO;
import com.dreamport.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ren.xiaobo on 2017/7/28.
 */
@Repository
public interface UserMapper {
    /**
     * 新建用户
     *
     * @param user
     * @return
     */
    int insert(User user);

    List<User> list(UserBO param);
}
