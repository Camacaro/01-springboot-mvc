package com.jesus.cources.sprintboot.webapp.sprintbootweb.controllers;

import com.jesus.cources.sprintboot.webapp.sprintbootweb.models.User;
import com.jesus.cources.sprintboot.webapp.sprintbootweb.models.dto.UserDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api") // Agregando un prefix a la ruta /details o las que se creen
public class UserRestController {
    /**
     *
     * Así como en el GetMapping hay también PostMapping,DeleteMapping, stc
     */
    @GetMapping("/details")
    public Map<String, Object> details() {
        User user = new User("Jesus", "Camacaro");
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "Hola Mundo Sprint boot");
        payload.put("user", user);
        return payload;
    }

    @RequestMapping(path = "/details-req", method = RequestMethod.GET)
    public Map<String, Object> detailsReq() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "Hola Mundo Sprint boot");
        payload.put("name", "Jesus");
        payload.put("lastname", "Camacaro");
        return payload;
    }

    /**
     * Usando DTO
     * Este es mejor de este modo podemos controlar que dato se devuelve hacia la UI
     * Transportar datos para formatear los datos, como monedas o time.
     * Devuelve las propiedades del objeto
     */
    @GetMapping("/details-dto")
    public UserDto detailsDto() {
        UserDto userDto = new UserDto();
        User user = new User("Jesus", "Camacaro");
        userDto.setUser(user);
        userDto.setTitle("Hola mundo Spring Boot");
        return userDto;
    }

    @GetMapping("/usersList")
    public List<User> userList() {
        User user = new User("Jesus", "Camacaro");
        User user2 = new User("Alejandro", "Zambrano");
        User user3 = new User("Oriana", "Castillo");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);

        // Otro método de Array Lis
        List<User> usersHelper = Arrays.asList(user, user2, user3);

        return users;
    }

}
