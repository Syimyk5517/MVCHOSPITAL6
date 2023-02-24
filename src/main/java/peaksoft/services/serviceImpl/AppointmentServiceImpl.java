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
    private final PatientRepo patientRepo ;
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
        int day = LocalDate.now().getDayOfMonth();
        int  appointmentDay = appointment.getDate().getDayOfMonth();
        int month = LocalDate.now().getMonthValue();
        int appointmentMonth = appointment.getDate().getMonthValue();
        int year = LocalDate.now().getYear();
        int appointmentYear = appointment.getDate().getYear();
        if (day>appointmentDay || month>appointmentMonth || year>appointmentYear){
            throw new BadRequestExseption("Bad request exseption");
        }else {
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
        }
}

    @Override
    public void getById(Long id) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
