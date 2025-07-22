package com.example.jpa_h2_example.repository;

import com.example.jpa_h2_example.model.Billionaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillionaireRepository extends CrudRepository<Billionaire, Long> {

    // Automatic Custom Query
    List<Billionaire> findByFirstName(String name);

    // Manual Custom Query #1
    @Query(value = "SELECT * FROM BILLIONAIRE u WHERE u.first_name = ?1", nativeQuery = true)
    List<Billionaire> retrieveByName1(String firstName);

    // Manual Custom Query #2
    @Query(value = "SELECT * FROM BILLIONAIRE u WHERE u.first_name = :name", nativeQuery = true)
    List<Billionaire> retrieveByName2(@Param("name") String firstName);
}
