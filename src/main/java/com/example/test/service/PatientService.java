package com.example.test.service;

import com.example.test.dto.PatientDTO;
import com.example.test.entity.Patient;
import com.example.test.repository.Patientrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientService {
    @Autowired
    private Patientrepo patientrepo;

    public List<PatientDTO> getAllPatient(){
        List <Patient> patientList= patientrepo.findAll();
         return patientList.stream().map(
                 patient -> new PatientDTO(patient.getName(),
                         patient.getCity(),
                         patient.getEmail(),
                         patient.getBloodgroup())
         ).toList();

    }

    public PatientDTO createPatient(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setEmail(patientDTO.getEmail());
        patient.setBloodgroup(patientDTO.getBloodgroup());
        patient.setCity(patientDTO.getCity());
        try {
            patientrepo.save(patient);
            return new PatientDTO(patient.getName(),patient.getCity(),patient.getEmail(),patient.getBloodgroup());
        }
        catch (Exception e){
            return null;
        }
    }

    public PatientDTO getPatientById(Long id){
        Patient patient = patientrepo.findById(id).orElse(null);
        if(patient!=null) {
            PatientDTO patientDTO = new PatientDTO(patient.getName(),patient.getCity(),patient.getEmail(),patient.getBloodgroup());
            return patientDTO;
        }
        else{
            return null;
        }
    }

    public Boolean deletePatientById(Long id){
        Patient patient = patientrepo.findById(id).orElse(null);
        if(patient!=null) {
            patientrepo.delete(patient);
            return true;
        }
        else{
            return false;
        }
    }
    public PatientDTO updatePatientById(Long id, PatientDTO patientDTO){
        Patient patient = patientrepo.findById(id).orElse(null);
        if(patientDTO.getName()!=null) {
            patient.setName(patientDTO.getName());
        }
        if(patientDTO.getBloodgroup()!=null) {
            patient.setBloodgroup(patientDTO.getBloodgroup());
        }
        if(patientDTO.getEmail()!=null) {
            patient.setEmail(patientDTO.getEmail());
        }
        if(patientDTO.getCity()!=null) {
            patient.setCity(patientDTO.getCity());
        }
        try {
            patientrepo.save(patient);
            PatientDTO patientDTO1= new PatientDTO(patient.getName(),
                    patient.getCity(),patient.getEmail(),patient.getBloodgroup());
            return patientDTO1;
        }
        catch (Exception e){
            return null;
        }
    }
}
