package peaksoft.services;


import org.springframework.stereotype.Service;
import peaksoft.models.Appointment;

import java.util.List;


@Service

public interface AppointmentService {
    List<Appointment> findAll();

}
