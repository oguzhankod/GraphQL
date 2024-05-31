package com.graphql_demo.graphqldemo.controller;

import com.graphql_demo.graphqldemo.model.User;
import com.graphql_demo.graphqldemo.model.UserRequest;
import com.graphql_demo.graphqldemo.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @QueryMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @QueryMapping
    public User getUserById(@Argument Long id){
        return userService.getUserById(id);
    }

    @MutationMapping
    public User createUser(@Argument UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @MutationMapping
    public User updateUser(@Argument UserRequest userRequest){
        return userService.updateUser(userRequest);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument Long id){
        userService.deleteUser(id);
        return true;
    }




}
