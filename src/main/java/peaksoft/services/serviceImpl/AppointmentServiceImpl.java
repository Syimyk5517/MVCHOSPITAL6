package peaksoft.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.models.*;
import peaksoft.repositories.*;
import peaksoft.services.AppointmentService;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepo appointmentRepo;
    private final HospitalRepo hospitalRepo;
    private final PatientRepo patientRepo ;
    private final DoctorRepo doctorRepo;
    private final DepartmentRepo departmentRepo;


    @Override
    public List<Appointment> findAll(Long id) {
        return appointmentRepo.findAll(id);
    }

    @Override
    public void save(Long hospitalId, Long patientId, Long doctorId, Long departmentId, Appointment appointment) {
        Hospital hospital = hospitalRepo.findById(hospitalId);
        hospital.addAppointment(appointment);
        Patient patient = patientRepo.finById(patientId);
        patient.addAppointment(appointment);
        appointment.setPatient(patient);
        Doctor doctor = doctorRepo.findById(doctorId);
        doctor.addAppointment(appointment);
        appointment.setDoctor(doctor);
        Department department = departmentRepo.finById(departmentId);
        appointment.setDepartment(department);
        appointmentRepo.save(appointment);
}

    @Override
    public void getById(Long id) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
