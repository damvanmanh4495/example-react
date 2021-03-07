package com.example.springapi.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "không được để trống")
    @Column(name = "code")
    private String code;

    @NotNull(message = "không được để trống")
    @Column(name = "name")
    private String name;

    @NotNull(message = "không được để trống")
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @NotNull(message = "không được để trống")
    @ManyToOne
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private Inventory inventory;

    @Column(name = "descriptions")
    private String descriptions;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "number")
    private int number;

    @Column(name = "number_sale")
    private int numberSale;

    @Column(name = "created_new")
    private Date createdNew;

    @Column(name = "created_edit")
    private Date createdEdit;

}
