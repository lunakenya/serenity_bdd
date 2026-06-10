package com.demoblaze.models;

/**
 * Modelo que representa los datos de una compra en Demoblaze.
 * Encapsula todos los campos del formulario de compra.
 */
public class PurchaseData {

    private final String buyerName;
    private final String country;
    private final String city;
    private final String cardNumber;
    private final String month;
    private final String year;

    private PurchaseData(Builder builder) {
        this.buyerName = builder.buyerName;
        this.country = builder.country;
        this.city = builder.city;
        this.cardNumber = builder.cardNumber;
        this.month = builder.month;
        this.year = builder.year;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "PurchaseData{" +
                "buyerName='" + buyerName + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", cardNumber='****'" +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    /**
     * Builder para construcción fluida de PurchaseData.
     */
    public static class Builder {
        private String buyerName;
        private String country;
        private String city;
        private String cardNumber;
        private String month;
        private String year;

        public Builder withBuyerName(String buyerName) {
            this.buyerName = buyerName;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder withMonth(String month) {
            this.month = month;
            return this;
        }

        public Builder withYear(String year) {
            this.year = year;
            return this;
        }

        public PurchaseData build() {
            return new PurchaseData(this);
        }
    }
}
