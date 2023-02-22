package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.exception.Exception;
import peaksoft.models.Department;
import peaksoft.models.Doctor;
import peaksoft.services.DepartmentService;
import peaksoft.services.DoctorService;

import java.util.List;

@Controller
@RequestMapping("/{id}/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    private final DepartmentService departmentService;

    @GetMapping
    String getAllDepartments(@PathVariable("id") Long id, Model model,@ModelAttribute("department")Department department){
        model.addAttribute("doctors",doctorService.getAll(id));
        model.addAttribute("departments",departmentService.getAll(id));
        model.addAttribute("hospitalId",id);
        return "doctor/doctors";
    }
    @GetMapping("/saveDoctor")
    String save(Model model,@PathVariable("id")Long id){
        model.addAttribute("doctor",new Doctor());
        model.addAttribute("hospitalId",id);
        return "/doctor/saveDoctor";
    }
    @PostMapping("/new")
    String create(@ModelAttribute("doctor")Doctor doctor, @PathVariable("id") Long id) {
        doctorService.save(id,doctor);
        return "redirect:/{id}/doctors";
    }
    @PostMapping("/{doctorId}/{department}/assignDoctor")
    String assignDoctor(@PathVariable("doctorId")Long doctorId,@ModelAttribute("department") Department department){
          departmentService.assignDoctor(doctorId, department.getId()  );
        return "redirect:/doctors/"+doctorId;
    }
}