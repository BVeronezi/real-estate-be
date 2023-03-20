package com.brunsker.realestatebackend.model;

import com.brunsker.realestatebackend.utils.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String descricao;

    @NotNull
    private double valor;
    @NotNull
    private Type tipo;
    @NotNull
    private String cep;
    private String logradouro;
    private String bairro;
    @NotNull
    private String localidade;
    @NotNull
    private String uf;
}
