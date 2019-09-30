package com.buer.service.impl;

import com.buer.dao.UserDao;
import com.buer.entity.User;
import com.buer.entity.UserEntity;
import com.buer.service.UserService;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(int id) {
        logger.debug("查询用户");
        User user = userDao.getUser(id);
        return user;
    }

    @Override
    public UserEntity getUserByName(String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("张三");
        userEntity.setPassword("1234");
        return userEntity;
    }

    @Override
    @RequiresRoles(value={"admin","user"})
//    @RequiresPermissions(value={"add","update"},logical = Logical.AND)
    public int saveUser(UserEntity user) {
//        Subject subject= SecurityUtils.getSubject();
//        boolean admin = subject.isPermitted("admin");
        try {
//            subject.checkPermissions("add","update");
        }catch (UnauthorizedException e){
            //TODO 定义错误处理页面
            //未授权
            e.printStackTrace();
        } /*catch (UnauthenticatedException e) {
            //TODO 定义错误处理页面
            //未认证
            e.printStackTrace();
        }*/
        return 1;
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
