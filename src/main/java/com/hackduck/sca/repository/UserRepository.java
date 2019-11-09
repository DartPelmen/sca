package com.hackduck.sca.repository;

import com.hackduck.sca.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface UserRepository extends PagingAndSortingRepository<User, UUID> {
    User findByIduser(UUID iduser);
}
