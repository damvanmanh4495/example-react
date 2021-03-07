package com.example.springapi.dto;

import com.example.springapi.entity.Product;
import com.sun.istack.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InventoryDTO {
    private int id;
    @NotNull
    private String code;
    @NotNull
    private String name;
    private String address;
    private Date created;
    private Date modified;

}
