package com.example.springapi.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class CategoryDTO {
    private int id;
    @NotNull
    private String code;
    @NotNull
    private String name;
    private String descriptions;
    private Date created;
    private Date modified;
}
