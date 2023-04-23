package com.example.lab4_20191792.Controller;

import com.example.lab4_20191792.Entity.Reserva;
import com.example.lab4_20191792.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReservaController {

    @Autowired
    ReservaRepository reservaRepository;

    @PostMapping ("/comprarVuelo")
    public String comprarVuelo(Reserva reserva){
        reservaRepository.save(reserva);
        return "redirect:/usuario/homePage";
    }



}
