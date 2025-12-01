package com.example.test;

import com.example.test.controller.HospitalController;
import com.example.test.dto.PatientDTO;
import com.example.test.entity.Patient;
import com.example.test.repository.Patientrepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import java.util.List;

import static com.example.test.entity.type.Bloodgroup.A_POS;

@SpringBootTest
public class PatientTest {

    @Mock
    private Patientrepo patientrepo;


//    private HospitalController hospitalController;

    @Test
    public void checkAllPatient() {
        System.out.println(patientrepo.findAll());
    }

    @Test
    public void createPatient() {
        Patient patient = new Patient(1L,"ABC","mrt","rg@gmail.com",A_POS);
        System.out.println(patientrepo.save(patient));
    }

    @Test
    public void patientGetAll() {
        List<PatientDTO>=
    }
}
