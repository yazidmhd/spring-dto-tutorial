package com.dtotutorial.dto.controller;

import com.dtotutorial.dto.mapstruct.dtos.AuthorAllDto;
import com.dtotutorial.dto.mapstruct.mappers.MapStructMapper;
import com.dtotutorial.dto.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private MapStructMapper mapStructMapper;

    @Autowired
    private AuthorRepository authorRepository;

    public ResponseEntity<List<AuthorAllDto>> getAll() {
        return new ResponseEntity<>(
                mapStructMapper.authorsToAuthorAllDtos(authorRepository.findAll()),
                HttpStatus.OK
        );
    }

}
