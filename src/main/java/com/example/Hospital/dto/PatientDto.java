package com.example.Hospital.dto;

import com.example.Hospital.entity.type.Bloodgroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientDto {
    private Long id;
    private String name;
    private String email;
    private String city;
    private Bloodgroup bloodgroup;
}
