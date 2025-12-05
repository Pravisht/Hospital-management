package com.example.Hospital.entity;

import com.example.Hospital.entity.type.Shift;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String speciality;
    private String email;

    private Shift shift;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointmentList;
}
