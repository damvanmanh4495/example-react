package com.sapo.demojdbc.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Category {
    private int id;
    private String code;
    private String name;
    private String description;
    private Date createdNew;
    private Date createdEdit;

    public Category() {
    }

    public Category(int id) {
        this.id = id;
    }

    public Category(int id, String code, String name, String description, Date createdNew, Date createdEdit) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedNew() {
        return createdNew;
    }

    public void setCreatedNew(String createdNew) {
        try {
            this.createdNew = new SimpleDateFormat("yyyy-MM-dd").parse(createdNew);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getCreatedEdit() {
        return createdEdit;
    }

    public void setCreatedEdit(String createdEdit) {
        try {
            this.createdEdit = new SimpleDateFormat("yyyy-MM-dd").parse(createdEdit);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
