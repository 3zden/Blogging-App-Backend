package com._zden.BloggingApp.DTOs;



public record BlogResponseDTO(
        int id,
        String title,
        String content,
        String authorFirstName,
        String authorLastName
) {
}
