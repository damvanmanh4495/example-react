package com.example.springapi.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "categories")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code", length = 5)
    @NotNull(message = "không được để trống")
    private String code;

    @Column(name = "name", length = 20)
    @NotNull(message = "không được để trống")
    private String name;

    @Column(name = "descriptions")
    private String descriptions;

    @Column
    private Date createdNew;
    private Date createdEdit;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
