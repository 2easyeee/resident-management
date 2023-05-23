package com.nhnacademy.repository;

import com.nhnacademy.entity.BirthDeathReportResident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BirthDeathReportResidentRepository extends JpaRepository<BirthDeathReportResident, String> {
    List<BirthDeathReportResident> findByReport_resident(String birth_death_type_code, int resident_serial_number, int report_resident_serial_number);

    @Modifying
    @Query("update BirthDeathReportResident B set B.pk.birth_death_type_code = ?1 where B.pk.resident_serial_number = ?2")
    String updateRelation_code(String code,int resident_serial_number);

}
