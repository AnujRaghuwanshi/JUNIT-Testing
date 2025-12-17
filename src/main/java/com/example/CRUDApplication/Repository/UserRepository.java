package com.example.CRUDApplication.Repository;

import com.example.CRUDApplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    @Query(
            value = """
            SELECT * FROM users
            WHERE email IS NOT NULL
              AND sentiment_analysis = 1
              AND email REGEXP '^[A-Za-z0-9+_.-]+@[A-Za-z][A-Za-z-]*\\.[A-Za-z]{2,}$'
        """,
            nativeQuery = true
    )
    List<User> findUsersForSentimentAnalysis();
}
