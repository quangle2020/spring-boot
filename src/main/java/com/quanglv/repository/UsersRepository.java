package com.quanglv.repository;

import com.quanglv.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findOneByUsernameAndStatus(String username, Long status);
}
