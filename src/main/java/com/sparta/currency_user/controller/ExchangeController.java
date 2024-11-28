package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.ExchangeFindAllRequestDto;
import com.sparta.currency_user.dto.ExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exchange")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;


    @PostMapping
    public ResponseEntity<ExchangeResponseDto> createExchange(@RequestBody ExchangeRequestDto requestDto) {
        return new ResponseEntity<>(
                exchangeService.createExchange(requestDto),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExchangeResponseDto>> findAllByUser(@RequestBody ExchangeFindAllRequestDto requestDto) {

        List<ExchangeResponseDto> responseDtoList = exchangeService.findAllByUser(requestDto);

        return new ResponseEntity<>(
                responseDtoList,
                HttpStatus.OK
        );
    }
}
