package ru.dns.vitrina.server.controller.model.user;

import lombok.Data;
import ru.dns.vitrina.server.controller.model.animal.AnimalRequest;
import ru.dns.vitrina.server.controller.model.color.ColorRequest;
import ru.dns.vitrina.server.controller.model.vitrina.VitrinaRequest;

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
