package com.sparta.currency_user.controller;

import com.sparta.currency_user.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchage")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService service;


}
