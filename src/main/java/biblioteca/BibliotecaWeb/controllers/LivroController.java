package biblioteca.BibliotecaWeb.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import biblioteca.BibliotecaWeb.models.Livro;
import biblioteca.BibliotecaWeb.repositorio.LivrosRepo;

@Controller
public class LivroController {
    
    @Autowired
    private LivrosRepo repoLi;

    @GetMapping("/livro")
    public String index(Model model){

        List<Livro> livros = (List<Livro>)repoLi.findAll();

        model.addAttribute("livros", livros);
        return "home/livro/index";
    }

    @GetMapping("/livro/novo")
    public String novo(){
        return "home/livro/novo";
    }

    @PostMapping("/livro/criar")
    public String criar(Livro livro){
        repoLi.save(livro);
        return "redirect:/livro";
    }

    @GetMapping("/livro/{id}")
    public String busca(@PathVariable int id, Model model){
        Optional<Livro> livr = repoLi.findById(id);
        model.addAttribute("livro", livr.get());
        return "home/livro/editar";
    }

    @PostMapping("/livro/{id}/atualizar")
    public String busca(@PathVariable int id, Livro livro){

        if(!repoLi.exist(id)){
            return "redirect:/livro";
        }

        repoLi.save(livro);

        return "redirect:/livro";
    }

    @GetMapping("/livro/{id}/excluir")
    public String excluir(@PathVariable int id){
        repoLi.deleteById(id);
        return "redirect:/livro";
    }
}
