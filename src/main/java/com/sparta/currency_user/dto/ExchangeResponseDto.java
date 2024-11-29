package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Exchange;
import com.sparta.currency_user.entity.ExchangeEnum;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExchangeResponseDto {

    private Long id;
    private Long userId;
    private Long currencyId;
    private Long amount_in_krw;
    private Double amount_after_exchange;
    private ExchangeEnum status;
    private LocalDateTime create_at;
    private LocalDateTime modified_at;

    public ExchangeResponseDto() {
    }

    public ExchangeResponseDto(Exchange exchange) {
        this.id = exchange.getId();
        this.userId = exchange.getUser().getId();
        this.currencyId = exchange.getCurrency().getId();
        this.amount_in_krw = exchange.getAmountInKrw();
        this.amount_after_exchange = exchange.getAmountAfterExchange();
        this.status = exchange.getStatus();
        this.create_at = exchange.getCreatedAt();
        this.modified_at = exchange.getModifiedAt();
    }
}
