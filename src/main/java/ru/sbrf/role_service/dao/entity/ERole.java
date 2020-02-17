package ru.sbrf.role_service.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "E_ROLE")
@Data
public class ERole {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "E_ROLE_ID_SEQ")
    @SequenceGenerator(name = "E_ROLE_ID_SEQ", sequenceName = "E_ROLE_ID_SEQ", allocationSize = 1)
    private Long id;
    private String name;

//    @OneToMany(mappedBy = "eRole")
//    private Set<EUser> eUsers;

    @OneToMany(
            mappedBy = "eRole",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<EUser> eUsers;

    public void addEUser(EUser eUser) {
        eUsers.add(eUser);
        eUser.setERole(this);
    }

    public void removeEUser(EUser eUser) {
        eUsers.remove(eUser);
        eUser.setERole(null);
    }


}
