package com._zden.BloggingApp.Repositories;

import com._zden.BloggingApp.Entities.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsUserByEmail(@NotBlank String email);

    User findByEmail(String email);
}
