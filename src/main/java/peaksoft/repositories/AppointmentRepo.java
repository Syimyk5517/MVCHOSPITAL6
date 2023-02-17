package peaksoft.repositories;


import org.springframework.stereotype.Repository;
import peaksoft.models.Appointment;

import java.util.List;


@Repository
public interface AppointmentRepo {
    List<Appointment> findAll();

}
