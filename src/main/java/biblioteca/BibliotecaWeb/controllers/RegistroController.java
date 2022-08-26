package biblioteca.BibliotecaWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import biblioteca.BibliotecaWeb.models.Usuario;
import biblioteca.BibliotecaWeb.repositorio.UsuariosRepo;

@Controller
public class RegistroController {
    
    @Autowired
    private UsuariosRepo usuRepo;

    @GetMapping("/registro")
    public String novoReg(){
        return "home/registro/index";
    }

    @PostMapping("/registro/registrar")
    public String registrar(Usuario usuario){
        usuRepo.save(usuario);
        return "redirect:/login";
    }
}
