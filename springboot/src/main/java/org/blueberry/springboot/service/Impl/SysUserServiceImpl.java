package org.blueberry.springboot.service.Impl;

import org.blueberry.springboot.common.TaotaoResult;
import org.blueberry.springboot.mapper.SysUserMapper;
import org.blueberry.springboot.model.SysUser;
import org.blueberry.springboot.model.SysUserExample;
import org.blueberry.springboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring
 * @description: 用户表Service
 * @author: wind
 * @create: 2019-05-06 16:42
 **/
@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getList() {
        SysUserExample sysUserExample = new SysUserExample();
        return sysUserMapper.selectByExample(sysUserExample);
    }

    @Override
    public TaotaoResult createUser(SysUser user) {
        sysUserMapper.insert(user);
        return new TaotaoResult();
    }

    @Override
    public TaotaoResult deleteUser(String id) {
        sysUserMapper.deleteByPrimaryKey(id);
        return new TaotaoResult();
    }

    @Override
    public TaotaoResult updateUser(SysUser user) {
        sysUserMapper.updateByPrimaryKey(user);
        return new TaotaoResult();
    }
}
