package com.example.test.repository;

import com.example.test.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Patientrepo extends JpaRepository<Patient, Long> {

}
