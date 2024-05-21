package com.cursoalura.frases.repositorio;

import com.cursoalura.frases.modelos.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.Optional;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    @Query("SELECT COUNT(p.id) FROM Pelicula p")
    BigInteger muestraTotalItems();

    Optional<Pelicula> findById(BigInteger numero);
}
