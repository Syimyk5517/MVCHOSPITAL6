package peaksoft.services;

import org.springframework.stereotype.Service;
import peaksoft.models.Department;
import peaksoft.models.Doctor;

import javax.print.Doc;
import java.util.Deque;
import java.util.List;


@Service
public interface DoctorService {
    List<Doctor> getAll(Long id);
    void save(Long hospitalId,Doctor doctor);

    Doctor findById(Long id);
    Doctor update(Long doctorId,Doctor doctor);
    void delete(Long id);
    List<Department> getAllDepartmentDoctorById(Long doctorId);

}
