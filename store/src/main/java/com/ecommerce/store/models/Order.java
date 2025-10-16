package com.ecommerce.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private boolean completed;

    public Order() {}
    public Order(String itemName, boolean completed) {
        this.itemName = itemName;
        this.completed = completed;
    }

    // getters & setters
    public Long getId() { return id; }
    public String getItemName() { return itemName; }
    public boolean isCompleted() { return completed; }
    public void setId(Long id) { this.id = id; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}