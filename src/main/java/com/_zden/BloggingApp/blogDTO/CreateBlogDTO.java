package com._zden.BloggingApp.blogDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record createBlogDto(
        @NotBlank(message = "you should type something")
        @Size(min = 5 ,max = 25)
        String title,
        @NotBlank(message = "you should type something")
        @Size(min = 5, max = 2000)
        String content,
        @NotBlank
        String author
) {
}
