package org.blueberry.springboot.service;

import org.blueberry.springboot.common.TaotaoResult;
import org.blueberry.springboot.model.SysUser;

import java.util.List;

/**
 * @program: spring
 * @description: 用户表Service
 * @author: wind
 * @create: 2019-05-06 16:43
 **/
public interface SysUserService {

    /**
     * 查询用户列表
     * @return
     */
    public List<SysUser> getList();

    /**
     * @param user
     */
    public TaotaoResult createUser(SysUser user);

    /**
     * @param id
     */
    public TaotaoResult deleteUser(String id);

    /**
     * @param user
     */
    public TaotaoResult updateUser(SysUser user);
}
