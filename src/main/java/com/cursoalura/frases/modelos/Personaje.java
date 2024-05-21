package com.cursoalura.frases.modelos;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombrePersonaje;
    @ManyToOne
    private Pelicula pelicula;
    @OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FrasePersonaje> frasesPeliculas;

    public Personaje() {
    }

    public Personaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public List<FrasePersonaje> getFrasesPeliculas() {
        return frasesPeliculas;
    }

    public void setFrasesPeliculas(List<FrasePersonaje> frasesPeliculas) {
        this.frasesPeliculas = frasesPeliculas;
    }

    @Override
    public String toString() {
        return nombrePersonaje;
    }

    public FrasePersonaje getFraseAleatoriaDePersonaje() {
        Integer totalElementos = this.frasesPeliculas.size();
        Integer indiceRandom = (int) (Math.random() * totalElementos);
        return this.frasesPeliculas.get(indiceRandom);
    }
}
