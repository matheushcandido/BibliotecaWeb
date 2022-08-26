package biblioteca.BibliotecaWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import biblioteca.BibliotecaWeb.models.Usuario;
import biblioteca.BibliotecaWeb.repositorio.UsuariosRepo;

@Controller
public class LoginController {

    @Autowired
    private UsuariosRepo repoUsu;

    @GetMapping("/login")
    public String index(){
        return "home/login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, Usuario usuParam){
        Usuario usu = this.repoUsu.Login(usuParam.getEmail(), usuParam.getSenha());
        if(usu != null){
            return "redirect:/";
        }

        model.addAttribute("erro", "Usuario ou senha inválidos");

        return "home/login/index";
    }
}
