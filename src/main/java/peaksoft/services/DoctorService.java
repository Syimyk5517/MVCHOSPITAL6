package peaksoft.services;

import org.springframework.stereotype.Service;
import peaksoft.models.Doctor;

import javax.print.Doc;
import java.util.List;


@Service
public interface DoctorService {
    List<Doctor> getAll(Long id);
    void save(Long hospitalId,Doctor doctor);

    Doctor findById(Long id);
    Doctor update(Doctor doctor);
    void delete(Long id);

}
