package com.example.Hospital.dto;

import com.example.Hospital.entity.type.Shift;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.Hospital.entity.Appointment}
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AppointmentDto {
    private  Long patientId;
    private  Long doctorId;
    private  Shift shift;
    private LocalDateTime createDateTime;
    private  LocalDateTime appDateTime;

    public AppointmentDto(Long id, Long id1, Shift shift, LocalDateTime appDateTime) {
        this.patientId=id;
        this.doctorId= id1;
        this.shift= shift;
        this.appDateTime=appDateTime;
    }
}