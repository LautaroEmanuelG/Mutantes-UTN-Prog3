package com.parcial_prog3.mutant;

import com.parcial_prog3.mutant.services.MutantDetector;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MutantApplicationTests {

	@Test
	void testArrayVacio() {
		String[] arrayVacio = {};
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			MutantDetector.isMutant(arrayVacio);
		});
		assertEquals("El array de ADN no puede estar vacío", exception.getMessage());
	}

	@Test
	void testArrayNxM() {
		String[] arrayNxM = {"ATGCA", "CAGTA", "TTATA", "AGAAG"};
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			MutantDetector.isMutant(arrayNxM);
		});
		assertEquals("El array de ADN debe ser NxN", exception.getMessage());
	}

	@Test
	void testArrayConNumeros() {
		String[] arrayConNumeros = {"1234", "5678", "9123", "4567"};
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			MutantDetector.isMutant(arrayConNumeros);
		});
		assertEquals("Una fila del array de ADN contiene caracteres inválidos", exception.getMessage());
	}

	@Test
	void testArrayNull() {
		String[] arrayNull = null;
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			MutantDetector.isMutant(arrayNull);
		});
		assertEquals("El array de ADN no puede ser null", exception.getMessage());
	}

	@Test
	void testArrayConNulls() {
		String[] arrayConNulls = {null, null, null, null};
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			MutantDetector.isMutant(arrayConNulls);
		});
		assertEquals("Una fila del array de ADN no puede ser null", exception.getMessage());
	}

	@Test
	void testArrayConLetrasInvalidas() {
		String[] arrayConLetrasInvalidas = {"BHGC", "BHGC", "BHGC", "BHGC"};
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			MutantDetector.isMutant(arrayConLetrasInvalidas);
		});
		assertEquals("Una fila del array de ADN contiene caracteres inválidos", exception.getMessage());
	}

	@Test
	void testMutante1() {
		String[] mutante1 = {"AAAA", "CCCC", "TCAG", "GGTC"};
		assertTrue(MutantDetector.isMutant(mutante1));
	}

	@Test
	void testMutante2() {
		String[] mutante2 = {"TGAC", "AGCC", "TGAC", "GGTC"};
		assertTrue(MutantDetector.isMutant(mutante2));
	}

	@Test
	void testMutante3() {
		String[] mutante3 = {"AAAA", "AAAA", "AAAA", "AAAA"};
		assertTrue(MutantDetector.isMutant(mutante3));
	}

	@Test
	void testNoMutante1() {
		String[] noMutante1 = {"TGAC", "ATCC", "TAAG", "GGTC"};
		assertFalse(MutantDetector.isMutant(noMutante1));
	}

	@Test
	void testNoMutante2() {
		String[] noMutante2 = {"AAAT", "AACC", "AAAC", "CGGG"};
		assertFalse(MutantDetector.isMutant(noMutante2));
	}

	@Test
	void testMutante4() {
		String[] mutante4 = {
				"TCGGGTGAT", "TGATCCTTT", "TACGAGTGA",
				"AAATGTACG", "ACGAGTGCT", "AGACACATG",
				"GAATTCCAA", "ACTACGACC", "TGAGTATCC"
		};
		assertTrue(MutantDetector.isMutant(mutante4));
	}

	@Test
	void testMutante5() {
		String[] mutante5 = {
				"TTTTTTTTT", "TTTTTTTTT", "TTTTTTTTT",
				"TTTTTTTTT", "CCGACCAGT", "GGCACTCCA",
				"AGGACACTA", "CAAAGGCAT", "GCAGTCCCC"
		};
		assertTrue(MutantDetector.isMutant(mutante5));
	}
}