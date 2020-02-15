package ru.sbrf.role_service.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "E_ROLE")
@Data
public class ERole {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "E_ROLE_ID_SEQ")
    @SequenceGenerator(name = "E_ROLE_ID_SEQ", sequenceName = "E_ROLE_ID_SEQ", allocationSize = 1)
    private Long id;
    private String name;
}
