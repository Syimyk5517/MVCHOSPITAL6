package peaksoft.services;


import org.springframework.stereotype.Service;
import peaksoft.models.Appointment;

import java.util.List;


@Service

public interface AppointmentService {
    List<Appointment> findAll(Long id);
    void save(Long hospitalId,Long patientId, Long doctorId, Long departmentId,Appointment appointment);
    void getById(Long id);
    void deleteById(Long id);

}
