package com.nhnacademy.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "household_movement_address")
public class HouseholdMovementAddress {

    @EmbeddedId
    private Pk pk;

    private String house_movement_address;

    private String last_address_yn;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Pk implements Serializable {
        private Date house_movement_report_date;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "household_serial_number")
        private Household household_serial_number;
    }
}
