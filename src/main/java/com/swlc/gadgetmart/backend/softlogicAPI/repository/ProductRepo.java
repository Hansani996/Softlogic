package com.swlc.gadgetmart.backend.softlogicAPI.repository;



import com.swlc.gadgetmart.backend.softlogicAPI.dto.ProductDto;

import java.util.List;


public interface ProductRepo {
    List<ProductDto> getAllProducts() throws Exception;
}
