package com.sparta.currency_user.repository;

import com.sparta.currency_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    default public User findByIdOrElseThrow(Long userId){
        return findById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 아이디에 대한 유저는 없습니다." + userId)
        );
    }
}
