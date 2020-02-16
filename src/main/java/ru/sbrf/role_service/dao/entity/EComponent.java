package ru.sbrf.role_service.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "E_COMPONENT")
@Data
public class EComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "E_COMPONENT_ID_SEQ")
    @SequenceGenerator(name = "E_COMPONENT_ID_SEQ", sequenceName = "E_COMPONENT_ID_SEQ", allocationSize = 1)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "onEComponents")
    private Set<UIConfig> onUIConfigs;

    @ManyToMany(mappedBy = "offEComponents")
    private Set<UIConfig> offUIConfigs;

    @ManyToMany(mappedBy = "disabledEComponents")
    private Set<UIConfig> disabledUIConfigs;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EComponent tag = (EComponent) o;
        return Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
