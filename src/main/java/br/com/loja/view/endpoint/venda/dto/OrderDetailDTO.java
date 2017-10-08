package br.com.loja.view.endpoint.venda.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDetailDTO {

    @JsonProperty("item_name")
    private String itemName;
    @JsonProperty("item_quantity")
    private int itemQuantity;
    @JsonProperty("item_amount")
    private Double itemAmount;
    @JsonProperty("item_shipping_cost")
    private Double itemShippingCost;
    @JsonProperty("shipping_street")
    private String shippingStreet;
    @JsonProperty("shipping_number")
    private int shippingNumber;
    @JsonProperty("shipping_district")
    private String shippingDistrict;
    @JsonProperty("shipping_city")
    private String shippingCity;
    @JsonProperty("shipping_state")
    private String shippingState;
    @JsonProperty("shipping_country")
    private String shippingCountry;
    @JsonProperty("shipping_zip_code")
    private String shippingZipCode;

    public OrderDetailDTO(String itemName, int itemQuantity, Double itemAmount, Double itemShippingCost, String shippingStreet, int shippingNumber, String shippingDistrict, String shippingCity, String shippingState, String shippingCountry, String shippingZipCode) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemAmount = itemAmount;
        this.itemShippingCost = itemShippingCost;
        this.shippingStreet = shippingStreet;
        this.shippingNumber = shippingNumber;
        this.shippingDistrict = shippingDistrict;
        this.shippingCity = shippingCity;
        this.shippingState = shippingState;
        this.shippingCountry = shippingCountry;
        this.shippingZipCode = shippingZipCode;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public Double getItemAmount() {
        return itemAmount;
    }

    public Double getItemShippingCost() {
        return itemShippingCost;
    }

    public String getShippingStreet() {
        return shippingStreet;
    }

    public int getShippingNumber() {
        return shippingNumber;
    }

    public String getShippingDistrict() {
        return shippingDistrict;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public String getShippingState() {
        return shippingState;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public String getShippingZipCode() {
        return shippingZipCode;
    }
}