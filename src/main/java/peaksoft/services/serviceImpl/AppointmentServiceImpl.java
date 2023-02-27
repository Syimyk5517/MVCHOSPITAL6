package peaksoft.services.serviceImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.exception.BadRequestExseption;
import peaksoft.models.*;
import peaksoft.repositories.*;
import peaksoft.services.AppointmentService;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepo appointmentRepo;
    private final HospitalRepo hospitalRepo;
    private final PatientRepo patientRepo;
    private final DoctorRepo doctorRepo;
    private final DepartmentRepo departmentRepo;
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Appointment> findAll(Long id) {
        return appointmentRepo.findAll(id);
    }

    @Override
    public void save(Long hospitalId, Long patientId, Long doctorId, Long departmentId, Appointment appointment) {
//        var today = LocalDate.now();
//        var dd = today.getDayOfMonth();
//        var mm = today.getMonthValue();
//        var yyyy = today.getYear();
//        if (yyyy > appointment.getDate().getYear() || mm > appointment.getDate().getMonthValue() || dd > appointment.getDate().getDayOfMonth()) {
//            throw new BadRequestExseption("Not found ");
//        } else {
            Hospital hospital = hospitalRepo.findById(hospitalId);
            hospital.addAppointment(appointment);
            Patient patient = patientRepo.finById(patientId);
            appointment.setPatient(patient);
            patient.addAppointment(appointment);
            Doctor doctor = doctorRepo.findById(doctorId);
            appointment.setDoctor(doctor);
            doctor.addAppointment(appointment);
            appointment.setDepartment(departmentRepo.finById(departmentId));
            appointmentRepo.save(appointment);
//
//        }


    }

    @Override
    public Appointment getById(Long id) {
     return appointmentRepo.getById(id);
    }

    @Override
    public void deleteById(Long appointmentId) {
        Appointment appointment = appointmentRepo.getById(appointmentId);
        appointment.setPatient(null);
        appointment.setDepartment(null);
        appointment.setDoctor(null);
        appointmentRepo.deleteById(appointmentId);
    }

    @Override
    public Appointment update(Long hospitalId, Long patientId, Long doctorId, Long departmentId, Appointment appointment,Long appointmentId) {
        appointment.setPatient(patientRepo.finById(patientId));
        appointment.setDoctor(doctorRepo.findById(doctorId));
        appointment.setDepartment(departmentRepo.finById(departmentId));
        Appointment oldAppointment = getById(appointmentId);
        oldAppointment.setPatient(appointment.getPatient());
        oldAppointment.setDoctor(appointment.getDoctor());
        oldAppointment.setDepartment(appointment.getDepartment());
        oldAppointment.setDate(appointment.getDate());
        return appointmentRepo.update(oldAppointment);
        }
}

