package com.example.hospital.model;

import org.hibernate.mapping.List;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.awt.*;
import java.util.Collection;

@Entity
public class BillPatient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="inpatient_id")
    private InPatient inPatient;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "bill_items",
            joinColumns = @JoinColumn(name = "bill_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id")
    )
    private Collection<Item> items;

    private long amount;

    private String paymentStatus;

    public BillPatient(InPatient inPatient, String paymentStatus) {
        this.inPatient = inPatient;
        this.paymentStatus = paymentStatus;
    }

    public BillPatient(InPatient inPatient) {
        this.inPatient = inPatient;
    }

    public BillPatient() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public InPatient getInPatient() {
        return inPatient;
    }

    public void setInPatient(InPatient inPatient) {
        this.inPatient = inPatient;
    }


    public long getAmount() {
        return amount;
    }

    public void setAmount(Collection<Item> items) {
        long am=0;
        for(Item item:items){
            am=am+(item.getQty()*item.getCharge().getCost());
        }
        this.amount=am;
    }
}
