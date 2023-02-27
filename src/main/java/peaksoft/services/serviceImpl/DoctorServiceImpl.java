package peaksoft.services.serviceImpl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.models.Appointment;
import peaksoft.models.Department;
import peaksoft.models.Doctor;
import peaksoft.models.Hospital;
import peaksoft.repositories.AppointmentRepo;
import peaksoft.repositories.DepartmentRepo;
import peaksoft.repositories.DoctorRepo;
import peaksoft.repositories.HospitalRepo;
import peaksoft.services.DoctorService;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepo doctorRepo;
    private final HospitalRepo hospitalRepo;
    private final AppointmentRepo appointmentRepo;
    @Override
    public List<Doctor> getAll(Long id) {
        return doctorRepo.getAll(id);
    }

    @Override
    public void save(Long hospitalId,Doctor doctor) {
        Hospital hospital = hospitalRepo.findById(hospitalId);
        hospital.addDoctor(doctor);
        doctor.setHospital(hospital);
        doctorRepo.save(doctor);

    }


    @Override
    public Doctor findById(Long id) {
       return doctorRepo.findById(id);
    }

    @Override
    public Doctor update(Long doctorId,Doctor doctor) {
        Doctor oldDoctor = findById(doctorId);
        oldDoctor.setFirsName(doctor.getFirsName());
        oldDoctor.setLastName(doctor.getLastName());
        oldDoctor.setEmail(doctor.getEmail());
        oldDoctor.setPosition(doctor.getPosition());
        return doctorRepo.update(oldDoctor);
    }

    @Override
    public void delete(Long id) {
        Doctor doctor = findById(id);
        Hospital hospital = doctor.getHospital();
        List<Appointment> appointments = doctor.getAppointments();
        doctor.setDepartments(null);
       appointments.forEach(appointment -> appointment.getDoctor().setAppointments(null));
       appointments.forEach(appointment -> appointment.getPatient().setAppointments(null));
       appointments.forEach(appointment -> appointment.getDepartment().setDoctors(null));
       appointments.forEach(appointment -> appointment.getDoctor().setDepartments(null));
        hospital.getAppointments().removeAll(appointments);
        for (int i = 0; i < appointments.size(); i++) {
            appointmentRepo.deleteById(appointments.get(i).getId());
        }
      doctorRepo.delete(id);
    }

    @Override
    public List<Department> getAllDepartmentDoctorById(Long doctorId) {
        return doctorRepo.getAllDepartmentDoctorById(doctorId);
    }
}
