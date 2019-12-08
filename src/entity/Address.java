/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "street_name", length = 50)
    private String street;
    @Column(name = "city_name", length = 50)
    private String city;
    @Column(name = "state_name")
    private String state;
    @Column(name = "pin_code")
    private Long pincode;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + '}';
    }
    
    
}
