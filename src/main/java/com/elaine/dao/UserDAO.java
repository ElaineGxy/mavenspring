package com.elaine.dao;

import com.elaine.entity.UserEntity;

import java.util.List;

public interface UserDAO {
    public UserEntity login(String username, String password);

    public Integer save(UserEntity user);

    public void update(UserEntity user);

    public boolean validatePassword(Integer id, String password);

    public void updatePassword(Integer id, String password);

    public boolean validateUser(String userName,String password);

    public List<UserEntity> getAllUser();
}
