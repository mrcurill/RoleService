package ru.sbrf.role_service.web.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {
    @NotEmpty(message = "Заполните поле Логин")
    private String login;
    @NotEmpty (message = "Заполните поле Пароль")
    private String password;
}
