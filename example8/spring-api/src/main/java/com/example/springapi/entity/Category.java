package com.example.springapi.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "categories")
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Column(name = "created")
    private Date created;

    @LastModifiedDate
    @Column(name = "modified")
    private Date modified;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
