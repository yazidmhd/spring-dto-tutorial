package com.dtotutorial.dto.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class AuthorAllDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("birthDate")
    private Date birthDate;

    @JsonProperty("books")
    private Set<BookSlimDto> books;

}