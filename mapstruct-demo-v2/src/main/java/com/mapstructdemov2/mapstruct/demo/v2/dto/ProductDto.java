package com.mapstructdemov2.mapstruct.demo.v2.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mapstructdemov2.mapstruct.demo.v2.entity.Item;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@JsonFilter("myFilter")
public class ProductDto {

    private Long id;

    private String name;

    private String description;

    private String quantity;

    private long price;

}
