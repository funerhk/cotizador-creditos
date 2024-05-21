package com.cotizador.controller;

import com.cotizador.entity.dto.QuoterDto;
import com.cotizador.entity.model.QuoterResponse;
import com.cotizador.service.interfaces.QuoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quoter")
public class QuoterController {
    @Autowired
    private QuoterService service;

    @PostMapping("/calculate")
    public ResponseEntity<QuoterResponse> calculate(@RequestBody QuoterDto quoterDto) {
        return ResponseEntity.ok(service.findPrice(quoterDto));
    }

}
