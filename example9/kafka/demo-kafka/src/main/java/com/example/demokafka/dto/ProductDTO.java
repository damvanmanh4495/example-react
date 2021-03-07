package com.example.demokafka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;

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
