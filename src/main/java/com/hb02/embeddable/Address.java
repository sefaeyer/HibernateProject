package com.hb02.embeddable;

import javax.persistence.Embeddable;
import java.security.PrivateKey;

/*
 * Adress icin ayri bir tablo olusmasin, Ama Adress sinifindaki degiskenler ,
 * Student tablosunda kolon olarak eklenmesini sagliyor
 */

@Embeddable
public class Address {

    private String street;
    private String city;
    private String country;
    private String zipCode;

    // NOT:  POJO
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    // toString  *******************************
    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
