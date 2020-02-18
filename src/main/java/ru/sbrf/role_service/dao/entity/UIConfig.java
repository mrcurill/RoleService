package ru.sbrf.role_service.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "UI_CONFIG")
@Data
public class UIConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UI_CONFIG_ID_SEQ")
    @SequenceGenerator(name = "UI_CONFIG_ID_SEQ", sequenceName = "UI_CONFIG_ID_SEQ", allocationSize = 1)
    private Long id;
    private String uid;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "UI_CONFIG_ON_COMP",
            joinColumns = @JoinColumn(name="UI_CONFIG_ID"),
            inverseJoinColumns = @JoinColumn(name="E_COMPONENT_ID"))
    private Set<EComponent> onEComponents;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "UI_CONFIG_OFF_COMP",
            joinColumns = @JoinColumn(name="UI_CONFIG_ID"),
            inverseJoinColumns = @JoinColumn(name="E_COMPONENT_ID"))
    private Set<EComponent> offEComponents;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "UI_CONFIG_DIS_COMP",
            joinColumns = @JoinColumn(name="UI_CONFIG_ID"),
            inverseJoinColumns = @JoinColumn(name="E_COMPONENT_ID"))
    private Set<EComponent> disabledEComponents;

    public void addOffComponent(EComponent eComponent) {
        offEComponents.add(eComponent);
        disabledEComponents.remove(eComponent);
    }

    public void addDisabledEComponent(EComponent eComponent) {
        disabledEComponents.add(eComponent);
        offEComponents.remove(eComponent);
    }

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
