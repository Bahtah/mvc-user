package com.entity;

import javax.persistence.*;


@Entity
@Table(name = "repo_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "carModel")
    private String model;

    @Column(name = "carColor")
    private String color;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;

    public Car() {
    }

    public Car(Long id, String model, String color) {
        this.id = id;
        this.model = model;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
