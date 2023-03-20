package com.brunsker.realestatebackend.controller.dto;

import com.brunsker.realestatebackend.utils.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDto {
    private Long id;
    private String descricao;
    private Double valor;
    private Type tipo;
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
