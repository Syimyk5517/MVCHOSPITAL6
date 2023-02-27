package peaksoft.services;


import org.springframework.stereotype.Service;
import peaksoft.models.Appointment;

import java.util.List;


@Service

public interface AppointmentService {
    List<Appointment> findAll(Long id);
    void save(Long hospitalId,Long patientId, Long doctorId, Long departmentId,Appointment appointment);
    Appointment getById(Long id);
    void deleteById(Long appointmentId);
    Appointment update(Long hospitalId, Long patientId, Long doctorId, Long departmentId,Appointment appointment,Long appointmentId);

}
