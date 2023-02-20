package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.exception.Exception;
import peaksoft.models.Department;
import peaksoft.models.Patient;
import peaksoft.services.HospitalService;
import peaksoft.services.PatientService;

import java.util.List;

@Controller
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final HospitalService hospitalService;
    @GetMapping
    String getAllDepartments(Model model){
       List<Patient> patients = patientService.getAllPatient();
        model.addAttribute("patients",patients);
        return "patient/patients";
    }
    @PostMapping("/new")
    String create(@ModelAttribute("newPatient")Patient patient, @RequestParam("hospitalId") Long id) throws Exception {
          patientService.savePatient(id,patient);
        return "redirect:/patients";
    }
    @GetMapping("/savePatient")
    String save(Model model){
        model.addAttribute("patient",new Patient());
        model.addAttribute("hospitals",hospitalService.getAll());
        return "/patient/savePatient";
    }
}
