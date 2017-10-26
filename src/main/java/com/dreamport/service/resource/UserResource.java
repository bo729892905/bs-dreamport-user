package com.dreamport.service.resource;

import com.baomidou.mybatisplus.plugins.Page;
import com.dreamport.bo.UserBO;
import com.dreamport.domain.User;
import com.dreamport.service.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
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
    public List<User> selectList(@BeanParam UserBO param) {
        return userService.selectList(param);
    }

    @GET
    @Path("/{pageNo}")
    @ApiOperation(value = "用户管理-获取用户列表-分页", httpMethod = "GET", notes = "用户管理-获取用户列表")
    public Page<User> selectUserPage(@BeanParam UserBO param,
                                     @ApiParam(value = "页码", defaultValue = "1") @PathParam(value = "pageNo") Integer pageNo,
                                     @ApiParam(value = "每页条数", defaultValue = "10") @QueryParam("pageSize") Integer pageSize) {
        return userService.selectUserPage(new Page<User>(pageNo, pageSize), param);
    }

    @POST
    @ApiOperation(value = "用户管理-保存用户", httpMethod = "POST", notes = "用户管理-保存用户")
    public int insert(@RequestBody User user) {
        return userService.insert(user);
    }

    /*@GET
    @Path("/{id}")
    @ApiOperation(value = "用户管理-根据ID获取用户", httpMethod = "GET", notes = "用户管理-根据ID获取用户")
    public User selectById(@ApiParam(value = "用户id", defaultValue = "1") @PathParam("id") Integer id) {
        return userService.selectById(id);
    }*/

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "用户管理-删除用户", httpMethod = "DELETE", notes = "用户管理-删除用户")
    public int deleteById(@ApiParam(value = "用户id") @PathParam("id") Long id) {
        return userService.deleteById(id);
    }
}
