package br.com.loja.domain.venda;

import cz.jirutka.validator.collection.constraints.EachDecimalMin;
import cz.jirutka.validator.collection.constraints.EachDigits;
import cz.jirutka.validator.collection.constraints.EachSize;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

/**
 * Created by STELO\renato.5a on 8/29/17.
 */

@DateInterval
public class VendaFilters {

    @DecimalMin("1")
    @Digits(integer = 20, fraction = 0)
    private Long next;

    @DecimalMin("1")
    @Digits(integer = 20, fraction = 0)
    private Long previous;

    @DecimalMin(value = "1")
    @DecimalMax(value = "1000")
    private Long quantity = 10l;

    @EachDecimalMin(value = "1")
    @EachDigits(integer = 15, fraction = 0)
    private List<Long> customerDoc;

    @EachSize(min = 1, max = 20)
    private List<String> transactionID;

    @EachSize(min = 1, max = 50)
    private List<String> orderStoreID;

    @EachDecimalMin(value = "1")
    @EachDigits(integer = 20, fraction = 0)
    private List<Long> orderSteloID;

    @EachDigits(integer = 10, fraction = 0)
    private List<String> doc;

    @EachDigits(integer = 4, fraction = 0)
    private List<String> lastFourDigitsCC;

    @EachDigits(integer = 6, fraction = 0)
    private List<String> firstSixDigitsCC;

    @Past
    private Date dateFrom;

    @Past
    private Date dateTo;

    @EachSize(min = 1, max = 3)
    private List<String> orderStatus;

    @EachSize(min = 1, max = 3)
    private List<String> channel;

    @EachSize(min = 1, max = 3)
    private List<String> paymentMethod;

    private Boolean last = false;

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getNext() {
        return next;
    }

    public void setNext(Long next) {
        this.next = next;
    }

    public Long getPrevious() {
        return previous;
    }

    public void setPrevious(Long previous) {
        this.previous = previous;
    }

    public Boolean getLast() {
        return last;
    }

    public void setLast(Boolean last) {
        this.last = last;
    }

    public List<Long> getCustomerDoc() {
        return customerDoc;
    }

    public void setCustomerDoc(List<Long> customerDoc) {
        this.customerDoc = customerDoc;
    }

    public List<String> getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(List<String> transactionID) {
        this.transactionID = transactionID;
    }

    public List<String> getOrderStoreID() {
        return orderStoreID;
    }

    public void setOrderStoreID(List<String> orderStoreID) {
        this.orderStoreID = orderStoreID;
    }

    public List<Long> getOrderSteloID() {
        return orderSteloID;
    }

    public void setOrderSteloID(List<Long> orderSteloID) {
        this.orderSteloID = orderSteloID;
    }

    public List<String> getDoc() {
        return doc;
    }

    public void setDoc(List<String> doc) {
        this.doc = doc;
    }

    public List<String> getLastFourDigitsCC() {
        return lastFourDigitsCC;
    }

    public void setLastFourDigitsCC(List<String> lastFourDigitsCC) {
        this.lastFourDigitsCC = lastFourDigitsCC;
    }

    public List<String> getFirstSixDigitsCC() {
        return firstSixDigitsCC;
    }

    public void setFirstSixDigitsCC(List<String> firstSixDigitsCC) {
        this.firstSixDigitsCC = firstSixDigitsCC;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public List<String> getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(List<String> orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<String> getChannel() {
        return channel;
    }

    public void setChannel(List<String> channel) {
        this.channel = channel;
    }

    public List<String> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(List<String> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public boolean hasPrevious() {
        return this.previous != null;
    }

    public boolean hasCustomerDoc() {
        return this.customerDoc != null;
    }

    public boolean hasTransactionID() {
        return this.transactionID != null;
    }

    public boolean hasOrderStoreID() {
        return this.orderStoreID != null;
    }

    public boolean hasOrderSteloID() {
        return this.orderSteloID != null;
    }

    public boolean hasDoc() {
        return this.doc != null;
    }

    public boolean hasLastFourDigitsCC() {
        return this.lastFourDigitsCC != null;
    }

    public boolean hasFirstSixDigitsCC() {
        return this.firstSixDigitsCC != null;
    }

    public boolean hasDateFrom() {
        return this.dateFrom != null;
    }

    public boolean hasDateTo() {
        return this.dateTo != null;
    }

    public boolean hasDateInterval() {
        return this.dateFrom != null && this.dateTo != null;
    }

    public boolean hasOrderStatus() {
        return this.orderStatus != null;
    }

    public boolean hasChannel() {
        return this.channel != null;
    }

    public boolean hasPaymentMethod() {
        return this.paymentMethod != null;
    }


}
