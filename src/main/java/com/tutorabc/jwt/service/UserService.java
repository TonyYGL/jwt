package com.tutorabc.jwt.service;

import com.tutorabc.jwt.entity.User;
import com.tutorabc.jwt.repository.UserRepository;
import com.tutorabc.jwt.web.request.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public boolean isValidUser(UserLogin userLogin) {
        if (CollectionUtils.isEmpty(findByUsernamePassword(userLogin.getUsername(), userLogin.getPassword()))) {
            return false;
        }
        return true;
    }

    public List<User> findByUsernamePassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

}
