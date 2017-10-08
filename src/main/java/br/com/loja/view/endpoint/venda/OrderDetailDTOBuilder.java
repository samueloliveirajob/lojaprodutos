package br.com.loja.view.endpoint.venda;

public final class OrderDetailDTOBuilder {
    private String itemName;
    private int itemQuantity;
    private Double itemAmount;
    private Double itemShippingCost;
    private String shippingStreet;
    private int shippingNumber;
    private String shippingDistrict;
    private String shippingCity;
    private String shippingState;
    private String shippingCountry;
    private String shippingZipCode;

    private OrderDetailDTOBuilder() {
    }

    public static OrderDetailDTOBuilder anOrderDetailDTO() {
        return new OrderDetailDTOBuilder();
    }

    public OrderDetailDTOBuilder withItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public OrderDetailDTOBuilder withItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
        return this;
    }

    public OrderDetailDTOBuilder withItemAmount(Double itemAmount) {
        this.itemAmount = itemAmount;
        return this;
    }

    public OrderDetailDTOBuilder withItemShippingCost(Double itemShippingCost) {
        this.itemShippingCost = itemShippingCost;
        return this;
    }

    public OrderDetailDTOBuilder withShippingStreet(String shippingStreet) {
        this.shippingStreet = shippingStreet;
        return this;
    }

    public OrderDetailDTOBuilder withShippingNumber(int shippingNumber) {
        this.shippingNumber = shippingNumber;
        return this;
    }

    public OrderDetailDTOBuilder withShippingDistrict(String shippingDistrict) {
        this.shippingDistrict = shippingDistrict;
        return this;
    }

    public OrderDetailDTOBuilder withShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
        return this;
    }

    public OrderDetailDTOBuilder withShippingState(String shippingState) {
        this.shippingState = shippingState;
        return this;
    }

    public OrderDetailDTOBuilder withShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
        return this;
    }

    public OrderDetailDTOBuilder withShippingZipCode(String shippingZipCode) {
        this.shippingZipCode = shippingZipCode;
        return this;
    }

    public OrderDetailDTO build() {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO(itemName, itemQuantity, itemAmount, itemShippingCost, shippingStreet, shippingNumber, shippingDistrict, shippingCity, shippingState, shippingCountry, shippingZipCode);
        return orderDetailDTO;
    }
}
