package com.nhnacademy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "certificate_issue")
public class CertificateIssue {

    @Id
    private int certificate_confirmation_number;

    private String certificate_type_code;

    private Date certificate_issue_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resident_serial_number")
    private Household resident_serial_number;
}
