package com.igf.subsidiosv.beneficiario;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.igf.subsidiosv.beneficio.Beneficio;
import com.igf.subsidiosv.beneficio.BeneficioRepository;


@Controller
public class BeneficiarioController {
    
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private BeneficioRepository beneficioRepository;
    
   
    
    /*@GetMapping("/beneficiarios")
    public String nuevoBeneficiario(Model model){
        
        model.addAttribute("beneficiarios", new Beneficiario());

        return "beneficiarios/beneficiarios";
    }
    @PostMapping("/beneficiarios/guardar")
    public String guardarBeneficiario(Beneficiario beneficiario){
        beneficiarioRepository.save(beneficiario);
        return "redirect:/beneficiarios";
    }*/
    @GetMapping("/beneficiarios")
    public String listarBeneficiarios(Model model) {
        List<Beneficiario> listaBeneficiarios = beneficiarioRepository.findAll();
        model.addAttribute("listaBeneficiarios", listaBeneficiarios);
        return "beneficiarios/beneficiarios";
    }

    @GetMapping("/beneficiarionuevo")
    public String mostrarFormularioDeNuevoBeneficiario(Model model) {
        List<Beneficio> listaBeneficios = beneficioRepository.findAll();

        model.addAttribute("beneficiario", new Beneficiario());
        model.addAttribute("listaBeneficios", listaBeneficios);

        return "beneficiarios/beneficiarios_form";
    }

    @PostMapping("/beneficiarios/guardar")
    public String guardarBeneficiarios(Beneficiario beneficiario) {
        beneficiarioRepository.save(beneficiario);
        return "redirect:/usuarios";
    }

    @GetMapping("/beneficiarioeditar/{id}")
    public String mostrarFormularioDeEditarBeneficiario(Model model, @PathVariable Integer id) {
        List<Beneficio> listaBeneficios = beneficioRepository.findAll();

        Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);
        model.addAttribute("beneficiario", beneficiario);
        model.addAttribute("listaBeneficios", listaBeneficios);
        return "beneficiarios/beneficiarios_form";
    }

    @GetMapping("/beneficiarioeliminar/{id}")
    public String eliminarBeneficiario(Model model, @PathVariable Integer id) {
        beneficiarioRepository.deleteById(id);
        return "redirect:/beneficiarios";
    }

}
