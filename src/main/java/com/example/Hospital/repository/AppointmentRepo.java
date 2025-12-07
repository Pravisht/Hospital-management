package com.example.Hospital.repository;

import com.example.Hospital.dto.AppointmentDto;
import com.example.Hospital.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    @Query("""
select new com.example.Hospital.dto.AppointmentDto(
d.id,
p.id,
a.shift,
a.createDateTime,
a.appDateTime
)
from Appointment a
join a.doctor d
join a.patient p
""")
    List<AppointmentDto> findAllAppointments();
}