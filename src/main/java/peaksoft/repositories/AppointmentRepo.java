package peaksoft.repositories;


import org.springframework.stereotype.Repository;
import peaksoft.models.Appointment;

import java.util.List;


@Repository
public interface AppointmentRepo {
    List<Appointment> findAll(Long id);
    void save(Appointment appointment);
    void getById(Long id);
    void deleteById(Long id);





}
