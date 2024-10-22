package ru.dns.vitrina.server.controller.dto.user;

import lombok.Data;
import ru.dns.vitrina.server.controller.dto.animal.AnimalRequest;
import ru.dns.vitrina.server.controller.dto.color.ColorRequest;
import ru.dns.vitrina.server.controller.dto.vitrina.VitrinaRequest;

import java.util.List;

@Data
public class UserRequest {
    private Long id;
    private String name;
    private String lastName;
    private String password;
    private boolean root;
    private List<AnimalRequest> avatar;
    private List<ColorRequest> color;
    private List<VitrinaRequest> vitrina;
}
