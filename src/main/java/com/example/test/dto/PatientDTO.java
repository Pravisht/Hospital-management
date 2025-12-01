package com.example.test.dto;

import com.example.test.entity.type.Bloodgroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientDTO {
//    private Long id;
    private String name;
    private String email;
    private String city;
    private Bloodgroup bloodgroup;
}
