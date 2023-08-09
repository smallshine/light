package com.github.smallshine.light.user.service.impl;

import com.github.smallshine.light.user.domain.model.User;
import com.github.smallshine.light.user.domain.repository.UserRepository;
import com.github.smallshine.light.user.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user数据处理
 * @author jarry
 * @date 2023-5-20
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public int addUser(User user) {
        return userRepository.addUer(user);
    }

    @Override
    public int updateUser(User user) {
        return userRepository.update(user);
    }

    @Override
    public int deleteUser(User user) {
        return userRepository.delete(user);
    }

    @Override
    public int countUser(User user) {
        return userRepository.count(user);
    }

    @Override
    public List<User> getUserList(User user) {
        return userRepository.getList(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUser(User user) {
        return userRepository.getUser(user);
    }

    @Override
    public void batchAddUser(List<Object[]> batchArgs) {
        userRepository.batchAddUser(batchArgs);
    }
}
