package liftoffproject.futurevision.controllers;

import liftoffproject.futurevision.models.Client;
import liftoffproject.futurevision.models.data.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.xml.crypto.dsig.Reference;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("future")
public class clientcontroller {

    @Autowired
    private ClientDao clientDao;


    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("clients", clientDao.findAll());
        model.addAttribute("title", "Future Vision");

        return "future/index";
    }

    //adds client to database
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddClientForm(Model model){
        model.addAttribute("title", "Add Client");
        model.addAttribute(new Client());
        return "future/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddClientForm(@ModelAttribute @Valid Client newClient,
                                       Errors errors, Model model ){

        //sets the future visit property
        LocalDate date = newClient.getLastvisit();
        newClient.setFuturevisit(date.plusDays(90));

        clientDao.save(newClient);
        return "redirect:";

    }
    //removes client from database
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveClientForm(Model model){
        model.addAttribute("clients", clientDao.findAll());
        model.addAttribute("title", "Remove Client");
        return "future/remove";
    }
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveClientForm(@RequestParam int[] clientId){

        for (int client : clientId){
            clientDao.deleteById(client);
        }

        return "redirect:";
    }

    //individual client page
    @RequestMapping(value = "client-page/{clientId}", method = RequestMethod.GET)
    public String clientpage(Model model, @PathVariable int clientId){

        Optional<Client> optionalClient = clientDao.findById(clientId);
        Client client = optionalClient.get();


      model.addAttribute("title", "Client Page");
      model.addAttribute("client", client);

      return "future/client-page";
    }
}
