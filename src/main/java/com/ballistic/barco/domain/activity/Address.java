package com.ballistic.barco.domain.activity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// final class
@Embeddable
public final class Address{

   @Column( name = "street")
   private String street;
   @Column( name = "city")
   private String city;
   @Column( name = "state")
   private String state;
   @Column( name = "zipcode")
   private String zipcode;
   @Column(name = "country")
   private String country;

   public Address() {}
   public Address(String street, String city, String state, String zipcode) {
      this.street = street;
      this.city = city;
      this.state = state;
      this.zipcode = zipcode;
   }

   public String getStreet() { return street; }
   public void setStreet(String street) {
      this.street = street;
   }

   public String getCity() {
      return city;
   }
   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }
   public void setState(String state) {
      this.state = state;
   }

   public String getZipcode() {
      return zipcode;
   }
   public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
   }

   public String getCountry() { return country; }
   public void setCountry(String country) { this.country = country; }

   @Override
   public String toString() {
      return "Address {" + "street='" + street + '\'' + ", city='" + city + '\'' +
              ", state='" + state + '\'' + ", zipcode='" + zipcode + '\'' +
              ", country='" + country + '\'' + '}';
   }
}
