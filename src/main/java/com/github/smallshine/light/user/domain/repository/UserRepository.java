package com.github.smallshine.light.user.domain.repository;

import com.github.smallshine.light.user.domain.model.User;

import java.util.List;

public interface UserRepository {

    int addUer(User user);

    int update(User user);

    int delete(User user);

    int count(User user);

    List<User> getList(User user);

    User getUserById(Integer id);

    User getUser(User user);

    void batchAddUser(List<Object[]> batchArgs);
}