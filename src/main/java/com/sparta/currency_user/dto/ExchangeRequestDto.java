package com.sparta.currency_user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ExchangeRequestDto {

    @NotBlank
    private Long userId;
    @NotBlank
    private Long currencyId;
    @NotBlank
    private Long amountInKrw;

    public ExchangeRequestDto(Long userId, Long currencyId, Long amountInKrw) {
        this.userId = userId;
        this.currencyId = currencyId;
        this.amountInKrw = amountInKrw;
    }
}
