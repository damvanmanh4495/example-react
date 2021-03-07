package com.sapo.demojdbc.entities;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
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

    public Product() {
    }

    public Product(int id, String code, String name, String descriptions, String imageLink, int number, int numberSale, Date createdNew, Date createdEdit, Category category, Inventory inventory) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.descriptions = descriptions;
        this.imageLink = imageLink;
        this.number = number;
        this.numberSale = numberSale;
        this.createdNew = createdNew;
        this.createdEdit = createdEdit;
        this.category = category;
        this.inventory = inventory;
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

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberSale() {
        return numberSale;
    }

    public void setNumberSale(int numberSale) {
        this.numberSale = numberSale;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


}

