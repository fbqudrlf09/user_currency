package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRequestDto {

    @NotBlank
    private String name;

    @Email
    private String email;

    public User toEntity() {
        return new User(
                this.name,
                this.email
        );
    }
}
