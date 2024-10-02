// src/main/java/com/parcial_prog3/mutant/models/DnaRecord.java
package com.parcial_prog3.mutant.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DnaRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Convert(converter = DnaConverter.class)
    private String[] dna;
    private boolean isMutant;
}