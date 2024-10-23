package ru.dns.vitrina.server.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dns.vitrina.server.animal.model.Animal;
import ru.dns.vitrina.server.color.model.Color;
import ru.dns.vitrina.server.vitrina.model.Vitrina;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String name;
    private String lastName;
    private boolean root;
    private Animal avatar;
    private Color color;
    private List<Vitrina> vitrina;
}
