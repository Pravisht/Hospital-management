package com.example.Hospital.dto;

import com.example.Hospital.entity.Doctor;
import com.example.Hospital.entity.type.Shift;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Doctor}
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorDto{
    private String name;
    private String speciality;
    private String email;
    private Shift shift;
    private String phone;
    private String address;
    private List<Long> appointmentIdList;
}