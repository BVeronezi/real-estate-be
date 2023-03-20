package com.brunsker.realestatebackend.utils;

import com.brunsker.realestatebackend.controller.dto.PropertyDto;
import com.brunsker.realestatebackend.model.Property;

public interface MapStructMapper {
    Property propertyPostDtoToProperty(PropertyDto propertyDto);

}
