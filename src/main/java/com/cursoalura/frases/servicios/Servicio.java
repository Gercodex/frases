package com.cursoalura.frases.servicios;

import com.cursoalura.frases.dto.PeliculaDTO;
import com.cursoalura.frases.modelos.FrasePersonaje;
import com.cursoalura.frases.modelos.Pelicula;
import com.cursoalura.frases.modelos.Personaje;
import com.cursoalura.frases.repositorio.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Random;

@Service
public class Servicio {

    @Autowired
    private PeliculaRepository peliculaRepository;

    //NOTA: El máximo de peliculas es 7 (binario) si se desea generar random para una lista mayor incremente el valor de 3 (2^3 = 7)
    public PeliculaDTO numeroAleatorioPelicula() {
        BigInteger rango = peliculaRepository.muestraTotalItems();
        BigInteger numero;
        Optional<Pelicula> pelicula;
        Pelicula pelicula1 = null;
        boolean estado = true;
        while (estado) {
            numero = new BigInteger(3, new Random()); //2^3 = 7, se repite bucle al ser solo 5 películas de acuerdo con el total de items mas no el máximo valor de id.
            if (numero.compareTo(rango) < 0 || numero.compareTo(rango) == 0) {
                pelicula = peliculaRepository.findById(numero);
                if (pelicula.isPresent()) {
                    pelicula1 = pelicula.get();
                    estado = false;
                } else {
                    estado = true;
                }
            }
        }
        Personaje personaje = pelicula1.getPersonajeAleatorio();
        FrasePersonaje frasePersonaje = personaje.getFraseAleatoriaDePersonaje();
        PeliculaDTO peliculaDTO = new PeliculaDTO(pelicula1.getNombrePelicula(), personaje.getNombrePersonaje(), frasePersonaje.getFrase(), pelicula1.getPoster());

        return peliculaDTO;
    }

}
