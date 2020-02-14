package ru.sbrf.role_service.web.response;

import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {
    private String message;
    private List<String> errors;
}
