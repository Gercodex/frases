package com.cursoalura.frases.controller;

import com.cursoalura.frases.dto.PeliculaDTO;
import com.cursoalura.frases.repositorio.PeliculaRepository;
import com.cursoalura.frases.servicios.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class Control {

    @Autowired
    private Servicio servicio;

    @GetMapping("/frases")
    public PeliculaDTO peliAleatorio() {
        return servicio.numeroAleatorioPelicula();
    }
}
