package com.github.smallshine.light.user.service;

import com.github.smallshine.light.user.domain.model.User;

import java.util.List;

public interface UserService {

    public int addUser(User user);

    public int updateUser(User user);

    public int deleteUser(User user);

    public int countUser(User user);

    public List<User> getUserList(User user);

    public User getUserById(Integer id);

    public User getUser(User user);

    public void batchAddUser(List<Object[]> batchArgs);

}
