package biblioteca.BibliotecaWeb.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import biblioteca.BibliotecaWeb.models.Agenda;
import biblioteca.BibliotecaWeb.repositorio.AgendasRepo;

@Controller
public class AgendaController {

    @Autowired
    private AgendasRepo repo;

    @GetMapping("/agenda")
    public String index(Model model){

        List<Agenda> agendas = (List<Agenda>)repo.findAll();

        model.addAttribute("agendas", agendas);
        return "home/agenda/index";
    }

    @GetMapping("/agenda/novo")
    public String novo(){
        return "home/agenda/novo";
    }

    @PostMapping("/agenda/criar")
    public String criar(Agenda agenda){
        repo.save(agenda);
        return "redirect:/agenda";
    }

    @GetMapping("/agenda/{id}")
    public String busca(@PathVariable int id, Model model){
        Optional<Agenda> agend = repo.findById(id);
        model.addAttribute("agenda", agend.get());
        return "home/agenda/editar";
    }

    @PostMapping("/agenda/{id}/atualizar")
    public String busca(@PathVariable int id, Agenda agenda){

        if(!repo.exist(id)){
            return "redirect:/agenda";
        }

        repo.save(agenda);

        return "redirect:/agenda";
    }

    @GetMapping("/agenda/{id}/excluir")
    public String excluir(@PathVariable int id){
        repo.deleteById(id);
        return "redirect:/agenda";
    }
}
