package com.sparta.currency_user.service;


import com.sparta.currency_user.dto.ExchangeFindAllRequestDto;
import com.sparta.currency_user.dto.ExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.Exchange;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.repository.CurrencyRepository;
import com.sparta.currency_user.repository.ExchangeRepository;
import com.sparta.currency_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    public ExchangeResponseDto createExchange(ExchangeRequestDto requestDto) {

        User user = userRepository.findByIdOrElseThrow(requestDto.getUserId());
        Currency currency = currencyRepository.findByIdOrElseThrow(requestDto.getCurrencyId());

        Exchange exchange = new Exchange(user, currency, requestDto);
        Exchange savedExchange = exchangeRepository.save(exchange);
        return new ExchangeResponseDto(savedExchange);
    }


    public List<ExchangeResponseDto> findAllByUser(ExchangeFindAllRequestDto requestDto) {

        // Todo: 예외처리 해당 유저가 없을 경우 유저가 없다고 보여줘야함
        List<Exchange> exchangeList = exchangeRepository.findAllByUserId(requestDto.getUserId());

        return exchangeList.stream().map(ExchangeResponseDto::new).toList();
    }
}
