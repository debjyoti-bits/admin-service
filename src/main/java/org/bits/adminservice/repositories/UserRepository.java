package org.bits.adminservice.repositories;

import org.bits.adminservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

