package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.models.Hospital;
import peaksoft.services.HospitalService;

import java.util.List;

@Controller
@RequestMapping("/hospitals")
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService hospitalService;

    @GetMapping
    String getAll(Model model){
        List<Hospital> hospitals = hospitalService.getAll();
        model.addAttribute("hospitals",hospitals);
        return "hospital/hospitals";
    }
}
