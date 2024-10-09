package com.parcial_prog3.mutant.services;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MutantDetector {
    private static final int MIN_SEQUENCE_LENGTH = 4;
    private static final char[] BASES = {'A', 'T', 'C', 'G'};

    public static boolean isMutant(String[] dna) {
        if (dna == null) {
            throw new IllegalArgumentException("El array de ADN no puede ser null");
        }
        int n = dna.length;
        if (n == 0) {
            throw new IllegalArgumentException("El array de ADN no puede estar vacío");
        }
        for (String row : dna) {
            if (row == null) {
                throw new IllegalArgumentException("Una fila del array de ADN no puede ser null");
            }
            if (row.length() != n) {
                throw new IllegalArgumentException("El array de ADN debe ser NxN");
            }
            if (!row.matches("[ATCG]+")) {
                throw new IllegalArgumentException("Una fila del array de ADN contiene caracteres inválidos");
            }
        }

        int count = 0;

        // Check rows, columns, and diagonals
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j <= n - MIN_SEQUENCE_LENGTH && checkSequence(dna, i, j, 0, 1)) count++;
                if (i <= n - MIN_SEQUENCE_LENGTH && checkSequence(dna, i, j, 1, 0)) count++;
                if (i <= n - MIN_SEQUENCE_LENGTH && j <= n - MIN_SEQUENCE_LENGTH && checkSequence(dna, i, j, 1, 1)) count++;
                if (i <= n - MIN_SEQUENCE_LENGTH && j >= MIN_SEQUENCE_LENGTH - 1 && checkSequence(dna, i, j, 1, -1)) count++;
                if (count > 1) return true; // Early exit if more than one sequence is found
            }
        }
        return false;
    }

    private static boolean checkSequence(String[] dna, int row, int col, int rowInc, int colInc) {
        char base = dna[row].charAt(col);
        for (int k = 1; k < MIN_SEQUENCE_LENGTH; k++) {
            if (dna[row + k * rowInc].charAt(col + k * colInc) != base) {
                return false;
            }
        }
        return true;
    }
}