package com.sparta.currency_user.repository;


import com.sparta.currency_user.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
    List<Exchange> findAllByUserId(Long userId);

    default Exchange findByIdOrElseThrow(Long exchangeId) {
         return findById(exchangeId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 환전 기록이 존재하지 않습니다 " + exchangeId)
        );
    }

}
