package ru.sbrf.role_service.web.response;

import lombok.Data;

import java.util.Set;

@Data
public class UIConfigResponse {
    private String name;
    private Set<String> on;
    private Set<String> off;
    private Set<String> disabled;
}
