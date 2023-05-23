package com.nhnacademy.repository;

import com.nhnacademy.entity.Residents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResidentsRepository extends JpaRepository<Residents, Integer> {

    List<Residents> findResidentsByResident_registration_number(int resident_registration_number);

    @Modifying
    @Query("update Residents set Residents.name = ?1 where Residents.name = ?2")
    String updateName(String name, String newName);

    void deleteAllById(int resident_serial_number);

}
