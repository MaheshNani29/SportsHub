package com.cts.Project.SportsComplexManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.Project.SportsComplexManagementSystem.Model.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
