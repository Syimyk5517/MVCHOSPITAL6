package peaksoft.services;

import org.springframework.stereotype.Service;
import peaksoft.models.Patient;

import java.util.List;


@Service
public interface PatientService {
    List<Patient> getAllPatient(Long id);
    void savePatient(Long hospitalId,Patient patient);
    Patient finById(Long id);
    void delete(Long id);
    Patient updatePatient(Long id,Patient patient);
}
