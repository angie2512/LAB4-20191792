package com.example.lab4_20191792.Controller;

import com.example.lab4_20191792.Entity.Reserva;
import com.example.lab4_20191792.Entity.Vuelo;
import com.example.lab4_20191792.Repository.ReservaRepository;
import com.example.lab4_20191792.Repository.UsuarioRepository;
import com.example.lab4_20191792.Repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

@Controller
public class ReservaController {

    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    private VueloRepository vueloRepository;

    @GetMapping ("/comprarVuelo")
    public String comprarVuelo(@RequestParam("idUser") int idUsuario, @RequestParam("idVuelo") int idVuelo){
        Optional<Vuelo> vueloopt = vueloRepository.findById(idVuelo);
        Vuelo vuelo = vueloopt.get();
        Reserva reserva = new Reserva();
        reserva.setPrecioTotal(vuelo.getPrecio());
        reserva.setEstadoPago("procesado");
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        reserva.setFechaReserva(timestamp);
        reserva.setUser(usuarioRepository.findById(idUsuario).get());
        reserva.setVuelo(vuelo);
        reservaRepository.save(reserva); ///guarda en bd
        return "usuario/homePage2";
    }
}
