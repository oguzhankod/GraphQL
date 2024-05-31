package com.graphql_demo.graphqldemo.service;

import com.graphql_demo.graphqldemo.exceptions.UserNotFoundException;
import com.graphql_demo.graphqldemo.model.User;
import com.graphql_demo.graphqldemo.model.UserRequest;
import com.graphql_demo.graphqldemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository
                .findById(id)
                .orElseThrow(()-> new UserNotFoundException("ID'si verilen kullanıcı bulunamadı"));
    }

    public User createUser(UserRequest userRequest){
        User user = User.builder()
                .mail(userRequest.getMail())
                .role(userRequest.getRole())
                .username(userRequest.getUsername())
                .build();

        return userRepository.save(user);
    }

    public User updateUser(UserRequest userRequest){

        User updateUser = getUserById(userRequest.getId());

        updateUser.setMail(userRequest.getMail());
        updateUser.setRole(userRequest.getRole());
        updateUser.setUsername(userRequest.getUsername());
        return userRepository.save(updateUser);

    }

    public void deleteUser(Long id){
        User deleteUser = getUserById(id);
        userRepository.delete(deleteUser);
    }



}
