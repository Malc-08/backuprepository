package com.olgafranco.app.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id", nullable=false)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name="fk_user_id", nullable=false)
    private User user;

    @Temporal(TemporalType.DATE)
    @Column(name="order_date", nullable=false)
    private Date orderDate;

    @Column(name="status", nullable=false, length=50)
    private String status;

    @ManyToMany
    @JoinTable(
        name = "orders_has_products",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}