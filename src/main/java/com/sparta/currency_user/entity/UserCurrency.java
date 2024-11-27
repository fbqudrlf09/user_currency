package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class UserCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Currency currency;

    @Column
    private Long amount_in_krw;

    @Column
    private Double amount_after_exchange;

    @Column
    private String Status;

    public UserCurrency() {
    }

    public UserCurrency(Long id, User user, Currency currency, Long amount_in_krw, Double amount_after_exchange, String status) {
        this.id = id;
        this.user = user;
        this.currency = currency;
        this.amount_in_krw = amount_in_krw;
        this.amount_after_exchange = amount_after_exchange;
        this.Status = status;
    }
}
