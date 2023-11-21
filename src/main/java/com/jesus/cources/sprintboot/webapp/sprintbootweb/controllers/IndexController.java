package com.jesus.cources.sprintboot.webapp.sprintbootweb.controllers;

import com.jesus.cources.sprintboot.webapp.sprintbootweb.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/udemy")
public class IndexController {

    @Value("${texto.indexcontroller.index.title}")
    private String textoIndexFromProperties;

    @Value("${mivalordesdepropiedades}")
    private String titleStyle;

    /**
     * Esta variable viene de otro archivo de properties
     * src/main/resources/texts.properties
     * Configurado en TextPropertiesConfig
     */
    @Value("${othertexttitle}")
    private String titleOtherFileProperty;

    @GetMapping({"/home", "/", "", "/index"})
    public String index() {

        return "index";
    }

    @GetMapping("/style")
    public String style(Model model) {
        model.addAttribute("title", titleStyle);
        model.addAttribute("titleOtherFile", titleOtherFileProperty);
        return "template-style";
    }


    /**
     * Se puede usar Model(es la que más se usa), MadelMap, Map<String, Object> y ModelAndView
     * @param model Model | MadelMap | Map<String, Object> | ModelAndView
     * @return string
     */
    @GetMapping({"/home-data", "/data", "/index-data"})
    public String indexWithData(Model model) {
        model.addAttribute("title", "Spring Boot");
        model.addAttribute("title2", textoIndexFromProperties);

        return "index";
    }

    @RequestMapping("/profile")
    public String ProfileModel(Model model) {
        User user = new User();
        user.setName("Jesus");
        user.setLastname("Camacaro");
        model.addAttribute("user", user);
        model.addAttribute("title", "Perfil");
        model.addAttribute("profileName", "Mi Perfil: ".concat(user.getName()));
        return "profile/index";
    }
}
