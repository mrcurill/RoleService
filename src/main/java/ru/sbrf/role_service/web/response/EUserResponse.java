package ru.sbrf.role_service.web.response;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class EUserResponse {
    private String login;
    private Date createdAt;
    private Date lastSign;
    private Boolean isActive;
    private String ip;
//    private String role;
//    private Set<String> groups;
}
