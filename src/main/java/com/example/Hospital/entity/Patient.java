package com.example.Hospital.entity;

import com.example.Hospital.entity.type.Bloodgroup;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "email"})
}, indexes = {

})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String city;

    private String email;

    private Bloodgroup bloodgroup;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointmentList;

}
