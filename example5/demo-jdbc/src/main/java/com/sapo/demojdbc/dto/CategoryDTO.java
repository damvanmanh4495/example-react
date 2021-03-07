package com.sapo.demojdbc.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryDTO {
    private int id;
    private String code;
    private String name;
    private String description;
    private Date createdNew;
    private Date createdEdit;
}
