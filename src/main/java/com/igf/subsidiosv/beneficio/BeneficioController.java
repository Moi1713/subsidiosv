package com.igf.subsidiosv.beneficio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BeneficioController{
    @Autowired
    private BeneficioRepository beneficioRepository;
    
    
   /*  @GetMapping("/beneficios")
public String nuevaBeneficio(Model model){
    model.addAttribute("beneficios", new Beneficio());

    return "beneficios/beneficios";

}


    @PostMapping("/beneficios/guardar")
    public String guadarBeneficios(Beneficio beneficio){

        beneficioRepository.save(beneficio);

        return "redirect:/beneficios";
    }*/
    @GetMapping("/beneficios")
    public String listarBeneficios(Model model) {
        List<Beneficio> listaBeneficios = beneficioRepository.findAll();
        model.addAttribute("listaBeneficios", listaBeneficios);
        return "beneficios/beneficios";
    }

    @GetMapping("/beneficionuevo")
    public String mostrarFormularioDeNuevoBeneficio(Model model) {
        model.addAttribute("beneficio", new Beneficio());
        return "beneficios/beneficios_form";
    }

    @PostMapping("/beneficios/guardar")
    public String guardarBeneficio(Beneficio beneficio) {
        beneficioRepository.save(beneficio);
        return "redirect:/beneficios";
    }

    @GetMapping("/beneficioeditar/{id}")
    public String mostrarFormularioDeEditarBeneficio(Model model, @PathVariable Integer id) {
        
        Optional<Beneficio> beneficio = beneficioRepository.findById(id);
        model.addAttribute("beneficio", beneficio);
        return "beneficios/beneficios_form";
    }

    @GetMapping("/beneficioeliminar/{id}")
    public String eliminarBeneficio(Model model, @PathVariable Integer id) {
        beneficioRepository.deleteById(id);
        return "redirect:/beneficios";
    }

}
