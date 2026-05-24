package com._zden.BloggingApp.blogDTO;



public record Blogresponse(
        int id,
        String title,
        String content,
        String author,
        int likes
) {
}
