package com.brunsker.realestatebackend.utils.impl;

import com.brunsker.realestatebackend.controller.dto.PropertyDto;
import com.brunsker.realestatebackend.model.Property;
import com.brunsker.realestatebackend.utils.MapStructMapper;
import org.springframework.stereotype.Component;

@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public Property propertyPostDtoToProperty(PropertyDto propertyDto) {
        if (propertyDto == null) {
            return null;
        }

        Property property = new Property();

        property.setId(propertyDto.getId());
        property.setDescricao(propertyDto.getDescricao());
        property.setTipo(propertyDto.getTipo());
        property.setValor(propertyDto.getValor());
        property.setLogradouro(propertyDto.getLogradouro());
        property.setCep(propertyDto.getCep());
        property.setBairro(propertyDto.getBairro());
        property.setLocalidade(propertyDto.getLocalidade());
        property.setUf(propertyDto.getUf());


        return property;
    }
}
