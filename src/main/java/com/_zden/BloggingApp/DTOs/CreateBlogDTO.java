package com._zden.BloggingApp.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateBlogDTO(
        @NotBlank(message = "you should type something")
        @Size(min = 5 ,max = 45)
        String title,
        @NotBlank(message = "you should type something")
        @Size(min = 5, max = 2000)
        String content,
        long userId
) {
}
