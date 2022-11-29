package com.example.surmoonveysurvey.repositories;

import com.example.surmoonveysurvey.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
