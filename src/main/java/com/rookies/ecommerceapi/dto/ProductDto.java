package com.rookies.ecommerceapi.dto;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long id;

    @NotBlank // @NotNull
    private String productName;

    @NotNull
    private Integer categoryId;
    private CategoryDto category;

    private String model;

    @NotNull
    private Integer brandId;
    private BrandDto brand;

    @NotNull
    private Integer originId;
    private OriginDto origin;

    private String standard;

    private String size;

    private Float weight;

    private String material;

    private String description;

    private Short warranty;

    private Short img;

    // @NotNull
    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    @NotEmpty
    private Collection<ProductDetailDto> productDetails;
}
