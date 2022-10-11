package com.library.automation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.library.automation.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
