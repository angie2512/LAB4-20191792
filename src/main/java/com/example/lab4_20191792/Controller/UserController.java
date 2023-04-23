package com.example.lab4_20191792.Controller;

import com.example.lab4_20191792.Entity.User;
import com.example.lab4_20191792.Repository.UsuarioRepository;
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
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/inicio")
    public String Inicio() {
        return "usuario/inicio";
    }

    @PostMapping(value = "/registrousuario")
    public String Registro(Model model, @RequestParam (name = "correo") String correo, @RequestParam (name="contrasena") String contrasena){

        if(usuarioRepository.findByEmailAndPassword(correo,contrasena) > 0){
            return "redirect:/vuelo";
        }else{
            return "redirect:/inicio";
        }
    }

}
