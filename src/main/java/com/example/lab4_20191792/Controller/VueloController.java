package com.example.lab4_20191792.Controller;

import com.example.lab4_20191792.Entity.Aerolinea;
import com.example.lab4_20191792.Entity.Vuelo;
import com.example.lab4_20191792.Repository.AerolineaRepository;
import com.example.lab4_20191792.Repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VueloController {

    @Autowired
    VueloRepository vueloRepository;
    @Autowired
    AerolineaRepository aerolineaRepository;

    @GetMapping("/vuelo")
        public String listaVuelo(Model model){
        List<Vuelo> listaVuelos = vueloRepository.findAll();
        List<Aerolinea> listaAerolinea = aerolineaRepository.aerolinea();
        model.addAttribute("listaVuelos", listaVuelos);
        model.addAttribute("listaAerolinea", listaAerolinea);
        return "usuario/homePage";
    }






}
