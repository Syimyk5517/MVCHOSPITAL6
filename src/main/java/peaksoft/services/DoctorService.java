package peaksoft.services;

import org.springframework.stereotype.Service;
import peaksoft.models.Doctor;

import java.util.List;


@Service
public interface DoctorService {
    List<Doctor> getAll();
    void save(Long hospitalId,Long departmentId,Long doctorId,Doctor doctor);
    void assignDoctor(Long doctorId,Long departmentId);
    void findById(Long id);
    Doctor update(Doctor doctor);
    void delete(Long id);
}
