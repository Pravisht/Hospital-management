package com.example.Hospital.service;

import com.example.Hospital.dto.AppointmentDto;
import com.example.Hospital.entity.Appointment;
import com.example.Hospital.entity.Doctor;
import com.example.Hospital.entity.Patient;
import com.example.Hospital.repository.AppointmentRepo;
import com.example.Hospital.repository.DoctorRepo;
import com.example.Hospital.repository.Patientrepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private Patientrepo patientrepo;
    @Autowired
    private DoctorRepo doctorrepo;


    @Transactional
    public AppointmentDto createAppointment(AppointmentDto dto) throws Exception {
        Patient patient= patientrepo.findById(dto.getPatientId()).orElseThrow(()->new Exception("Patient not found"));
        Doctor doctor= doctorrepo.findById(dto.getDoctorId()).orElseThrow(()->new Exception("Doctor Not Found"));

        Appointment appointment = Appointment.builder().appDateTime(dto.getAppDateTime())
                .shift(dto.getShift()).patient(patient).doctor(doctor).build();
        try{
            appointmentRepo.save(appointment);
            return new AppointmentDto( appointment.getPatient().getId(),appointment.getDoctor().getId(),
                   appointment.getShift(),appointment.getAppDateTime());
        }
        catch (Exception e){
            return null;
        }
    }

    @Transactional
    public List<AppointmentDto> getAllAppointments() {
        List<AppointmentDto> appointmentList= appointmentRepo.findAllAppointments();
//        List<AppointmentDto> appointmentDtoList= appointmentList.stream()
//                .map((appointment)->
//                        (new AppointmentDto(appointment.getPatient().getId(),
//                                appointment.getDoctor().getId(),appointment.getShift(),
//                                appointment.getCreateDateTime(),appointment.getAppDateTime()))).toList();

//        return appointmentDtoList;
        return appointmentList;
    }

    public Boolean deleteAppointmentById(Long id) {
        Appointment appointment= appointmentRepo.findById(id).orElse(null);
        if(appointment!=null)
        try{
            appointmentRepo.delete(appointment);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
