package ru.sbrf.role_service.dao.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "E_USER")
public class EUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "E_USER_ID_SEQ")
    @SequenceGenerator(name = "E_USER_ID_SEQ", sequenceName = "E_USER_ID_SEQ", allocationSize = 1)
    private Long  id;
    @NotNull
    private String login;
    @NotNull
    private String password;
    private String ip;
    private Date lastSign;
    private Date createdAt;
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name="ROLE_ID")
    private ERole eRole;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "E_USER_E_GROUP",
            joinColumns = @JoinColumn(name="E_USER_ID"),
            inverseJoinColumns = @JoinColumn(name="E_GROUP_ID"))
    private Set<EGroup> eGroups;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EUser)) return false;
        return id != null && id.equals(((EUser) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
