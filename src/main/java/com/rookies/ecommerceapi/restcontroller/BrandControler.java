package com.rookies.ecommerceapi.restcontroller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;
import java.util.List;

import com.rookies.ecommerceapi.dto.BrandDto;
import com.rookies.ecommerceapi.service.BrandService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/public/brand")
public class BrandControler {
    private final BrandService brandService;

    private final ModelMapper modelMapper;

    @Autowired
    public BrandControler(BrandService brandService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<BrandDto> retrieveBrands() {
        return brandService.retrieveBrands().stream().map(brand -> modelMapper.map(brand, BrandDto.class))
                .collect(Collectors.toList());
    }

}