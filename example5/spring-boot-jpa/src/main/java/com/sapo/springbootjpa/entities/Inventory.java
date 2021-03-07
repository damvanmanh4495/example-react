package com.sapo.springbootjpa.entities;

import javax.persistence.*;
import java.util.Date;
@Entity(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String code;
    private String name;
    private String address;
    private Date createdNew;
    private Date createdEdit;

    public Inventory() {
    }

    public Inventory(int id, String code, String name, String address, Date createdNew, Date createdEdit) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.address = address;
        this.createdNew = createdNew;
        this.createdEdit = createdEdit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedNew() {
        return createdNew;
    }

    public void setCreatedNew(Date createdNew) {
        this.createdNew = createdNew;
    }

    public Date getCreatedEdit() {
        return createdEdit;
    }

    public void setCreatedEdit(Date createdEdit) {
        this.createdEdit = createdEdit;
    }
}
