package com.example.demoproducer.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("code")
    @NotNull
    private String code;

    @JsonProperty("name")
    @NotNull
    private String name;

    private int number;

    private int numberSale;

}

