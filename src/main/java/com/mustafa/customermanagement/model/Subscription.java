package com.mustafa.customermanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;

@Entity
public class Subscription {

    @Id
    private String id;
    private String planType;
    private double price;
    @ManyToOne
    private Customer customer;

    //Getters and Setters
    public String getId() {return id;}
    public void setId(String id) {this.id=id;}
    public String getPlanType() {return planType;}

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
