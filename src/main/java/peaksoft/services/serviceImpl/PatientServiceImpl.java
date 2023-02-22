package peaksoft.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.models.Hospital;
import peaksoft.models.Patient;
import peaksoft.repositories.HospitalRepo;
import peaksoft.repositories.PatientRepo;
import peaksoft.services.PatientService;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientRepo patientRepo;
    private final HospitalRepo hospitalRepo;

    @Override
    public List<Patient> getAllPatient(Long id) {
        return patientRepo.getAllPatient( id) ;
    }

    @Override
    public void savePatient(Long hospitalId,Patient patient) {
        Hospital hospital = hospitalRepo.findById(hospitalId);
        hospital.addPatient(patient);
        patient.setHospital(hospital);
        patientRepo.savePatient(patient);


    }

    @Override
    public void finById(Long id) {
    patientRepo.finById(id);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Patient updatePatient(Patient patient) {
        return null;
    }
}
