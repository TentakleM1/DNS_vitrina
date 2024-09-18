package ru.dns.vitrina.server.controller.model.user;

import lombok.Data;

@Data
public class UserRequest {
    private Long id;
    private String name;
    private String lastName;
    private String password;
    private boolean root;
}
