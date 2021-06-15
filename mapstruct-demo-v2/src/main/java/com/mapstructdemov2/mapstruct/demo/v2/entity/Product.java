package com.mapstructdemov2.mapstruct.demo.v2.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFilter;

@Data
@Entity
@Table
@JsonFilter("myFilter")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private long price;

}
