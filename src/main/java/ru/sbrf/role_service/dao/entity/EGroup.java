package ru.sbrf.role_service.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "E_GROUP")
@NoArgsConstructor
public class EGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "E_GROUP_ID_SEQ")
    @SequenceGenerator(name = "E_GROUP_ID_SEQ", sequenceName = "E_GROUP_ID_SEQ", allocationSize = 1)
    private Long id;
    @NonNull
    private String name;
//    @ManyToMany(mappedBy = "eGroups")
//    private Set<EUser> eUsers;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EGroup tag = (EGroup) o;
        return Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
