package ru.sbrf.role_service.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "E_COMPONENT")
@Data
public class EComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "e_component_id_seq")
    @SequenceGenerator(name = "e_component_id_seq", sequenceName = "e_component_id_seq", allocationSize = 1)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "onComponents")
    private Set<UIConfig> onUIConfigs;

    @ManyToMany(mappedBy = "offComponents")
    private Set<UIConfig> offUIConfigs;

    @ManyToMany(mappedBy = "disabledComponents")
    private Set<UIConfig> disabledUIConfigs;

    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Component tag = (Component) o;
//        return Objects.equals(name, tag.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
}
