package com._zden.BloggingApp.DTOs;

import jakarta.validation.constraints.NotBlank;

public record LoginUser(
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}
