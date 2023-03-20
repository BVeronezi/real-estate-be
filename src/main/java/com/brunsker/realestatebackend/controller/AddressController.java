package com.brunsker.realestatebackend.controller;

import com.brunsker.realestatebackend.model.Property;
import com.brunsker.realestatebackend.service.ViaCepService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/address")
@Tag(name = "Address", description = "Endpoints for managing address")
public class AddressController {

    @Autowired
    private ViaCepService service;

    @GetMapping("{zipCode}")
    public ResponseEntity<Object> getAddress(@PathVariable String zipCode) {
        Property property = service.getAddress(zipCode);

        return property != null ? ResponseEntity.ok().body(property) : ResponseEntity.notFound().build();
    }
}
