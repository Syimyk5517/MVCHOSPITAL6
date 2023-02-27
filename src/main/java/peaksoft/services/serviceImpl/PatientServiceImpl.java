package peaksoft.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.models.Appointment;
import peaksoft.models.Hospital;
import peaksoft.models.Patient;
import peaksoft.repositories.AppointmentRepo;
import peaksoft.repositories.HospitalRepo;
import peaksoft.repositories.PatientRepo;
import peaksoft.services.PatientService;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientRepo patientRepo;
    private final HospitalRepo hospitalRepo;
    private final AppointmentRepo appointmentRepo;

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
    public Patient finById(Long id) {
     return patientRepo.finById(id);
    }

    @Override
    public void delete(Long id) {
        Patient patient = finById(id);
        Hospital hospital = patient.getHospital();
        List<Appointment> appointments = patient.getAppointments();
        appointments.forEach(appointment -> appointment.getPatient().setAppointments(null));
        appointments.forEach(appointment -> appointment.getDoctor().setAppointments(null));
        hospital.getAppointments().removeAll(appointments);
        for (int i = 0; i < appointments.size(); i++) {
            appointmentRepo.deleteById(appointments.get(i).getId());
        }
         patientRepo.delete(id);
    }

    @Override
    public Patient updatePatient(Long id,Patient patient) {
        Patient oldPatient = patientRepo.finById(id);
        oldPatient.setFirstName(patient.getFirstName());
        oldPatient.setLastName(patient.getLastName());
        oldPatient.setGender(patient.getGender());
        oldPatient.setEmail(patient.getEmail());
        oldPatient.setPhoneNumber(patient.getPhoneNumber());
        return patientRepo.updatePatient(oldPatient);
    }
}
