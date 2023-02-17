package peaksoft.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.models.Appointment;
import peaksoft.repositories.AppointmentRepo;
import peaksoft.services.AppointmentService;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepo appointmentRepo;
    @Override
    public List<Appointment> findAll() {
        return appointmentRepo.findAll();
    }
}
