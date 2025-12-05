package com.example.Hospital.repository;

import com.example.Hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Patientrepo extends JpaRepository<Patient, Long> {

}
