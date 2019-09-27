package liftoffproject.futurevision.controllers;

import liftoffproject.futurevision.models.data.BookvisitsDao;
import liftoffproject.futurevision.models.data.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookvisit")
public class bookvisitscontroller {
    @Autowired
    private BookvisitsDao bookvisitsDao;

    @Autowired
    private ClientDao clientDao;

    @RequestMapping(value = "book-visit")
    public String index(Model model){

        model.addAttribute("clients", clientDao.findAll());
        model.addAttribute("title", "Book A Visit");

        return "bookvisit/index";
    }
}
