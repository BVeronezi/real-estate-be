package com.brunsker.realestatebackend.controller;

import com.brunsker.realestatebackend.controller.dto.PropertyDto;
import com.brunsker.realestatebackend.exception.ResourceNotFoundException;
import com.brunsker.realestatebackend.model.Property;
import com.brunsker.realestatebackend.repository.PropertyRepository;
import com.brunsker.realestatebackend.utils.MapStructMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/property")
@Tag(name = "Property", description = "Endpoints for managing property")
public class PropertyController {
    private MapStructMapper mapstructMapper;
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    public PropertyController(
            MapStructMapper mapstructMapper
    ) {
        this.mapstructMapper = mapstructMapper;
    }

    @GetMapping
    public List<Property> getAllProperty(){
        return propertyRepository.findAll();
    }

    @PostMapping
    public Property createproperty(@RequestBody PropertyDto propertyDto) {
        return propertyRepository.save(
                mapstructMapper.propertyPostDtoToProperty(propertyDto)
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable long id){
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not exist with id:" + id));
        return ResponseEntity.ok(property);
    }

    @PutMapping("{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable long id, @RequestBody PropertyDto propertyDto) {
        Property updateProperty = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not exist with id: " + id));

        updateProperty.setDescricao(propertyDto.getDescricao());
        updateProperty.setValor(propertyDto.getValor());
        updateProperty.setTipo(propertyDto.getTipo());
        updateProperty.setCep(propertyDto.getCep());
        updateProperty.setLogradouro(propertyDto.getLogradouro());
        updateProperty.setBairro(propertyDto.getBairro());
        updateProperty.setLocalidade(propertyDto.getLocalidade()  );
        updateProperty.setUf(propertyDto.getUf());

        propertyRepository.save(updateProperty);

        return ResponseEntity.ok(updateProperty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProperty(@PathVariable long id){

        Property employee = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not exist with id: " + id));

        propertyRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
