package com.igf.subsidiosv.consumo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.ui.Model;

@Controller
public class ConsumoController {
    @Autowired 
    private ConsumoRepository consumoRepository;

    @GetMapping("/consumo")
    public String nuevoConsumo(Model model){
        List<Consumo> listaConsumos = consumoRepository.findAll(); 
        model.addAttribute("listaConsumos", listaConsumos);

        return "consumo/consumo";

    }

    @PostMapping("/consumo/guardar")
    public String guadarConsumo(Consumo consumo){
        consumoRepository.save(consumo);
        return "redirect:/consumo";

    }

}
