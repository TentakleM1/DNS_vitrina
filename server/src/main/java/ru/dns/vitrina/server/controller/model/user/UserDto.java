package ru.dns.vitrina.server.controller.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.dns.vitrina.server.controller.model.animal.AnimalDto;
import ru.dns.vitrina.server.controller.model.color.ColorDto;
import ru.dns.vitrina.server.controller.model.vitrina.VitrinaDto;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;
    private String name;
    private String lastName;
    private String password;
    private boolean root;
    private List<AnimalDto> avatar;
    private List<ColorDto> color;
    private List<VitrinaDto> vitrina;

    public UserDto() {
        this.avatar = new ArrayList<>();
        this.color = new ArrayList<>();
        this.vitrina = new ArrayList<>();
    }
}
