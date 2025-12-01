package com.example.test.controller;

import com.example.test.dto.PatientDTO;
import com.example.test.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HospitalController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/getAllPatient")
    public List<PatientDTO> getAllPatient(){
        return patientService.getAllPatient();
    }
    @PostMapping ("/createPatient")
    public ResponseEntity<?> createPatient(@RequestBody PatientDTO patientDTO){
        PatientDTO patientDTO1 = patientService.createPatient(patientDTO);
        if(patientDTO1!=null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(patientDTO1);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(patientDTO1);
    }

    @GetMapping("/getPatientById/{id}")
    public ResponseEntity<?>  getPatientById(@PathVariable Long id){
        PatientDTO patientDTO1 = patientService.getPatientById(id);
        if(patientDTO1!=null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(patientDTO1);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(patientDTO1);
    }
    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        Boolean isDeleted = patientService.deletePatientById(id);
        if(!isDeleted){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to Delete Patient");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Deleted Patient successfully");
    }

    @PatchMapping("/updatePatient/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO){
        PatientDTO patientDTO1 = patientService.updatePatientById(id,patientDTO);
        if(patientDTO1!=null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(patientDTO1);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(patientDTO1);
    }
}
