package ru.dns.vitrina.server.vitrina.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dns.vitrina.server.block.model.Block;
import ru.dns.vitrina.server.user.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VitrinaDto {
    private int id;
    @NotBlank(message = "поле имени не может быть пустым")
    private String name;
    @NotBlank(message = "поле блока не может быть пустым")
    private Block block;
    private User user;
    
}
