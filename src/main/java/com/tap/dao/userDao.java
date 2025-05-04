package com.tap.dao;

import java.util.List;

import com.tap.model.User;

public interface userDao {
        void addUser(User user);
        void updateUser(User user);
        void deleteUser(int userId); 
        User getUserById (int id);
        List<User> getAllUsers();  
}
