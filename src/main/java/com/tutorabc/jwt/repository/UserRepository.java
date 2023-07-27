package com.tutorabc.jwt.repository;

import com.tutorabc.jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByUsernameAndPassword(String username, String password);
}
