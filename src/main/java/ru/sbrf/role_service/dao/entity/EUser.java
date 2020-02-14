package ru.sbrf.role_service.dao.entity;

import lombok.*;
import ru.sbrf.role_service.enums.Role;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "E_USER")
public class EUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "e_user_id_seq")
    @SequenceGenerator(name = "e_user_id_seq", sequenceName = "e_user_id_seq", allocationSize = 1)
    private Long Id;
    @NotNull
    private String login;
    @NotNull
    private String password;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Role role;
    private String ip;
//    private Date lastSign;
//    private Date createdAt;
    private Boolean isActive;
    private Long roleId;
//    private EGroup group;
}
