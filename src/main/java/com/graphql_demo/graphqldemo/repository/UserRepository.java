package com.graphql_demo.graphqldemo.repository;

import com.graphql_demo.graphqldemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {



}
