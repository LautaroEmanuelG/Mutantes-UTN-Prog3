package com.parcial_prog3.mutant;

import com.parcial_prog3.mutant.services.MutantDetector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MutantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutantApplication.class, args);
	}

	@Bean
	public org.springframework.boot.web.server.WebServerFactoryCustomizer<org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory> containerCustomizer(Environment environment) {
		return factory -> {
			String port = environment.getProperty("PORT");
			if (port != null) {
				factory.setPort(Integer.parseInt(port));
			} else {
				factory.setPort(8080); // Default to port 8080 if PORT is not set
			}
		};
	}
}

/*
//Array vacio Pruebas Unitarias en Main, fueron movidas a Test
		try {
			String[] arrayVacio = {};
			MutantDetector.isMutant(arrayVacio);
			System.out.println("Error: no se lanzó excepción para el array vacío.");
		} catch (Exception e) {
			System.out.println("Manejo de error 1: " + e.getMessage());
		}

		//Array NxM
		try {
			String[] arrayNxM = {"ATGCA", "CAGTA", "TTATA", "AGAAG"};
			MutantDetector.isMutant(arrayNxM);
			System.out.println("Error: no se lanzó excepción para un array NxM.");
		} catch (Exception e) {
			System.out.println("Manejo de error 2: " + e.getMessage());
		}

		//Array con numero como strings
		try {
			String[] arrayConNumeros = {"1234", "5678", "9123", "4567"};
			MutantDetector.isMutant(arrayConNumeros);
			System.out.println("Error: no se lanzó excepción para un array con números como strings.");
		} catch (Exception e) {
			System.out.println("Manejo de error 3: " + e.getMessage());
		}

		//Array nulo
		try {
			String[] arrayNull = null;
			MutantDetector.isMutant(arrayNull);
			System.out.println("Error: no se lanzó excepción para el array nulo.");
		} catch (Exception e) {
			System.out.println("Manejo de error 4: " + e.getMessage());
		}

		//Array de NxN con nulls
		try {
			String[] arrayConNulls = {null, null, null, null};
			MutantDetector.isMutant(arrayConNulls);
			System.out.println("Error: no se lanzó excepción para el array con nulls.");
		} catch (Exception e) {
			System.out.println("Manejo de error 5: " + e.getMessage());
		}

		//Array con letras distintas a las propuestas
		try {
			String[] arrayConLetrasInvalidas = {"BHGC", "BHGC", "BHGC", "BHGC"};
			MutantDetector.isMutant(arrayConLetrasInvalidas);
			System.out.println("Error: no se lanzó excepción para un array con letras no válidas.");
		} catch (Exception e) {
			System.out.println("Manejo de error 6: " + e.getMessage());
		}

		//Caso de prueba 1 - MUTANTE
		try {
			String[] mutante1 = {"AAAA", "CCCC", "TCAG", "GGTC"};
			boolean resultado = MutantDetector.isMutant(mutante1);
			System.out.println("Prueba Unitaria 1: " + (resultado ? "Es mutante" : "No es mutante"));
		} catch (Exception e) {
			System.out.println("Error en la prueba 1: " + e.getMessage());
		}

		//Caso de prueba 2 - MUTANTE
		try {
			String[] mutante2 = {"TGAC", "AGCC", "TGAC", "GGTC"};
			boolean resultado = MutantDetector.isMutant(mutante2);
			System.out.println("Prueba Unitaria 2: " + (resultado ? "Es mutante" : "No es mutante"));
		} catch (Exception e) {
			System.out.println("Error en la prueba 2: " + e.getMessage());
		}

		//Caso de prueba 3 - MUTANTE
		try {
			String[] mutante3 = {"AAAA", "AAAA", "AAAA", "AAAA"};
			boolean resultado = MutantDetector.isMutant(mutante3);
			System.out.println("Prueba Unitaria 3: " + (resultado ? "Es mutante" : "No es mutante"));
		} catch (Exception e) {
			System.out.println("Error en la prueba 3: " + e.getMessage());
		}

		//Caso de prueba 4 - NO MUTANTE
		try {
			String[] noMutante1 = {"TGAC", "ATCC", "TAAG", "GGTC"};
			boolean resultado = MutantDetector.isMutant(noMutante1);
			System.out.println("Prueba Unitaria 4: " + (resultado ? "Es mutante" : "No es mutante"));
		} catch (Exception e) {
			System.out.println("Error en la prueba 4: " + e.getMessage());
		}

		//Caso de prueba 5 - NO MUTANTE
		try {
			String[] noMutante2 = { "AAAT", "AACC","AAAC","CGGG"};
			boolean resultado = MutantDetector.isMutant(noMutante2);
			System.out.println("Prueba Unitaria 5: " + (resultado ? "Es mutante" : "No es mutante"));
		} catch (Exception e) {
			System.out.println("Error en la prueba 5: " + e.getMessage());
		}

		//Caso de prueba 6 - MUTANTE
		try {
			String[] mutante4 = {
					"TCGGGTGAT", "TGATCCTTT", "TACGAGTGA",
					"AAATGTACG", "ACGAGTGCT", "AGACACATG",
					"GAATTCCAA", "ACTACGACC", "TGAGTATCC"
			};
			boolean resultado = MutantDetector.isMutant(mutante4);
			System.out.println("Prueba Unitaria 6: " + (resultado ? "Es mutante" : "No es mutante"));
		} catch (Exception e) {
			System.out.println("Error en la prueba 6: " + e.getMessage());
		}

		//Caso de prueba 7
		try {
			String[] mutante5 = {
					"TTTTTTTTT", "TTTTTTTTT", "TTTTTTTTT",
					"TTTTTTTTT", "CCGACCAGT", "GGCACTCCA",
					"AGGACACTA", "CAAAGGCAT", "GCAGTCCCC"
			};
			boolean resultado = MutantDetector.isMutant(mutante5);
			System.out.println("Prueba Unitaria 7: " + (resultado ? "Es mutante" : "No es mutante"));
		} catch (Exception e) {
			System.out.println("Error en la prueba 7: " + e.getMessage());
		}
 */