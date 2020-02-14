package ru.sbrf.role_service.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "UI_CONFIG")
@Data
public class UIConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ui_config_id_seq")
    @SequenceGenerator(name = "ui_config_id_seq", sequenceName = "ui_config_id_seq", allocationSize = 1)
    private Long id;
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "UI_CONFIG_ON_COMP",
            joinColumns = @JoinColumn(name="ui_config_id"),
            inverseJoinColumns = @JoinColumn(name="e_component_id"))
    private Set<EComponent> onEComponents;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "UI_CONFIG_OFF_COMP",
            joinColumns = @JoinColumn(name="ui_config_id"),
            inverseJoinColumns = @JoinColumn(name="e_component_id"))
    private Set<EComponent> offEComponents;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "UI_CONFIG_DISABLED_COMP",
            joinColumns = @JoinColumn(name="ui_config_id"),
            inverseJoinColumns = @JoinColumn(name="e_component_id"))
    private Set<EComponent> disabledEComponents;

//    public void addOnComponent(Component component) {
//        onComponents.add(component);
//        component.getOnViews().add(this);
//    }
//
//    public void removeOnComponent(Component component) {
//        onComponents.remove(component);
//        component.getOnViews().remove(this);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UIConfig)) return false;
        return id != null && id.equals(((UIConfig) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
