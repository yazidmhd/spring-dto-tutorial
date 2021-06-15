package com.mapstructdemov2.mapstruct.demo.v2.mapper;

import com.mapstructdemov2.mapstruct.demo.v2.dto.ProductDto;
import com.mapstructdemov2.mapstruct.demo.v2.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(
        imports = UUID.class,
        componentModel = "spring"
)
public interface ProductMapper {

    ProductDto productToProductDto(Product product);

    List<ProductDto> productsToProductDtos(List<Product> product);

    @InheritInverseConfiguration
    Product productDtoToProduct(ProductDto productDto);

}
