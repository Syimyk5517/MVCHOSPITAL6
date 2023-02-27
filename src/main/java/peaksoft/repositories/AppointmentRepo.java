package peaksoft.repositories;


import org.springframework.stereotype.Repository;
import peaksoft.models.Appointment;

import java.util.List;


@Repository
public interface AppointmentRepo {
    List<Appointment> findAll(Long id);
    void save(Appointment appointment);
    Appointment getById(Long id);
    void deleteById(Long id);
    Appointment update(Appointment appointment);





}
