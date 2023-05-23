package com.nhnacademy.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "household_composition_resident")
public class HouserholdCompositionResident {

    @EmbeddedId
    private Pk pk;

    private Date report_date;

    private String household_relationship_code;

    private String household_composition_change_reason_code;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Pk implements Serializable {

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "household_serial_number")
        private Household household_serial_number;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "resident_serial_number")
        private Residents resident_serial_number;
    }
}
