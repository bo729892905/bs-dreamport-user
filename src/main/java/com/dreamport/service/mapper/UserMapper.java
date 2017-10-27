package com.dreamport.service.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.dreamport.bo.UserBO;
import com.dreamport.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ren.xiaobo on 2017/7/28.
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * <p>
     * 查询 : 查询用户列表，分页显示
     * </p>
     *
     * @param page  翻页对象，可以作为 xml 参数直接使用，传递参数 Page 即自动分页
     * @param param 查询实体类
     * @return
     */
    List<User> selectUserList(Pagination page, UserBO param);
}
