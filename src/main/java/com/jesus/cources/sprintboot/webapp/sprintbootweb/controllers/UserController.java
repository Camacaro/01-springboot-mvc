package com.jesus.cources.sprintboot.webapp.sprintbootweb.controllers;

import com.jesus.cources.sprintboot.webapp.sprintbootweb.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    /*
        Con esta anotación GetMapping decimos que la func details va a manejar
        una petición rest get

        Importamos el Model que es para manejar las variables hacia la vista,
        en vez de usar Model también podemos usar el Map<string, Object>
     */
    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("title", "Hola Mundo Sprint boot");
        model.addAttribute("name", "Jesus");
        model.addAttribute("lastname", "Camacaro");
        /*
            Thymeleaf

            En este caso vamos a devolver un string debido a que como vamos a practicar con
            thymeleaf para devolver vistas del lado del servidor tenemos que poner el nombre
            de la plantilla
         */
        return "details";
    }

    @GetMapping("/details-obj")
    public String detailsObj(Model model) {
        User user = new User("Jesus", "Camacaro");
        model.addAttribute("title", "Hola Mundo Sprint boot");
        model.addAttribute("user", user);
        /*
            y accedo como user.name
         */
        return "details-obj";
    }

    /**
     * ModelMap es lo mismo que un model, pero con un map interno
     */
    @GetMapping("/list")
    public String list(ModelMap model) {
        List<User> users = Arrays.asList(
                new User("Jesus", "camacaro"),
                new User("Oriana", "castillo", "orianacmujica@mail.com"),
                new User("Alejandro", "Zambrano")
        );
        model.addAttribute("users", users);
        model.addAttribute("title", "Listado de Usuarios");
        return "list";
    }

    /**
     * Un atributo de modelo es para poder pasar a la vista
     * esa variable con datos si en list(ModelMap model) eliminados
     * users el template "list" va a poder seguir reconociendo "users"
     * ya, que se declaró un @ModelAttribute("users")
     * se puede usar en cualquier método, cualquier plantilla
     */
    @ModelAttribute("users")
    public List<User> usersModel() {
        return Arrays.asList(
                new User("Jesus", "camacaro2"),
                new User("Oriana", "castillo2", "orianacmujica@mail.com"),
                new User("Alejandro", "Zambrano2")
        );
    }
}
