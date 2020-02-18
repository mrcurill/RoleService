package ru.sbrf.role_service.web.response;

import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {
    private EUserResponse user;
    private String token;
    private List<String> errors;
}
