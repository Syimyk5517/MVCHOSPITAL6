package peaksoft.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.models.Patient;
import peaksoft.repositories.PatientRepo;
import peaksoft.services.PatientService;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientRepo patientRepo;
    @Override
    public List<Patient> getAllPatient() {
        return patientRepo.getAllPatient();
    }

    @Override
    public void savePatient(Patient patient) {

    }
}
