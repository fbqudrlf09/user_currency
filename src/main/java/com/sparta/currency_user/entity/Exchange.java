package com.sparta.currency_user.entity;

import com.sparta.currency_user.dto.ExchangeRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Getter
public class Exchange extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Currency currency;

    @Column
    private Long amountInKrw;

    @Column
    private Double amountAfterExchange;

    @Column
    @Setter
    private ExchangeEnum status;

    public Exchange() {
    }

    public Exchange(User user, Currency currency, ExchangeRequestDto requestDto) {
        BigDecimal amountInKrwBigDecimal = BigDecimal.valueOf(requestDto.getAmountInKrw());

        this.amountInKrw = requestDto.getAmountInKrw();
        this.amountAfterExchange = amountInKrwBigDecimal.divide(currency.getExchangeRate(), 2, RoundingMode.HALF_EVEN).doubleValue();
        this.status = ExchangeEnum.normal;
        this.user = user;
        this.currency = currency;
    }

    public Exchange(Long id, User user, Currency currency, Long amountInKrw, Double amountAfterExchange, String status) {
        this.id = id;
        this.user = user;
        this.currency = currency;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.status = ExchangeEnum.valueOf(status);
    }
}
