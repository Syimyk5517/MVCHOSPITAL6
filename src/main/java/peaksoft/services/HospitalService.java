package peaksoft.services;

import org.springframework.stereotype.Service;
import peaksoft.models.Hospital;

import java.util.List;


@Service
public interface HospitalService {
    List<Hospital> getAll();
    void save(Hospital hospital);
    Hospital findById(Long id);
    void deleteById(Long id);
    void ubdateHospital(Long id,Hospital newHospital);
}
