package peaksoft.repositories;

import peaksoft.models.Doctor;

import java.util.List;


public interface DoctorRepo {
    List<Doctor> getAll();
    void save(Doctor doctor);
    Doctor findById(Long id);
    Doctor update(Doctor doctor);
    void delete(Long id);



}
