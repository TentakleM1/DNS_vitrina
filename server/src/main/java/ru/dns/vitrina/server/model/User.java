package ru.dns.vitrina.server.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import ru.dns.vitrina.server.validator.annotation.NotWriteSpace;
import ru.dns.vitrina.server.validator.annotation.NullOrNotBlank;
import ru.dns.vitrina.server.validator.group.Create;
import ru.dns.vitrina.server.validator.group.Default;
import ru.dns.vitrina.server.validator.group.Update;

@Data
@Builder
public class User {
    @NotNull(groups = Update.class)
    @Positive(groups = Update.class)
    private long id;

    @NotBlank(groups = Create.class)
    @NotWriteSpace(groups = Default.class)
    @NullOrNotBlank(groups = Update.class)
    private String name;

    @NotBlank(groups = Create.class)
    @NotWriteSpace(groups = Default.class)
    @NullOrNotBlank(groups = Update.class)
    private String lastName;

    @NotBlank(groups = Create.class)
    @NotWriteSpace(groups = Default.class)
    @NullOrNotBlank(groups = Update.class)
    private String password;

    @NotBlank(groups = Create.class)
    private boolean root;
}
