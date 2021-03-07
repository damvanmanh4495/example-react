package com.example.springapi.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class ProductDTO {
    private int id;
    @NotNull
    private String code;
    @NotNull
    private String name;
    private int categoryId;
    private int inventoryId;
    private String descriptions;
    private String imageLink;
    private int number;
    private int numberSale;
    private Date created;
    private Date modified;

}
