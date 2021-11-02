package com.xp_skak.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {


    @Id
    @Column(name = "payment_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "lastpd", nullable = false)
    private Date lastPaymentDate;

    public Payment(){
    }

    public Payment(Long id) {
        this.id = id;
        this.lastPaymentDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(Date lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }
}
