package com.jesus.cources.sprintboot.webapp.sprintbootweb.controllers;

import com.jesus.cources.sprintboot.webapp.sprintbootweb.models.User;
import com.jesus.cources.sprintboot.webapp.sprintbootweb.models.dto.ParamDto;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/pathvar")
public class PathVariableController {

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    /**
     * Usando postman POST http://localhost:3010/api/pathvar/create
     * {
     *     "name": "Jesus",
     *     "lastname": "Camacaro",
     *     "email": "jesus@mail.com"
     * }
     *
     * @param user User
     * @return User
     */
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        /**
         * Con el RequestBody se va a popular la data que llegue
         * lo importante es que en la clase User se tenga un constructor vacío
         * y los setters relacionados con los atributos
         */
        user.setName(user.getName().toUpperCase());
        return user;
    }
}
