package com.swlc.gadgetmart.backend.softlogicAPI.dto;

import java.util.List;

public class ProductList {
    List<ProductDto> items;

    public List<ProductDto> getItems() {
        return items;
    }

    public void setItems(List<ProductDto> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "items=" + items +
                '}';
    }
}
