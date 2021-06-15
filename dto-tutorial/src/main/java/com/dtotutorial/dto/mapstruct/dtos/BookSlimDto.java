package com.dtotutorial.dto.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookSlimDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

}
