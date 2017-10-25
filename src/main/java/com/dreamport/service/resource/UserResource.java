package com.dreamport.service.resource;

import com.dreamport.bo.UserBO;
import com.dreamport.domain.User;
import com.dreamport.service.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by ren.xiaobo on 2017/7/28.
 */
@Component
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "users", description = "用户接口", produces = MediaType.APPLICATION_JSON)
public class UserResource {
    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }


    @GET
    @ApiOperation(value = "用户管理-获取用户列表", httpMethod = "GET", notes = "用户管理-获取用户列表")
    public PageInfo list(@BeanParam UserBO param) {
        PageHelper.startPage(1, 10);
        List<User> userList = userService.list(param);
        return new PageInfo(userList);
    }

    @POST
    @ApiOperation(value = "用户管理-保存用户", httpMethod = "POST", notes = "用户管理-保存用户")
    public int insert(@RequestBody User user) {
        return userService.insert(user);
    }
}
