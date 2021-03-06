package com.web.curation.dao.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.curation.model.user.User;

public interface UserDao extends JpaRepository<User, String> {
    Optional<User> findByIdAndPassword(String id, String password);
    Optional<User> findById(String id);
	
}