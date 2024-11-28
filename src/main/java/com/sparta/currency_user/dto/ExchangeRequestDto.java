package com.sparta.currency_user.dto;

import lombok.Getter;

@Getter
public class ExchangeRequestDto {

    private Long userId;
    private Long currencyId;
    private Long amountInKrw;

    public ExchangeRequestDto(Long userId, Long currencyId, Long amountInKrw) {
        this.userId = userId;
        this.currencyId = currencyId;
        this.amountInKrw = amountInKrw;
    }
}
