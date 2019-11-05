package com.hackduck.sca.repository;

import com.hackduck.sca.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByIduser(UUID iduser);
}
