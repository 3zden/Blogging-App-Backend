package com._zden.BloggingApp.blogDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record createBlogDto(
        @NotBlank(message = "you should type something")
        @Min(3) @Max(100)
        String title,
        @NotBlank(message = "you should type something")
        @Min(20)
        String content,
        @NotBlank
        String author
) {
}
