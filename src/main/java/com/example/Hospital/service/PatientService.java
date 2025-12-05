package com.example.Hospital.service;

import com.example.Hospital.dto.PatientDto;
import com.example.Hospital.entity.Patient;
import com.example.Hospital.repository.Patientrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientService {
    @Autowired
    private Patientrepo patientrepo;

    public List<PatientDto> getAllPatient(){
        List <Patient> patientList= patientrepo.findAll();
         return patientList.stream().map(
                 patient -> new PatientDto(patient.getId(), patient.getName(),
                         patient.getCity(),
                         patient.getEmail(),
                         patient.getBloodgroup())
         ).toList();

    }

    public PatientDto createPatient(PatientDto patientDTO){
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setName(patientDTO.getName());
        patient.setEmail(patientDTO.getEmail());
        patient.setBloodgroup(patientDTO.getBloodgroup());
        patient.setCity(patientDTO.getCity());
        try {
            patientrepo.save(patient);
            return new PatientDto(patient.getId(), patient.getName(),patient.getCity(),patient.getEmail(),patient.getBloodgroup());
        }
        catch (Exception e){
            return null;
        }
    }

    public PatientDto getPatientById(Long id){
        Patient patient = patientrepo.findById(id).orElse(null);
        if(patient!=null) {
            PatientDto patientDTO = new PatientDto(patient.getId(), patient.getName(),patient.getCity(),patient.getEmail(),patient.getBloodgroup());
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
    public PatientDto updatePatientById(Long id, PatientDto patientDTO){
        Patient patient = patientrepo.findById(id).orElse(null);
        if(patientDTO.getId()!=null){
            patient.setId(patient.getId());
        }
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
            PatientDto patientDto1 = new PatientDto(patient.getId(), patient.getName(),
                    patient.getCity(),patient.getEmail(),patient.getBloodgroup());
            return patientDto1;
        }
        catch (Exception e){
            return null;
        }
    }
}
