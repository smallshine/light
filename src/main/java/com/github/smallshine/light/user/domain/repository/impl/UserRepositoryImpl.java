package com.github.smallshine.light.user.domain.repository.impl;

import com.github.smallshine.light.user.domain.repository.UserRepository;
import com.github.smallshine.light.user.domain.model.User;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Users表数据访问
 * @author jarry
 * @date 2023-5-20
 */

@Repository("UserRepository")
public class UserRepositoryImpl implements UserRepository {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int addUer(User user) {
        String sql = "INSERT into `users` (name, email, phone, status) VALUES(:name, :email, :phone, :status);";
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("name", user.getName());
        source.addValue("email", user.getEmail());
        source.addValue("phone", user.getPhone());
        source.addValue("status", user.getStatus());
        int update = namedParameterJdbcTemplate.update(sql, source);
        return update;
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE `users` SET status=? WHERE user_name=?;";
        return jdbcTemplate.update(sql, user.getStatus(), user.getName());
    }

    @Override
    public int delete(User user) {
        String sql = "DELETE FROM `users` where user_name=?;";
        return jdbcTemplate.update(sql, user.getName());
    }

    @Override
    public int count(User user) {
        String sql = "SELECT COUNT(*) FROM `users` where `status`=?;";
        return jdbcTemplate.queryForObject(sql, Integer.class, user.getStatus());
    }

    @Override
    public List<User> getList(User user) {
        String sql = "SELECT * FROM `users` where `status`=? limit 50;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), user.getStatus());
    }

    @Override
    public User getUserById(Integer id) {
        String sql = "SELECT * FROM `users` where `id` = :id;";
        User user = new User();
        user.setId(id);
        SqlParameterSource source = new BeanPropertySqlParameterSource(user);
        return namedParameterJdbcTemplate.queryForObject(sql, source, new BeanPropertyRowMapper<User>(User.class));
    }


    @Override
    public User getUser(User user) {
        String sql = "SELECT * FROM `users` where `user_id`=?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getId());
    }

    @Override
    public void batchAddUser(List<Object[]> args) {
        String sql = "INSERT into `users` (`users`.user_name,`users`.`status`) VALUES(?,?);";
        jdbcTemplate.batchUpdate(sql, args);
    }
}