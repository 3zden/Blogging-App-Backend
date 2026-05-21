package com._zden.BloggingApp.blogDTO;

import java.util.UUID;

public record BlogResponseDTO(
        String title,
        String content,
        String author
) {
}
