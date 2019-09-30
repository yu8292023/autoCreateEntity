package com.buer.dao;

import com.buer.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseDao {
    public User getUser(int id);

    public void insertUser(User user);
}
