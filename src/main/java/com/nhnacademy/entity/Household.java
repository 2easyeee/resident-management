package com.nhnacademy.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "household")
public class Household {

    @Id
    private int household_serial_number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resident_serial_number")
    private Residents household_resident_serial_number;

    private Date household_composition_date;

    private String household_composition_reason_code;

    private String current_house_movement_address;

    @OneToMany(mappedBy = "household_serial_number")
    private List<HouseholdMovementAddress> householdMovementAddresses;

    @OneToMany(mappedBy = "household_serial_number")
    private List<HouserholdCompositionResident> houserholdCompositionResidents;

}
