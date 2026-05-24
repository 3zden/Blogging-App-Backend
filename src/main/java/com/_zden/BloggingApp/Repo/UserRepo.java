package com._zden.BloggingApp.Repo;

import com._zden.BloggingApp.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
}
