package com.sapo.demojdbc.dto;

import com.sapo.demojdbc.entities.Category;
import com.sapo.demojdbc.entities.Inventory;
import lombok.Data;

import java.util.Date;

@Data
public class ProductDTO {
    private int id;
    private String code;
    private String name;
    private String descriptions;
    private String imageLink;
    private int number;
    private int numberSale;
    private Date createdNew;
    private Date createdEdit;
    private Category category;
    private Inventory inventory;
}
