/*package com.cursoalura.frases;

import com.cursoalura.frases.principal.PrincipalConsola;
import com.cursoalura.frases.repositorio.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrasesApplicationConsola implements CommandLineRunner {

	@Autowired
	private PeliculaRepository peliculaRepository;

	public static void main(String[] args) {
		SpringApplication.run(FrasesApplicationConsola.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PrincipalConsola principalConsola = new PrincipalConsola(peliculaRepository);
		principalConsola.muestraElMenu();
	}
}*/
