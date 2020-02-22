package com.Flashycards.Flashycards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Flashycards.Flashycards.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByUsernameOrEmail(String username, String email);
    List<User> findAllByRoles (String role);
    boolean existsByUsernameAndEmail(String username, String email);
}
