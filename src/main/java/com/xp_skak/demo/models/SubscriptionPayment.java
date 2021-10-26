package com.xp_skak.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscription_payment")
public class SubscriptionPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "payment_date", nullable = false)
    private Date paymentDate;

    //TODO Tjek ManyToONe om den er rigtig
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", referencedColumnName = "id", nullable = false)
    private Member member;
}
