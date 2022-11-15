package com.igf.subsidiosv.subsidioaplicado;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.igf.subsidiosv.rol.Rol;
import com.igf.subsidiosv.rol.RolRepository;

@Controller
public class SubsidioAplicadoController {

    @Autowired
    private SubsidioAplicadoRepository subsidioaplicadoRepository;

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/subsidiosaplicados")
    public String listarSubsidiosAplicados(Model model) {
        List<SubsidioAplicado> listaSubsidiosAplicados = subsidioaplicadoRepository.findAll();
        model.addAttribute("listaSubsidiosAplicados", listaSubsidiosAplicados);

        return "subsidiosaplicados/subsidiosaplicados";
    }

}