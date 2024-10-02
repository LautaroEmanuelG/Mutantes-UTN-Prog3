package com.parcial_prog3.mutant.services;

import com.parcial_prog3.mutant.models.DnaRecord;
import com.parcial_prog3.mutant.repositories.DnaRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DnaService {

    @Autowired
    private DnaRecordRepository dnaRecordRepository;

    public boolean isMutant(String[] dna) {
        // Lógica de detección de mutantes (usando MutantDetector)
        boolean isMutant = MutantDetector.isMutant(dna);

        // Guardar el registro en la base de datos
        if (!dnaRecordRepository.existsByDna(dna)) {
            DnaRecord dnaRecord = new DnaRecord();
            dnaRecord.setDna(dna);
            dnaRecord.setMutant(isMutant);
            dnaRecordRepository.save(dnaRecord);
        }

        return isMutant;
    }
}