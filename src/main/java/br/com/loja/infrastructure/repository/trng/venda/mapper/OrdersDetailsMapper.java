package br.com.loja.infrastructure.repository.trng.venda.mapper;

import org.springframework.jdbc.core.RowMapper;

import br.com.loja.view.endpoint.venda.OrderDetailDTO;
import br.com.loja.view.endpoint.venda.OrderDetailDTOBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersDetailsMapper implements RowMapper<OrderDetailDTO> {

    @Override
    public OrderDetailDTO mapRow(ResultSet resultSet, int i) throws SQLException {

        if (resultSet != null) {
            return OrderDetailDTOBuilder.anOrderDetailDTO()
                    .withItemName(resultSet.getString("item_name"))
                    .withItemQuantity(resultSet.getInt("item_quantity"))
                    .withItemAmount(resultSet.getDouble("item_amount"))
                    .withItemShippingCost(resultSet.getDouble("item_shipping_cost"))
                    .withShippingStreet(resultSet.getString("shipping_street"))
                    .withShippingNumber(resultSet.getInt("shipping_number"))
                    .withShippingDistrict(resultSet.getString("shipping_district"))
                    .withShippingCity(resultSet.getString("shipping_city"))
                    .withShippingState(resultSet.getString("shipping_state"))
                    .withShippingCountry(resultSet.getString("shipping_country"))
                    .withShippingZipCode(resultSet.getString("shipping_zip_code"))
                    .build();
        }
        return null;
    }
}
