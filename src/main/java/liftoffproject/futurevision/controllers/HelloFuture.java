package liftoffproject.futurevision.controllers;

import liftoffproject.futurevision.models.Client;
import liftoffproject.futurevision.models.data.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("future")
public class HelloFuture {

    @Autowired
    private ClientDao clientDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("clients", clientDao.findAll());
        model.addAttribute("title", "Future Vision");

        return "future/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddClientForm(Model model){
        model.addAttribute("title", "Add Client");
        model.addAttribute(new Client());
        return "future/add";
    }
    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddClientForm(@ModelAttribute @Valid Client newClient,
                                       Errors errors, Model model){
        clientDao.save(newClient);
        return "redirect:";

    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveClientForm(Model model){
        model.addAttribute("clients", clientDao.findAll());
        model.addAttribute("title", "Remove Client");
        return "future/remove";
    }
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveClientForm(@RequestParam int[] clientIds){

        for (int clientId : clientIds){
            clientDao.deleteById(clientId);
        }

        return "redirect:";
    }

}
