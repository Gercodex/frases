package com.cursoalura.frases.modelos;

import jakarta.persistence.*;

@Entity
public class FrasePersonaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Personaje personaje;
    @Column(unique = true)
    private String frase;

    public FrasePersonaje() {
    }

    public FrasePersonaje(String frase, Personaje personaje) {
        this.frase = frase;
        this.personaje = personaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
}
