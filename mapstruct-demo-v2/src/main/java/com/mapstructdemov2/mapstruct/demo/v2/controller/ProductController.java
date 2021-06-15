package com.mapstructdemov2.mapstruct.demo.v2.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.mapstructdemov2.mapstruct.demo.v2.dto.ProductDto;
import com.mapstructdemov2.mapstruct.demo.v2.entity.Product;
import com.mapstructdemov2.mapstruct.demo.v2.mapper.ProductMapper;
import com.mapstructdemov2.mapstruct.demo.v2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<Product> save(
            @RequestBody ProductDto productDto
    ) {
        Product p = productRepository.save(productMapper.productDtoToProduct(productDto));

        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter
                .serializeAllExcept("description", "name");

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("myFilter", theFilter);

//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
//
//        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
//
        MappingJacksonValue mapping = new MappingJacksonValue(p);

        mapping.setFilters(filters);
//
        return new ResponseEntity(mapping, HttpStatus.CREATED);


//        return new ResponseEntity<>(productRepository.save(
//                productMapper.productDtoToProduct(productDto)), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> findAll(){
        List<ProductDto> pList = productMapper.productsToProductDtos(productRepository.findAll());

        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter
                .serializeAllExcept("description", "name");

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("myFilter", theFilter);

        MappingJacksonValue mapping = new MappingJacksonValue(pList);

        mapping.setFilters(filters);

        return new ResponseEntity(mapping, HttpStatus.OK);

//        return new ResponseEntity<>(productMapper.productsToProductDtos(productRepository.findAll()), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> findById(
            @PathVariable("id") Long id
    ){
        FilterProvider filters = new SimpleFilterProvider().addFilter(
                "myFilter", SimpleBeanPropertyFilter.serializeAllExcept());

        ProductDto p1 = productMapper.productToProductDto(productRepository.findById(id).get());

        MappingJacksonValue mapping = new MappingJacksonValue(p1);

        mapping.setFilters(filters);

        return new ResponseEntity(mapping, HttpStatus.OK);

//        return new ResponseEntity<>(productMapper.productToProductDto(productRepository.findById(id).get()),
//                HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("id") Long id
    ){
        ProductDto productDto = productMapper.productToProductDto(productRepository.findById(id).get());
        productRepository.deleteById(productDto.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
