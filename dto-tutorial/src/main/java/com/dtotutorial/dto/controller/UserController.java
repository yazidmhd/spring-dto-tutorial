package com.dtotutorial.dto.controller;

import com.dtotutorial.dto.mapstruct.dtos.UserGetDto;
import com.dtotutorial.dto.mapstruct.dtos.UserPostDto;
import com.dtotutorial.dto.mapstruct.mappers.MapStructMapper;
import com.dtotutorial.dto.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private MapStructMapper mapStructMapper;

    @Autowired
    private UserRepository userRepository;

    @PostMapping()
    public ResponseEntity<UserPostDto> create(
            @Valid @RequestBody UserPostDto userPostDto
    ) {
        userRepository.save(mapStructMapper.userPostDtoToUser(userPostDto));
        log.info(String.valueOf(userPostDto.getId()));
        return new ResponseEntity<>(
                userPostDto,
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetDto> getById(
            @PathVariable(value = "id") int id
    ) {
        return new ResponseEntity<>(mapStructMapper.userToUserGetDto(userRepository.findById(id).get()), HttpStatus.OK);
    }

}
