package ru.dns.vitrina.server.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInUserDto {
    @NotBlank(message = "поле фамилии не должно быть пустым")
    private String lastName;
    @NotBlank(message = "поле пароля не должно быть пустым")
    private String password;
}
