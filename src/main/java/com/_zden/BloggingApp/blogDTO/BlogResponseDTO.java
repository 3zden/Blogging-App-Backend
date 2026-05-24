package com._zden.BloggingApp.blogDTO;



public record BlogResponseDTO(
        int id,
        String title,
        String content,
        String authorFirstName,
        String authorLastName
) {
}
