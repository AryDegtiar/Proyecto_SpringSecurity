package com.sistemasactivos.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Permission")
public class Permission extends Base{

    private String name;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;
}
