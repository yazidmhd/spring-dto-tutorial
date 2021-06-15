package com.dtotutorial.dto.controller;

import com.dtotutorial.dto.mapstruct.dtos.BookDto;
import com.dtotutorial.dto.mapstruct.mappers.MapStructMapper;
import com.dtotutorial.dto.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private MapStructMapper mapStructMapper;

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getById(
        @PathVariable(value = "id") int id
    ) {
        return new ResponseEntity<>(mapStructMapper.booktoBookDto(
                bookRepository.findById(id).get()
        ), HttpStatus.OK);
    }

}
