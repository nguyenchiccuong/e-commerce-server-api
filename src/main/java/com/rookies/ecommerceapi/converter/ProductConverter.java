package com.rookies.ecommerceapi.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rookies.ecommerceapi.constant.ErrorCode;
import com.rookies.ecommerceapi.dto.ProductDto;
import com.rookies.ecommerceapi.entity.Brand;
import com.rookies.ecommerceapi.entity.Category;
import com.rookies.ecommerceapi.entity.Origin;
import com.rookies.ecommerceapi.entity.Product;
import com.rookies.ecommerceapi.exception.SaveErrorException;

@Component
public class ProductConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Product convertToEntity(ProductDto productDto) {
        try {
            Product product = modelMapper.map(productDto, Product.class);
            product.setBrand(new Brand());
            product.setOrigin(new Origin());
            product.setCategory(new Category());
            product.getBrand().setId(productDto.getBrandId());
            product.getOrigin().setId(productDto.getOriginId());
            product.getCategory().setId(productDto.getCategoryId());
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            // throw new ConvertToEntityDtoException(ErrorCode.ERR_CONVERTER);
            throw new SaveErrorException(ErrorCode.ERR_SAVE_PRODUCT);
        }

    }

    public ProductDto convertToDto(Product product) {
        try {
            ProductDto productDto = modelMapper.map(product, ProductDto.class);
            productDto.setCategoryId(product.getCategory().getCategory().getId());
            return productDto;
        } catch (Exception e) {
            e.printStackTrace();
            // throw new ConvertToEntityDtoException(ErrorCode.ERR_CONVERTER);
            throw new SaveErrorException(ErrorCode.ERR_SAVE_PRODUCT);
        }
    }

}
