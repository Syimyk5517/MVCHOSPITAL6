package peaksoft.services.serviceImpl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.models.Department;
import peaksoft.models.Doctor;
import peaksoft.models.Hospital;
import peaksoft.repositories.DepartmentRepo;
import peaksoft.repositories.DoctorRepo;
import peaksoft.repositories.HospitalRepo;
import peaksoft.services.DoctorService;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepo doctorRepo;
    private final HospitalRepo hospitalRepo;
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
    public void findById(Long id) {
       doctorRepo.findById(id);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return null;
    }

    @Override
    public void delete(Long id) {
      doctorRepo.delete(id);
    }
}
