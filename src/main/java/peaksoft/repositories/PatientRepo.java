package peaksoft.repositories;

import org.springframework.stereotype.Repository;
import peaksoft.models.Patient;

import java.util.List;


@Repository
public interface PatientRepo {
    List<Patient> getAllPatient();
    void savePatient(Patient patient);

}
