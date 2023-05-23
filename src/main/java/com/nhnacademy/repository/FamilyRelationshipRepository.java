package com.nhnacademy.repository;

import com.nhnacademy.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship,Integer> {

    List<FamilyRelationship> findFamilyRelationshipByFamily_relationship(int family_resident_serial_number, int base_resident_serial_number);

    @Modifying
    @Query("update FamilyRelationship F set F.family_relationship_code = ?1 where F.pk.family_resident_serial_number = ?2 and F.pk.base_resident_serial_number = ?3")
    String updateRelation_code(String code,int family_resident_serial_number, int base_resident_serial_number);

    void deleteAllBySerial_number(int family_resident_serial_number, int base_resident_serial_number);

}
