package com.haochenlu.pojos;

import java.util.Objects;

public class OrderData {
    private String name;
    private String product;
    private String amount;
    private String date;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String card;
    private String cardNumber;
    private String expiry;

    public OrderData(String name, String product, String amount, String date, String street, String city, String state, String zip, String card, String cardNumber, String expiry) {
        this.name = name;
        this.product = product;
        this.amount = amount;
        this.date = date;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.card = card;
        this.cardNumber = cardNumber;
        this.expiry = expiry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderData orderData = (OrderData) o;
        return Objects.equals(name, orderData.name) && Objects.equals(product, orderData.product) && Objects.equals(amount, orderData.amount) && Objects.equals(street, orderData.street) && Objects.equals(city, orderData.city) && Objects.equals(state, orderData.state) && Objects.equals(zip, orderData.zip) && Objects.equals(card, orderData.card) && Objects.equals(cardNumber, orderData.cardNumber) && Objects.equals(expiry, orderData.expiry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, product, amount, street, city, state, zip, card, cardNumber, expiry);
    }
}
