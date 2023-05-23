package com.nhnacademy.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "family_relationship")
public class FamilyRelationship {

    @EmbeddedId
    private Pk pk;

    private String family_relationship_code;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Pk implements Serializable {
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "resident_serial_number")
        private Residents base_resident_serial_number;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "resident_serial_number")
        private Residents family_resident_serial_number;
    }
}
