package com.parcial_prog3.mutant.controllers;

import com.parcial_prog3.mutant.dto.DnaRequest;
import com.parcial_prog3.mutant.dto.DnaResponse;
import com.parcial_prog3.mutant.services.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class MutantController {

    @Autowired
    private DnaService dnaService;

    @PostMapping("/")
    public ResponseEntity<DnaResponse> checkMutant(@RequestBody DnaRequest dnaRequest) {
        boolean isMutant = dnaService.isMutant(dnaRequest.getDna());
        DnaResponse response = new DnaResponse(isMutant, isMutant ? "Mutant detected" : "Not a mutant");
        return new ResponseEntity<>(response, isMutant ? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }
}