package com.example.Hospital;

import com.example.Hospital.dto.PatientDto;
import com.example.Hospital.entity.Patient;
import com.example.Hospital.repository.Patientrepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.Hospital.entity.type.Bloodgroup.A_POS;

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
        List<PatientDto>=
    }
}
