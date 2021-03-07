package com.example.springapi.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "inventory")
@EntityListeners(AuditingEntityListener.class)
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

    @Column(name = "address")
    private String address;

    @CreatedDate
    @Column(name = "created")
    private Date created;

    @LastModifiedDate
    @Column(name = "modified")
    private Date modified;
}
