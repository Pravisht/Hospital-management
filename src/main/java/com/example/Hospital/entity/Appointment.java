package com.example.Hospital.entity;

import com.example.Hospital.entity.type.Shift;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_app_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_app_id")
    private Doctor doctor;

    private Shift shift;

    @CreationTimestamp
    @Column(name="timestamp_creation",updatable = false)
    private LocalDateTime createDateTime;

    @Column(name = "timestamp_booking")
    private LocalDateTime  appDateTime;

}
