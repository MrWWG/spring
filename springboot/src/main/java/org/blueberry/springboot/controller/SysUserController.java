package org.blueberry.springboot.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.blueberry.springboot.common.TaotaoResult;
import org.blueberry.springboot.model.SysUser;
import org.blueberry.springboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: spring
 * @description: 用户表controller
 * @author: wind
 * @create: 2019-05-06 16:59
 **/
@RestController
@RequestMapping("/users")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @ApiOperation(value = "获取用户列表" ,notes="")
    @RequestMapping(value = "" , method = RequestMethod.GET)
    public List<SysUser> getUserList(){
       return  sysUserService.getList();
    }

    @ApiOperation(value = "创建用户" , notes = "根据用户对象创建用户")
    @ApiImplicitParam(name = "user" , value = "用户详细实体user" , required = true , dataType = "SysUser")
    @RequestMapping(value = "create" , method = RequestMethod.POST)
    public TaotaoResult createUser(@RequestBody SysUser user) {
        return sysUserService.createUser(user);
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String")
    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
    public TaotaoResult deleteUser(@PathVariable String id) throws Exception{
        throw new Exception("测试");
        //return sysUserService.deleteUser(id);
    }
}
