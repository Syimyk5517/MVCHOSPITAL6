package peaksoft.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.exception.BadRequestExseption;
import peaksoft.exception.Exception;
import peaksoft.models.Appointment;
import peaksoft.models.Department;
import peaksoft.models.Doctor;
import peaksoft.models.Hospital;
import peaksoft.repositories.AppointmentRepo;
import peaksoft.repositories.DepartmentRepo;
import peaksoft.repositories.DoctorRepo;
import peaksoft.repositories.HospitalRepo;
import peaksoft.services.DepartmentService;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;
    private final HospitalRepo hospitalRepo;
    private final DoctorRepo doctorRepo;
    private final AppointmentRepo appointmentRepo ;

    @Override
    public List<Department> getAll(Long id) {
        return departmentRepo.getAll(id);
    }

    @Override
    @Transactional
    public void save(Long id, Department department) throws Exception {
        Hospital hospital = hospitalRepo.findById(id);
//      for (Department dep : departmentRepo.getAll(id)) {
//           if (dep.getName().equalsIgnoreCase(department.getName())) {
//              throw new BadRequestExseption("");
//           } else {
                hospital.addDepartment(department);
                department.setHospital(hospital);
                departmentRepo.save(department);
//          }
//      }
    }


    //        System.out.println("id = " + id);
//        System.out.println("department = " + department);
//        List<Department> departments = departmentRepo.getAll();
//            for (Department d:departments) {
//                if (d.getName().equalsIgnoreCase(department.getName())){
//                     throw new BadRequestExseption("qwerty");
//                }else {
//                     Hospital hospital = hospitalRepo.findById(id);
//                     hospital.addDepartment(department);
//                     department.setHospital(hospital);
//                     departmentRepo.save(department);
////
////                    System.out.println("department = " + department);
////                }
////            }
//    }
    @Override
    public Department finById(Long id) {
       return departmentRepo.finById(id);
    }

    @Override
    public void deleteById(Long id) {
      Department department = departmentRepo.finById(id);
      Hospital hospital = department.getHospital();
      List<Appointment> appointments = appointmentRepo.findAll(hospital.getId());
      List<Appointment> appointmentList = new ArrayList<>();
      for (Appointment appointment : appointments){
          if (appointment.getDepartment().getId().equals(id)){
              appointmentList.add(appointment);
          }
      }
      appointmentList.forEach(appointment -> appointment.getDoctor().setAppointments(null));
      appointmentList.forEach(appointment -> appointment.getPatient().setAppointments(null));
      hospital.getAppointments().removeAll(appointmentList);
        for (int i = 0; i < appointmentList.size(); i++) {
            appointmentRepo.deleteById(appointmentList.get(i).getId());
        }
        departmentRepo.deleteById(id);
    }

    @Override
    public void update(Long departmentId, Department department) {
        Department oldDepartment = finById(departmentId);;
        oldDepartment.setName(department.getName());
          departmentRepo.update(oldDepartment);
    }

    @Override
    public void assignDoctor(Long doctorId, Doctor doctor) {
        Department department = departmentRepo.finById(doctor.getDepartmentId());
        Doctor oldDoctor = doctorRepo.findById(doctorId);
        oldDoctor.addDepartment(department);
        department.addDoctor(doctor);
        departmentRepo.assignDoctor(oldDoctor);
    }
}
