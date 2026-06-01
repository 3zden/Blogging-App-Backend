package com._zden.BloggingApp.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

public record CreateUserDTO(
        @NotBlank @Size(min = 2,max = 25)
        String firstName,
        @NotBlank @Size(min = 2,max = 25)
        String lastName,
        @NotBlank @Size(max = 100)
        String email,
        @NotBlank
        String password
) {
}
