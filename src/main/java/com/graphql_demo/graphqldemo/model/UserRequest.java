package com.graphql_demo.graphqldemo.model;

import lombok.Data;

@Data
public class UserRequest {


    private Long id;
    private String username;
    private String mail;
    private Role role;
}
