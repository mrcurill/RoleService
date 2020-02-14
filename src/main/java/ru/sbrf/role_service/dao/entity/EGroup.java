package ru.sbrf.role_service.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@Table(name = "E_GROUP")
@NoArgsConstructor
public class EGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "e_group_id_seq")
    @SequenceGenerator(name = "e_group_id_seq", sequenceName = "e_group_id_seq", allocationSize = 1)
    private Long id;
    @NonNull
    private String name;
}
