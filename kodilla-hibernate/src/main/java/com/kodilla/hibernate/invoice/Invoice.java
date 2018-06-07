package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INVOICE")
public class Invoice {
    int id;
    String number;
    List<Item> items = new ArrayList<>();

    public Invoice(String number) {
        this.number = number;
    }

    public Invoice() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "NUMBER")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            targetEntity =Item.class,
            mappedBy = "invoice"
    )
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
