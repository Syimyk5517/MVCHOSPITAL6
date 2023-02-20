package peaksoft.services;

import org.springframework.stereotype.Service;
import peaksoft.models.Patient;

import java.util.List;


@Service
public interface PatientService {
    List<Patient> getAllPatient();
    void savePatient(Long hospitalId,Patient patient);
    void finById(Long id);
    void delete(Long id);
    Patient updatePatient(Patient patient);
}
