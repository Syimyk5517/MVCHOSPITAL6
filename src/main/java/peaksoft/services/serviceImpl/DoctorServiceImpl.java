package peaksoft.services.serviceImpl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.services.DoctorService;


@Service
@RequiredArgsConstructor
@Transactional
public class DoctorServiceImpl implements DoctorService {
}
