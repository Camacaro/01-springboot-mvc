package com.jesus.cources.sprintboot.webapp.sprintbootweb.controllers;

import com.jesus.cources.sprintboot.webapp.sprintbootweb.models.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    /**
     * El @RequestParam es para poder recibir un queryParam con el nombre message
     * y hay que indicarle si es requerido o no
     *
     * @param message string
     * @return object
     */
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "valor por defecto") String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam String text, @RequestParam Integer code) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(text);
        paramDto.setCode(code);
        return paramDto;
    }

    /**
     * Por defecto no es requerido los queryParams con HttpServletRequest req
     * @param req string
     * @return object
     */
    @GetMapping("/request")
    public ParamDto request(HttpServletRequest req) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(req.getParameter("text"));
        int code = 0;
        try {
            code = Integer.parseInt(req.getParameter("code"));
        } catch (NumberFormatException ignored) {

        }
        paramDto.setCode(code);
        return paramDto;
    }
}
