package com.buer.service;


import com.buer.entity.User;
import com.buer.entity.UserEntity;

public interface UserService {

    public User getUser(int id);

    public UserEntity getUserByName(String name);


    public int saveUser(UserEntity user);

    public void insertUser(User user);
}
