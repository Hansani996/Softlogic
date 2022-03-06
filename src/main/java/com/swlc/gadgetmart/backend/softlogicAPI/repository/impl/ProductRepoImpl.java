package com.swlc.gadgetmart.backend.softlogicAPI.repository.impl;


import com.swlc.gadgetmart.backend.softlogicAPI.dto.ProductDto;
import com.swlc.gadgetmart.backend.softlogicAPI.repository.ProductRepo;
import com.swlc.gadgetmart.backend.softlogicAPI.database.DBConnection;
import org.apache.commons.dbutils.DbUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepoImpl implements ProductRepo {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    @Override
    public List<ProductDto> getAllProducts()
            throws Exception {
        connection = DBConnection.getDBConnection().getConnection();
        String SQL = "select i.item_id,i.name,i.description,i.image,i.price,i.deliveryCost,b.brand_name,c.category_name,i.discount,i.shop,i.warranty,i.soldOut from item i,brand b,category c where i.brand=b.brand_id && i.category=c.category_id";

        preparedStatement = connection.prepareStatement(SQL);
        resultSet = preparedStatement.executeQuery();
        List<ProductDto> productDto = new ArrayList<>();
        while (resultSet.next()) {
            ProductDto product = new ProductDto();
            product.setId(resultSet.getString(1));
            product.setName(resultSet.getString(2));
            product.setDescription(resultSet.getString(3));
            product.setImage(resultSet.getString(4));
            product.setPrice(resultSet.getDouble(5));
            product.setDeliveryCost(resultSet.getDouble(6));
            product.setBrand(resultSet.getString(7));
            product.setCategory(resultSet.getString(8));
            product.setDiscount(resultSet.getInt(9));
            product.setShop(resultSet.getString(10));
            product.setWarranty(resultSet.getString(11));
            product.setSoldOut(resultSet.getBoolean(12));
            productDto.add(product);
        }
        closeConnection();
        return productDto;
    }

    private void closeConnection() {
        try {
            DbUtils.closeQuietly(resultSet);
            DbUtils.closeQuietly(preparedStatement);
            DbUtils.close(connection);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
