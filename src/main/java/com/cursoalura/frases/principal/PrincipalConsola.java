package com.cursoalura.frases.principal;


import com.cursoalura.frases.modelos.FrasePersonaje;
import com.cursoalura.frases.modelos.Pelicula;
import com.cursoalura.frases.modelos.Personaje;
import com.cursoalura.frases.repositorio.PeliculaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConsola {

    Scanner teclado = new Scanner(System.in);

    private PeliculaRepository peliculaRepository;
    public PrincipalConsola(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public void muestraElMenu() {
        Boolean bucle = true;
        Integer seleccion;
        while (bucle) {
            String menu = """
                1 - Agregar frase de película.
                0 - Salir.
                """;
            System.out.println(menu);
            seleccion = teclado.nextInt();
            teclado.nextLine();
            switch (seleccion) {
                case 1:
                    agregarFrasePelicula();
                    break;
                case 0:
                    bucle = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

    }

    private void agregarFrasePelicula() {
        List<Personaje> personajes = new ArrayList<>();
        System.out.println("Escribe el nombre de la película:");
        String nombrePelicula = teclado.nextLine();
        Pelicula pelicula = new Pelicula(nombrePelicula);
        String nombrePersonaje;
        String frasePersonaje;
        boolean bucle = true;
        while (bucle) {
            List<FrasePersonaje> frasesPersonaje = new ArrayList<>();
            System.out.println("Escribe el nombre del personaje perteneciente a la película:");
            nombrePersonaje = teclado.nextLine();
            Personaje personaje = new Personaje(nombrePersonaje);
            personaje.setPelicula(pelicula);
            boolean bucle_b = true;
            while (bucle_b) {
                System.out.println("Escribe una frase del personaje:");
                frasePersonaje = teclado.nextLine();
                FrasePersonaje frasePersonaje1 = new FrasePersonaje(frasePersonaje, personaje);
                frasesPersonaje.add(frasePersonaje1);
                System.out.println("Agregar otra frase? para continuar escriba 1. Para salir 0");
                int salir = teclado.nextInt();
                teclado.nextLine();
                switch (salir) {
                    case 1:
                        System.out.println("...");
                        break;
                    case 0:
                        System.out.println("Ha terminado de escribir las frases de personaje");
                        bucle_b = false;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }
            personaje.setFrasesPeliculas(frasesPersonaje);
            personajes.add(personaje);
            System.out.println("Agregar otro personaje? para continuar escriba 1. Para salir 0");
            int salir = teclado.nextInt();
            teclado.nextLine();
            switch (salir) {
                case 1:
                    System.out.println("...");
                    break;
                case 0:
                    System.out.println("Ha terminado de agregar personajes de la pelicula");
                    bucle = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        }
        pelicula.setPersonajeList(personajes);
        System.out.println("Escriba la url de la portada:");
        String poster = teclado.nextLine();
        pelicula.setPoster(poster);
        peliculaRepository.save(pelicula);
    }

}
