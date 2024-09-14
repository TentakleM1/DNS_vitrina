package ru.dns.vitrina.server.controller.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;
    private String name;
    private String lastName;
    private String password;
    private boolean root;
}
