package com.cursoalura.frases.modelos;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.List;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombrePelicula;
    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Personaje> personajeList;
    private String poster;

    public Pelicula() {
    }

    public Pelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public List<Personaje> getPersonajeList() {
        return personajeList;
    }

    public void setPersonajeList(List<Personaje> personajeList) {
        this.personajeList = personajeList;
    }

    public Personaje getPersonajeAleatorio() {
        Integer totalElementos = this.getPersonajeList().size();
        Integer indiceRandom = (int) (Math.random() * totalElementos);
        return this.personajeList.get(indiceRandom);
    }

}
