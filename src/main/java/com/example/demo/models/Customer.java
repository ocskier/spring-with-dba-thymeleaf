package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column()
    private int age;

    @Column(length = 256)
    private String address;

    @Column()
    private LocalDate dateJoined;

    public Customer(String name, int age, String address, LocalDate dateJoined) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.dateJoined = dateJoined;
    }

    // getters and setters
    public int getId()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getAge()
    {
        return this.age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getAddress()
    {
        return this.address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public LocalDate getDateJoined()
    {
        return this.dateJoined;
    }
    public void setDateJoined(LocalDate dateJoined)
    {
        this.dateJoined = dateJoined;
    }
}
