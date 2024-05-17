package com.cts.Project.SportsComplexManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.Project.SportsComplexManagementSystem.Model.Bookings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {

    @Query(nativeQuery = true, value = "select * from bookings where user_id=:userId")
    List<Bookings> findByUserId(@Param("userId") Long userId);
}