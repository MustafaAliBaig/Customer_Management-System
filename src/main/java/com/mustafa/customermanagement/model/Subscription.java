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
   // @ManyToOne
    //private Customer customer;
   private String customerId; // Reference to Customer ID in MongoDB
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
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
