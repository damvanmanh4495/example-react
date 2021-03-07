package com.example.springapi.entity;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "inventory")
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "code")
    @NotNull(message = "không được để trống")
    private String code;
    @Column(name = "name")
    @NotNull(message = "không được để trống")
    private String name;
    private String address;
    private Date createdNew;
    private Date createdEdit;
}
