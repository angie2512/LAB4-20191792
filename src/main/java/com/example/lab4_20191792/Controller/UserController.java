package com.example.lab4_20191792.Controller;

import com.example.lab4_20191792.Entity.Aerolinea;
import com.example.lab4_20191792.Entity.User;
import com.example.lab4_20191792.Entity.Vuelo;
import com.example.lab4_20191792.Repository.AerolineaRepository;
import com.example.lab4_20191792.Repository.UsuarioRepository;
import com.example.lab4_20191792.Repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class UserController {
    @Autowired
    VueloRepository vueloRepository;

    @Autowired
    AerolineaRepository aerolineaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/inicio")
    public String Inicio() {
        return "usuario/inicio";
    }

    @PostMapping(value = "/registrousuario")
    public String Registro(Model model, @RequestParam (name = "correo") String correo, @RequestParam (name="contrasena") String contrasena){
        User user = usuarioRepository.findByEmailAndPassword(correo,contrasena);
        if(user != null){
            model.addAttribute("usuario",user);
            List<Vuelo> listaVuelos = vueloRepository.findAll();
            model.addAttribute("listaVuelos", listaVuelos);
            return "usuario/homePage";
        }else{
            return "redirect:/inicio";
        }
    }

}
