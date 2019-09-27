package liftoffproject.futurevision.controllers;


import liftoffproject.futurevision.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class usercontroller {
    @Autowired
    private UserDao userDao;



}
