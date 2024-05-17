package com.cts.Project.SportsComplexManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.Project.SportsComplexManagementSystem.Model.SportsInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsInfoRepository extends JpaRepository<SportsInfo, Long> {
}
