package com.buer.service.impl;

import com.buer.entity.UserEntity;
import com.buer.dao.UserDao;
import com.buer.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *
 * @author 于海宁
 * @since 2019-10-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

}
