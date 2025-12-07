package com.example.Hospital.controller;

import com.example.Hospital.dto.AppointmentDto;
import com.example.Hospital.dto.PatientDto;
import com.example.Hospital.service.AppointmentService;
import com.example.Hospital.service.PatientService;
import org.apache.coyote.Response;
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

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/getAllPatient")
    public List<PatientDto> getAllPatient(){
        return patientService.getAllPatient();
    }

    @GetMapping("/getAllAppointments")
    public ResponseEntity<?> getAllAppointments(){
        List<AppointmentDto> appointmentList= appointmentService.getAllAppointments();

        return (appointmentList!=null)?ResponseEntity.status(HttpStatus.OK).body(appointmentList)
                :ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No data found to display");
    }

    @PostMapping("/createAppointment")
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDto appointmentDto){
        try {
            AppointmentDto appointmentDto1 = appointmentService.createAppointment(appointmentDto);
            if(appointmentDto1==null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(appointmentDto1);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(appointmentDto1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping ("/createPatient")
    public ResponseEntity<?> createPatient(@RequestBody PatientDto patientDTO){
        PatientDto patientDto1 = patientService.createPatient(patientDTO);
        if(patientDto1 ==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(patientDto1);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(patientDto1);
    }

    @GetMapping("/getPatientById/{id}")
    public ResponseEntity<?>  getPatientById(@PathVariable Long id){
        PatientDto patientDto1 = patientService.getPatientById(id);
        if(patientDto1 ==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(patientDto1);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(patientDto1);
    }
    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        Boolean isDeleted = patientService.deletePatientById(id);
        if(!isDeleted){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to Delete Patient");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Patient successfully");
    }

    @DeleteMapping("/deleteAppointment/{id}")
    public ResponseEntity<?> deleteAppointment(@RequestBody Long id){
        Boolean isDeleted = appointmentService.deleteAppointmentById(id);
        if(!isDeleted){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to delete Appoitment");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Appointment successfully");
    }
    @PatchMapping("/updatePatient/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDTO){
        PatientDto patientDto1 = patientService.updatePatientById(id,patientDTO);
        if(patientDto1 !=null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(patientDto1);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(patientDto1);
    }
}
