package com.nhnacademy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "resident")
public class Residents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resident_serial_number")
    private int resident_serial_number;

    private String name;

    private String resident_registration_number;

    private String gender_code;

    private Date birth_date;

    private String birth_place_code;

    private String registration_base_address;

    private Date death_date;

    private String death_place_code;

    private String death_place_address;

    @OneToMany(mappedBy = "family_resident_serial_number", fetch = FetchType.LAZY)
    private List<FamilyRelationship> familyRelationships_family;

    @OneToMany(mappedBy = "base_resident_serial_number", fetch = FetchType.LAZY)
    private List<FamilyRelationship> familyRelationships_base;

    @OneToMany(mappedBy = "report_resident_serial_number")
    private List<BirthDeathReportResident> birthDeathReportResidents;

    @OneToMany(mappedBy = "resident_serial_number")
    private List<CertificateIssue> certificateIssues;

    @OneToMany(mappedBy = "household_resident_serial_number")
    private List<Household> households;

    @OneToMany(mappedBy = "resident_serial_number")
    private List<HouserholdCompositionResident> houserholdCompositionResidents;
}
