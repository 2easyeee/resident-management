package com.nhnacademy.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "birth_death_report_resident")
public class BirthDeathReportResident {

    @EmbeddedId
    private Pk pk;

    private Date birth_death_report_date;

    private String birth_report_qualifications_code;

    private String death_report_qualifications_code;

    private String email_address;

    private String phone_number;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Pk implements Serializable {
        private String resident_serial_number;

        private String birth_death_type_code;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "birthDeathReportResidents ")
        private Residents report_resident_serial_number;
    }

}
