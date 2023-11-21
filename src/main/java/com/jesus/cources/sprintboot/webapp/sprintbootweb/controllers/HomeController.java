package com.jesus.cources.sprintboot.webapp.sprintbootweb.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "redirect:/udemy/index";
    }

    @GetMapping("/redirect-website")
    public String website() {
        return "redirect:https://www.google.com";
    }

    /**
     * Con el forward lo que hace es redireccionar el contenido que esta en
     * /udemy/index pero sin cambiar el nombre de la URL
     *
     * Solo funciona para los metodos del sprint
     * @return string
     */
    @GetMapping("/forward-website")
    public String forward() {
        return "forward:/udemy/index";
    }
}
