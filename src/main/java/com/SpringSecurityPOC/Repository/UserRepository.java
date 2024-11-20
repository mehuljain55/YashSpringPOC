package com.SpringSecurityPOC.Repository;

import com.SpringSecurityPOC.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
