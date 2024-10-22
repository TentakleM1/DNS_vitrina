package ru.dns.vitrina.server.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dns.vitrina.server.animal.model.Animal;
import ru.dns.vitrina.server.color.model.Color;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationUserDto {
    @NotBlank(message = "поле имени не должно быть пустым")
    private String name;
    @NotBlank(message = "поле фамилии не должно быть пустым")
    private String lastName;
    @NotBlank(message = "поле пароля не должно быть пустым")
    private String password;
    @NotBlank(message = "поле прав не должно быть пустым")
    private boolean root;
    private Animal animal;
    private Color color;
}
