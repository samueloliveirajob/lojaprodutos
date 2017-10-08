package br.com.loja.view.endpoint.venda.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderDTO {

    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("status_code")
    private String statusCode;
    @JsonProperty("status_text")
    private String statusText;
    @JsonProperty("channel_code")
    private String channelCode;
    @JsonProperty("channel_text")
    private String channelText;
    @JsonProperty("customer_name")
    private String customerName;
    @JsonProperty("customer_dcto")
    private String customerDcto;
    @JsonProperty("payment_method_code")
    private String paymentMethodCode;
    @JsonProperty("payment_method_text")
    private String paymentMethodText;
    @JsonProperty("credit_card_number")
    private String creditCardNumber;
    @JsonProperty("credit_card_brand_code")
    private String creditCardBrandCode;
    @JsonProperty("credit_card_brand_text")
    private String creditCardBrandText;
    @JsonProperty("installments_quantity")
    private Long installmentsQuantity;
    private Double total;
    private Double discount;
    private Long id;
    private String idTransation;
    @JsonProperty("store_order_id")
    private String storeOrderId;
    @JsonProperty("items")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<OrderDetailDTO> details;

    public OrderDTO() {
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelText() {
        return channelText;
    }

    public void setChannelText(String channelText) {
        this.channelText = channelText;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerDcto() {
        return customerDcto;
    }

    public void setCustomerDcto(String customerDcto) {
        this.customerDcto = customerDcto;
    }

    public String getPaymentMethodCode() {
        return paymentMethodCode;
    }

    public void setPaymentMethodCode(String paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    public String getPaymentMethodText() {
        return paymentMethodText;
    }

    public void setPaymentMethodText(String paymentMethodText) {
        this.paymentMethodText = paymentMethodText;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardBrandCode() {
        return creditCardBrandCode;
    }

    public void setCreditCardBrandCode(String creditCardBrandCode) {
        this.creditCardBrandCode = creditCardBrandCode;
    }

    public String getCreditCardBrandText() {
        return creditCardBrandText;
    }

    public void setCreditCardBrandText(String creditCardBrandText) {
        this.creditCardBrandText = creditCardBrandText;
    }

    public Long getInstallmentsQuantity() {
        return installmentsQuantity;
    }

    public void setInstallmentsQuantity(Long installmentsQuantity) {
        this.installmentsQuantity = installmentsQuantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdTransation() {
        return idTransation;
    }

    public void setIdTransation(String idTransation) {
        this.idTransation = idTransation;
    }

    public String getStoreOrderId() {
        return storeOrderId;
    }

    public void setStoreOrderId(String storeOrderId) {
        this.storeOrderId = storeOrderId;
    }

    public List<OrderDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetailDTO> details) {
        this.details = details;
    }
}